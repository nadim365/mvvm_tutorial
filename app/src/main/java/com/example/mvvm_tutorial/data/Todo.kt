package com.example.mvvm_tutorial.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title:String,
    val description:String?,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null
)
//Step 1 :
/**
* When it comes to databases, especially SQL databases which Room implements (SQLite Database).
* We first need an "Entity" which is the table or class that contains the data that we want to save.

* In this case, the Todo entity contains all the fields that we want to save for a single todo item.

* The first step is to annotate the data class with the "Entity" Keyword which tells Room that this is an entity
* that we want to have as a table in our database.

* The last property that we add is the Primary Key which is usually an Id that we save with each item and the Id's need to be
* unique.
* It is used to uniquely identify an item in our database
* We make this Id null for now but in the end it wont be.
* We do this because, the way Room handles this is that when we dont pass a value here, when creating an entity,
* Room will automatically generate an Id.
* And we annotate it with the PrimaryKey keyword to let Room know that we are using this field as our primary key.
*/