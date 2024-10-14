package com.example.housingapp.presentation.view

import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.housingapp.R
import com.example.housingapp.databinding.FragmentAddNoteBinding
import com.example.housingapp.di.injectViewModel
import com.example.housingapp.presentation.viewmodel.AddNoteViewModel
import kotlinx.coroutines.launch

class AddNoteFragment : BaseFragment(R.layout.fragment_add_note) {

    private val mViewBinding by viewBinding(FragmentAddNoteBinding::bind)
    private val mViewModel: AddNoteViewModel by injectViewModel()

    override fun setViewsPresets(): Unit = with(mViewBinding) {

    }

    override fun setupListeners(): Unit = with(mViewBinding) {
        ivHome.setOnClickListener {
            mViewModel.navigateToHome()
        }
        cvConfirm.setOnClickListener {
            mViewModel.onConfirmButton(
                etShortDescription.text.toString(),
                etLongDescription.text.toString(),
                etTelephoneNumber.text.toString(),
                etPrice.text.toString(),
                etImageLink.text.toString(),
            )
        }
    }

    override fun setupObservers(): Unit = with(mViewModel) {
        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                shfToastText.collect { text ->
                    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}