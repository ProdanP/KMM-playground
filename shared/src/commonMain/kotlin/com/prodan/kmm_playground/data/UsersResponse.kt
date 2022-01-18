package com.prodan.kmm_playground.data

import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(val results : List<User>)

@Serializable
data class User(val name : UserName, val picture: UserPicture)

@Serializable
data class UserName(val first : String, val last : String)

@Serializable
data class UserPicture(val medium : String)