package com.example.dinosaursapp.data.network.model

import android.content.Context
import android.os.Parcelable
import com.example.dinosaursapp.utils.getCurrentLanguage
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DinosaursList(

    @SerializedName("Dinousaurs")
    val dinosaurs: Dinosaurs? = null
)

data class Dinosaurs(
    @SerializedName("en")
    val en: EnglishVersion? = null,

    @SerializedName("ru")
    val ru: RussianVersion? = null
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
    val land: List<Land>? = ArrayList(),

    @SerializedName("Sweem")
    val aqua: List<Aqua>? = ArrayList(),

    @SerializedName("Fly")
    val air: List<Air>? = ArrayList()
) : CurrentLanguage

@Parcelize
data class RussianVersion(
    @SerializedName("Land")
    val land: List<Land>? = ArrayList(),

    @SerializedName("Sweem")
    val aqua: List<Aqua>? = ArrayList(),

    @SerializedName("Fly")
    val air: List<Air>? = ArrayList()
) : CurrentLanguage

@Parcelize
data class Land(

    @SerializedName("titleRussian")
    val title: String? = "",

    @SerializedName("photoUrlRussian")
    val imageMain: String? = "",

    @SerializedName("rusCompare")
    val imageCompare: String? = "",

    @SerializedName("detailRussian")
    val detail: String? = "",

    @SerializedName("description1Russian")
    val descriptionFirst: String? = "",

    @SerializedName("description2Russian")
    val descriptionSecond: String? = "",

    @SerializedName("takenRussian")
    val takenFrom: String? = "",

    @SerializedName("isOnSaleRussian")
    val isPredator: Boolean? = false

) : Parcelable, DinosaurType

@Parcelize
data class Aqua(

    @SerializedName("titleSwim")
    val title: String? = "",

    @SerializedName("photoUrlSwim")
    val image: String? = "",

    @SerializedName("detailSwim")
    val detail: String? = "",

    @SerializedName("description1Swim")
    val descriptionFirst: String? = "",

    @SerializedName("description2Swim")
    val descriptionSecond: String? = "",

    @SerializedName("takenSwim")
    val takenFrom: String? = ""


) : Parcelable, DinosaurType

@Parcelize
data class Air(

    @SerializedName("title")
    val title: String? = "",

    @SerializedName("photo")
    val image: String? = "",

    @SerializedName("compare")
    val imageCompare: String? = "",

    @SerializedName("detail")
    val detail: String? = "",

    @SerializedName("description1")
    val descriptionFirst: String? = "",

    @SerializedName("description2")
    val descriptionSecond: String? = "",

    @SerializedName("taken")
    val takenFrom: String? = ""
) : Parcelable, DinosaurType