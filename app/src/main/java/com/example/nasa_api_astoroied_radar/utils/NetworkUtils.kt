package com.example.nasa_api_astoroied_radar.utils

import com.example.nasa_api_astoroied_radar.db.model.Asteroid
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun AsteroidJsonResult(jsonObject: JSONObject): ArrayList<Asteroid> {
    val nearEarthObjects = jsonObject.getJSONObject("near_earth_objects")
    val asteroidList = ArrayList<Asteroid>()
    val next7Days = getNext7Days()

    for (formatedDate in next7Days) {

        if (nearEarthObjects.has(formatedDate)) {
            val dateWiseData = nearEarthObjects.getJSONArray(formatedDate)

            for (index in 0 until dateWiseData.length()) {
                val asteroidJson = dateWiseData.getJSONObject(index)
                val id = asteroidJson.getLong("id")
                val codename = asteroidJson.getString("name")
                val absoluteMagnitude = asteroidJson.getDouble("absolute_magnitude_h")
                val isPotentiallyHazardous =
                    asteroidJson.getBoolean("is_potentially_hazardous_asteroid")

                //estimatedDiameterMin_Max
                val estimatedDiameterObject = asteroidJson.getJSONObject("estimated_diameter")
                val estimatedDiameterInKilometers = estimatedDiameterObject.getJSONObject("kilometers")
                val estimatedDiameterMin = estimatedDiameterInKilometers.getDouble("estimated_diameter_min")
                val estimatedDiameterMax = estimatedDiameterInKilometers.getDouble("estimated_diameter_max")

                //closeApproachDate
                val closeApproachData = asteroidJson
                    .getJSONArray("close_approach_data")
                    .getJSONObject(0)

                val closeApproachDate = closeApproachData.getString("close_approach_date")

                val relativeVelocityObject = closeApproachData.getJSONObject("relative_velocity")
                val relativeVelocity = relativeVelocityObject.getDouble("kilometers_per_hour")


                //distanceFromEarth
                val missDistanceObject = closeApproachData.getJSONObject("miss_distance")
                val distanceFromEarth = missDistanceObject.getDouble("kilometers")

                asteroidList.add(
                    Asteroid(
                        id,
                        codename,
                        closeApproachDate,
                        absoluteMagnitude,
                        estimatedDiameterMin,
                        estimatedDiameterMax,
                        relativeVelocity,
                        distanceFromEarth,
                        isPotentiallyHazardous
                    )
                )
            }
        }

    }

    return asteroidList
}



fun getNext7Days(): ArrayList<String> {
    val listOfDays = ArrayList<String>()

    val calendar = Calendar.getInstance()

    for (i in 1..7) {
        val currentTime = calendar.time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        listOfDays.add(dateFormat.format(currentTime))
        calendar.add(Calendar.DAY_OF_YEAR, 1)
    }

    return listOfDays
}