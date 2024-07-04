import java.util.*;
import java.io.*;
import java.lang.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;       
        
       while(x<=test){
            String ans="";
            int gtr=0;
            Scanner sce=new Scanner(System.in); 
           String s=sc.nextLine();
           for(int i=0;i<s.length();i++){
               
               int ch=Integer.valueOf(s.charAt(i))-48;
               
               int diff=ch-gtr;
               if(diff>0){
                   while(diff-->0){
                       ans+="(";
                   }
               }
               else if(diff<0){
                   while(diff++<0){
                       ans+=")";
                   }
               }
               
               ans+=s.charAt(i);
               gtr=ch;
               if(i==s.length()-1){
                while(ch-->0){
                ans+=")";}
            }
           }
           System.out.println("Case #"+x+": "+ans);
           x++;
       }
    }
}