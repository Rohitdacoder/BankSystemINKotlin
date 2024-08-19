package com.example.thebankaccount

// BankAccount project part 2 User Input
fun main() {
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
}
