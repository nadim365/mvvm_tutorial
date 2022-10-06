package com.example.mvvm_tutorial.ui.todo_list

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvm_tutorial.util.UiEvent
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TodoListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val todos = viewModel.todos.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.ShowSnackbar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(TodoListEvent.OnUndoDeleteClick)
                    }
                }
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(TodoListEvent.OnAddTodoClick)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos.value) { todo ->
                TodoItem(
                    todo = todo,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(TodoListEvent.OnTodoClick(todo))
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}


/*
* Step 10
*
* Here for the TodoListScreen composable, we need a few parameters and these are as follows:
*
* 1. onNavigate() function which we will call whenever we want to navigate from this screen to another screen.
* so the screen themselves don't handle the navigation, that will be done by the parent composable
* which will be purely for navigation and contain the NavController instance.
* This way we don't have to pass this instance all the way down to the lowest level composables here,
* instead we have all the navigation happening in a single file and we propagate up these navigation events.
*
* 2. Next is the viewModel which is the ViewModel reference because now we are in the UI layer and are communicating with
* the ViewModel layer because the ViewModel now contains the "state" of this specific screen so that we also want
* to able to retrieve the state when we rotate the device so that it is not lost.
* Since we use Dagger-Hilt to inject the ViewModel, we add the hiltViewModel() at the end. What this does is that
* it automatically passes the ViewModel for us
*
*
* Now we move to the function definition,
* here we declare a variable called todos to retrieve our todoList state which we can get from viewModel.todos but this returns a "Flow"
* and we need it as a compose state because only that will trigger recompositions so that everything is updated on our screen
*
* The next thing we do that we do for pretty much every other screen is to collect these UI events.
* For this what we need is something called a LaunchEffect() block and pass "true" as the first key
* So what this does is execute the code within the curly braces independent of the compose function because this function is triggered everytime
* our screen updates which we don't want as we want this particular to only execute once when we show it the first time.
* Next, within the curly braces, we add the viewModel.uiEvent.collect {} which will be triggered for every single event that we send
* into this uiEvent channel
*
* So everytime we the sendUiEvent() and call the send() functions, we now trigger this block of code within the inner curly braces.
* And depending on what this event is, if it is UiEvent.ShowSnackBar we want it to do some operations, if it is UiEvent.Navigate we do some other operations
*
* for showing the snackbar, we need a scaffold state for which we need to declare a variable called "scaffoldState"
* Now how do we detect if we clicked the undo for the snackbar ?
* for that what we do is add "val result =" before calling the scaffoldState.snackbarHostState.ShowSnackbar()
* and after that we can use the result variable to check if the result is SnackbarResult.ActionPerformed which would be the result if we actually clicked
* on the undo button.
*
* If that is the case, then what we want to do is, call the onEvent() that is now a UI event that we send from our UI to our
* ViewModel and the event that we send here will now be TodoListEvent.OnUndoDeleteClick
* so that when we click on the undo button it sends the OnUndoDeleteClick event to our ViewModel
* and the ViewModel will take care of that in the TodoViewModel file.
*
* And now below the LaunchedEffect block we will have our actual content which will be a scaffold.
* Here we pass our scaffold state, and add the parameter to make sure that it is a floating action button
* Now in this scaffold block we want our TodoList list (a list of the tasks) which would be a list of our
* TodoItem composables which will be a Lazy list
*
* within the items block,
* in the TodoItem() function, we have the onEvent() in our TodoItem, which we trigger for every single action.
* And for these things, we now send the events up.
* The interesting thing we can now do because our ViewModel directly receives these events, we can say "viewModel::onEvent"
* which removes the need for having a complicated lambda function and instead we delegate this event that we propagate up directly to the ViewModel
*
* ---------------------------x--------------------------------
* Next we need to implement the add/edit TodoScreen before we can add new items so we can see them
* */