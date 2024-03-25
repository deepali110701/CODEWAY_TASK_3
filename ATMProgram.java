package com.codeway;

import java.util.Scanner;

//Bank Account class representing user's account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true; // Withdrawal successful
     } else {
         return false; // Insufficient funds
     }
 }
}

//ATM class representing the ATM machine
class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void displayOptions() {
     System.out.println("Welcome to the ATM!");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void withdraw(double amount) {
     if (account.withdraw(amount)) {
         System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
     } else {
         System.out.println("Withdrawal failed. Insufficient funds.");
     }
 }

 public void deposit(double amount) {
     account.deposit(amount);
     System.out.println("Deposit successful. New balance: " + account.getBalance());
 }

 public void checkBalance() {
     System.out.println("Your current balance is: " + account.getBalance());
 }
}

public class ATMProgram {
 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(1000); // Initial balance of 1000
     ATM atm = new ATM(userAccount);
     Scanner scanner = new Scanner(System.in);
     int choice;

     do {
         atm.displayOptions();
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 atm.withdraw(withdrawAmount);
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 atm.deposit(depositAmount);
                 break;
             case 3:
                 atm.checkBalance();
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Bye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     } while (choice != 4);

     scanner.close();
 }
}
