package io.bonial.test.data.model

import com.google.gson.annotations.SerializedName

data class BrochureData(
    @SerializedName("_embedded" ) var Embedded : Embedded? = Embedded()
)

data class Embedded (
    @SerializedName("contents" ) var contents : ArrayList<Contents> = arrayListOf()
)

data class ExternalTracking (
    @SerializedName("impression" ) var impression : ArrayList<String> = arrayListOf(),
    @SerializedName("click"      ) var click      : ArrayList<String> = arrayListOf()
)

data class Contents (
    @SerializedName("placement"           ) var placement           : String?            = null,
    @SerializedName("adFormat"            ) var adFormat            : String?            = null,
    @SerializedName("contentFormatSource" ) var contentFormatSource : String?            = null,
    @SerializedName("contentType"         ) var contentType         : String?            = null,
    @SerializedName("externalTracking"    ) var externalTracking    : ExternalTracking?  = ExternalTracking(),
    @SerializedName("content"             ) var content             : Any?,
)

data class ContentObj (
    @SerializedName("id"             ) var id             : String? = null,
    @SerializedName("publisherId"    ) var publisherId    : Int?    = null,
    @SerializedName("publishedFrom"  ) var publishedFrom  : String? = null,
    @SerializedName("publishedUntil" ) var publishedUntil : String? = null,
    @SerializedName("clickUrl"       ) var clickUrl       : String? = null,
    @SerializedName("imageUrl"       ) var imageUrl       : String? = null,
    @SerializedName("brochureImage"  ) var brochureImage       : String? = null,
    @SerializedName("retailer"       ) var retailer             : Retailer?        =  Retailer(),
    @SerializedName("distance"       ) var distance             : Double?        =  null
)

data class Retailer (
    @SerializedName("id"             ) var id              : String? = null,
    @SerializedName("name"           ) var name            : String?    = null
)
