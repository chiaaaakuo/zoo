package com.example.zoo.AppCore.Model

import com.google.gson.annotations.SerializedName


data class Exhibit(
    @SerializedName("E_Pic_URL") var img: String,
    @SerializedName("E_Name") var name: String,
    @SerializedName("E_Category") var category: String,
    @SerializedName("E_Info") var info: String,
    @SerializedName("E_Memo") var memo: String,
    @SerializedName("E_URL") var url: String,
    @SerializedName("E_Geo")  var geo:String,
    @SerializedName("E_no")  var no:String,
    @SerializedName("_id")  var id:String
    ){

}