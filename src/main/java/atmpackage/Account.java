package atmpackage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;

    private double checkingBalance;
    private double savingBalance;

    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");   //SUPERRRR


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    //calculate checking balance after withdraw
    private double calculateChekingBalanceAfterWithdrow(double amount) {
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    //Calculate checking account balance after deposit
    private double calculateCheckingAccountBalanceAfterDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    //calculate saving balance after withdraw
    private double calculateSavingBalanceAfterWithdrow(double amount) {
        savingBalance = savingBalance - amount;
        return checkingBalance;
    }

    //Calculate checking account balance after deposit
    private double calculateSavingAccountBalanceAfterDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return checkingBalance;
    }

    //Interact with user to withdraw money from checking account
    public void getCheckingWithdraw() {
        System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));            //SUPERRRR
        System.out.println("Enter the amount you would like to withdraw: ");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not acceptable!");
            getCheckingWithdraw();
        } else if (checkingBalance >= amount) {
            calculateChekingBalanceAfterWithdrow(amount);
        } else {
            System.out.println("You do not have enough money on your checking account");
        }
    }

    //Interact with customer to deposit money to their checking account
    public void getCheckingDeposit() {
        System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));            //SUPERRRR
        System.out.println("Enter the amount you would like to deposit: ");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not acceptable!");
            getCheckingDeposit();
        } else {
            calculateCheckingAccountBalanceAfterDeposit(amount);
            System.out.println("Your checking balance: " + moneyFormat.format(checkingBalance));
        }
    }


    //Interact with customer to deposit money to their saving account
    public void getSavingWithdraw() {
        System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));            //SUPERRRR
        System.out.println("Enter the amount you would like to withdraw: ");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not acceptable!");
            getSavingWithdraw();
        } else if (savingBalance >= amount) {
            calculateSavingBalanceAfterWithdrow(amount);
            System.out.println("Your checking balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("You do not have enough money on your checking account");
        }
    }
    //Interact with customer to deposit money to their saving account
    public void getSavingDeposit() {
        System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));            //SUPERRRR
        System.out.println("Enter the amount you would like to withdraw: ");
        double amount = scan.nextDouble();

        if (amount <= 0) {
            System.out.println("Negative or Zero amount is not acceptable!");
            getSavingDeposit();
        } else {
            calculateSavingAccountBalanceAfterDeposit(amount);
            System.out.println("Your saving balance: " + moneyFormat.format(savingBalance));
        }
    }

}
