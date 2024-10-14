package com.example.housingapp.presentation.navigation

import com.example.housingapp.presentation.model.HouseItemPresentation
import com.example.housingapp.presentation.view.AddNoteFragment
import com.example.housingapp.presentation.view.DetailsFragment
import com.example.housingapp.presentation.view.HomeFragment
import com.example.housingapp.presentation.view.SignInFragment
import com.example.housingapp.presentation.view.SignUpFragment
import com.example.housingapp.util.withArguments
import com.github.terrakok.cicerone.androidx.FragmentScreen

const val HOUSE_ITEM_ARGUMENT_KEY = "house_item"

object Screens {
    fun signInFragment() = FragmentScreen { SignInFragment() }
    fun signUpFragment() = FragmentScreen { SignUpFragment() }
    fun homeFragment() = FragmentScreen { HomeFragment() }
    fun detailsFragment(item: HouseItemPresentation) = FragmentScreen {
        DetailsFragment().withArguments(
        HOUSE_ITEM_ARGUMENT_KEY to item
        )
    }
    fun addNoteFragment() = FragmentScreen { AddNoteFragment() }

}