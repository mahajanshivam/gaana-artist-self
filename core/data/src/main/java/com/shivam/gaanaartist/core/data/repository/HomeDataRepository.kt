package com.shivam.gaanaartist.core.data.repository


// TODO :: inject home data source here and use that to fetch n/w data for home page
interface HomeDataRepository {

    abstract fun getSampleHomeText(): String

//    fun getHomeSectionList():List<HomeSection>
}