package com.example.ezmemo.di

import android.content.Context
import androidx.room.Room
import com.example.ezmemo.repositorys.ItemRepository
import com.example.ezmemo.room.AppDatabase
import com.example.ezmemo.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):
            AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "item_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideItemDao(appDatabase: AppDatabase): ItemDao = appDatabase.itemDao()

    @Provides
    fun provideItemRepository(itemDao: ItemDao): ItemRepository = ItemRepository(itemDao)
}