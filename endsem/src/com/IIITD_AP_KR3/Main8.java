package com.IIITD_AP_KR3;

//Q8: Convert the following cmplx class into a singleton class.
// You should be able to pass the values of real and imaginary components from the main function.

public class Main8 {
    public static void main(String[] args) {
        System.out.println(cmplx.getInstance(10,12).re+"+"+cmplx.getInstance(10,12).im+"i");
    }
}

class cmplx{
    double re;
    double im;
    private static cmplx cmp =null;
    public static cmplx getInstance(double re, double im) {
        if(cmp==null){
            cmp=new cmplx();
            cmp.re=re;
            cmp.im=im;
        }

        return cmp;
    }
    cmplx(){
    }
}