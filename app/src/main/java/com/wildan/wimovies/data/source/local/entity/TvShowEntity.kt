package com.wildan.wimovies.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tvshowentities")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: String,

        @ColumnInfo(name = "tvShowTitle")
        var tvShowTitle: String,

        @ColumnInfo(name = "tvShowGenre")
        var tvShowGenre: String,

        @ColumnInfo(name = "tvShowRating")
        var tvShowRating: String,

        @ColumnInfo(name = "tvShowDescription")
        var tvShowDescription: String,

        @ColumnInfo(name = "tvShowPoster")
        var tvShowPoster: String,

        @ColumnInfo(name = "tvShowBookmarked")
        var tvShowBookmarked: Boolean = false
): Parcelable