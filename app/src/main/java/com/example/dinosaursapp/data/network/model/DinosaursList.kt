package com.example.dinosaursapp.data.network.model

import android.content.Context
import android.os.Parcelable
import com.example.dinosaursapp.utils.getCurrentLanguage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DinosaursList(

    @SerializedName("Dinousaurs")
    var dinosaurs: Dinosaurs? = null
)

data class Dinosaurs(
    @SerializedName("en")
    var en: EnglishVersion? = null,

    @SerializedName("ru")
    var ru: RussianVersion? = null
)

private fun localizedField(
    context: Context,
    enField: EnglishVersion?,
    ruField: RussianVersion?
): CurrentLanguage? {
    val lang = context.getCurrentLanguage()
    val result = when (lang) {
        "en" -> enField
        "ru" -> ruField
        else -> ruField
    }
    return result
}

fun Dinosaurs.localizedCurrentLang(context: Context) = localizedField(
    context,
    en, ru
)

@Parcelize
data class EnglishVersion(
    @SerializedName("Land")
    var land: List<Land>? = ArrayList(),

    @SerializedName("Sweem")
    var aqua: List<Aqua>? = ArrayList(),

    @SerializedName("Fly")
    var air: List<Air>? = ArrayList()
) : CurrentLanguage

@Parcelize
data class RussianVersion(
    @SerializedName("Land")
    var land: List<Land>? = ArrayList(),

    @SerializedName("Sweem")
    var aqua: List<Aqua>? = ArrayList(),

    @SerializedName("Fly")
    var air: List<Air>? = ArrayList()
) : CurrentLanguage

@Parcelize
data class Land(

    @SerializedName("titleRussian")
    var title: String? = "",

    @SerializedName("photoUrlRussian")
    var imageMain: String? = "",

    @SerializedName("rusCompare")
    var imageCompare: String? = "",

    @SerializedName("detailRussian")
    var detail: String? = "",

    @SerializedName("description1Russian")
    var descriptionFirst: String? = "",

    @SerializedName("description2Russian")
    var descriptionSecond: String? = "",

    @SerializedName("takenRussian")
    var takenFrom: String? = "",

    @SerializedName("isOnSaleRussian")
    var isPredator: Boolean? = false

) : Parcelable, DinosaurType

@Parcelize
data class Aqua(

    @SerializedName("titleSwim")
    var title: String? = "",

    @SerializedName("photoUrlSwim")
    var image: String? = "",

    @SerializedName("detailSwim")
    var detail: String? = "",

    @SerializedName("description1Swim")
    var descriptionFirst: String? = "",

    @SerializedName("description2Swim")
    var descriptionSecond: String? = "",

    @SerializedName("takenSwim")
    var takenFrom: String? = ""


) : Parcelable, DinosaurType

@Parcelize
data class Air(

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("photo")
    var image: String? = "",

    @SerializedName("compare")
    var imageCompare: String? = "",

    @SerializedName("detail")
    var detail: String? = "",

    @SerializedName("description1")
    var descriptionFirst: String? = "",

    @SerializedName("description2")
    var descriptionSecond: String? = "",

    @SerializedName("taken")
    var takenFrom: String? = ""
) : Parcelable, DinosaurType