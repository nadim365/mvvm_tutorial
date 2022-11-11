package com.example.mvvm_tutorial.data;

import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fH\u0016J\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/mvvm_tutorial/data/TodoRepositoryImpl;", "Lcom/example/mvvm_tutorial/data/TodoRepository;", "dao", "Lcom/example/mvvm_tutorial/data/TodoDao;", "(Lcom/example/mvvm_tutorial/data/TodoDao;)V", "deleteTodo", "", "todo", "Lcom/example/mvvm_tutorial/data/Todo;", "(Lcom/example/mvvm_tutorial/data/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodoById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodos", "Lkotlinx/coroutines/flow/Flow;", "", "insertTodo", "app_debug"})
public final class TodoRepositoryImpl implements com.example.mvvm_tutorial.data.TodoRepository {
    private final com.example.mvvm_tutorial.data.TodoDao dao = null;
    
    public TodoRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.data.TodoDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.data.Todo todo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.data.Todo todo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getTodoById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.mvvm_tutorial.data.Todo> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.mvvm_tutorial.data.Todo>> getTodos() {
        return null;
    }
}