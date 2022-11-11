// Generated by Dagger (https://dagger.dev).
package com.example.mvvm_tutorial.di;

import android.app.Application;
import com.example.mvvm_tutorial.data.TodoDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideTodoDatabaseFactory implements Factory<TodoDatabase> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideTodoDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public TodoDatabase get() {
    return provideTodoDatabase(appProvider.get());
  }

  public static AppModule_ProvideTodoDatabaseFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideTodoDatabaseFactory(appProvider);
  }

  public static TodoDatabase provideTodoDatabase(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTodoDatabase(app));
  }
}
