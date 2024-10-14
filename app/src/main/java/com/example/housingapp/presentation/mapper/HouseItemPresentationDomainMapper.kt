package com.example.housingapp.presentation.mapper

import com.example.domain.model.HouseItemDomain
import com.example.housingapp.presentation.model.HouseItemPresentation

fun HouseItemPresentation.toDomain(): HouseItemDomain {
    return HouseItemDomain(
        imageLink = this.imageLink,
        shortDescription = this.shortDescription,
        longDescription = this.longDescription,
        costPerMonth = this.costPerMonth,
        telephone = this.telephone
    )
}

fun HouseItemDomain.toPresentation(): HouseItemPresentation {
    return HouseItemPresentation(
        imageLink = this.imageLink,
        shortDescription = this.shortDescription,
        longDescription = this.longDescription,
        costPerMonth = this.costPerMonth,
        telephone = this.telephone
    )
}

fun List<HouseItemPresentation>.toDomain(): List<HouseItemDomain> {
    return this.map { it.toDomain() }
}

fun List<HouseItemDomain>.toPresentation(): List<HouseItemPresentation> {
    return this.map { it.toPresentation() }
}