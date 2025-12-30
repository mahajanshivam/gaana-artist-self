package com.shivam.gaanaartist.core.data.repository

import com.shivam.gaanaartist.core.model.data.MainData
import javax.inject.Inject

// TODO:: remove when no longer required
class FakeMainDataRepository @Inject constructor() : MainDataRepository {
    override fun getData(): MainData {
        return MainData(text = "Main Data from FakeMainDataRepository")
    }
}