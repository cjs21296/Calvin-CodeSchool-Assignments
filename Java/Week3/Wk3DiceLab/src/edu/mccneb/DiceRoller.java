package edu.mccneb;
import java.util.Scanner;
public class DiceRoller {
    public static Dice mydice = new Dice();
    public static Scanner in = new Scanner(System.in);
    public static boolean firstRoll = true;
    public static void main(String[] args) {
        greeting();
        while(rollAgain()){
            rollDice();
            printRoll();
        }
    }
    private static void printRoll() {
        mydice.printRoll();
    }

    private static boolean rollAgain() {
        if(firstRoll) {
            System.out.print("Roll the dice? (y/n): ");
            firstRoll=false;
        }
        else
            System.out.print("Roll again? (y/n): ");
        if(in.next().charAt(0)=='y')
            return true;
        return false;
    }

    private static void rollDice() {
        mydice.Roll();
    }

    private static void greeting() {
        System.out.println("Welcome to Dice Roller!\n");
    }

}
