package com.ucne.parcial1_jeremy.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.ucne.parcial1_jeremy.data.AppDataBase
import com.ucne.parcial1_jeremy.data.remote.ArticuloApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDababase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "ParcialDb"
        ).fallbackToDestructiveMigration().build()
    }
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    @Singleton
    @Provides
    fun providesArticuloApi(moshi: Moshi): ArticuloApi {
        return Retrofit.Builder()
            .baseUrl("http://www.consumoapi.somee.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ArticuloApi::class.java)
    }
}