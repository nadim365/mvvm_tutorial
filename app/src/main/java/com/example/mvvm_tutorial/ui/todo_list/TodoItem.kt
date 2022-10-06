package com.example.mvvm_tutorial.ui.todo_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_tutorial.data.Todo

@Composable
fun TodoItem(
    todo: Todo,
    onEvent: (TodoListEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = todo.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {
                    onEvent(TodoListEvent.OnDeleteTodoClick(todo))
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
            todo.description?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it)
            }
        }

        Checkbox(
            checked = todo.isDone,
            onCheckedChange = { isChecked ->
                onEvent(TodoListEvent.OnDoneChange(todo, isChecked))
            }
        )
    }
}

/*
* Step 10
* here we create a composable that takes 3 parameters,
* these are the todoItem from our database that we want to show in the UI,
* next we need the onEvent parameter which will be a lambda function that will take a TodoListEvent and doesn't return anything
* and lastly, we pass a modifier
*
* For the screen, we will first have an outer container which will be Row
* and inside this Row element, we will have a Column element and a checkbox
* Within the column we will have another Row element that will have the Name of the task and the description of the task.
*
* The good thing about having the TodoListEvent class is, that all we really need to do for the child composables (because the composable we had created that is the TodoItem) is not the parent composable,
* it doesn't reflect the whole screen, it is just a single item.
* In a more complex app, we would have many more such single items which could contain other custom composables that we implemented
* and all of these only need the onEvent() function to propagate events upto the parent stream which then talks to the ViewModel.
* If we don't do this, then we would need to have a callback function for every single thing a user could do. In this case, then we would have needed a parameter for adding an item,
* for deleting an item, for toggling the isDone state etc.
*
* Having this Event class, we only need the onEvent() function for every one of our child composables which makes it much more easier.
*
* Last thing to is the checkbox which we will add to the outer Row
*
* Next Step is to implement the TodoList Screen which we will do in the same package.
* */