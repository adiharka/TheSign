package com.kuliah.thesign.model

class GalleryItem {
    var imgGallery: Int? = 0
    var idGallery: Int? = 0
    var textGallery: String? = null
    var creatorGallery: String? = null
    var phoneGallery: String? = null

    constructor(imgGallery: Int?, idGallery: Int?, textGallery: String?, creatorGallery: String?, phoneGallery: String?) {
        this.imgGallery = imgGallery
        this.idGallery = idGallery
        this.textGallery = textGallery
        this.creatorGallery = creatorGallery
        this.phoneGallery = phoneGallery
    }
}