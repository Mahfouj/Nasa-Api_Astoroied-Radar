package com.example.nasa_api_astoroied_radar


import com.squareup.moshi.Json

data class Response_data(
    @Json(name = "element_count")
    val elementCount: Int?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "near_earth_objects")
    val nearEarthObjects: NearEarthObjects?
) {
    data class Links(
        @Json(name = "next")
        val next: String?,
        @Json(name = "previous")
        val previous: String?,
        @Json(name = "self")
        val self: String?
    )

    data class NearEarthObjects(
        @Json(name = "2015-09-07")
        val x20150907: List<X20150907?>?,
        @Json(name = "2015-09-08")
        val x20150908: List<X20150908?>?
    ) {
        data class X20150907(
            @Json(name = "absolute_magnitude_h")
            val absoluteMagnitudeH: Double?,
            @Json(name = "close_approach_data")
            val closeApproachData: List<CloseApproachData?>?,
            @Json(name = "estimated_diameter")
            val estimatedDiameter: EstimatedDiameter?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "is_potentially_hazardous_asteroid")
            val isPotentiallyHazardousAsteroid: Boolean?,
            @Json(name = "is_sentry_object")
            val isSentryObject: Boolean?,
            @Json(name = "links")
            val links: Links?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "nasa_jpl_url")
            val nasaJplUrl: String?,
            @Json(name = "neo_reference_id")
            val neoReferenceId: String?
        ) {
            data class CloseApproachData(
                @Json(name = "close_approach_date")
                val closeApproachDate: String?,
                @Json(name = "close_approach_date_full")
                val closeApproachDateFull: String?,
                @Json(name = "epoch_date_close_approach")
                val epochDateCloseApproach: Long?,
                @Json(name = "miss_distance")
                val missDistance: MissDistance?,
                @Json(name = "orbiting_body")
                val orbitingBody: String?,
                @Json(name = "relative_velocity")
                val relativeVelocity: RelativeVelocity?
            ) {
                data class MissDistance(
                    @Json(name = "astronomical")
                    val astronomical: String?,
                    @Json(name = "kilometers")
                    val kilometers: String?,
                    @Json(name = "lunar")
                    val lunar: String?,
                    @Json(name = "miles")
                    val miles: String?
                )

                data class RelativeVelocity(
                    @Json(name = "kilometers_per_hour")
                    val kilometersPerHour: String?,
                    @Json(name = "kilometers_per_second")
                    val kilometersPerSecond: String?,
                    @Json(name = "miles_per_hour")
                    val milesPerHour: String?
                )
            }

            data class EstimatedDiameter(
                @Json(name = "feet")
                val feet: Feet?,
                @Json(name = "kilometers")
                val kilometers: Kilometers?,
                @Json(name = "meters")
                val meters: Meters?,
                @Json(name = "miles")
                val miles: Miles?
            ) {
                data class Feet(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Kilometers(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Meters(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Miles(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )
            }

            data class Links(
                @Json(name = "self")
                val self: String?
            )
        }

        data class X20150908(
            @Json(name = "absolute_magnitude_h")
            val absoluteMagnitudeH: Double?,
            @Json(name = "close_approach_data")
            val closeApproachData: List<CloseApproachData?>?,
            @Json(name = "estimated_diameter")
            val estimatedDiameter: EstimatedDiameter?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "is_potentially_hazardous_asteroid")
            val isPotentiallyHazardousAsteroid: Boolean?,
            @Json(name = "is_sentry_object")
            val isSentryObject: Boolean?,
            @Json(name = "links")
            val links: Links?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "nasa_jpl_url")
            val nasaJplUrl: String?,
            @Json(name = "neo_reference_id")
            val neoReferenceId: String?
        ) {
            data class CloseApproachData(
                @Json(name = "close_approach_date")
                val closeApproachDate: String?,
                @Json(name = "close_approach_date_full")
                val closeApproachDateFull: String?,
                @Json(name = "epoch_date_close_approach")
                val epochDateCloseApproach: Long?,
                @Json(name = "miss_distance")
                val missDistance: MissDistance?,
                @Json(name = "orbiting_body")
                val orbitingBody: String?,
                @Json(name = "relative_velocity")
                val relativeVelocity: RelativeVelocity?
            ) {
                data class MissDistance(
                    @Json(name = "astronomical")
                    val astronomical: String?,
                    @Json(name = "kilometers")
                    val kilometers: String?,
                    @Json(name = "lunar")
                    val lunar: String?,
                    @Json(name = "miles")
                    val miles: String?
                )

                data class RelativeVelocity(
                    @Json(name = "kilometers_per_hour")
                    val kilometersPerHour: String?,
                    @Json(name = "kilometers_per_second")
                    val kilometersPerSecond: String?,
                    @Json(name = "miles_per_hour")
                    val milesPerHour: String?
                )
            }

            data class EstimatedDiameter(
                @Json(name = "feet")
                val feet: Feet?,
                @Json(name = "kilometers")
                val kilometers: Kilometers?,
                @Json(name = "meters")
                val meters: Meters?,
                @Json(name = "miles")
                val miles: Miles?
            ) {
                data class Feet(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Kilometers(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Meters(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )

                data class Miles(
                    @Json(name = "estimated_diameter_max")
                    val estimatedDiameterMax: Double?,
                    @Json(name = "estimated_diameter_min")
                    val estimatedDiameterMin: Double?
                )
            }

            data class Links(
                @Json(name = "self")
                val self: String?
            )
        }
    }

    companion object

}