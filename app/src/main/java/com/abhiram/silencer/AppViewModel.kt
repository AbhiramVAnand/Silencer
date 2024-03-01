package com.abhiram.silencer

import android.media.AudioManager
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    preferencesHelper: PreferencesHelper,
    audioManager: AudioManager
) : ViewModel() {
    var sharedPreferences = preferencesHelper
    val audioManager = audioManager

    fun getIsSilent() : Boolean{
        var v = sharedPreferences.getIsSilent()
        return v
    }

    fun updateIsSilent(){
        var v = sharedPreferences.getIsSilent()
        sharedPreferences.setIsSilent(!v)
    }

    fun updateRingStatus(){
        audioManager.adjustStreamVolume(
            AudioManager.STREAM_RING,
            AudioManager.ADJUST_TOGGLE_MUTE,0
        )
        audioManager.ringerMode = AudioManager.RINGER_MODE_VIBRATE
    }
}