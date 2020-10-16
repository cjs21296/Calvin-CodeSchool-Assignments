package edu.mccneb;
import java.util.*;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Random r = new Random();

    public static void main(String[] args) {
        int randomNum;
        boolean Continue = true;
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++\n");
        while(Continue)
        {
            randomNum = NumGen();
            NumChecker(randomNum);
            Continue=TryAgain();
        }
        System.out.println("Bye - Come back soon!");
    }
    public static int NumGen()
    {
        System.out.println("I'm thinking of a number from 1 to 100.\nTry to guess it.\n");
        return r.nextInt(100)+1;
    }
    public static void NumChecker(int randomNum){
        boolean inProgress=true;
        int userInput;
        int counter=1;
        while(inProgress)
        {

            userInput=0;
            while(!(userInput>0&&userInput<101)) {
                System.out.print("Enter a Number: ");
                userInput = in.nextInt();
            }
            if(userInput==randomNum)
            {
                System.out.printf("You got it in %d tries.%n",counter);
                if(counter<=3)
                    System.out.println("Great work! You are a guessing wizard.\n");
                else if((counter>3) && counter<=7)
                    System.out.println("Not too bad! You've got some potential.\n");
                else
                    System.out.println("What took you so long? Maybe you should take some lessons.\n");
                inProgress=false;
            }
            else if(userInput>randomNum)
                if(userInput-10>randomNum)
                    System.out.println("Way too high! Guess again.\n");
                else
                    System.out.println("Too high! Guess again.\n");

            else {
                if(userInput+10<randomNum)
                    System.out.println("Way too low! Guess again.\n");
                else
                    System.out.println("Too low! Guess again.\n");
            }
            counter++;
        }
    }
    public static boolean TryAgain()
    {
        char tryAgain;
        tryAgain = 'o';
        while((tryAgain!='y')&&(tryAgain!='n'))
        {
            System.out.print("Try again? (y/n): ");
            tryAgain = in.next().charAt(0);
            if((tryAgain!='y')&&(tryAgain!='n'))
                System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
        }
        System.out.println();
        if(tryAgain=='n')
            return false;
        else return true;
    }
}
