package com.IIITD_AP_KR3;

//Q3: This code has throws a null pointer exception.
// The classes A,B & C cannot be changed.
// Please handle this exception using try-catch in the main function itself such that there is no null pointer exception and the program outputs the desired result, i.e. 5.



public class Main3 {

    public static void main(String[] args) {
        try{
            (new C()).display();
        }
        catch(NullPointerException e){
            try{
                C c = new C();
                c.a= new A();
                c.display();
            }
            catch(NullPointerException i) {
                System.out.println("Null pointer exception");
            }
        }
    }
}

class A{
    int i=5;
}

class B{
    A a;
}

class C extends B{
    void display(){
        System.out.println(a.i);
    }
}