import java.util.*;
import java.io.*;
import java.lang.Math; 


public class Solution {
    
     public static void solve(int x, int y,String s,int t)
     {
         int i=0;
         int p = Math.abs(x)+Math.abs(y);
         int time =0;
         
         while((time<p)&&(i<s.length())){
            time++;
            
            
             if (s.charAt(i)=='S'){
                 y=y-1;
             }
             else if (s.charAt(i)=='N'){
                 y=y+1;
             }
             else if (s.charAt(i)=='E'){
                 x=x+1;
             }
             else if(s.charAt(i)=='W'){
                 x=x-1;
             }
             
             p=Math.abs(x)+Math.abs(y);
             i++;
             
             
         }
         
         if (time<p){
             System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
         }
         else{
              System.out.println("Case #" + t + ": " + time);
         }
        
            
     }
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt(); 
            int y = in.nextInt();
            
            String s = in.next();
         
            solve(x,y,s,i);
        }
      }
}
