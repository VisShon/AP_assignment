import java.io.*;
import java.util.*;
class Matrix{
/*      
    0. Rectangular Matrix
    1. Row Matrix
    2. Column Matrix
    3. Square Matrix
    4. Symmetric Matrix
    5. Skew-symmetric Matrix
    6. Upper-triangular Matrix
    7. Lower-triangular Matrix
    8. Singular Matrix
    9. Diagonal Matrix
    10. Scalar Matrix
    11. Identity Matrix
    12. Singleton Matrix
    13. Ones Matrix
    14. Null Matrix
*/        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    protected String name;
    protected int[] labels = new int[15];
    protected int m;
    protected int n;
    protected float[][] data;
    protected float k=Float.MAX_VALUE;
    protected float[] data2;
    public Matrix(int op)throws IOException{
        System.out.println("Enter name of matrix");
        this.name = br.readLine();
        System.out.println("Enter the number of rows");
        this.m=Integer.parseInt(br.readLine());
        System.out.println("Enter the number of columns");
        this.n=Integer.parseInt(br.readLine());
        data = new float[m][n];
        data2 = new float[m];
        for(int i=0;i<m;i++){
            System.out.println("Enter the elements of row "+i);
            for(int j=0;j<n;j++){
                data[i][j]=Float.parseFloat(br.readLine());
            }             
        }
    }

    public Matrix(int m,int n){
        this.m=m;
        this.n=n;
        data = new float[m][n];
    }
    public Matrix(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getData2() {
        return data2;
    }

    public void setData2(float[] data2) {
        this.data2 = data2;
    }

    public int[] getLabels() {
        return labels;
    }

    public void setLabels(int[] labels) {
        this.labels = labels;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public float[][] getData() {
        return data;
    }

    public void setData(float[][] data) {
        this.data = data;
    }

    public float getK() {
        return k;
    }

    public void setK(float k) {
        this.k = k;
    }

    void printLables(){
        String[] types = {"Rectangular Matrix","Row Matrix","Column Matrix","Square Matrix"
            ,"Symmetric Matrix","Skew-symmetric Matrix","Upper-triangular Matrix","Lower-triangular Matrix"
            ,"Singular Matrix","Diagonal Matrix","Scalar Matrix","Identity Matrix","Singleton Matrix","Ones Matrix",
            "Null Matrix"};
        for(int i=0;i<this.labels.length;i++){
            if(this.labels[i]==1){
                System.out.println(types[i]);
            }
        }
    }
    void arthimetic(Matrix B)throws IOException{
        System.out.println(
            "\n1=addition"+
            "\n2=subtraction"+
            "\n3=multiplication"+
            "\n4=division");
        int op = Integer.parseInt(br.readLine());
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(op==0){
            System.out.println(
                "\n1=addition"+
                "\n2=subtraction"+
                "\n3=multiplication"+
                "\n4=division");
                op = Integer.parseInt(br.readLine());
        }
        if(op==1){
            float[][] C = new float[this.m][this.n];
            if(this.m==B.m && this.n==B.n){
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        C[i][j]= d[i][j]+B.data[i][j];
                    }
                }
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.println("\n");
                }
            }
        }

        else if(op==2){
            float[][] C = new float[this.m][this.n];
            if(this.m==B.m && this.n==B.n){
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        C[i][j]= d[i][j]-B.data[i][j];
                    }
                }
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.println("\n");
                }
            }
        }

        else if(op==3){
            if(this.n==B.m && (B.labels[12]!=1 && this.labels[12]!=1 )){
                float[][] C = new float[this.m][B.n];
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<B.n;j++){
                        for(int k=0;k<B.m;k++){
                            C[i][j] += d[i][k]*B.data[k][j];
                        }
                    }
                }
                
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<B.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.println("\n");
                }
            }
            if(B.labels[12]==1 || this.labels[12]==1 ){
                System.out.println("Do you want scalar multiplication 0 for no 1 for yes");
                int y=Integer.parseInt(br.readLine());
                if(y==1){
                    if(B.labels[12]==1){
                        float[][] C = new float[this.m][this.n];
                        for(int i=0;i<this.m;i++){
                            for(int j=0;j<this.n;j++){
                                C[i][j] += this.data[i][j]*B.k; 
                            }
                        }
                        for(int i=0;i<this.m;i++){
                            for(int j=0;j<this.n;j++){
                                System.out.print(C[i][j]+" ");
                            }
                            System.out.println("\n");
                        }
                    }
                    if(this.labels[12]==1){
                        float[][] C = new float[B.m][B.n];
                        for(int i=0;i<B.m;i++){
                            for(int j=0;j<B.n;j++){
                                C[i][j] += this.k*B.data[i][j];
                            }
                        }
                        for(int i=0;i<B.m;i++){
                            for(int j=0;j<B.n;j++){
                                System.out.print(C[i][j]+" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
                else{
                    System.out.println("enter a scalar");
                    int k=Integer.parseInt(br.readLine());
                    if(B.labels[12]==1){
                        float[][] C = new float[this.m][this.n];
                        for(int i=0;i<this.m;i++){
                            for(int j=0;j<this.n;j++){
                                C[i][j] += this.data[i][j]*k; 
                            }
                        }
                        for(int i=0;i<this.m;i++){
                            for(int j=0;j<this.n;j++){
                                System.out.print(C[i][j]+" ");
                            }
                            System.out.println("\n");
                        }
                    }
                    if(this.labels[12]==1){
                        float[][] C = new float[B.m][B.n];
                        for(int i=0;i<B.m;i++){
                            for(int j=0;j<B.n;j++){
                                C[i][j] += k*B.data[i][j];
                            }
                        }
                        for(int i=0;i<B.m;i++){
                            for(int j=0;j<B.n;j++){
                                System.out.print(C[i][j]+" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }

        else if(op==4){
            this.arthimetic(B.inverse(0),3);
        }

        else{
            System.out.println("Invalid matrix try again.");
        }
    }

    void arthimetic(Matrix B, int op){
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(op==1){
            float[][] C = new float[this.m][this.n];
            if(this.m==B.m && this.n==B.n){
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        C[i][j]= d[i][j]+B.data[i][j];
                    }
                }
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
        }

        else if(op==2){
            float[][] C = new float[this.m][this.n];
            if(this.m==B.m && this.n==B.n){
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        C[i][j]= d[i][j]-B.data[i][j];
                    }
                }
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<this.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
        }

        else if(op==3){
            float[][] C = new float[this.m][B.n];
            if(this.n==B.m){
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<B.n;j++){
                        for(int k=0;k<B.m;k++){
                            C[i][j] += d[i][k]*B.data[k][j];
                        }
                    }
                }
                for(int i=0;i<this.m;i++){
                    for(int j=0;j<B.n;j++){
                        System.out.print(C[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
        }

        else if(op==4){
            this.arthimetic(B.inverse(0),3);
        }

        else{
            System.out.println("Invalid matrix try again.");
        }
    }
    void EWO(Matrix B)throws IOException{
        float[][] d = new float[this.m][this.n];
        float[][] e = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(this.k==Float.MAX_VALUE){
            e=B.data;
        }
        else{
            e=B.matrixit(this.k, this.m, this.n, this.data2);
        }
        float[][] C = new float[this.m][this.n];
        System.out.println(
                            "\n1=addition"+
                            "\n2=subtraction"+
                            "\n3=multiplication"+
                            "\n4=division");
        int op = Integer.parseInt(br.readLine());

        if(op==1){
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C[i][j]= d[i][j]+e[i][j];
                }
            }
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    System.out.print(C[i][j]+" ");
                }
                System.out.print("\n");
            }
        }

        else if(op==2){
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C[i][j]= d[i][j]-e[i][j];
                }
            }
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    System.out.print(C[i][j]+" ");
                }
                System.out.print("\n");
            }
        }

        else if(op==3){
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C[i][j]= d[i][j]*e[i][j];
                }
            }
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    System.out.print(C[i][j]+" ");
                }
                System.out.print("\n");
            }
        }

        else if(op==4){
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    if(e[i][j]==0){
                        System.out.println("Zero cant divide");
                        return;
                    }
                    C[i][j]= d[i][j]/e[i][j];
                }
            }
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    System.out.print(C[i][j]+" ");
                }
                System.out.print("\n");
            }
        }            
    }

    Matrix transpose(int op){
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        Matrix C = new Matrix(this.n,this.m);
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                C.data[i][j]= d[j][i];
            }
        }
        if(op==1){
            for(int i=0;i<this.n;i++){
                for(int j=0;j<this.m;j++){
                    System.out.print(C.data[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
        return C;
    }
    Matrix inverse(int op){
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(this.labels[0]==1){
            System.out.println("Rectangular matrix cant have an inverse");
            return null;
        }
        if(this.determinant()==0){
            System.out.println("Matrix with determinant = 0 can't have an inverse");
            return null;
        }
        Matrix C = new Matrix(this.m,this.n);
        float det =this.determinant();
        if(this.m==1){
            C=this;
            
        }
        else if(this.m==2){
            C.data[0][0] = (float)((float)this.data[1][1]/det);
           C.data[0][1] = (float)(((float)this.data[0][1]*(-1))/det);
           C.data[1][0] = (float)(((float)this.data[1][0]*(-1))/det);
           C.data[1][1] = (float)((float)this.data[0][0]/det);
            
        }
        else if(this.m==3){
            float[][] A = new float[3][3];
            A[0][0] = d[1][1]*d[2][2] - d[1][2]*d[2][1];
            A[1][0] = d[1][2]*d[2][0] - d[1][0]*d[2][2];
            A[2][0] = d[1][0]*d[2][1] - d[1][1]*d[2][0];
            A[0][1]= d[0][2]*d[2][1] - d[0][1]*d[2][2];
            A[1][1] = d[0][0]*d[2][2] - d[0][2]*d[2][0];
            A[2][1] = d[0][1]*d[2][0] - d[0][0]*d[2][1];
            A[0][2] = d[0][1]*d[1][2] - d[0][2]*d[1][1];
            A[1][2] = d[0][2]*d[1][0] - d[0][0]*d[1][2];
            A[2][2] = d[0][0]*d[1][1] - d[0][1]*d[1][0];
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C.data[i][j]=A[i][j]*(float)Math.pow(-1,i+j)/det;
                }
            }
            
        }
        if(op==1){
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    System.out.print(C.data[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
        return C;
    }

    void mean()throws IOException{
        System.out.println(
                            "\n1=row wise"+
                            "\n2=column wise"+
                            "\n3=all element");
        int op= Integer.parseInt(br.readLine());
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(op==2){
            float[][] C = new float[1][this.n];
            for(int i=0;i<this.n;i++){
                for(int j=0;j<this.m;j++){
                    C[0][i]+=d[j][i]/this.m;
                }
            }
            for(int i=0;i<this.n;i++){
                System.out.print(C[0][i]+" ");
            }
        }
        else if(op==1){
            float[][] C = new float[this.m][1];
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C[i][0]+=d[i][j]/this.n;
                }
            }
            for(int i=0;i<this.m;i++){
                System.out.print(C[i][0]+"\n");
            }
        }

        else if(op==3){
            int C=0;
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    C+=d[j][i];
                }
            }
            System.out.println("Mean = "+C/(this.m*this.n));
        }
    }

    float[][] matrixit(float k, int m, int n, float[] data2){
        float[][] data = new float[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(this.labels[14]==1){
                    data[i][j]=0;
                }
                else if(this.labels[13]==1){
                    data[i][j]=1;
                }
                else if(this.labels[12]==1){
                    data[i][j]=k;
                    
                }
                else if(this.labels[10]==1 || this.labels[11]==1){
                    data[i][i]=k;
                }
                else if(this.labels[9]==1){
                    data[i][i]=data2[i];
                }
            }
        }
        return data;
    }

    float determinant(){
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(this.labels[0]==1){
            System.out.println("Rectangular Matrix can't be determined");
            return (float)0;
        }
        float det=0;
        if(this.m==1 && this.n==1){
            return d[0][0];
        }
        else if(this.m==2 && this.n==2){
            return d[0][0]*d[1][1]-d[1][0]*d[0][1];
        }
        else{
            Matrix C = new Matrix(this.m,this.n);
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    Matrix temp = new Matrix(this.m-1,this.n-1);
                    int p=0;
                    int q=0;
                    for(int k=0;k<this.m;k++){
                        for(int l=0;l<this.n;l++){
                            if(k!=i && l!=j){
                                temp.data[p][q]=d[k][l];
                                q++;
                            }
                        }
                        if(q==n-1){
                            p++;
                            q=0;
                        }
                    }
                    C.data[i][j]=d[i][j]*temp.determinant()*(int)((float)Math.pow(-1, i + j));
                }
            }
            
            for(int i=0;i<C.n;i++){
                det +=C.data[0][i];
            }
        }
        return det;
             
    }

    void addtranspose(){

        Matrix B = this.transpose(0);
        this.arthimetic(B, 1);
    }

    void eigen(){
        float [] vals = new float[2];
        float x , y;
        float[][] d = new float[this.m][this.n];
        if(this.k==Float.MAX_VALUE){
            d=this.data;
        }
        else{
            d=this.matrixit(this.k, this.m, this.n, this.data2);
        }
        if(this.n != this.n){
            System.out.println("eigen not defined");
            vals[0] = vals[1] = 0;
            for(int i=0; i<2;i++){
                System.out.println(vals[i]);
            }
        }

        else{
            if(this.n == 1){
                x = (float)this.data[0][0];
                vals[0] = x;
                for(int i=0; i<2;i++){
                    System.out.println(vals[i]);
                }
            }

            if(this.n == 2){
                float sqrt = d[0][0]*d[0][0] - 2*d[0][0]*d[1][1] + 4*d[0][1]*d[1][0] + d[1][1]*d[1][1];
                if(sqrt >= 0){
                    float sr = (float)Math.sqrt(sqrt);
                    x = (d[0][0] + d[1][1] - sr)/2;
                    y = (d[0][0] + d[1][1] + sr)/2;
                    vals[0] = x;
                    vals[1] = y;
                    for(int i=0; i<2;i++){
                        System.out.println(vals[i]);
                    }
                }
            }
        }
    }

    void solve(Matrix B){

        if(B.m==this.m){
            this.inverse(0).arthimetic(B,3);
        }
    }

    int Checktypes(Matrix B,ArrayList<Matrix> mat){

        B.constructIt(mat,0);
        for(int i=0;i<this.labels.length;i++){
            if(this.labels[i]!=B.labels[i]){
                return 0;
            }
        }
        return 1;
    }

    void constructIt(ArrayList<Matrix> mat,int op){
        if(this.m==this.n){
            for(int i=3;i<15;i++){
                this.labels[i]=1;
            }
            this.labels[8]=0;
            this.labels[12]=0;
            if(this.m==1){
                this.labels[12]=1;
                this.labels[11]=0;
                this.labels[13]=0;
                this.labels[14]=0;
                this.labels[5]=0;
                if (this.determinant()==0){
                    this.labels[8]=1;
                }
                if(this.data[0][0]==1){
                    this.labels[11]=1;
                    this.labels[13]=1;
                }
                if(this.data[0][0]==0){
                    this.labels[14]=1;
                }
                Singleton A = new Singleton(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.determinant()==0) {
                this.labels[8]=1;
            }
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    if(this.data[i][j]!=0){
                        this.labels[14]=0;
                    }
                    if(this.data[i][j]!=1){
                        this.labels[13]=0;
                    }
                    if(this.data[i][j]!=this.data[j][i]){
                        this.labels[4]=0;
                    }
                    if(this.data[i][j]!=-this.data[i][j] || this.data[i][i]!=0){
                        this.labels[5]=0;
                    }
                    if(this.data[i][j]!=0 || this.data[i][i]==0){
                        this.labels[9]=0;
                    }
                    if(this.data[i][j]!=0 || this.data[i][i]==0 || this.data[i][i]!=this.data[0][0]){
                        this.labels[10]=0;
                    }
                    if(this.data[i][j]!=0 && this.data[i][i]==0 && this.data[i][i]!=1){
                        this.labels[11]=0;
                    }
                }
            }
            int flag =0;
            for(int i=1;i<this.m;i++){
                for(int j=0;j<i;j++){
                    if(this.data[i][j]!=0){
                        this.labels[6]=0;
                        flag++;
                    }
                }
            }
            for(int i=0;i<this.m;i++){
                for(int j=i+1;j<this.n;j++){
                    if(this.data[i][j]!=0){
                        this.labels[7]=0;
                        flag++;
                    }
                }
            }
            if(flag==2){
                this.labels[7]=0;
                this.labels[6]=0;
            }
            if(this.labels[5]==1){
                Skew A=new Skew(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.labels[6]==1){
                Uppert A =new Uppert(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.labels[7]==1){
                Lowert A =new Lowert(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.labels[4]==1){
                if(this.labels[13]==1){
                    Ones A = new Ones(this.m,this.n,this.data,this.labels,this.name);
                    mat.add(A);
                    return;
                }
                if(this.labels[14]==1){
                    Nul A = new Nul(this.m,this.n,this.data,this.labels,this.name);
                    mat.add(A);
                    return;
                }
                if(this.labels[9]==1){
                    if(this.labels[10]==1){
                        if(this.labels[11]==1){
                            Identity A = new Identity(this.m,this.data,this.labels,this.name);
                            mat.add(A);
                            return;
                        }
                        Scalar A = new Scalar(this.m,this.data,this.labels,this.name);
                        mat.add(A);
                        return;
                    }
                    Diagonal A = new Diagonal(this.m,this.data,this.labels,this.name);
                    mat.add(A);
                    return;
                }
                Symmetric A = new Symmetric(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.labels[8]==1){
                Singular A = new Singular(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            mat.add(this);
        }

        else{
            this.labels[0]=1;
            this.labels[13]=1;
            this.labels[14]=1;
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    if(this.data[i][j]!=0){
                        this.labels[14]=0;
                    }
                    if(this.data[i][j]!=1){
                        this.labels[13]=0;
                    }
                }
            }
            if(this.labels[14]==1){
                Nul A = new Nul(this.m,this.n,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.labels[13]==1){
                Ones A = new Ones(this.m,this.n,this.data,this.labels,this.name);
                mat.add(A);
                return;                
            }
            if(this.m==1 && this.n!=1){
                this.labels[1]=1;
                Rows A = new Rows(this.n,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            if(this.m!=1 && this.n==1){
                this.labels[2]=1;
                Cols A = new Cols(this.m,this.data,this.labels,this.name);
                mat.add(A);
                return;
            }
            mat.add(this);
        }
    }
}

class Rectangular extends Matrix{
    
    public Rectangular(int m, int n, float[][] data,int[] labels,String name){
        this.m=m;
        this.n=n;
        this.data=data;
        this.labels=labels;
        this.name=name;
    }
    public Rectangular(){

    }

}
class Square extends Matrix{
    
    public Square(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
    public Square(){
        
    }
}
//special
class Nul extends Matrix{
    
    public Nul(int m, int n, float[][] data,int[] labels,String name){
        this.m=m;
        this.n=n;
        //this.data=data;
        this.k=0;
        this.labels=labels;
        this.name=name;
        
    }
}
class Ones extends Matrix{
    
    public Ones(int m, int n, float[][] data,int[] labels,String name){
        this.m=m;
        this.n=n;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Rows extends Rectangular {
    
    public Rows(int n, float[][] data, int[] labels,String name){
        this.n=n;
        this.m=1;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Cols extends Rectangular{
    
    public Cols(int m, float[][] data, int[] labels,String name){
        this.m=m;
        this.n=1;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Uppert extends Square{
    
    public Uppert(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Lowert extends Square{
    
    public Lowert(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Singular extends Square{
    
    public Singular(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
class Symmetric extends Square{
    
    public Symmetric(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
    public Symmetric(){
        
    }
}
class Skew extends Square{
    
    public Skew(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=Float.MAX_VALUE;
    }
}
//special
class Diagonal extends Symmetric{
    
    public Diagonal(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        //this.data=data;
        for(int i=0;i<this.m;i++){
            this.data2[i]=data[i][i];
            this.k*=data[i][i];
        }
        this.labels=labels;
        this.name=name;
    }
    public Diagonal(){
        
    }
}
//special
class Scalar extends Diagonal{
    
    public Scalar(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        //this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=data[0][0];
    }
    public Scalar(){
        
    }
}
//special
class Identity extends Scalar{
    
    public Identity(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        //this.data=data;
        this.labels=labels;
        this.name=name;
        this.k=1;
    }
}
//special
class Singleton extends Symmetric{
    
    public Singleton(int m, float[][] data, int[] labels,String name){
        this.m=this.n=m;
        this.labels=labels;
        this.name=name;
        this.k=data[0][0];
    }
}
class Main{
    static void menu(ArrayList<Matrix> mat,int op){
        if(op==1){
            System.out.println(
                "0= Create new matrix"+
                "\n1= Arithematic"+
                "\n2= Element wise operation"+ //scalar matrix
                "\n3= Transpose"+ //special for symmetric ans skew
                "\n4= Inverse"+
                "\n5= Mean"+
                "\n7= Determinant"+ // direct for diagonal, singleton and singular
                "\n8= Transpose addition"+ //2a for symetric and null for skew
                "\n9= Eigen value and eigen vectors"+
                "\n10= Solve linear equation"+
                "\n11= Print of a particular type"+
                "\n12= Edit a matrix"+
                "\n13= print labels"+
                "\n14= Exit");
                System.out.println("===========================");
        }
        else if(op ==2){
            for(Matrix M: mat){
                System.out.println(M.name+"=>");
                for(int i=0;i<M.m;i++){
                    for(int j=0;j<M.n;j++){
                        float[][] d = new float[M.m][M.n];
                        if(M.k==Float.MAX_VALUE){
                            d=M.data;
                        }
                        else{
                            d=M.matrixit(M.k, M.m, M.n, M.data2);
                        }
                        System.out.print(d[i][j]+" ");
                    }
                    System.out.print("\n");
                }
                System.out.println("===========================");
            }
        }
        else if(op==3){
            System.out.println(
                "Rectangular Matrix"+
                "\nRow Matrix"+
                "\nColumn Matrix"+
                "\nSquare Matrix"+
                "\nSymmetric Matrix"+
                "\nSkew-symmetric Matrix"+
                "\nUpper-triangular Matrix"+
                "\nLower-triangular Matrix"+
                "\nSingular Matrix"+
                "\nDiagonal Matrix"+
                "\nScalar Matrix"+
                "\nIdentity Matrix"+
                "\nSingleton Matrix"+
                "\nOnes Matrix"+
                "\nNull Matrix"); 
            System.out.println("===========================\n");
        }
        
    }
    static void printOfType(String type, ArrayList<Matrix> M,List<String> types){
        int k =types.indexOf(type);
        for(Matrix Mat : M){
            if(Mat.labels[k]==1){
                System.out.println(Mat.name + " => ");
                for(int i=0;i<Mat.m;i++){
                    for(int j=0;j<Mat.n;j++){
                        System.out.print(Mat.data[i][j]+" ");
                    }
                    System.out.print("\n");
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        List<String> types = Arrays.asList("Rectangular Matrix","Row Matrix","Column Matrix","Square Matrix"
            ,"Symmetric Matrix","Skew-symmetric Matrix","Upper-triangular Matrix","Lower-triangular Matrix"
            ,"Singular Matrix","Diagonal Matrix","Scalar Matrix","Identity Matrix","Singleton Matrix","Ones Matrix",
            "Null Matrix");
        ArrayList<Matrix> matrices = new ArrayList<Matrix>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opr=-1;
        while(opr!=14){
            menu(matrices,1);
            Matrix A=new Matrix(0,0);
            opr=Integer.parseInt(br.readLine());
            if(opr==0){
                Matrix temp = new Matrix(0);
                temp.constructIt(matrices,1);
                System.out.println("Added Successfully");
                System.out.println("===========================\n");
            }

            else if(opr==1){
                menu(matrices,2);
                Matrix B=new Matrix(0,0);
                System.out.println("select first matrix");
                String name1=br.readLine();
                System.out.println("select second matrix");
                String name2=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                    if(m.getName().equals(name2)){
                        B=m;
                    }
                }
                A.arthimetic(B);
                System.out.println("===========================\n");
            }

            else if(opr==2){
                menu(matrices,2);
                Matrix B=new Matrix(0,0);
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                System.out.println("select matrix second matrix");
                String name2=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name2)){
                        B=m;
                    }
                }
                A.EWO(B);
                System.out.println("===========================\n");
            }

            else if(opr==3){
                menu(matrices,2);
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.transpose(1);
                System.out.println("===========================\n");
            }
            
            else if(opr==4){
                menu(matrices,2);               
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.inverse(1);
                System.out.println("===========================\n");
            }

            else if(opr==5){
                menu(matrices,2);                
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.mean();
                System.out.println("===========================\n");
            }

            else if(opr==6){
                menu(matrices,2);                
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.mean();
                System.out.println("===========================\n");
            }

            else if(opr==7){
                menu(matrices,2);               
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                System.out.println(A.determinant());
                System.out.println("===========================\n");
            }

            else if(opr==8){
                menu(matrices,2);                
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.addtranspose();
                System.out.println("===========================\n");
            }

            else if(opr==9){
                menu(matrices,2);               
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.eigen();
                System.out.println("===========================\n");
            }

            else if(opr==10){
                menu(matrices,2);                
                Matrix B=new Matrix(0,0);
                System.out.println("select first matrix\n");
                String name1=br.readLine();
                System.out.println("select second matrix\n");
                String name2=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                    if(m.getName().equals(name2)){
                        B=m;
                    }
                }
                A.solve(B);
                System.out.println("===========================\n");
            }

            else if(opr==11){
                menu(matrices,3);
                System.out.println("select type\n");
                String type=br.readLine();
                printOfType(type, matrices, types);
                System.out.println("===========================\n");
            }

            else if(opr==12){
                int op=-1;
                menu(matrices,2);               
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                Matrix B=new Matrix(A.m,A.n);
                B.data=A.data;
                while(op!=0){
                    System.out.println("To enter new data into matrix press 1 or press 0 to exit");
                    op=Integer.parseInt(br.readLine());
                    if(op==1){
                        System.out.println("Enter the coordinates x and y to edit");
                        int x= Integer.parseInt(br.readLine())-1;
                        int y= Integer.parseInt(br.readLine())-1;
                        System.out.println("Enter new value");
                        int value=Integer.parseInt(br.readLine());
                        B.data[x][y] = value;
                        int k=A.Checktypes(B,matrices);
                        if(k==1){
                            A.data[x][y]=value;
                            System.out.println("Done!");
                        }
                        else{
                            System.out.println("Invalid editing, Matrix type changed, Try again");
                        }

                    }
                }
            }
            else if(opr==13){
                menu(matrices,2);               
                System.out.println("select matrix");
                String name1=br.readLine();
                for(Matrix m : matrices){
                    if(m.getName().equals(name1)){
                        A=m;
                    }
                }
                A.printLables();
            }
        }
    }
}