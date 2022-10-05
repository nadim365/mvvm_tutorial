package com.example.mvvm_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.mvvm_tutorial.ui.theme.MvvmTodoAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            MvvmTodoAppTheme() {
                
            }
        }
    }
}