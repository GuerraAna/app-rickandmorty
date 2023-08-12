package com.example.app_rickandmorty.analytics

interface TrackedPage {

    fun getPageName(): AnalyticsPageName

    fun onNavigateTo(isFirstLoad: Boolean)

}
