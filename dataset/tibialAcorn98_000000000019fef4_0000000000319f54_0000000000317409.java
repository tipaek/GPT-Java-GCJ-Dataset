import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int j=0; j<t; j++){
            
            int x= in.nextInt();
            int y= in.nextInt();
            
            char[] path=in.next().toCharArray();
            
            
            
            
            
            
            
            System.out.println("Case #"+(j+1)+": "+solve(x,y,path));
        }
        
    }
    
    public static String solve(int x, int y, char[] path) {
       String ans="IMPOSSIBLE";
       int time=0;
       int loc=0;
       boolean met=false;
       if(x==0&&y==0)
       return "0";
       for(char c: path){
         
           if(met){
               break;
           }
             time++;
           if(c=='N'){
               y++;
           }
            if(c=='E'){
                x++;
           }
            if(c=='S'){
                y--;
           }
            if(c=='W'){
               x--; 
           }
           loc=Math.abs(x)+Math.abs(y);
          
           if(loc<=time){
               met=true;
           }
          // System.out.println(x+"  "+y);
       }
       
       if(met){
               ans=""+time;
           }
       
       return ans;
    }
 }






