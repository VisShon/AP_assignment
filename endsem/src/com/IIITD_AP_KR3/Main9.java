package com.IIITD_AP_KR3;
import java.util.*;
//Q9: Create the list of 5 complex numbers (class=cmplx2) and print them all using an iterator in the main function.

public class Main9 {
    public static void main(String[] args) {
        ArrayList<cmplx2> cmp = new ArrayList<cmplx2>();
        cmplx2 a = new cmplx2(1,2);
        cmplx2 b = new cmplx2(2,3);
        cmplx2 c = new cmplx2(3,4);
        cmplx2 d = new cmplx2(4,5);
        cmplx2 e = new cmplx2(5,6);
        cmp.add(a);
        cmp.add(b);
        cmp.add(c);
        cmp.add(d);
        cmp.add(e);
        Iterator<cmplx2> it = cmp.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class cmplx2{
    double re;
    double im;
    cmplx2(double re, double im){
        this.re=re;
        this.im=im;
    }
    public String toString(){
        return (re + "+" + im + "i");
    }
}