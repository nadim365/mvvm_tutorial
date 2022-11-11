package com.example.mvvm_tutorial.di;

import android.app.Application;
import androidx.room.Room;
import com.example.mvvm_tutorial.data.TodoDatabase;
import com.example.mvvm_tutorial.data.TodoRepository;
import com.example.mvvm_tutorial.data.TodoRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/mvvm_tutorial/di/AppModule;", "", "()V", "provideTodoDatabase", "Lcom/example/mvvm_tutorial/data/TodoDatabase;", "app", "Landroid/app/Application;", "provideTodoRepository", "Lcom/example/mvvm_tutorial/data/TodoRepository;", "db", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mvvm_tutorial.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.mvvm_tutorial.data.TodoDatabase provideTodoDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.mvvm_tutorial.data.TodoRepository provideTodoRepository(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.data.TodoDatabase db) {
        return null;
    }
}