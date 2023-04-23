package com.example.mvvm_tutorial.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao: TodoDao
): TodoRepository {

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)
    }

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos()
    }
}

/**
* Step 5
* Here we implement the interface we had created in the previous step
* to implement these functions, we need access to our database instance.
* To get that, we just pass it to the constructor of this TodoRepositoryImpl
*
* After we have finished implementing the interface,
* we have now defined how we access our database and we have a repository that our future ViewModel's
* can access
*
*
* Next Step: Setup Dagger - Hilt, which will be used for dependency injection
* What is Dependency Injection ?
* It is all about giving an object its instance variables
* what that means is that for example in this todo app, what we do with the TodoDao interface that we had created earlier
* is basically dependency injection.
* NOTE :  a dependency is an object a specific class depends on.
* Because in this example, here the TodoDao is a dependency because the TodoRepository needs a TodoDao object and
* when we pass the object from outside by passing it to the constructor(constructor injection),
* we are basically "injecting" that dependency.
* Another way of doing the above is using Dagger - Hilt which is a library for dependency injection
* which makes all of this much more easier so that we just have a central place where we define our dependencies
* (which in this case is just the Database and the repository), all these stuff would be put in a central module
* where Dagger - Hilt would basically learn how to construct these objects to able to pass it to the different classes in our project.
*/