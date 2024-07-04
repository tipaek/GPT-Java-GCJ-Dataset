import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int j=0; j<t; j++){
            int n=in.nextInt();
           
            System.out.println("Case #"+(j+1)+":");
            solve(n);
        }
        
    }
    
    public static void solve(int n) {
     int index=1;
     int row=1;
     if(n==1){
         System.out.println("1 1");
         return;
     }
     if(n==2){
          System.out.println("1 1");
           System.out.println("2 2");
           return;
     }
     System.out.println("1 1");
    System.out.println("2 2");
    n-=2;
    row=2;
    index=1;
     //going down
     while(n>0){
         if(row==1){
             break;
         }
         else{
             if(n-index-1==0){
                 System.out.println((index+2)+" "+2);
                 return;
             }else if(n-index-1<0){
                 row=1;
             }
             else{
                 n=n-index-1;
                 index++;
                   System.out.println((index+1)+" "+2);
                 
             }
         }
     }
     index++;
        while(n>0){
         n--;
        System.out.println((index)+" "+1);
        index--;
        }
     
     
    }
    
    
}






