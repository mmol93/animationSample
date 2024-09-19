package com.example.testanimation.model

data class PaymentDetail(
    val title: String,
    val price: Int,
    val paymentType: String,
    val date: String
)

val paymentDetails = listOf(
    PaymentDetail("Laptop", 1500000, "Credit Card", "2024-09-19"),
    PaymentDetail("Smartphone", 800000, "Debit Card", "2024-09-19"),
    PaymentDetail("Headphones", 150000, "PayPal", "2024-09-19"),
    PaymentDetail("Monitor", 300000, "Bank Transfer", "2024-09-19"),
    PaymentDetail("Keyboard", 50000, "Credit Card", "2024-09-19"),
    PaymentDetail("Mouse", 30000, "Gift Card", "2024-09-19"),
    PaymentDetail("Gaming Console", 500000, "Debit Card", "2024-09-19"),
    PaymentDetail("Office Chair", 250000, "Credit Card", "2024-09-19"),
    PaymentDetail("Table Lamp", 40000, "PayPal", "2024-09-19"),
    PaymentDetail("Bluetooth Speaker", 70000, "Credit Card", "2024-09-19")
)
