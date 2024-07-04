import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        int count=1;
        while(test-->0) {
            int n=s.nextInt();
            Integer start[]=new Integer[n];
            Integer finish[]=new Integer[n];
            Integer index[]=new Integer[n];
            for(int i=0;i<n;i++) {
                start[i]=s.nextInt();
                finish[i]=s.nextInt();
                index[i]=i;
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(start[j]>start[i]) {
                        int temp=start[i];
                        start[i]=start[j];
                        start[j]=temp;

                        temp=finish[i];
                        finish[i]=finish[j];
                        finish[j]=temp;

                        temp=index[i];
                        index[i]=index[j];
                        index[j]=temp;

                        /*swap(finish[i],finish[j]);
                        swap(index[i],index[j]);*/
                    }
                }
            }
            /*for(int i=0;i<n;i++) {
                System.out.println("Start="+start[i]+" Finsish="+finish[i]+" index="+index[i]);
            }*/
            char[] c=new char[n];
            char[] result=new char[n];
            int finish_c=-1;
            int finish_j=-1;
            int i;
            boolean flag=true;
            for(i=0;i<n;i++) {
              
                if(finish_c<=start[i]) {
                    finish_c=finish[i];
                    result[i]='C';
                    continue;
                }
                if(finish_j<=start[i]) {
                    finish_j=finish[i];
                    result[i]='J';
                    continue;
                }
                if((finish_j>start[i])&&(finish_c>start[i])) {
                    flag=false;
                    break;
                    
                }
            }
            
            if(flag==false) 
                System.out.println("Case #"+(count++)+": IMPOSSIBLE");
            else {
                for(i=0;i<n;i++) {
                    c[index[i]]=result[i];
                }
                System.out.print("Case #"+(count++)+": ");
                for(i=0;i<n;i++) {
                    System.out.print(c[i]);
                }
                System.out.println();
              
            }
        }
    }
   
}