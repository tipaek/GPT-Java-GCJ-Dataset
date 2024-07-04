import java.util.*;
class Solution{ 
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int T= sc.nextInt();
    for(int t=1;t<=T;t++){
        int n=sc.nextInt();
        int s[]=new int[n];
        int e[]=new int[n];
        for(int i=0;i<n;i++){
            s[i]=sc.nextInt();
            e[i]=sc.nextInt();
        }
        int C[]=new int[1441];
        int J[]=new int[1440];
        char[] array=new char[n];
        
        int flag=0;
        for(int i=0;i<n;i++){
            for(int k=s[i];k<e[i];k++){
                if(C[k]==1){
                    flag=1;
                    for(int j=s[i];j<k;j++){
                        C[j]=0;
                    }
                    break;
                }
                else C[k]=1;
            }
            if(flag==1){
               for(int k=s[i];k<e[i];k++){
                if(J[k]==1){
                    flag=2;
                    break;
                }
                else J[k]=1;
               } 
            }
        
            if(flag==0)  array[i]='C';
            else if(flag==1)  array[i]='J';
            else if(flag==2)  break;
            flag=0;
        }
       
       if(flag==2){
           System.out.println("Case #"+t+": IMPOSSIBLE");
       }
       else{
            String str=new String(array);
            System.out.println("Case #"+t+": "+str);
       }
    }
  }
}