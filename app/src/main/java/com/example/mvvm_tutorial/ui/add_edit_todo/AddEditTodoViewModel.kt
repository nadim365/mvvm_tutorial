package com.example.mvvm_tutorial.ui.add_edit_todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tutorial.data.Todo
import com.example.mvvm_tutorial.data.TodoRepository
import com.example.mvvm_tutorial.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTodoViewModel @Inject constructor(
     private val repository: TodoRepository,
     savedStateHandle: SavedStateHandle
): ViewModel() {
    var todo by mutableStateOf<Todo?>(null)
        private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val todoId = savedStateHandle.get<Int>("todoId")!!
        if (todoId != -1) {
            viewModelScope.launch {
                // todo = repository.getTodoById(todoId!!) -> we moved the assertion to the variable declaration and assigment above.
                repository.getTodoById(todoId)?.let { todo ->
                    title = todo.title
                    description = todo.description ?: ""
                    this@AddEditTodoViewModel.todo = todo
                }
            }
        }
    }

    fun onEvent(event: AddEditTodoEvent) {
        when(event) {
            is AddEditTodoEvent.OnTitleChange -> {
                title = event.title
            }
            is AddEditTodoEvent.OnDescriptionChange -> {
                description = event.description
            }
            is AddEditTodoEvent.OnSaveTodoClick -> {
                viewModelScope.launch {
                    if (title.isBlank()) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = "The title can't be empty"
                        ))
                        return@launch
                    }

                    repository.insertTodo(
                        Todo(
                            title = title,
                            description = description,
                            isDone = todo?.isDone ?: false,
                            id = todo?.id
                        )
                    )

                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}

/*
* Step 11
*
* Here the process is similar to how we created the ViewModel for the TodoListScreen but there are a few differences.
* here we need another constructor called "savedStateHandle"
* it is basically a key value object that contains a bunch of state variables,
* So on one hand we could use that to restore the ViewModel state maybe after process death
* but on the other hand, another useful thing that is contains is that
* it contains our navigation arguments.
*
* On this screen we actually have this navigation argument, that is the TodoId which would like to load from the database
* if we clicked on a todo to open its details on this page
* and Hilt will actually do all that for us behind the scenes since we used @Inject in the class definition and we don't need to provide this anywhere,
* it will just work.
*
* What do we actually need in this class ?
* In here we now need our different states as we did for the TodoListViewModel where we only had a single state (todos)
* which wasn't really a compose state because we got the Flow from the Room database.
*
* But here for the Add/Edit TodoListScreen, we need a separate state(s).
* On the one hand we need the TodoTitle, so if we add a title in our textfield, we want a state for that.
* We also need a state for the actual description and we also need a state for the state that we load here if we clicked on
* and existing task. Let's start with that.
*
* We declare a public variable and we put nullable Todo? in the event that we want to add a new todo to our database.
* we add a "private set" below this state because we only want to able to change the value from within our ViewModel
* but we can read it from outside. This is similar to what we did in the TodoListViewModel file where we only exposed the immutable
* version of the state.
*
* Next we create a variable for the title
* and we also declare a variable for the description
*
* Next we need to declare our UI event channel as we had done in TodoListViewModel.
*
* now we add the init which will be executed when our ViewModel is initialized
* and here we want to check did we actually open this Add/Edit page by clicking on an existing todo or by clicking on adding a new todo,
* because if we opened this from an existing todo, then we want to load this todo from the database by its id.
* Then we would get the TodoId using our "savedStateHandle" and the navigation element for this handle is called "todoId"
* We don't need this "todoId" to be nullable since for integer values we can't pass null in this case, we made the
* todoId an optional argument  as we can see in the TodoViewModel file where we made the todoId nullable,
* but we will always pass it anyways because we will define a default value of -1 for the reason that we can't have nullable integers
* And if we don't click on a todoItem, then we simply pass -1 for the todoId, and that way we can detect if we want to open a new one or open
* and existing one.
*
* And so we add an if() block now where, if the todoId is not equal to -1, then that means that we clicked on an existing one and
* we want to load this and to do this we add a viewModelScope.launch {} block inside.
* In this block, we say that todo(which is our state)
* is equal to repository.getTodoById() and we pass the Id.
* We get an error when we type this because the id could be null which would never be the case as we always pass the Id.
* before we make any other changes, we also change the "=" for our states to by so that we can easily send the state using xyz.value all the time
* and next to fix the error in the init block, we add the assertion (symbol = !!) that it is not equal to null and the error is fixed.
*
* Next, we also want to make sure that we assign the corresponding title to the title state
* for which we add the line : title = todo.title
* and we also add the description to the description state as well.
*
*
* UPDATE : for the variable in the block where we passed the todoId to the repository, we change it from instead of assigning a variable (variable name: todo)
* we remove the variable but keep the rest of the line and add a "let" block where and move the title and description assignments inside it
*
*
* Now the next step is to do the same thing that we did in the TodoViewModel
* and that is, we want to have the onEvent() function
* and which events do we pass to this onEvent() function ?
* for that we need a new Event class which we create in the add_edit_todo package named AddEditTodoEvent
*
* --------------------X------------------------
* Coming from step 12 where we created the AddEditTodoEvent class,
* Inside we add the when block again to check what that event is.
* Inside the block where we handle the event when we save a todoItem,
* we launch a coroutine again because, here we want to insert the todoItem into our database.
* Inside the coroutine, we first want to check if the title is empty because only then
* we want to insert it into our database.
*
* one additional thing we have to do is to add/copy the sendUiEvent() function that we had previously defined in the TodoListViewModel
* so that we can it to handle the OnSaveTodoClick event.
* and the event we want to send for this is the "ShowSnackbar" event
*
* if the title is not empty for the above mentioned event, then we can just add it to the repository
* within this event (OnSaveTodoClick) we send another event after we've created a new TodoItem and added it to our
* repository which is the PopBackstack because then we want to navigate back to the todoList screen.
* */