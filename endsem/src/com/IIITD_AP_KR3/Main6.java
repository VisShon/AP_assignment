package com.IIITD_AP_KR3;

//Q6: Modify A6 such that it implements the Comparable Interface. And compare a with b in terms of i-value in the main function.

public class Main6 {
    public static void main(String[] args) {
        A6 a=new A6(5);
        System.out.println(a.compareTo(a.b));
    }
}

class A6 implements Comparable<A6>{
    @Override
    public int compareTo(A6 b){
        if(this.i==b.i){
            return 0;
        }
        else if(this.i>b.i){
            return 1;
        }
        else{
            return -1;
        }
    }
    static A6 b;
    static{
        b=new A6(7);
    }
    int i;
    A6(int i){
        this.i=i;
    }
}