package com.example.testcompose

interface EventHandler<T> {
    fun obtainEvent(event: T)
}