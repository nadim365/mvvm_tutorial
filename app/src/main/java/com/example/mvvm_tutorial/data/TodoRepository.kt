package com.example.mvvm_tutorial.data


import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo (todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Int): Todo?

    fun getTodos(): Flow<List<Todo>>
}

/**
* Step 4
* Having the repository as an interface gives us more flexibility and makes testing easier too.
* The Job of the repository is to access all of our data sources (could be database, API, or preferences or a combination of them) and decide which data,
*  it should forward to the ViewModel
* like for example should the app show the remoteData, the localData, or some preferenceData
*/