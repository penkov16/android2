package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 999,
    var likedByMe: Boolean = false,
    var share: Int = 998,
    var shareByMe: Boolean = false,
    )