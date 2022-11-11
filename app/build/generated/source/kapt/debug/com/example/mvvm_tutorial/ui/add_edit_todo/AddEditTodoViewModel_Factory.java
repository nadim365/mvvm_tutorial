// Generated by Dagger (https://dagger.dev).
package com.example.mvvm_tutorial.ui.add_edit_todo;

import androidx.lifecycle.SavedStateHandle;
import com.example.mvvm_tutorial.data.TodoRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AddEditTodoViewModel_Factory implements Factory<AddEditTodoViewModel> {
  private final Provider<TodoRepository> repositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public AddEditTodoViewModel_Factory(Provider<TodoRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public AddEditTodoViewModel get() {
    return newInstance(repositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static AddEditTodoViewModel_Factory create(Provider<TodoRepository> repositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new AddEditTodoViewModel_Factory(repositoryProvider, savedStateHandleProvider);
  }

  public static AddEditTodoViewModel newInstance(TodoRepository repository,
      SavedStateHandle savedStateHandle) {
    return new AddEditTodoViewModel(repository, savedStateHandle);
  }
}