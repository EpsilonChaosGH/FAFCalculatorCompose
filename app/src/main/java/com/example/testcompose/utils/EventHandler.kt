package com.example.testcompose.utils

interface EventHandler<T> {
    fun obtainEvent(event: T)
}