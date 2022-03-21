package com.IIITD_AP_KR3;

//Q2: In the code given below, there are two class doing the same job. Convert this code such that it outputs the same but using a generic class


public class Main2 {
    public static void main(String[] args) {
     double a1=5.5;
     double b1=4.5;
     int a2=5;
     int b2=5;
        (new print_complex<Double,Double>()).tss(a1,b1);
       (new print_complex<Integer,Integer>()).tss(a2,b2);

    }
}

class print_complex<D extends Number, D1 extends Number> {
    <t,w>void tss(t a, w b){
        System.out.println(a+"+"+b+"i");
         }
}

