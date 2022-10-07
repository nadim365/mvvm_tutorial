package com.example.mvvm_tutorial.ui.add_edit_todo

sealed class AddEditTodoEvent {

    data class OnTitleChange (val title: String): AddEditTodoEvent()
    data class OnDescriptionChange(val description: String): AddEditTodoEvent()
    object OnSaveTodoClick: AddEditTodoEvent()


}

/*
* Step 12
* Now here again we need to think of what kind of events we could possibly send or what
* could the user do in this Add/Edit todoScreen.
* On one hand the user could change the text content of the title text
* so let's call it OnTitleChange where we pass the new title to it
* and we do the same for description change as well
* Next we could even click on the save button, so we add that as well.
*
*
* Now we go back to the AddEditTodoViewModel file and use this Event class that we just created.
*
*
* After completing that, the last thing to do is to implement the Add/Edit todoScreen within the add_edit_todo package
* so that we have a ui that talks to the ViewModel that we had created in step 11.
* We name this file, AddEditTodoScreen
* */