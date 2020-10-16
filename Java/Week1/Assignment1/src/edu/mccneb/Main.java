package edu.mccneb;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fn,ln,dob;
//        Student Registration Form
//
//        Enter first name: Harold
//        Enter last name: Moore
//        Enter year of birth: 1998
//
//        Welcome Harold Moore!
//                Your registration is complete.
//                Your temporary password is: Harold*1998
        System.out.println("Student Registration Form\n");
        System.out.print("Enter First Name: ");
        fn=in.next();
        System.out.print("Enter Last Name: ");
        ln=in.next();
        System.out.print("Enter Year of Birth: ");
        dob=in.next();
        System.out.println();
        System.out.println("Welcome "+fn+" "+ln+"!");
        System.out.println("Your registration is complete.");
        System.out.println("Your temporary password is "+fn+"*"+dob);
    }
}
