package com.example.mvvm_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvm_tutorial.ui.add_edit_todo.AddEditTodoScreen
import com.example.mvvm_tutorial.ui.theme.MvvmTodoAppTheme
import com.example.mvvm_tutorial.ui.todo_list.TodoListScreen
import com.example.mvvm_tutorial.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            MvvmTodoAppTheme() {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.TODO_List) {
                    composable(Routes.TODO_List) {
                        TodoListScreen(
                            onNavigate = {
                                navController.navigate(it.route) // so that we get the UiEvent here and then use the navController to navigate
                            }
                        )
                    }
                    composable(
                        route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        arguments = listOf(
                            navArgument(name = "todoId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        AddEditTodoScreen(onPopBackStack = {
                            navController.popBackStack()
                        } )
                    }
                }
            }
        }
    }
}

/*
* Step 14
* Lastly,
* the only thing that is left now is the navigation which we will add directly into MainActivity.
* But in a more complex project where we have other stuff going on in MainActivity,
* we would create a separate navigation composable for that
* Another thing we have to consider is that we annotate the MainActivity with the @AndroidEntryPoint
* which is an annotation that comes with Dagger-Hilt and is necessary as soon as we want to inject
* dependencies in an android component.
*
* An android component could be an activity, fragment, or a service etc. if we want to inject dependencies
* in those like we want to here with our ViewModel's, then we need this annotation,
* if we want to inject that in other classes, then we don't need that
*
* Inside, we define our navController first which we use to navigate
* and then we have a navHost where we pass our controller
*
* In this NavHost now, we define all the screens that we have by using composable blocks and defining a route for that
* first we add the composable block for the main TodoList screen
* next we add the composable block for the Add/Edit Screen
* in this block, along with the route, we pass another argument which is the todoId which we want to be able to pass to the screen
* along with routes, we add another parameter called arguments which will contain a list of navArguments and in the navArguments, we define
* what our argument looks like
* we can customize this argument by saying that the type of the argument is "NavType.IntType" because our todoId is an integer and we want
* to be able to pass integers here, and if we don't pass a todoId, if we want to directly create a new todoItem, we need to pass
* some kind of default value to detect that and the default value will be -1 as we did in the AddEditTodoViewModel
* */