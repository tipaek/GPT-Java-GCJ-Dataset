import java.util.*;
import java.io.*;
 
 public class Solution{
     public static void main(String args[])
     {
         Scanner sc=new Scanner(System.in);
         int testcase=sc.nextInt();
         int t=1;
         while(t<=testcase)
         { 
             String str= sc.next();
             String str1="";                 
             char prev='0';
             for(int i=0;i<str.length();i++)
             {   char num=str.charAt(i);
                 if(prev>num)
                 {
                     for(int j=0;j<prev-num-0;j++)
                      str1+=")";
                      
                 }
                 
                 else
                  for(int j=0;j<num-prev-0;j++)
                      str1+="(";
                      str1+=num;
                 prev=num;
             }
             for(int i=0;i<prev-'0';i++)
             str1+=")";
             
          System.out.println("Case  #"+t+": "+str1); 
          t++;
         }
     }
 }