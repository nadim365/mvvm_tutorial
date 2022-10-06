package com.example.mvvm_tutorial.ui.add_edit_todo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mvvm_tutorial.data.Todo
import com.example.mvvm_tutorial.data.TodoRepository
import com.example.mvvm_tutorial.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class AddEditTodoViewModel @Inject constructor(
     private val repository: TodoRepository,
     savedStateHandle: SavedStateHandle
): ViewModel() {
    var todo = mutableStateOf<Todo?>(null)
        private set

    var title = mutableStateOf("")
        private set

    var description = mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val todoId = savedStateHandle.get<Int>("todoId")
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
* */