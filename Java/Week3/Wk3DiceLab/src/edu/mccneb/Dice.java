package edu.mccneb;

public class Dice {
    private Die die1;
    private Die die2;

    public Dice()
    {
        die1 = new Die();
        die2 = new Die();
    }
    public int getDie1Value()
    {
        return die1.getValue();
    }
    public int getDie2Value()
    {
        return die2.getValue();
    }
    public int getSum()
    {
        return getDie1Value()+getDie2Value();
    }
    public void Roll()
    {
        die1.Roll();
        die2.Roll();
    }
    public void printRoll()
    {
        System.out.println("Die 1: "+getDie1Value());
        System.out.println("Die 2: "+getDie2Value());
        System.out.println("Total: "+getSum());
        if(getSum()==7)
            System.out.println("Craps!");
        if(getSum()==12)
            System.out.println("Boxcars!");
        if(getSum()==2)
            System.out.println("Snake Eyes!");
        System.out.println();
    }
}
