package com.abhiram.silencer.di

import android.content.Context
import android.media.AudioManager
import android.provider.MediaStore.Audio
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
    fun providesAudioManager(@ApplicationContext context: Context) : AudioManager{
        return context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }
}