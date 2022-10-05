package com.example.mvvm_tutorial

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApp: Application() {
}

/*
* Step 6
* When we use Dagger - Hilt, we need to have an application class that inherits from
* the Application class and annotate with the "@HiltAndroidApp"
* which will give it access to the application and to also be able to use the application context
* to provide some objects and dependencies.
*
* part of this step involves going to the manifest and specify that we have an application class
* by using the name attribute and passing TodoApp
*
* Now we will define the so called Module which will be the central place that will define how
* our dependencies are created so that Dagger - Hilt can inject these into similar classes.
**/