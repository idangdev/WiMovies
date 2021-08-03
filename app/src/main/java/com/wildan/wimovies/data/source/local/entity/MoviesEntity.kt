package com.wildan.wimovies.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "moviesentities")
data class MoviesEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "moviesId")
        var moviesId: String,

        @ColumnInfo(name = "moviesTitle")
        var moviesTitle: String,

        @ColumnInfo(name = "moviesGenre")
        var moviesGenre: String,

        @ColumnInfo(name = "moviesRating")
        var moviesRating: String,

        @ColumnInfo(name = "moviesDescription")
        var moviesDescription: String,

        @ColumnInfo(name = "moviesPoster")
        var moviesPoster: String,

        @ColumnInfo(name = "moviesBookmarked")
        var moviesBookmarked: Boolean = false
): Parcelable