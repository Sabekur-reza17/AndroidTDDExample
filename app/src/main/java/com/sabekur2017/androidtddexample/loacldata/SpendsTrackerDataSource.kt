package com.sabekur2017.androidtddexample.loacldata

class SpendsTrackerDataSource(private val db: SpendDao) {
    suspend fun addSpend(spend: Spend) = db.addSpend(spend)
    suspend fun getLast20spends() = db.getLast20Spends()
}