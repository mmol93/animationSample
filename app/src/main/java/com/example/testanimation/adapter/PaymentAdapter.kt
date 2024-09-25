package com.example.testanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanimation.constant.PAYMENT_DATE_TRANSITION
import com.example.testanimation.constant.PAYMENT_PRICE_TRANSITION
import com.example.testanimation.constant.PAYMENT_TITLE_TRANSITION
import com.example.testanimation.databinding.ItemPaymentBinding
import com.example.testanimation.model.PaymentDetail

class PaymentAdapter(
    private val paymentList: List<PaymentDetail>,
    private val clickEvent: (view: View, paymentId: Int) -> Unit
) :
    RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    private var lastSelectedId: Int? = null

    inner class PaymentViewHolder(private val binding: ItemPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(paymentDetail: PaymentDetail, position: Int) {
            // binding을 통해 데이터 설정
            binding.paymentTitleText.text = paymentDetail.title
            binding.paymentTitleText.transitionName = PAYMENT_TITLE_TRANSITION + position.toString()

            binding.paymentPriceText.text = paymentDetail.price.toString()
            binding.paymentPriceText.transitionName = PAYMENT_PRICE_TRANSITION + position.toString()

            binding.paymentDateText.text = paymentDetail.paymentType
            binding.paymentDateText.transitionName = PAYMENT_DATE_TRANSITION + position.toString()

            itemView.setOnClickListener{
                lastSelectedId = paymentList[position].id.toInt()
                clickEvent(it, paymentList[position].id.toInt())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(paymentList[position], position)
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }
}