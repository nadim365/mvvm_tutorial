package com.example.mvvm_tutorial.ui.todo_list;

import com.example.mvvm_tutorial.data.Todo;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "", "()V", "OnAddTodoClick", "OnDeleteTodoClick", "OnDoneChange", "OnTodoClick", "OnUndoDeleteClick", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnAddTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnDeleteTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnDoneChange;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnUndoDeleteClick;", "app_debug"})
public abstract class TodoListEvent {
    
    private TodoListEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnDeleteTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "todo", "Lcom/example/mvvm_tutorial/data/Todo;", "(Lcom/example/mvvm_tutorial/data/Todo;)V", "getTodo", "()Lcom/example/mvvm_tutorial/data/Todo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnDeleteTodoClick extends com.example.mvvm_tutorial.ui.todo_list.TodoListEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.example.mvvm_tutorial.data.Todo todo = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.ui.todo_list.TodoListEvent.OnDeleteTodoClick copy(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public OnDeleteTodoClick(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo getTodo() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnDoneChange;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "todo", "Lcom/example/mvvm_tutorial/data/Todo;", "isDone", "", "(Lcom/example/mvvm_tutorial/data/Todo;Z)V", "()Z", "getTodo", "()Lcom/example/mvvm_tutorial/data/Todo;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnDoneChange extends com.example.mvvm_tutorial.ui.todo_list.TodoListEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.example.mvvm_tutorial.data.Todo todo = null;
        private final boolean isDone = false;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.ui.todo_list.TodoListEvent.OnDoneChange copy(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo, boolean isDone) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public OnDoneChange(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo, boolean isDone) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo getTodo() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean isDone() {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnUndoDeleteClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "()V", "app_debug"})
    public static final class OnUndoDeleteClick extends com.example.mvvm_tutorial.ui.todo_list.TodoListEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.mvvm_tutorial.ui.todo_list.TodoListEvent.OnUndoDeleteClick INSTANCE = null;
        
        private OnUndoDeleteClick() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "todo", "Lcom/example/mvvm_tutorial/data/Todo;", "(Lcom/example/mvvm_tutorial/data/Todo;)V", "getTodo", "()Lcom/example/mvvm_tutorial/data/Todo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OnTodoClick extends com.example.mvvm_tutorial.ui.todo_list.TodoListEvent {
        @org.jetbrains.annotations.NotNull()
        private final com.example.mvvm_tutorial.data.Todo todo = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.ui.todo_list.TodoListEvent.OnTodoClick copy(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public OnTodoClick(@org.jetbrains.annotations.NotNull()
        com.example.mvvm_tutorial.data.Todo todo) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mvvm_tutorial.data.Todo getTodo() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent$OnAddTodoClick;", "Lcom/example/mvvm_tutorial/ui/todo_list/TodoListEvent;", "()V", "app_debug"})
    public static final class OnAddTodoClick extends com.example.mvvm_tutorial.ui.todo_list.TodoListEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.mvvm_tutorial.ui.todo_list.TodoListEvent.OnAddTodoClick INSTANCE = null;
        
        private OnAddTodoClick() {
            super();
        }
    }
}