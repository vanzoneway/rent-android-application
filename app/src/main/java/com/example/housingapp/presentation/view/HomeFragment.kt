package com.example.housingapp.presentation.view

import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.housingapp.R
import com.example.housingapp.databinding.FragmentHomeBinding
import com.example.housingapp.di.injectViewModel
import com.example.housingapp.presentation.adapter.RvItemsAdapter
import com.example.housingapp.presentation.model.HouseItemPresentation
import com.example.housingapp.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment(R.layout.fragment_home), RvItemsAdapter.ClickListener {

    private val mViewBinding by viewBinding(FragmentHomeBinding::bind)
    private val mViewModel: HomeViewModel by injectViewModel()
    private val mRvAdapter: RvItemsAdapter = RvItemsAdapter(this)

    override fun setViewsPresets(): Unit = with(mViewBinding) {
        rvList.adapter = mRvAdapter
        mRvAdapter.addHouseItems(mViewModel.getRvItems())
    }

    override fun setupListeners(): Unit = with(mViewBinding) {
        ivAddNote.setOnClickListener {
            mViewModel.navigateToAddNote()
        }
        fabLogout.setOnClickListener {
            mViewModel.onLogout()
        }
    }

    override fun setupObservers(): Unit = with(mViewModel) {

    }

    override fun onClickRvItem(item: HouseItemPresentation) {
        mViewModel.onClickItem(item)
    }
}