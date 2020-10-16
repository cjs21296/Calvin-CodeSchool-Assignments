package edu.mccneb;

public class SavingsAccount extends Account{
    private double interestRate;
    private double interestPaymentAmt;

    public SavingsAccount(double interest)
    {
        super();
        interestRate=interest;
    }
    public void CalculateSavingsInterest()
    {
        interestPaymentAmt=(interestRate*balance);
    }
    public double savingsInterestAmt()
    {
        return interestPaymentAmt;
    }
}
