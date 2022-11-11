package com.example.mvvm_tutorial.ui.todo_list;

import androidx.lifecycle.ViewModel;
import com.example.mvvm_tutorial.data.Todo;
import com.example.mvvm_tutorial.data.TodoRepository;
import com.example.mvvm_tutorial.util.Routes;
import com.example.mvvm_tutorial.util.UiEvent;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/mvvm_tutorial/data/TodoRepository;", "(Lcom/example/mvvm_tutorial/data/TodoRepository;)V", "_uiEvent", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/mvvm_tutorial/util/UiEvent;", "deletedTodo", "Lcom/example/mvvm_tutorial/data/Todo;", "todos", "Lkotlinx/coroutines/flow/Flow;", "", "getTodos", "()Lkotlinx/coroutines/flow/Flow;", "uiEvent", "getUiEvent", "onEvent", "", "event", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "sendUiEvent", "app_debug"})
public final class TodoListViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.mvvm_tutorial.data.TodoRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.mvvm_tutorial.data.Todo>> todos = null;
    private final kotlinx.coroutines.channels.Channel<com.example.mvvm_tutorial.util.UiEvent> _uiEvent = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.mvvm_tutorial.util.UiEvent> uiEvent = null;
    private com.example.mvvm_tutorial.data.Todo deletedTodo;
    
    @javax.inject.Inject()
    public TodoListViewModel(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.data.TodoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.mvvm_tutorial.data.Todo>> getTodos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.mvvm_tutorial.util.UiEvent> getUiEvent() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull()
    com.example.mvvm_tutorial.ui.todo_list.TodoListEvent event) {
    }
    
    private final void sendUiEvent(com.example.mvvm_tutorial.util.UiEvent event) {
    }
}