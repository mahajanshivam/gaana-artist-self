package com.shivam.gaanaartist.core.data.di

import com.shivam.gaanaartist.core.data.repository.ConnectivityManagerNetworkMonitor
import com.shivam.gaanaartist.core.data.repository.FakeMainDataRepository
import com.shivam.gaanaartist.core.data.repository.MainDataRepository
import com.shivam.gaanaartist.core.data.repository.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun bindsMainDataRepository(
        repository: FakeMainDataRepository
    ): MainDataRepository
}