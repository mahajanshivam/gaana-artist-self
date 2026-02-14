package com.shivam.gaanaartist.core.datastore

import androidx.datastore.core.DataStore
import com.shivam.gaanaartist.core.model.data.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {

    val userData = userPreferences.data
        .map {
            UserData(
                name = it.name,
                id = it.id,
                isLoggedIn = it.isLoggedIn,
                isOnboardingCompleted = it.isOnboardingCompleted
            )
        }

    suspend fun setLoginCompleted(){
        userPreferences.updateData {
            it.copy {
                isLoggedIn = true
            }
        }
    }

    suspend fun setOnboardingCompleted(){
        userPreferences.updateData {
            it.copy {
                isOnboardingCompleted = true
            }
        }
    }

}