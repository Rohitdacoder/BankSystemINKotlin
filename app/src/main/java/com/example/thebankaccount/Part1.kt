package com.example.thebankaccount

// BankAccount project part 1 User UI
fun main()
{
    println("Welcome to your banking System")
    println("What type of account would you like to create? ")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    var accountType = ""
    var userChoice = 0

    while (accountType == "")
    {
        println("Choose an option(1,2 or3)")
        userChoice = (1..5).random()
        println("The Selected option is $userChoice")
        when (userChoice) {
             1 -> accountType = "Debit"
             2 -> accountType = "Credit"
             3 -> accountType = "Checking"
            else -> continue
        }
        println("You have created a ${accountType} account")
    }
}
