package com.example.data.mapper

import com.example.data.model.HouseItemData
import com.example.domain.model.HouseItemDomain

fun HouseItemData.toDomain(): HouseItemDomain {
    return HouseItemDomain(
        imageLink = this.imageLink,
        shortDescription = this.shortDescription,
        longDescription = this.longDescription,
        costPerMonth = this.costPerMonth,
        telephone = this.telephone
    )
}

fun HouseItemDomain.toData(): HouseItemData {
    return HouseItemData(
        imageLink = this.imageLink,
        shortDescription = this.shortDescription,
        longDescription = this.longDescription,
        costPerMonth = this.costPerMonth,
        telephone = this.telephone
    )
}

fun List<HouseItemData>.toDomain(): List<HouseItemDomain> {
    return this.map { it.toDomain() }
}

fun List<HouseItemDomain>.toData(): List<HouseItemData> {
    return this.map { it.toData() }
}