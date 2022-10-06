package com.example.mvvm_tutorial.ui.todo_list

import com.example.mvvm_tutorial.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}

/*
* Step 9
* Now for this Event Class we need to think about what kind of user interactions could we have on this todolist screen
* we could click the delete item, we could toggle the done state in our todoItem, we could click on a todoItem to edit it,
* we could click on the floating action button to add a new todoItem, and we could also click undo when deleting an item which is also
* a ui event that we send to our ViewModel
* ------------------------------------------
* We first begin with adding the delete event
* Next we add the event for when a task on the list is checked "Done" for which we need a boolean "isDone" parameter which is the new isDone state to be passed along with the
* task that is marked done so that the ViewModel can update that in the databse
* Next we an event so that we can undo the deletion of a task and we declare this as an object because it doesn't need any parameters as
* we will cache the recently deleted task in our ViewModel and then restore it
* Next we add an event for when we click on an existing task to get its detailed view to edit it
* And lastly we add the event to add a new task to the list
*
* Now we jump back to the ViewModel and implement the function "onEvent"
* which will be the function that we trigger from the UI given a TodoListEvent
*/