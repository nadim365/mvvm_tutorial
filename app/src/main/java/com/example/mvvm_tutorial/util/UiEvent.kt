package com.example.mvvm_tutorial.util
//Part of Step 8


sealed class UiEvent {
    object PopBackStack: UiEvent() // Event that we send to the UI when we want to navigate back
    data class Navigate(val route: String): UiEvent ()// Event we send from the ViewModel to the Ui when we want to navigate to a new screen. The route parameter is the route we actually want to navigate to.
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}


/*
* Coming from step 8 section 2 where we define the Channel
*/