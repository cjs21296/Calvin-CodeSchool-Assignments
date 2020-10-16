package edu.mccneb;

import java.text.NumberFormat;

public class AccountBalanceApp {
    private static boolean start=true;
    private static NumberFormat NF = NumberFormat.getCurrencyInstance();
    public static void main(String[] args) {
        CheckingsAccount CA = new CheckingsAccount(1);
        SavingsAccount SA = new SavingsAccount(0.012);
        greeting();
        startBalance(CA, SA);
        while (keepGoing()) {
            accountAction(CA, SA);
        }
        monthlyFeesAndInterest(CA, SA);
        finalBalance(CA, SA);
        String[] genreType =  {"Rock","Jazz"};
    }
    
    private static void accountAction(CheckingsAccount checking, SavingsAccount savings) {
        String WD = Console.getString("Withdrawl or Deposit? (w/d): ","w","d");
        String accountType = Console.getString("Checking or Savings? (c/s): ","c","s");
        double Amt = Console.getDouble("Amount?: ",0,10000);
        Account account;
        if (accountType.equalsIgnoreCase("c")) {
            account = checking; // Where checking was created earlier as a CheckingsAccount
        } else {
            account = savings; // Where savings was created earlier as a SavingsAccount
        }
        if (WD.equalsIgnoreCase("w")) {
            account.withdraw(Amt); // Where checking was created earlier as a CheckingsAccount
        } else {
            account.deposit(Amt); // Where savings was created earlier as a SavingsAccount
        }

        System.out.println();
    }

    private static boolean keepGoing() {
        if(start) {
            start=false;
            return true;
        }
        else
        {
            String again = Console.getString("Continue? (y/n): ","y","n");
            System.out.println();
            if(again.equals("y"))
                return true;
            return false;
        }
    }

    private static void startBalance(CheckingsAccount CA, Account SA) {
        CA.setBalance(1000);
        SA.setBalance(1000);
        System.out.println("Starting Balances");
        System.out.println("Checking:\t"+NF.format(CA.getBalance()));
        System.out.println("Savings:\t"+NF.format(CA.getBalance()));
        System.out.println("\nEnter the Transactions for the month\n");
    }

    private static void greeting() {
        System.out.println("Welcom to the Account Application\n");
    }

    private static void monthlyFeesAndInterest(CheckingsAccount CA, SavingsAccount SA)
    {
        System.out.println("Monthly Payments and Fees");
        SA.CalculateSavingsInterest();
        System.out.println("Checking fee:\t\t\t\t"+NF.format(CA.getMonthlyFee()));
        System.out.println("Savings Interest Payment:\t"+NF.format(SA.savingsInterestAmt()));
        CA.subMonthlyFee();

        SA.deposit(SA.savingsInterestAmt());
        System.out.println();
    }

    private static void finalBalance(CheckingsAccount CA, SavingsAccount SA)
    {
        System.out.println("Final Balances");
        System.out.println("Checking:\t"+NF.format(CA.getBalance()));
        System.out.println("Savings:\t"+NF.format(SA.getBalance()));
    }
}
