package com.example.testanimation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Fade
import com.example.testanimation.R
import com.example.testanimation.adapter.PaymentAdapter
import com.example.testanimation.constant.FAST_OUT_LINEAR_IN
import com.example.testanimation.constant.LARGE_COLLAPSE_DURATION
import com.example.testanimation.constant.LARGE_EXPAND_DURATION
import com.example.testanimation.constant.LINEAR_OUT_SLOW_IN
import com.example.testanimation.constant.PAYMENT_DATE_TRANSITION
import com.example.testanimation.constant.PAYMENT_PRICE_TRANSITION
import com.example.testanimation.constant.PAYMENT_TITLE_TRANSITION
import com.example.testanimation.databinding.FragmentFirstBinding
import com.example.testanimation.model.paymentDetails
import java.util.concurrent.TimeUnit

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Fade(Fade.OUT).apply {
            duration = LARGE_EXPAND_DURATION / 2
            interpolator = FAST_OUT_LINEAR_IN
        }
        reenterTransition = Fade(Fade.IN).apply {
            duration = LARGE_COLLAPSE_DURATION / 2
            startDelay = LARGE_COLLAPSE_DURATION / 2
            interpolator = LINEAR_OUT_SLOW_IN
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.paymentRecyclerView.run {
            layoutManager = LinearLayoutManager(requireContext())

            val paymentAdapter = PaymentAdapter(paymentDetails) { v, position ->
                val bundle = bundleOf("paymentId" to position)
                v.findNavController().navigate(
                    R.id.action_firstFragment_to_secondFragment,
                    args = bundle,
                    navOptions = null,
                    navigatorExtras = FragmentNavigatorExtras(
                        v.findViewById<TextView>(R.id.payment_title_text) to PAYMENT_TITLE_TRANSITION,
                        v.findViewById<TextView>(R.id.payment_price_text) to PAYMENT_PRICE_TRANSITION,
                        v.findViewById<TextView>(R.id.payment_date_text) to PAYMENT_DATE_TRANSITION,
                    )
                )
            }
            if (paymentAdapter.expectsTransition) postponeEnterTransition(100L, TimeUnit.MILLISECONDS)
            adapter = paymentAdapter
        }
        postponeEnterTransition()
        binding.paymentRecyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
        return binding.root
    }
}