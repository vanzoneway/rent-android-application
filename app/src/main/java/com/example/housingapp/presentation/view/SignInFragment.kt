package com.example.housingapp.presentation.view

import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.housingapp.R
import com.example.housingapp.databinding.FragmentSignInBinding
import com.example.housingapp.di.injectViewModel
import com.example.housingapp.presentation.viewmodel.SignInViewModel

class SignInFragment : BaseFragment(R.layout.fragment_sign_in) {

    private val mViewBinding by viewBinding(FragmentSignInBinding::bind)
    private val mViewModel: SignInViewModel by injectViewModel()

    override fun setViewsPresets() = with(mViewBinding) {

    }

    override fun setupListeners() = with(mViewBinding) {
        tvSignUp.setOnClickListener {
            mViewModel.onSignUpBtn()
        }
        btnSignIn.setOnClickListener {
            mViewModel.onSignInBtn(etEmail.text.toString(), etPassword.text.toString())
        }
    }

    override fun setupObservers() = with(mViewModel) {
        ldShowToastText.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }
}