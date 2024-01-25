package com.example.color_app_test.domain.mappers

import com.example.color_app_test.data.remote.models.ColorModelDto
import com.example.color_app_test.domain.models.ColorModel
import com.example.color_app_test.extensions.formatDate

object ColorModelMapper {

    fun buildFrom(model: ColorModelDto): ColorModel {
        return ColorModel(
            id = model.id,
            title = model.title,
            userName = model.userName,
            dateCreated = model.userName.formatDate(),
            rgb = model.rgb,
            description = model.description,
            imageUrl = model.imageUrl
        )
    }

}