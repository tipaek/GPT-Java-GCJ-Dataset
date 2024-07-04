import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
            int t=scan.nextInt();
           
           int z;
            for(z=0;z<t;z++){
                int t1=scan.nextInt();
                String[] arr=new String[t1];
                int max=0;
                int ind=0;
                String res="";
           
                for(int i=0;i<t1;i++){
                        
                    String str=scan.next();
                  
                    arr[i]=str.substring(1);
                      int len=arr[i].length();
                    if(len>max){
                        max=len;
                        ind=i;
                    }
                     
                }
                
                int j;
                int flag=0;
                for(j=0;j<t;j++){
                    int l1=arr[j].length();
                   
                     if(arr[j].equals(arr[ind].substring(max-l1))){
                         flag=0;
                     }
                     else{
                         flag=1;
                         break;
                     }
                    
                }
                
                if(flag==0){
                    res=res+arr[ind];
                }
                else{
                    res=res+"*";
                }
                int p=z+1;
                System.out.println("Case #"+p+": "+res);
                
            }
        
    }
}