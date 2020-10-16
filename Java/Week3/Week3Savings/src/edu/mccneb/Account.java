package edu.mccneb;

public class Account implements Depositable, Withdrawable, Balanceable{
    protected double balance;

    public Account(){balance=0;}

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) {
        balance-=amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        balance=amount;
    }
}
