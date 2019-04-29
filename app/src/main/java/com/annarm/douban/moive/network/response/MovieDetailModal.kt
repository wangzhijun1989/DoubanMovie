package com.annarm.douban.moive.network.response

/**
 * description:
 * @author wangzhijun
 * date 2019/4/28 7:21 PM
 * @version V1.0
 */
data class MovieDetailModal(
    val aka: List<String>,
    val alt: String,
    val casts: List<Cast>,
    val collect_count: Int,
    val comments_count: Int,
    val countries: List<String>,
    val current_season: Any,
    val directors: List<Director>,
    val do_count: Any,
    val douban_site: String,
    val episodes_count: Any,
    val genres: List<String>,
    val id: String,
    val images: Images,
    val mobile_url: String,
    val original_title: String,
    val rating: Rating,
    val ratings_count: Int,
    val reviews_count: Int,
    val schedule_url: String,
    val seasons_count: Any,
    val share_url: String,
    val subtype: String,
    val summary: String,
    val title: String,
    val wish_count: Int,
    val year: String
)

data class Director(
    val alt: String,
    val avatars: AvatarsX,
    val id: String,
    val name: String
)

data class Avatars(
    val large: String,
    val medium: String,
    val small: String
)

data class Rating(
    val average: Double,
    val max: Int,
    val min: Int,
    val stars: String
)

data class Images(
    val large: String,
    val medium: String,
    val small: String
)

data class Cast(
    val alt: String,
    val avatars: Avatars,
    val id: String,
    val name: String
)

data class AvatarsX(
    val large: String,
    val medium: String,
    val small: String
)