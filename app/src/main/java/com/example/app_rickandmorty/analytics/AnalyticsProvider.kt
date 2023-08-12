package com.example.app_rickandmorty.analytics

interface AnalyticsProvider {

    fun trackView()

    fun trackSeenObject()

    fun trackClick()
}