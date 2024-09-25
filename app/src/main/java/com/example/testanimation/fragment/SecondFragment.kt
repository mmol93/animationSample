package com.example.testanimation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.example.testanimation.constant.PAYMENT_DATE_TRANSITION
import com.example.testanimation.constant.PAYMENT_PRICE_TRANSITION
import com.example.testanimation.constant.PAYMENT_TITLE_TRANSITION
import com.example.testanimation.databinding.FragmentSecondBinding
import com.example.testanimation.model.paymentDetails
import java.util.concurrent.TimeUnit

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // These are the shared element transitions.
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        postponeEnterTransition(100, TimeUnit.MILLISECONDS)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val paymentId = arguments?.getInt("paymentId")

        binding.paymentTitleText.transitionName = PAYMENT_TITLE_TRANSITION + paymentId
        binding.paymentPriceText.transitionName = PAYMENT_PRICE_TRANSITION + paymentId
        binding.paymentDateText.transitionName = PAYMENT_DATE_TRANSITION + paymentId

        binding.paymentTitleText.text = paymentDetails[paymentId!!].title
        binding.paymentPriceText.text = paymentDetails[paymentId].price.toString()
        binding.paymentDateText.text = paymentDetails[paymentId].date

        binding.root.doOnPreDraw {
            startPostponedEnterTransition()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
        return binding.root
    }
}