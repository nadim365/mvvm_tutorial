package com.example.mvvm_tutorial.di

import android.app.Application
import androidx.room.Room
import com.example.mvvm_tutorial.data.TodoDatabase
import com.example.mvvm_tutorial.data.TodoRepository
import com.example.mvvm_tutorial.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module // to tell Dagger that we have a module here
@InstallIn(SingletonComponent::class) //Defines how long the dependencies we define here will live
object AppModule {

    //Here we define with functions how the dependencies should be created
    // We start by defining how Dagger can create our Room Database
    @Provides
    @Singleton //there will only be a single instance that exists of it
    fun provideTodoDatabase(app: Application) : TodoDatabase { // this function needs the application context to be provided which we pass as a parameter to it
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build() // this is how we create a new instance of the database object which we can then use in the repository to access the database and insert stuff
    } // Now Dagger-Hilt knows how to construct this object to be able to "inject" it into our single class

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }
}

/*
* Step 7
* Why is it called AppModule ?
* There could be more modules that we create, in a bigger project for example there would be more than one module
* These modules not only define the dependencies that we have in our project, but also their lifetimes.
* Because sometimes, there might be dependencies that we don't need throughout the whole lifetime of our application
* so they don't need to be singletons.
* If we had an App that has multiple activities, there might be dependencies that we need for a single activity, then we can put those dependencies in a single module
* that keeps them alive for the lifetime of that specific activity.
*
* In this step we also need another dependency that we provide here, which is not only our database but also our repositories.
* In the end we will have a central place where we inject these and that will be our ViewModel's.
* In the end we need to think about what do we need in our ViewModel's to use our app
* and that is typically our repositories since now, Dagger-Hilt only knows how to create this Database instance but not yet how to create the repository
* since we still need to define that. But to create this repository instance we need the Database instance (as seen in the constructor of TodoRepositoryImpl) which is why we first provided the Database and
* then we add the repository.
*
*
* The next step is to implement our ViewModel's. On one hand we have our ViewModel for the todo list screen.
* and we have a ViewModel for our add/edit todo screen the screen in which we will add a new todo or edit an existing one.
* In the end, usually in our apps we have 1 ViewModel per screen.
* If you have an activity fragment architecture not Jetpack Compose, then sometimes we also have whats called
* a shared ViewModel so that we bind our ViewModel to our activity and not to our fragment and then multiple fragments can use the same ViewModel instance.
* This is not used often but is helpful when we want to share data between fragments
*
* So what is the job of the ViewModel ?
* As we learnt before, the ViewModel houses the business logic. But there is more to it than that.
* It also contains our state of the specific screen. State is how our UI looks at a given moment, so basically it reflects the data and values at a given moment
* So state in the end is a value that can change over time.
* */