package ru.netology

interface Attachment {
    val type: String
}

data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo = Photo()
) : Attachment

data class PostedPhotoAttachment(
    override val type: String = "posted_photo",
    val postedPhoto: PostedPhoto = PostedPhoto()
) : Attachment

data class VideoAttachment(
    override val type: String = "video",
    val video: Video = Video()
) : Attachment

data class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio = Audio()
) : Attachment

data class DocAttachment(
    override val type: String = "doc",
    val doc: Doc = Doc()
) : Attachment

data class Photo(
    val id: Int? = null,
    val albumId: Int? = null,
    val ownerId: Int? = null,
    val userId: Int? = null,
    val text: String? = null,
    val date: Int? = null
)

data class PostedPhoto(
    val id: Int? = null,
    val albumId: Int? = null,
    val photo130: String? = null,
    val photo604: String? = null
)

data class Video(
    val id: Int? = null,
    val ownerId: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val date: Int? = null
)

data class Audio(
    val id: Int? = null,
    val ownerId: Int? = null,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int? = null,
    val date: Int? = null
)

data class Doc(
    val id: Int? = null,
    val ownerId: Int? = null,
    val title: String? = null,
    val url: String? = null,
    val date: Int? = null
)
