package com.beko.universityfinderapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class University (
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @SerializedName("domains"        ) var domains        : ArrayList<String> = arrayListOf(),
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("state-province" ) var state_province : String?           = null,
    @SerializedName("web_pages"      ) var webPages       : ArrayList<String> = arrayListOf(),
    @SerializedName("name"           ) var name           : String?           = null
):Parcelable
