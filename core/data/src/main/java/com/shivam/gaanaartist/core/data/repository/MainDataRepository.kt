package com.shivam.gaanaartist.core.data.repository

import com.shivam.gaanaartist.core.model.data.MainData

interface MainDataRepository {
    fun getData(): MainData
}