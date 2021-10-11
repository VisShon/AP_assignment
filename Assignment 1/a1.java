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
class a1{
    static void menu(){
        System.out.println("--------------------------------"
                +"\n1.Add Vaccine"
                +"\n2.Register Hospital"
                +"\n3.Register Citizen"
                +"\n4.Add Slot for Vaccination"
                +"\n5.Book Slot for Vacciation"
                +"\n6.List all slots for a hospital"
                +"\n7.Check Vaccination Status"
                +"\n8.exit"
                +"\n--------------------------------");
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op=0;
        int i=100000;
        int l=0;
        ArrayList<Vaccine> Vaccine=new ArrayList<Vaccine>();
        ArrayList<Hospital> Hospitals=new ArrayList<Hospital>();
        ArrayList<Citizen> Citizens=new ArrayList<Citizen>();
        System.out.println("CoWin Portal initialized...");
        while(op!=8){
            menu();
            op=Integer.parseInt(br.readLine());;

            if(op==1){
                System.out.println("Vaccine Name: ");
                String na = br.readLine();
                System.out.println("Number of doses: ");
                int n=Integer.parseInt(br.readLine());
                System.out.println("Gap between the doses: ");
                int g=Integer.parseInt(br.readLine());
                Vaccine vcc= new Vaccine(na,n,g);
                Vaccine.add(vcc);
                System.out.println("--------------------------------");
            }

            else if(op==2){
                System.out.println("Hospital Name: ");
                String na = br.readLine();
                System.out.println("PinCode: ");
                int p=Integer.parseInt(br.readLine());
                int id=i;
                i++;
                Hospital hsp= new Hospital(na,p,id);
                Hospitals.add(hsp);
                System.out.println("--------------------------------");
            }

            else if(op==3){
                System.out.println("Citizen Name: ");
                String na = br.readLine();
                System.out.println("Age: ");
                int a=Integer.parseInt(br.readLine());
                System.out.println("Unique ID: ");
                int id = Integer.parseInt(br.readLine());
                Citizen c= new Citizen(na,a,id);
                if(a>=18){
                    Citizens.add(c);
                }
                System.out.println("--------------------------------");
            }

            else if(op==4){
                String vcc;
                System.out.println("Enter Hospital ID: ");
                int ID = Integer.parseInt(br.readLine());
                System.out.println("Enter number of Slots to be added: ");
                int num=Integer.parseInt(br.readLine());
                for(int j=0;j<num;j++){
                    for(Hospital h:Hospitals){
                        if(h.UID==ID){
                            System.out.println("Enter Day Number: ");
                            int day = Integer.parseInt(br.readLine());
                            System.out.println("Enter Quantity: ");
                            int qty=Integer.parseInt(br.readLine());
                            System.out.println("Select Vaccine"
                                    +"\n0.Covax"
                                    +"\n1.Covi");
                            int v =Integer.parseInt(br.readLine());
                            if(v==0){
                                vcc="Covax";
                            }
                            else{
                                vcc="Covi";
                            }
                            h.s.createSlot(qty,h,day,vcc,l,h.UID);
                            l++;
                        }
                    }
                }
                System.out.println("--------------------------------");
            }

            else if(op==5){
                System.out.println("Enter patient Unique ID: ");
                int id = Integer.parseInt(br.readLine());
                int gap=0;
                int d=0;
                String v="";
                Hospital hptl=new Hospital("",0,0);
                Citizen c3=new Citizen("",0,0);
                Citizen c2=new Citizen("",0,0);
                System.out.println("1.Search by area"
                        +"\n2.Search by Vaccine"
                        +"\n3.Exit");
                System.out.println("Enter Option: ");
                int option = Integer.parseInt(br.readLine());
                if (option ==1){
                    System.out.println("Enter PinCode: ");
                    int pin= Integer.parseInt(br.readLine());
                    for(Hospital hpt:Hospitals){
                        if(hpt.pin==pin){
                            System.out.println(hpt.UID+" "+hpt.name);
                        }
                    }
                    System.out.println("Enter hospital id: ");
                    int id2= Integer.parseInt(br.readLine());
                    for(Hospital h:Hospitals){
                        if(h.UID==id2){
                            hptl=h;
                            for(pack p:h.s.sl){
                                System.out.println(p.l+"->"+" Day: "+p.day+" Available Qty:"+p.quant+" Vaccine: "+p.name);
                            }
                        }
                    }
                    System.out.println("Choose Slot: ");
                    int l3= Integer.parseInt(br.readLine());
                    for(pack p: hptl.s.sl){
                        if(p.l==l3){
                            d=p.day;
                            v=p.name;
                        }
                    }
                    for(Vaccine vic:Vaccine){
                        if(vic.getName().equals(v)){
                            gap=vic.getGap();
                        }
                    }
                    for(Citizen c:Citizens){
                        if(c.ID==id){
                            c3 = c;
                            if(c.stat.Status.equals("Registered")){
                                c.stat.Status="Partially Vaccinated";
                                c.stat.vacc=v;
                                c.stat.numDoses++;
                                c.stat.next=d+gap;
                            }
                            else if(c.stat.Status.equals("Partially Vaccinated")){
                                c.stat.Status="Fully Vaccinated";
                                c.stat.vacc=v;
                                c.stat.numDoses++;
                            }
                        }
                    }
                    for(pack p: hptl.s.sl){
                        if(p.l==l3){
                            System.out.println(c3.name+" Vaccinated with "+p.name);
                        }
                    }

                }
                else if (option ==2){
                    System.out.println("Enter Vaccine Name: ");
                    String vc= br.readLine();
                    for(Vaccine vaac : Vaccine){
                        if(vaac.getName().equals(vc)){
                            gap= vaac.getGap();
                        }
                    }
                    for(Hospital h:Hospitals){
                        for(pack p: h.s.sl){
                            if(p.name.equals(vc)){
                                System.out.println(h.UID+" "+h.name);
                            }
                        }
                    }
                    System.out.println("Enter Hospital ID: ");
                    int uid= Integer.parseInt(br.readLine());
                    for(Hospital h:Hospitals){
                        if(h.UID==uid){
                            hptl=h;
                            for(pack p:h.s.sl){
                                if(p.name.equals(vc)){
                                    System.out.println(p.l+"->"+" Day: "+p.day+" Available Qty:"+p.quant+" Vaccine: "+p.name);
                                }
                            }
                        }
                    }
                    System.out.println("Choose Slot: ");
                    int l2= Integer.parseInt(br.readLine());
                    for(pack p: hptl.s.sl){
                        if(p.l==l2){
                            d=p.day;
                            v=p.name;
                        }
                    }
                    for(Vaccine vic:Vaccine){
                        if(vic.getName().equals(v)){
                            gap=vic.getGap();
                        }
                    }
                    for(Citizen c:Citizens){
                        if(c.ID==id){
                            c2 = c;
                            if(c.stat.Status.equals("Registered")){
                                c.stat.Status="Partially Vaccinated";
                                c.stat.vacc=v;
                                c.stat.numDoses++;
                                c.stat.next=d+gap;
                            }
                            else if(c.stat.Status.equals("Partially Vaccinated")){
                                c.stat.Status="Fully Vaccinated";
                                c.stat.vacc=v;
                                c.stat.numDoses++;
                            }
                        }
                    }
                    for(pack p: hptl.s.sl){
                        if(p.l==l2){
                            System.out.println(c2.name+" Vaccinated with "+p.name);
                        }
                    }
                }
                System.out.println("--------------------------------");
            }

            else if(op==6){
                System.out.println("Enter Hospital Id: ");
                int id =Integer.parseInt(br.readLine());
                for(Hospital h:Hospitals){
                    if(h.UID==id){
                        h.s.availableSlot(h);
                    }
                }
                System.out.println("--------------------------------");
            }

            else if(op==7){
                System.out.println("Enter Patient ID: ");
                int id1= Integer.parseInt(br.readLine());
                for(Citizen cr : Citizens){
                    if(cr.ID==id1){
                        if(cr.stat.Status.equals("Fully Vaccinated")){
                            System.out.println(cr.stat.Status);
                            System.out.println("Vaccine given: "+cr.stat.vacc);
                            System.out.println("Number of doses given: "+cr.stat.numDoses);
                        }
                        else if(cr.stat.Status.equals("Partially Vaccinated")){
                            System.out.println(cr.stat.Status);
                            System.out.println("Vaccine given: "+cr.stat.vacc);
                            System.out.println("Number of doses given: "+cr.stat.numDoses);
                            System.out.println("Next Dose due date: "+cr.stat.next);
                        }
                        else{
                            System.out.println("Citizen Registered");
                            cr.stat.Status="Registered";
                        }
                    }
                }
                System.out.println("--------------------------------");
            }
            else if(op==8){
                return;
            }
            else{
                System.out.println("Error! try again.");
                System.out.println("--------------------------------");
            }
        }
    }
}