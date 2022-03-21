import java.io.*;
import java.util.*;

class Main{ 
    static void menu(int op){
        if(op==0){
            System.out.println("Welcome to Classroom"+
                                "\n1. Enter as instructor"+
                                "\n2. Enter as student"+
                                "\n3. Exit");
        }
        else if(op==1){
            System.out.println("INSTRUCTOR MENU"+
                                "\n1. Add class material"+
                                "\n2. Add assessments"+
                                "\n3. View lecture materials"+
                                "\n4. View assessments"+
                                "\n5. Grade assessments"+
                                "\n6. Close assessment"+
                                "\n7. View comments"+
                                "\n8. Add comments"+
                                "\n9. Logout");
        }
        else if(op==2){
            System.out.println("STUDENT MENU"+
                                "\n1. View lecture materials"+
                                "\n2. View assessments"+
                                "\n3. Submit assessment"+
                                "\n4. View grades"+
                                "\n5. View comments"+
                                "\n6. Add comments"+
                                "\n7. Logout");
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Instructor> instructors =new ArrayList<>();
        ArrayList<Student> students =new ArrayList<>();
        ArrayList<lectureSlide> Ls = new ArrayList<>();
        ArrayList<lectureVideo> Lv = new ArrayList<>();
        ArrayList<comments> cc = new ArrayList<>();
        ArrayList<Quiz> q = new ArrayList<>();
        ArrayList<Assignment> ass = new ArrayList<>();
        Instructor I0 = new Instructor("I0");
        instructors.add(I0);
        Instructor I1 = new Instructor("I1");
        instructors.add(I1);
        Student S0 = new Student("S0");
        students.add(S0);
        Student S1 = new Student("S1");
        students.add(S1);
        Student S2 = new Student("S2");
        students.add(S2);
        int op=0;


        while(op!=3){
            menu(0);
            int id;
            int act=0;
            op=Integer.parseInt(br.readLine());


            if(op==1){
                Instructor it=new Instructor("");
                for(Instructor I : instructors){
                    System.out.println(I.getID()+"-"+I.getName());
                }
                System.out.println("Choose id");
                id=Integer.parseInt(br.readLine());
                for(Instructor I : instructors){
                    if(id==I.getID()){
                        it=I;
                    }
                }

                while(act!=9){
                    System.out.println("Welcome "+it.getName());
                    menu(1);
                    act=Integer.parseInt(br.readLine());

                    if(act==1){
                        it.addClassMaterial(it.getName(),Ls,Lv);
                    }

                    else if(act==2){
                        it.addAssesments(q,ass,students);
                    }

                    else if(act==3){
                        it.viewLectureMaterial(Ls,Lv);
                    }
                    
                    else if(act==4){
                        System.out.println("List of Open Assignments:");
                        it.viewAssesments(q,ass);
                    }

                    else if(act==5){
                        it.gradeAssessments(it.getName(),q,ass,students);
                    }

                    else if(act==6){
                        it.closeAssessments(q,ass);
                    }

                    else if(act==7){
                        it.viewComments(cc);
                    }

                    else if(act==8){
                        it.addComments(it.getName(),cc);
                    }
                }

            }


            else if(op==2){
                Student it= new Student("");
                for(Student S : students){
                    System.out.println(S.getID()+"-"+S.getName());
                }
                System.out.println("Choose id");
                id=Integer.parseInt(br.readLine());
                for(Student S : students){
                    if(id==S.getID()){
                        it=S;
                    }
                }

                while(act!=7){
                    System.out.println("Welcome "+it.getName());
                    menu(2);
                    act=Integer.parseInt(br.readLine());

                    if(act==1){
                        it.viewLectureMaterial(Ls,Lv);
                    }

                    else if(act==2){
                        System.out.println("List of Open Assignments:");
                        it.viewAssesments(q,ass);
                    }

                    else if(act==3){
                        it.submitAssesments(it,q,ass);
                    }

                    else if(act==4){
                        it.viewGrades(it,q,ass);
                    }

                    else if(act==5){
                        it.viewComments(cc);
                    }

                    else if(act==6){
                        it.addComments(it.getName(),cc);
                    }
                }

            }
        }
    }
}

class Student implements classroom{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private int ID;
    static int id=-1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    ArrayList<pack> sub = new ArrayList<>();
    Student(String name){
        id++;
        this.ID=id;
        this.name= name;
    }
    public void viewLectureMaterial(ArrayList<lectureSlide> Ls,ArrayList<lectureVideo>Lv){
        for(lectureSlide L:Ls){
            System.out.println("Title: "+L.getTopic());
            for(int i=0;i<L.getN();i++){
                System.out.println("Slide"+i+": "+L.getSlides()[i]);
            }
            System.out.println("Number of slides: "+L.getN());
            System.out.println("Date of upload: "+L.timestamp);
            System.out.println("Upladed by: "+L.getInst());
            System.out.println("\n");
        }

        for(lectureVideo L:Lv){
            System.out.println("Title of video: "+L.getTopic());
            System.out.println("Video file: "+L.getVideo());
            System.out.println("Date of upload: "+L.timestamp);
            System.out.println("Upladed by: "+L.getInst());
            System.out.println("\n");
        }
    }
    public void viewAssesments(ArrayList<Quiz> q,ArrayList<Assignment> ass){
        for(Assignment a: ass){
            System.out.println("ID: "+a.getId()+" Assignment: "+a.getPs()+" Max marks: "+a.getMax());
        }
        System.out.println("----------------");
        for(Quiz Q :q){
            System.out.println("ID: "+Q.getId()+" Question: "+Q.getQq());
        }
        System.out.println("----------------");
    }
    public void viewComments(ArrayList<comments>cc){
        for(comments c :cc){
            System.out.println(c.getComment()+" - "+c.getName());
            System.out.println(c.timestamp);
            System.out.println("\n");
        }
    }
    public void addComments(String name,ArrayList<comments>cc)throws IOException{
        System.out.println("Enter comment:");
        String cmnt =br.readLine();
        comments c2=new comments(cmnt,name);
        cc.add(c2);
    }
    void submitAssesments(Student it,ArrayList<Quiz> q,ArrayList<Assignment> ass)throws IOException{
        int h=0;
        System.out.println("Pending assessments");
        for(Assignment a: ass){
            int l=Integer.MAX_VALUE;
            for(pack p:it.sub){
                if(a.getId()==p.getId()){
                    l=p.getSubmit();
                }
            }
            if(a.getOpen()==1 && l==0){
                h++;
                System.out.println("ID: "+a.getId()+" Assignment: "+a.getPs()+" Max marks: "+a.getMax());
            }
        }
        for(Quiz Q :q){
            int k=Integer.MAX_VALUE;
            for(pack p:it.sub){
                if(Q.getId()==p.getId()){
                    k=p.getSubmit();
                }
            }
            if(Q.getOpen()==1 && k==0){
                h++;
                System.out.println("ID: "+Q.getId()+" Question: "+Q.getQq());
            }
        }
        if(h==0){
            System.out.println("No pending assignments");
        }
        else{
            System.out.println("Enter ID of assessment:");
            int Id = Integer.parseInt(br.readLine());
            for(Assignment a: ass){
                if(a.getId()==Id){
                    System.out.println("Enter filename of assignment:");
                    String assgn=br.readLine();
                    if(assgn.endsWith(".zip")){
                        for(pack p:it.sub){
                            if(a.getId()==p.getId()){
                                p.getSubmit(1);
                                p.getAns(assgn);
                            }
                        }
                    }
                    else{
                        System.out.println("Wrong format");
                    }
                }
            }
            for(Quiz Q :q){
                if(Q.getId()==Id){
                    System.out.println(Q.getQq());
                    String as=br.readLine();
                    for(pack p:it.sub){
                        if(Q.getId()==p.getId()){
                            p.getSubmit(1);
                            p.getAns(as);
                        }
                    }
                }
            }
        }
    }
    void viewGrades(Student it,ArrayList<Quiz> q,ArrayList<Assignment> ass){
        System.out.println("Graded submissions");
        for(pack p:it.sub){
            if(!p.getBy().equals("") && p.getMax()!=0){
                System.out.println("Submission: "+p.getAns());
                System.out.println("Marks scored: "+p.getMarks());
                System.out.println("Graded by: "+p.getBy());
            }
            else if(!p.getBy().equals("") && p.getMax()==1){
                System.out.println("Submission: "+p.getAns());
                System.out.println("Marks scored: "+p.getMarks());
                System.out.println("Graded by: "+p.getBy());
            }
        }
        System.out.println("----------------------------");
        System.out.println("Ungraded submissions");
        for(pack p:it.sub){
            if(p.getBy().equals("") && p.getMax()!=0){
                System.out.println("Submission: "+p.getAns());
            }
        }
    }
}

class Instructor implements classroom{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    static int id=-1;
    Instructor(String name){
        id++;
        this.ID=id;
        this.name= name;
    }

    public void viewLectureMaterial(ArrayList<lectureSlide> Ls,ArrayList<lectureVideo>Lv){

        for(lectureSlide L:Ls){
            System.out.println("Title: "+L.getTopic());
            for(int i=0;i<L.getN();i++){
                System.out.println("Slide "+i+": "+L.getSlides()[i]);
            }
            System.out.println("Number of slides: "+L.getN());
            System.out.println("Date of upload: "+L.timestamp);
            System.out.println("Upladed by: "+L.getInst());
            System.out.println("\n");
        }
        for(lectureVideo L:Lv){
            System.out.println("Title of video: "+L.getTopic());
            System.out.println("Video file: "+L.getVideo());
            System.out.println("Date of upload: "+L.timestamp);
            System.out.println("Upladed by: "+L.getInst());
            System.out.println("\n");
        }
    }
    public void viewAssesments(ArrayList<Quiz> q,ArrayList<Assignment> ass){
        for(Assignment a: ass){
            System.out.println("ID: "+a.getId()+" Assignment: "+a.getPs()+" Max marks: "+a.getMax());
        }
        System.out.println("----------------");
        for(Quiz Q :q){
            System.out.println("ID: "+Q.getId()+" Question: "+Q.getQq());
        }
        System.out.println("----------------");
    }
    public void viewComments(ArrayList<comments>cc){
        for(comments c :cc){
            System.out.println(c.getComment()+" - "+c.getName());
            System.out.println(c.timestamp());
            System.out.println("\n");
        }
    }
    public void addComments(String name,ArrayList<comments>cc)throws IOException{
        System.out.println("Enter comment:");
        String cmnt =br.readLine();
        comments c1=new comments(cmnt,name);
        cc.add(c1);
    }
    void addClassMaterial(String name,ArrayList<lectureSlide> Ls,ArrayList<lectureVideo>Lv)throws IOException{
        System.out.println("1. Add Lecture Slide"+
                            "\n2. Add Lecture Video");
        int op =Integer.parseInt(br.readLine());
        if(op == 1){
            lectureSlide S = new lectureSlide(name);
            Ls.add(S);
        }
        else if(op== 2){
            lectureVideo V = new lectureVideo(name);
            if(V.getVideo().endsWith(".mp4")){
                Lv.add(V);
            }
            else{
                System.out.println("Wrong format");
            }
        }
    }
    void addAssesments(ArrayList<Quiz> q,ArrayList<Assignment> ass,ArrayList<Student> students)throws IOException{
        System.out.println("1. Add Assignment"+
                            "\n2. Add Quiz");
        int op =Integer.parseInt(br.readLine());
        if(op == 1){
            Assignment assignment = new Assignment();
            ass.add(assignment);
            for(Student s : students){
                pack p = new pack(0,assignment.getId(),assignment.getMax());
                s.sub.add(p);
            }
        }
        else if(op == 2){
            Quiz quiz = new Quiz();
            q.add(quiz);
            for(Student s : students){
                pack p = new pack(0,quiz.getId(),1);
                s.sub.add(p);
            }
        }
    }
    void gradeAssessments(String name,ArrayList<Quiz> q,ArrayList<Assignment> ass,ArrayList<Student> students)throws IOException{
        viewAssesments(q,ass);
        System.out.println("Enter ID of assessment to view submissions:");
        int Id = Integer.parseInt(br.readLine());
        String prob="";
        for(Quiz q1:q){
            if(q1.getId()==Id){
                prob=q1.getQq();
            }
        }
        for(Assignment a1:ass){
            if(a1.getId()==Id){
                prob=a1.getPs();
            }
        }
        System.out.println("Choose ID from these ungraded submissions");
        for(Student S : students){
            for(pack p : S.sub){
                if(p.getId()==Id){
                    if(p.getSubmit()==1){
                        System.out.println(S.getID()+". "+S.getName());
                    }
                }
            }
        }
        int Ids= Integer.parseInt(br.readLine());
        for(Student S : students){
            if(S.getID()==Ids){
                for(pack p : S.sub){
                    if(p.getId()==Id){
                        System.out.println(prob);
                        System.out.println("Submission: "+p.getAns());
                        System.out.println("Max Marks: "+p.getMax());
                        System.out.println("Marks scored: ");
                        int mark = Integer.parseInt(br.readLine());
                        p.getMarks(mark);
                        p.getBy(name);
                    }
                }
            }
        }
    }
    void closeAssessments(ArrayList<Quiz> q,ArrayList<Assignment> ass)throws IOException{
        viewAssesments(q,ass);
        System.out.println("Enter id of assignment to close:");
        int Id = Integer.parseInt(br.readLine());
        for(Assignment a: ass){
            if(a.getId()== Id){
                a.getOpen(0);
            }
        }
        for(Quiz Q :q){
            if(Q.getId() == Id){
                Q.getOpen(0);
            }
        }
    }
}

interface classroom{
    void viewLectureMaterial(ArrayList<lectureSlide> Ls,ArrayList<lectureVideo>Lv); 
    void viewAssesments(ArrayList<Quiz> q,ArrayList<Assignment> ass);      
    void viewComments(ArrayList<comments>cc);        
    void addComments(String name,ArrayList<comments>cc)throws IOException;         
}

class Assessment{
    private int id;
    static int ID=0;
    private int open=1;

    public int getId() {
        return id;
    }

    public void getId(int x) {
        this.id=x;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOpen() {
        return open;
    }

    public void getOpen(int x) {
        this.open=x;
    }

    public void setOpen(int open) {
        this.open = open;
    }
}

class Quiz extends Assessment{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String qq;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    Quiz()throws IOException{
        this.getId(ID++);
        System.out.println("Enter Enter quiz question:");
        this.qq = br.readLine();
    }
}

class Assignment extends Assessment{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String ps;
    private int max;

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    Assignment()throws IOException{
        this.getId(ID++);
        System.out.println("Enter problem statement:");
        this.ps = br.readLine();
        System.out.println("Enter max marks:");
        this.max = Integer.parseInt(br.readLine());
    }
}

class comments{
    private String comment;
    Date timestamp;
    private String name;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    comments(String comment, String name){
        this.comment = comment;
        this.name = name;
        Date date = java.util.Calendar.getInstance().getTime();
        this.timestamp = date;
    }
}

class material{
    private String inst;

    public String getInst() {
        return inst;
    }

    public void getInst(String x) {
        this.inst = x;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }
}

class lectureSlide extends material{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String topic;
    private int n;
    private String[] slides;
    Date timestamp;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String[] getSlides() {
        return slides;
    }

    public void setSlides(String[] slides) {
        this.slides = slides;
    }

    lectureSlide(String inst)throws IOException{
        System.out.println("Enter topic of slides:");
        this.topic = br.readLine();

        System.out.println("Enter number of slides:");
        this.n=Integer.parseInt(br.readLine());

        System.out.println("Enter content of slides");
        this.slides= new String[n];
        for(int i=0; i<n; i++){
            this.slides[i]=br.readLine();
        }
        Date date = java.util.Calendar.getInstance().getTime();
        this.timestamp = date;
        this.getInst(inst);
    }
}

class lectureVideo extends material{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private String topic;
    private String video;
    Date timestamp;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    lectureVideo(String inst)throws IOException{
        System.out.println("Enter topic of video:");
        this.topic = br.readLine();

        System.out.println("Enter filename of video:");
        this.video = br.readLine();
        Date date = java.util.Calendar.getInstance().getTime();
        this.timestamp = date;
        this.getInst(inst);
    }
}

class pack{
    private int submit;
    private int id;
    private String ans="";
    private int marks=0;
    private int max=1;
    private String by="";

    public int getSubmit() {
        return submit;
    }
    public void getSubmit(int x) {
        this.submit = x;
    }

    public String getAns() {
        return ans;
    }

    public void getAns(String x) {
        this.ans=x;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void getMarks(int x) {
        this.marks=x;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getBy() {
        return by;
    }

    public void getBy(String x) {
        this.by=x;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }

    pack(int submit, int id, int max){
        this.submit = submit;
        this.id = id;
        this.max = max;
    }
}