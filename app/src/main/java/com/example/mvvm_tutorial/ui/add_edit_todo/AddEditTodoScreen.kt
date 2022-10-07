package com.example.mvvm_tutorial.ui.add_edit_todo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvm_tutorial.util.UiEvent
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddEditTodoScreen(
    onPopBackStack: () -> Unit,
    viewModel: AddEditTodoViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditTodoEvent.OnSaveTodoClick)
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save"
                )
            }
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
           TextField(
               value = viewModel.title,
               onValueChange = {
                   viewModel.onEvent(AddEditTodoEvent.OnTitleChange(it))
               },
               placeholder = {
                   Text(text = "Title")
               },
               modifier = Modifier.fillMaxWidth()
           )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.onEvent(AddEditTodoEvent.OnDescriptionChange(it))
                },
                placeholder = {
                    Text(text = "Description")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                maxLines = 5
            )
        }
    }
}

/*
* Step 13
*
* This new function that we created will again, take a
* lambda function that we will trigger from our ViewModel
* this time only the OnPopBackStack event when we receive the BackStack event
* and we don't really need a navigate event because we won't navigate anywhere,
* we just want to pop the BackStack
*
* Along with that we also need a reference to our ViewModel
*
* inside the function we need a scaffold state again to show the snackbars.
* and then we add a LaunchEffect block to collect these ui events that we get from our ViewModel
* for the event PopBackStack, here for this event we trigger a callback function so that we
* propagate the event upto the navigation composable so that we can then pop the backstack using navController.
*
* */