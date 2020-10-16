package edu.mccneb;
import java.util.*;
public class Main {

    public static Random r = new Random();
    public static Scanner s = new Scanner(System.in);
    public static boolean again=true;
    public static int dice1, dice2, total;
    public static void main(String[] args) {
        greeting();
        int choice;
        int num;
        while(again) {
            choice=ChooseDiceType();
            //num = ChooseDiceNum();
            Roll(choice);
            Result(dice1, dice2, choice);
            Total(dice1, dice2);
            again = PlayAgain();
        }
    }
    public static void greeting()
    {
        System.out.println("Welcome to Dice Roller 9000\n");
    }
    public static boolean PlayAgain()
    {
        System.out.print("\nRoll again? (y/n): ");
        char c = s.next().charAt(0);
        System.out.println();
        if(c=='y')
            return true;
        else
            return false;
    }
    public static void Roll(int dicesize)
    {
        switch(dicesize)
        {
            case 2:
                dice1=r.nextInt(2)+1;
                dice2=r.nextInt(2)+1;
                break;
            case 4:
                dice1=r.nextInt(4)+1;
                dice2=r.nextInt(4)+1;
                break;
            case 6:
                dice1=r.nextInt(6)+1;
                dice2=r.nextInt(6)+1;
                break;
            case 10:
                dice1=r.nextInt(10)+1;
                dice2=r.nextInt(10)+1;
                break;
            case 20:
                dice1=r.nextInt(20)+1;
                dice2=r.nextInt(20)+1;
                break;
            case 66:
                dice1=r.nextInt(6)+1;
                dice2=(r.nextInt(6)+1)*10;
                break;
            case 100:
                dice1=r.nextInt(100)+1;
                dice2=r.nextInt(100)+1;
                break;
            default:
                break;
        }
    }
    public static void Result(int d1, int d2, int choice)
    {
        if(choice!=66) {
            System.out.println("Die 1: " + d1);
            System.out.println("Die 2: " + d2);
        }
        else
            System.out.printf("Die Roll: %d\n",d1+d2);
    }
    public static void Total(int d1, int d2)
    {
        total = d1+d2;
        System.out.println("Total: "+total);
    }
    public static int ChooseDiceType()
    {
        int dicesize=2;

        while(true) {
            System.out.println("What dice size would you like to choose?");
            System.out.print("Choices include: 2, 4, 6, 10, 20, 66, 100: ");
            dicesize = s.nextInt();

            switch(dicesize)
            {
                case 2:
                    return 2;
                case 4:
                    return 4;
                case 6:
                    return 6;
                case 10:
                    return 10;
                case 20:
                    return 20;
                case 66:
                    return 66;
                case 100:
                    return 100;
                default:
                    break;
            }
        }

    }
    public static int ChooseDiceNum()
    {
        System.out.println("How many Dice would you like to roll? (1-5): ");
        int i = s.nextInt();
        if(i<1)
            i=1;
        if(i>5)
            i=5;
        return i;
    }
}
