package com.IIITD_AP_KR3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Q10: Using "assert", test if the code is running as expected. The code was expected to implement (a+b)^2 formula.
//In case something went wrong in the formula, your code should print the message "The formula is wrong."

public class Main10 {
    public static void main(String[] args) {
        int a=8;
        int b=2;
        int c=a*a+a*b+b*b;
        try {
            assert(c==a*a+2*a*b+b*b);
            System.out.println(c);
        }
        catch (AssertionError ass){
            System.out.println("This formula is wrong");
        }
    }
}
//by default aassertion is disabled we need to pass -ea flag