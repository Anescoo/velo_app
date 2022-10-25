package com.example.bikesinnantes.model

import kotlinx.serialization.*

var stationSelected:Station? = null
@Serializable
data class Station (
    val id: Long,
    val name: String,
    val lattitude: Double,
    val longitude: Double,
    val status: String,
    val address: String,
    val bikeStands: Long,
    val availableBikes: Long,
    val availableBikeStands: Long,
    val recordId: String
)
