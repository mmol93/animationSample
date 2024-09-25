package com.example.testanimation.model

data class PaymentDetail(
    val id: String,
    val title: String,
    val price: Int,
    val paymentType: String,
    val date: String
)

val paymentDetails = listOf(
    PaymentDetail("1","Laptop", 1500000, "Credit Card", "2024-09-19"),
    PaymentDetail("2","Smartphone", 800000, "Debit Card", "2024-09-19"),
    PaymentDetail("3","Headphones", 150000, "PayPal", "2024-09-19"),
    PaymentDetail("4","Monitor", 300000, "Bank Transfer", "2024-09-19"),
    PaymentDetail("5","Keyboard", 50000, "Credit Card", "2024-09-19"),
    PaymentDetail("6","Mouse", 30000, "Gift Card", "2024-09-19"),
    PaymentDetail("7","Gaming Console", 500000, "Debit Card", "2024-09-19"),
    PaymentDetail("8","Office Chair", 250000, "Credit Card", "2024-09-19"),
    PaymentDetail("9","Table Lamp", 40000, "PayPal", "2024-09-19"),
    PaymentDetail("10","Bluetooth Speaker", 70000, "Credit Card", "2024-09-19")
)
