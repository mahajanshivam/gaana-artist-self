package com.shivam.gaanaartist.core.data.repository

import com.shivam.gaanaartist.core.datastore.UserPreferencesDataSource
import com.shivam.gaanaartist.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserDataRepository {


    //
//    implement user data repo to handle whether user has signed in or not
//
//    an object of this repo impl is passed to rememberGaanaArtistAppState() from MainActivity
//    to handle which screen is to be opened, i.e. MainContentscreen with bottom nav and content
//    or login and onboarding screens
    override val userData: Flow<UserData> = userPreferencesDataSource.userData

    override suspend fun getUserData() {

    }

    override suspend fun setLoginCompleted() {

    }

    override suspend fun setOnboardingCompleted() {

    }
}