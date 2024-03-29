package com.example.myphysicsapps

import com.google.gson.annotations.SerializedName

data class Pagination(

	@field:SerializedName("pageCount")
	val pageCount: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("pageSize")
	val pageSize: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null
)

data class Thumbnail(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Any? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Equation(

	@field:SerializedName("data")
	val data: Data? = null
)

data class Data(

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Small(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Any? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Attributes(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("analogy")
	val analogy: String? = null,

	@field:SerializedName("equation")
	val equation: Equation? = null,

	@field:SerializedName("profilePic")
	val profilePic: ProfilePic? = null,

	@field:SerializedName("video")
	val video: Video? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("explanation")
	val explanation: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("formats")
	val formats: Formats? = null,

	@field:SerializedName("previewUrl")
	val previewUrl: Any? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("size")
	val size: Any? = null,

	@field:SerializedName("provider")
	val provider: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("provider_metadata")
	val providerMetadata: Any? = null,

	@field:SerializedName("alternativeText")
	val alternativeText: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class ProfilePic(

	@field:SerializedName("data")
	val data: Data? = null
)

data class Formats(

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail? = null,

	@field:SerializedName("small")
	val small: Small? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null
)

data class Medium(

	@field:SerializedName("ext")
	val ext: String? = null,

	@field:SerializedName("path")
	val path: Any? = null,

	@field:SerializedName("size")
	val size: Any? = null,

	@field:SerializedName("mime")
	val mime: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Meta(

	@field:SerializedName("pagination")
	val pagination: Pagination? = null
)

data class Video(

	@field:SerializedName("data")
	val data: Data? = null
)

data class DataItem(

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("id")
	val id: Int? = null
):java.io.Serializable

data class MateriResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)
