package edu.mccneb;

public class CheckingsAccount  extends Account{
    private double monthlyFee;

    public CheckingsAccount(double fee)
    {
        super();
        monthlyFee=fee;
    }
    public void subMonthlyFee()
    {
        withdraw(monthlyFee);
    }
    public double getMonthlyFee()
    {
        return monthlyFee;
    }
}
