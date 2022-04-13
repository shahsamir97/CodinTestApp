package com.apps.codintestapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.apps.codintestapp.R
import com.apps.codintestapp.databinding.LoginFragmentBinding
import com.apps.codintestapp.network.ServiceGenerator

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels{
        LoginViewModelFactory(LoginRepo(ServiceGenerator.apiService))
    }

  private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.loginButton.setOnClickListener {
            val userName = binding.userNameText.text.toString().trim()
            val password = binding.passwordText.text.toString().trim()
            viewModel.loginUser(userName, password)

            //Just for test as no login response provided I'm placing the navigation code here
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            //I know the above line shouldn't be here
        }

        viewModel.loginResult.observe(viewLifecycleOwner){
            // here we will navigate to Home if login is successful
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        viewModel.showToast.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

}