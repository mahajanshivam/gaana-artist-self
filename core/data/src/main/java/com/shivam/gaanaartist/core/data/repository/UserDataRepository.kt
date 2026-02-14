package com.shivam.gaanaartist.core.data.repository

import com.shivam.gaanaartist.core.model.data.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun getUserData()

    suspend fun setLoginCompleted()

    suspend fun setOnboardingCompleted()
}