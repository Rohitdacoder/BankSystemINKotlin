package com.example.thebankaccount

fun main()
{
    // Part1
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

    // Part2
    var accountBalance = (0..1000).random()
    println("Your account balance is ${accountBalance}")
    val money = (0..1000).random()
    println("You have deposited/Withdrawn ${money}")
    var output = 0
    fun withdraw(amount: Int): Int {
        accountBalance = amount - accountBalance
        println("Your account balance is ${accountBalance} and Withdrawn Amount is ${amount}")
        return amount
    }
    output = withdraw(money)
    print("The Amount you withdrew is ${output}dollars.")

    fun debitWithdraw(amount: Int): Int {
        if (accountBalance == 0) {
            println("Can't withdraw, no money in this account")
            return accountBalance
        } else if (amount > accountBalance) {
            println("Not enough money on this account! The checking balance is ${accountBalance}dollars")
            return 0
        } else {
            return withdraw(amount)
        }
    }
    output = debitWithdraw(money)
    println("The amount you withdrew is ${output}dollars.")

    fun deposit(amount: Int): Int {
        accountBalance = amount + accountBalance
        println("You successfully deposited ${amount}dollars. Your current balance is ${accountBalance}dollars")
        return amount
    }
    output = deposit(money)
    println("The amount you deposited is ${output}dollars.")

    fun creditDeposit(amount: Int): Int {
        if (accountBalance == 0) {
            println("This account is completely paid off! Do not deposit money!")
            return accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The current balance is ${accountBalance} dollars.")
            return 0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this acount!")
            return amount
        } else {
            return deposit(amount)
        }
    }
    output = creditDeposit(money)
    println("The amount you deposited is ${output}dollars.")

    // Part3
    fun transfer(mode: String) {
        val transferAmount: Int

        when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = withdraw(money)
                }
                println("The amount you withdrew is ${transferAmount} dollars.")
            }
            "deposit" -> {
                if (accountType == "credit") {
                    transferAmount = creditDeposit(money)
                } else {
                    transferAmount = deposit(money)
                }
                println("The amount you deposited is ${transferAmount} dollars.")
            }
            else -> return
        }
    }

    var isSystemOpen = true
    var option = 0

    while (isSystemOpen == true) {
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()
        println("The selected option is ${option}.")

        when (option) {
            1 -> println("The current balance is ${accountBalance} dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}