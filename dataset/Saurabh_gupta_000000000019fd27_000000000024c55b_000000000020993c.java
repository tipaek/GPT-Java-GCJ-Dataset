import java.util.*;
class CODEJAM1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int Arrsum[]=new int[T];
        int Arrrow[]=new int[T];
        int Arrcol[]=new int[T];
        int c=0;
        while(c<T){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int sum=0,row=0,col=0, flagr=0,flagc=0;
            String str="";
            String strarr[]=new String[n];
            boolean cols[]=new boolean[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int t=sc.nextInt();
                    
                    arr[i][j]=t;
                    if(i==j)
                        sum+=t;
                    //System.out.println((str.contains(t+""))&&flag==0&&j!=0);
                    if((str.contains(t+""))&&flagr==0&&j!=0){
                        row++;
                    flagr=1;}
                    if(strarr[j]==null){
                        strarr[j]="";
                    }
                    if(strarr[j]!=null&&strarr[j].contains(t+"")&&cols[j]==false){
                        col++;
                        cols[j]=true;
                        //System.out.println(strarr[j]+":::t "+t+" j:"+j);
                    }
                    
                    strarr[j]+=t;
                    str+=t;
                }
                flagr=0;
                str="";
            }
            Arrsum[c]=sum;
            Arrrow[c]=row;
            Arrcol[c]=col;
            
            //System.out.println("sum:- "+sum+" row: "+row+" col: "+col);
            //for(String s:strarr){
              //  System.out.println(s);
            //}
            
            c++;
        }
        for(c=0;c<T;c++){
            System.out.println("Case #"+(c+1)+": "+Arrsum[c]+" "+Arrrow[c]+" "+Arrcol[c]);
        }
    }
    
}