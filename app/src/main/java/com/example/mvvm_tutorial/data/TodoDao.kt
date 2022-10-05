package com.example.mvvm_tutorial.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    //Step 2
    /*
    * Dao stands for Data Access Object
    * it is used to access our data.
    * It defines the different ways we want to access our data
     */

    /*
    * The "suspend" keyword used here is used to
    * suspend the current function where this function is called
    * until we actually get the result, so until we actually
    * know that the execution of this function is finished
    *
    * This is another way of asynchronous programming because we can do this in a sequential way.
    * It basically gets rid of callbacks
    * so instead of having a callback that gets triggered when we insert a todo item in this case,
    * we can suspend and wait in the calling function in a way.
    */
    // we add this onConflict in the annotation so that if we try to add a Todo item that already exists, then we replace the old one, in that way we have an insert and an update function in one.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo (todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id") // we add the colon here to refer to the parameter that we passed
    suspend fun getTodoById(id: Int): Todo?

    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
    /*
    * This Flow means that we get real-time updates
    * as soon as something in our database changes
    * for example when we insert or delete a todo
    * or change something that would affect the query that we defined above (getTodos)
    * Then the Flow would get triggered again and it would give us the new and updated list of todos
    */
}