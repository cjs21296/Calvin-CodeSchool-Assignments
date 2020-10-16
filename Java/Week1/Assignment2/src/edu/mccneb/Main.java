package edu.mccneb;
import java.util.*;
import java.math.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        int output=1;
        char con;
        boolean cont=true;
        System.out.print("Welcome to the Factorial Calculator");
        while(cont)
        {
            output=1;
            System.out.print("\nEnter an integer that's greater than 0 and less than 10: ");
            input = in.nextInt();
            for(;input>0;input--)
                output*=input;
            System.out.println(output);
            System.out.print("Would you like to continue? (y/n): ");
            con=in.next().charAt(0);
            if(con=='n')
                cont=false;
        }
    }
}
