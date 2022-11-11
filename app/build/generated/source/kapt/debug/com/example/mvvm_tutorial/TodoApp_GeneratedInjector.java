package com.example.mvvm_tutorial;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = TodoApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface TodoApp_GeneratedInjector {
  void injectTodoApp(TodoApp todoApp);
}
