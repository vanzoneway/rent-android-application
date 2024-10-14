package com.example.housingapp.presentation.view

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.housingapp.R
import com.example.housingapp.databinding.FragmentDetailsBinding
import com.example.housingapp.di.injectViewModel
import com.example.housingapp.presentation.model.HouseItemPresentation
import com.example.housingapp.presentation.navigation.HOUSE_ITEM_ARGUMENT_KEY
import com.example.housingapp.presentation.viewmodel.DetailsViewModel
import com.example.housingapp.util.getArgument
import com.squareup.picasso.Picasso

class DetailsFragment : BaseFragment(R.layout.fragment_details) {

    private val mViewBinding by viewBinding(FragmentDetailsBinding::bind)
    private val mViewModel: DetailsViewModel by injectViewModel()

    private val mHouseItem: HouseItemPresentation by lazy (LazyThreadSafetyMode.NONE) {
        getArgument(HOUSE_ITEM_ARGUMENT_KEY) }

    override fun setViewsPresets() = with(mViewBinding) {
        Picasso.get()
            .load(mHouseItem.imageLink)
            .placeholder(R.drawable.im_flat_placeholder)
            .into(pvPhoto)

        tvShortDescription.text = mHouseItem.shortDescription
        tvLongDescription.text = mHouseItem.longDescription
        tvPrice.text = mHouseItem.costPerMonth.toString()
        tvNumber.text = "${mHouseItem.telephone.toString()}"
    }

    override fun setupListeners() = with(mViewBinding) {

    }

    override fun setupObservers() = with(mViewModel) {

    }
}