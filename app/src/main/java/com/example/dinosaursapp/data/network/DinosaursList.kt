package com.example.dinosaursapp.data.network

import com.google.gson.annotations.SerializedName

class DinosaursList {

    @SerializedName("Dinousaurs")
    var dinosaurs : Dinosaurs? = null

}

class Dinosaurs {
    @SerializedName("en")
    var en: EnglishVersion? = null

    @SerializedName("ru")
    var ru: RussianVersion? = null
}

class EnglishVersion {
    @SerializedName("Land")
    var land: List<Land>? = ArrayList()

    @SerializedName("Sweem")
    var sweem: List<Sweem>? = ArrayList()

    @SerializedName("Fly")
    var fly: List<Fly>? = ArrayList()
}

class RussianVersion {
    @SerializedName("Land")
    var land: List<Land>? = ArrayList()

    @SerializedName("Sweem")
    var sweem: List<Sweem>? = ArrayList()

    @SerializedName("Fly")
    var fly: List<Fly>? = ArrayList()
}

class Land {

    @SerializedName("titleRussian")
    var title: String? = ""

    @SerializedName("photoUrlRussian")
    var imageMain: String? = ""

    @SerializedName("rusCompare")
    var imageCompare: String? = ""

    @SerializedName("detailRussian")
    var detail : String? = ""

    @SerializedName("description1Russian")
    var descriptionFirst : String? = ""

    @SerializedName("description2Russian")
    var descriptionSecond : String? = ""

    @SerializedName("takenRussian")
    var takenFrom : String? = ""

    @SerializedName("isOnSaleRussian")
    var isPredator : Boolean? = false

}

class Sweem {

    @SerializedName("titleSwim")
    var title: String? = ""

    @SerializedName("photoUrlSwim")
    var image: String? = ""

    @SerializedName("detailSwim")
    var detail: String? = ""

    @SerializedName("description1Swim")
    var descriptionFirst: String? = ""

    @SerializedName("description2Swim")
    var descriptionSecond: String? = ""

    @SerializedName("takenSwim")
    var takenFrom: String? = ""


}

class Fly {

    @SerializedName("title")
    var title : String? = ""

    @SerializedName("photo")
    var image : String? = ""

    @SerializedName("compare")
    var imageCompare : String? = ""

    @SerializedName("detail")
    var detail : String? = ""

    @SerializedName("description1")
    var descriptionFirst : String? = ""

    @SerializedName("description2")
    var descriptionSecond : String? = ""

    @SerializedName("taken")
    var takenFrom : String? = ""
}