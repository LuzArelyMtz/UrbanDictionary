package net.aptivist.daggerbase.dagger.modules

import androidx.lifecycle.ViewModel
import com.nike.urbandictionary.viewmodels.MainViewModel
import com.nike.urbandictionary.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MainViewModel): ViewModel
}