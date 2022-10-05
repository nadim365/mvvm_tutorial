package com.example.mvvm_tutorial.ui.todo_list

import androidx.lifecycle.ViewModel
import com.example.mvvm_tutorial.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//Every ViewModel in android inherits from ViewModel which gives it some lifecycle specific behaviour
@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
): ViewModel() {

    val todos = repository.getTodos()

}

/*
* Step 7
* In this step, since we want to inject the repository using Dagger-Hilt, we do this in the
* constructor using @Inject annotation
* The way this works is we pass the instance of the repository and for ViewModel specifically, we add
* another annotation called @HiltViewModel
* How does the above steps work ?
* As soon as we annotate something, either a constructor or a property with @Inject,
* That will tell Dagger-Hilt, please look in your modules and see if you have any dependency of that type
* (in this case it is type TodoRepository) that you know you can create and that you can pass behind the scenes for us.
* So we now don't create this ViewModel instance on our own, instead Dagger-Hilt will generate code for us that already creates this instance for us
* and injects this into our composables later.
* And since in our AppModule we already defined how to create a TodoRepository, Dagger-Hilt will know how to pass it to the constructor here.
* And so now inside the calss we will put all our business logic, all our repository functions, and this is where we will have our state variables.
* */