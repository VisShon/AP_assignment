package com.IIITD_AP_KR3;

//Q1: Convert this code such that it does the same job but by implementing the Runnable interface

public class Main {
    public static void main(String[] args) {

	      th t1=new th(1);
          th t2=new th(2);
          Thread a = new Thread(t1);
          Thread b = new Thread(t2);
        a.start();
          b.start();
    }
}

class th implements Runnable {
    int i;
    th(int i){
        this.i=i;
    }
    public void run(){
        int j=0;
        for (j=1;j<1000;j++){
            System.out.println(i);
        }
    }
}