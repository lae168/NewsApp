package com.androiddevs.mvvmnewsapp.prj.db

import androidx.room.TypeConverter


class Converters {
    @TypeConverter
    fun fromSource(source: com.androiddevs.mvvmnewsapp.prj.models.Source) : String {
        return source.name
    }
    @TypeConverter
    fun toSource(name:String) : com.androiddevs.mvvmnewsapp.prj.models.Source {
        return com.androiddevs.mvvmnewsapp.prj.models.Source(name, name)
    }
}