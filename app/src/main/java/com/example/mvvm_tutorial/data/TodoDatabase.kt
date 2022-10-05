package com.example.mvvm_tutorial.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Todo::class], // All the tables that we have in our Database
    version = 1 // we change the version when we change the database so that Room can tell whether it has to migrate the database or not
)
abstract class TodoDatabase: RoomDatabase() {

    abstract val dao: TodoDao
}

/*
* Step 3
* Here we define one final class with regards to room
* and that is the database instance which then has an instance of the TodoDao object
* to access the actual Database
*/