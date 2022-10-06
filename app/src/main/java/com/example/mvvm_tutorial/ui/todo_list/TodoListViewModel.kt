package com.example.mvvm_tutorial.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_tutorial.data.Todo
import com.example.mvvm_tutorial.data.TodoRepository
import com.example.mvvm_tutorial.util.Routes
import com.example.mvvm_tutorial.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


//Every ViewModel in android inherits from ViewModel which gives it some lifecycle specific behaviour
@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
): ViewModel() {

    val todos = repository.getTodos()

    private val _uiEvent = Channel<UiEvent>()

    //Exposing the immutable version of the channel or rather this channel as a flow because then we can easily receive these events
    val uiEvent = _uiEvent.receiveAsFlow()

    private var deletedTodo: Todo? = null

    fun onEvent(event: TodoListEvent){

        when(event){
            is TodoListEvent.OnTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO + "?todoId=${event.todo.id}"))
            }
            is TodoListEvent.OnAddTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }
            is TodoListEvent.OnUndoDeleteClick -> {
                deletedTodo?.let { todo ->
                    viewModelScope.launch {
                        repository.insertTodo(todo)
                    }
                }
            }
            is TodoListEvent.OnDeleteTodoClick -> {
                viewModelScope.launch {
                    deletedTodo = event.todo
                    repository.deleteTodo(event.todo)
                    sendUiEvent(UiEvent.ShowSnackbar(
                        message = "Todo Deleted",
                        action = "Undo"
                    ))
                }
            }
            is TodoListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertTodo(
                        event.todo.copy(
                            isDone = event.isDone
                        )
                    )
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
* Step 8
* In this step, since we want to inject the repository using Dagger-Hilt, we do this in the
* constructor using @Inject annotation
* The way this works is we pass the instance of the repository and for ViewModel specifically, we add
* another annotation called @HiltViewModel
*
* How does the above steps work ?
* As soon as we annotate something, either a constructor or a property with @Inject,
* That will tell Dagger-Hilt, please look in your modules and see if you have any dependency of that type
* (in this case it is type TodoRepository) that you know you can create and that you can pass behind the scenes for us.
* So we now don't create this ViewModel instance on our own, instead Dagger-Hilt will generate code for us that already creates this instance for us
* and injects this into our composables later.
* And since in our AppModule we already defined how to create a TodoRepository, Dagger-Hilt will know how to pass it to the constructor here.
* And so now inside the calls we will put all our business logic, all our repository functions, and this is where we will have our state variables.
*
* One of the state variables that makes sense to have here is the list of todos that we want to display as that is the only value on the screen that can
* potentially change overtime. Because initially the list is empty, then we load it from the DataBase and we update the state with the list that we got from the database
* and we reflect that in the UI. This is why we declare the todos val first.
*
* Next we also need what is called as a Channel or Shared Flow.
* What is a Channel ?
* A channel is used to send One Time Events or even a Shared Flow too, both will essentially do the same thing. Channel is meant to have 1 observer
* whereas Shared Flow is shared therefore multiple observers
*
* What are One Time Events ?
* It means the thing that only happens once like for example when we try to delete an item from the list, we get a confirmation in the snack bar letting us know that the
* todo item is deleted and gives us the option to undo if we want to.
*  These are One Time Events that we don't actually want to assign to a new state because as soon as we have some kind of state in a state variable,
* then that means that the state will be kept during configuration changes like screen rotations etc.
* Because if we had a state then, even when we would delete an item, the snack bar would get triggered again and show error messages in the past or any items that we deleted in the past.
*
* Another use case for this would be for navigation,
* in the todo app for example, if we click on the button to add a new item to the list, then what happens is that our ViewModel will send a navigate event to our UI and the ui will call the
* navigate function of our nav controller
*
*
-----------
* In this app we will use a channel because we only have a single observer. We do this by defining the variable "_uiEvent". The "_" because this will be the mutable version of the app so that when we use
* things like State Flow, States or in this case Channels, then in the ViewModel we always define a mutable version (the version we can send Events into) and then we also define an immutable version of that
* (which would be a version we can't send events into). This immutable version will be exposed to the UI later so that the ui layer can receive events but can't send new events.
*
* For _uiEvent we now need to define what kind of events we want to send into that channel we defined since we defined the channel as uiEvent, we will name the class UiEvent in the constructor that as well.
* since we dont have that class defined, next step is to create that class. to do so we create a "util" package in the root package which in this case is the
* com.example.mvvm_tutorial.
* We define this UiEvent class as a "sealed class" because we will have different types of Ui events here so that our ui actually does something.
* once we define the mutable and the immutable version of the channel we can then subscribe these changes to the ui layer so that we receive these events just once.
* ---------------
*
* Another thing that is useful to do in the Model View ViewModel is that each screen has a so called "Event Class" which is not referring to the "UiEvent" class we
* had created earlier. With Event Class we are referring to specific events to the screen and those will be the events that send from the screen( the UI layer )
* to our ViewModel when there is some kind of user interaction like when we click a button or when we want to reload the list or when we click something on the toolbar,
* those would be events that we send from the UI to the ViewModel, so the ViewModel should do something.
*
* And this "Event Class" is created in the "todo_list" package and in this since we only have 1 screen we only create one class that is named "TodoListEvent". In other
* apps we would do this for every single screen that we have.
*
*
* -----------------------------
* Coming to this file from step 9
* We implement the onEvent() function and this will be the function that we trigger from the UI given a TodoListEvent
* and inside the function we can distinguish what kind of event that is and depending on that we can execute a different function
* or some other piece of code
*
* having one function for this makes it easier as it makes the code more cleaner and we don't need a separate function for every event in our ViewModel
* and instead we have 1 event function that handles them all.
*
* We first start with the onAddTodoClick event.
* All that should happen for this part is, we send a "navigate event" to the UI that we now want to navigate to the Add/Edit TodoList screen
* and for that we are going to create another object in our "util" package which defines our navigation routes
*
* now coming back to the onEvent() function in the when statement we continue to working on the OnAddTodoClick
* here we actually want to send an event to this channel, to do this we use the "send" function of Channel
* and inside the parentheses for the function we use the UiEvent.Navigate function where we specify the route to take
* When we type in this line, we see that there is an error in the send function, this is because this _uiEvent.send needs to be executed in a coroutine
* and since that is an asynchronous call, we first need to launch a coroutine
*
* For this scenario what we basically want is we want a separate function to send an event into this channel which is why we define the sendUiEvent()
* and in this function, we can launch a coroutine using "viewModelScope" which is used to bind the lifetime of this coroutine to our ViewModel lifecycle
* so for example if we want to do a asynchronous call like a network call, and our ViewModel is cleared, then we want to stop executing the network call, the ongoing one
* and that is what the scope will do here. So it will determine that if the ViewModel is cleared then all the coroutines in that scope will be cancelled.
* And in the block of the "launch" function, we can now execute the so called suspend function as we have with our Room database.
*
* So we can take the line for the _uiEvent.send and place it in this new function we just created ( sendUiEvent() ) and error is resolved because
* the send function is not executed in the launch block.
*
* Note: if we check the description of the function, we see that the send function is a "suspend" function which means that it needs to be executed in a
* launch block or another suspend function.
*
* Now we go back to the onEvent() function back to the line where we had previously written the line to send the event and call the newly defined sendUiEvent() function and call it here.
*
*
*
* Next, we move onto the onTodoClick event.
* which is also simple to do as we want to navigate to  ADD_EDIT_TODO
* but with a minor difference and that is, we want to attach the id of the todoItem we clicked on because if we click on an existing todoItem, we want
* to load that item on the Add/Edit todoScreen, because otherwise it would have empty textfields and assume we want to add a new item.
* But if it exists, then we want to edit them instead.
*
* Next we goto OnDoneChange for when checkbox is toggled,
* we want to update that change in our database with the new Boolean
* In this section, we also use the viewModelScope.launch() function that we had used earlier when defining the sendUiEvent() function.
* We do this because, to execute our Database functions we also need a coroutine as these are also suspend functions
* And in there what we want to do is to access our repository which acts as our database and we want to insert a new task but not really insert a todoItem
* because it is already in our database, we only want to update the done state for that
* However, if we take a look at our TodoDao, we had previously added an annotation for onConflict for the insertTodo function in the interface where we used "REPLACE".
* Because of this, if we try to add a todo that already exists, it will be updated instead which is what we will make use of here for the onDoneChange event.
* Here, we will use the "todo" for the event from our UI layer and we copy that, so we keep its ID and that way it will be updated and we just add "isDone=event.isDone"
* and so that will be the new isDone state that we receive from the UI
*
* Next we move to the OnDeleteTodo
* we also launch a coroutine here
* here we access the repository as we did previously and pass the event, which is enough to delete the todoItem that we add.
* However, we also need to consider that we want to be able to undo that deletion. And how do we know we actually want to undo when we click that.
* Because of that what we do is, in the class we add another variable called "deletedTodo" and make it nullable.
* This is used to cache the recently deleted todoItem and if we select undo, then we take the value stored in the variable and put it back in our database.
* and we add a copy of the task into the variable before deleting it.
* we also need to send an UI event, to do so we use the function sendUiEvent() that we created and use it to "show the snack bar" and be able to undo the deletion.
*
* Now lastly, we move to the OnUndoDeleteClick event.
* here, we first have to check if the value stored in the "deletedTodo" is null and if it is not,
* then we also want to launch a coroutine with viewModelScope again and say that we want to insert the task back into our database.
*
* -----------------------------------------x-----------------------------------------------
* Now the next step would be to implement the TodoList screen.
* */