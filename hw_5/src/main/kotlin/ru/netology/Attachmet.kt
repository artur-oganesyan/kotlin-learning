package ru.netology

abstract class Attachment {
    abstract val type: String
}

abstract class PhotoAttachment : Attachment() {

    override val type = "photo"

    abstract val id: Int
    abstract val album_id: Int
    abstract val owner_id: Int
    abstract val user_id: Int
    abstract val text: String
    abstract val date: Int
}

class Photo(
    override val id: Int,
    override val album_id: Int,
    override val owner_id: Int,
    override val user_id: Int,
    override val text: String,
    override val date: Int

) : PhotoAttachment()

abstract class PostedPhotoAttachment : Attachment() {

    override val type = "posted_photo"

    abstract val id: Int
    abstract val album_id: Int
    abstract val photo_130: String
    abstract val photo_604: String
}

class PostedPhoto(
    override val id: Int,
    override val album_id: Int,
    override val photo_130: String,
    override val photo_604: String
) : PostedPhotoAttachment()

abstract class VideoAttachment : Attachment() {

    override val type = "video"

    abstract val id: Int
    abstract val owner_id: Int
    abstract val title: String
    abstract val description: String
    abstract val date: Int
}

class Video(
    override val id: Int,
    override val owner_id: Int,
    override val title: String,
    override val description: String,
    override val date: Int
) : VideoAttachment()

abstract class AudioAttachment : Attachment() {

    override val type = "audio"

    abstract val id: Int
    abstract val owner_id: Int
    abstract val artist: String
    abstract val title: String
    abstract val duration: Int
    abstract val date: Int
}

class Audio(
    override val id: Int,
    override val owner_id: Int,
    override val artist: String,
    override val title: String,
    override val duration: Int,
    override val date: Int
) : AudioAttachment() {

    abstract class DocAttachment : Attachment() {

        override val type = "doc"

        abstract val id: Int
        abstract val owner_id: Int
        abstract val title: String
        abstract val url: String
        abstract val date: Int
    }

    class Doc(
        override val id: Int,
        override val owner_id: Int,
        override val title: String,
        override val url: String,
        override val date: Int
    ) : DocAttachment()
}
