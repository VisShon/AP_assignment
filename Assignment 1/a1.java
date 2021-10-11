import java.io.BufferedReader;
import java.util.*;
import java.io.*;
class Vaccine {
    private String name;
    private int num;
    private int gap;
    public void setName(String name) {
        this.name = name;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setGap(int gap) {
        this.gap = gap;
    }
    public String getName(){
        return this.name;
    }
    public int getNum(){
        return this.num;
    }
    public int getGap(){
        return this.gap;
    }
    Vaccine(String na,int n, int g){
        this.name=na;
        this.num=n;
        this.gap=g;
        System.out.println("Vaccine Name: "+name+", Number of Doses: "+num+", Gap Between Doses: "+gap);
    }

}
class Hospital {
    String name;
    int pin;
    int UID;
    slots s = new slots();
    Hospital(String na,int p,int uid){
        this.name=na;
        this.pin=p;
        this.UID=uid;
        if(na!=""){
            System.out.println("Hospital Name: "+name+", PinCode: "+pin+", Unique ID: "+UID);
        }

    }
}
class Citizen {
    String name;
    int age;
    int ID;
    status stat = new status();
    Citizen(String na,int a,int id){
        this.name=na;
        this.age=a;
        this.ID=id;
        if(na!=""){
            System.out.println("Citizen ame: "+name+", Age: "+age+", Unique ID: "+ID);
            if(age<18){
                System.out.println("Only above 18 are allowed");
            }
        }

    }
}
class status {
    String Status="Registered";
    String vacc="";
    int numDoses=0;
    int next=0;
}

class pack{
    int l=0;
    int day=0;
    int quant=0;
    String name="";

}

class slots{
    int ID;
    ArrayList<pack> sl=new ArrayList<pack>();
    ArrayList<Integer> vacc=new ArrayList<Integer>();
    void createSlot(int n, Hospital hsp, int day,String Vcc,int l,int ID){
        pack pc=new pack();
        pc.day=day;
        pc.quant=n;
        pc.name=Vcc;
        pc.l=l;
        hsp.s.sl.add(pc);
        System.out.println("Slot added by Hospital: "+ID+" for Day: "+day+", Available Quantity: "+n+" of Vaccine "+Vcc);
    }
    void bookSlot(){

    }
    void availableSlot(Hospital hsp){
        for(pack p : sl){
            System.out.println("Day: "+p.day+" of "+p.name+", Available Quantity: "+p.quant);
        }
    }
}
