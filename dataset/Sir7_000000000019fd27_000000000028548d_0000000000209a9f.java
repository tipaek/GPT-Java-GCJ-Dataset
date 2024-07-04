import java.util.*;
import java.io.*;
import java.lang.*;
class solution{
    public static void main(String[]args){
         Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;       
        
       while(x<=test){
            String ans="";
            int gtr=0;
            Scanner sce=new Scanner(System.in); 
           String s=sce.nextLine();
           for(int i=0;i<s.length();i++){
               
               int ch=Integer.valueOf(s.charAt(i)-48);
               
               int diff=ch-gtr;
               if(diff>0){
                   for(int y=0;y<diff;y++){
                       ans+="(";
                   }
               }
               else if(diff<0){
                   for(int y=0;y<Math.abs(diff);y++){
                       ans+=")";
                   }
               }
               
               ans+=s.charAt(i);
               gtr=ch;
               if(i==s.length()-1){
                for(int y=0;y<ch;y++)
                ans+=")";
            }
           }
           System.out.println("Case #"+x+": "+ans);
           x++;
       }
    }
}