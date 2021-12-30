package com.example.zoo.AppCore.Model

import com.google.gson.annotations.SerializedName

data class Plant(
    @SerializedName("F_Name_Ch")var nameCh: String="",
    @SerializedName("F_Name_En") var nameEn: String="",
    @SerializedName("F_Name_Latin")var nameLatin: String="",
    @SerializedName("F_Family")var family: String="",
    @SerializedName("F_Genus") var genus: String="",
    @SerializedName("F_Brief") var brief: String="",
    @SerializedName("F_Feature")var feature: String="",
    @SerializedName("F_Function＆Application")var function: String="",
    @SerializedName("F_Pic01_URL")var img: String="",
    @SerializedName("F_AlsoKnown")var alsoKnown:String="",
    @SerializedName("F_Location")var location:String="",
    @SerializedName("F_Update") var updateTime:String="",
    @SerializedName("_id") var id:String=""
) {


}