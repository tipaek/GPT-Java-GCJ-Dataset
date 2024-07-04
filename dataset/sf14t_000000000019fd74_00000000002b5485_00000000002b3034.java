import java.util.*;
import java.io.*;
public class Solution {
   public static void main(String args[]) {
       Scanner input=new Scanner(System.in);
       int test=input.nextInt();
       for(int t=1;t<=test;t++) {
           int n=input.nextInt();
           String[] str=new String[n];
           for(int i=0;i<n;i++) {
               str[i]=input.next();
           }
           boolean is_pos=true;
           for(int i=0;i<n;i++) {
               for(int j=0;j<n;j++) {
                   is_pos=true;
                   for(int k=0;k<str[i].length() && k<str[j].length();k++) {
                       if(str[i].charAt(k)=='*' || str[j].charAt(k)=='*') {
                           break;
                       }
                       if(str[i].charAt(k)!=str[j].charAt(k)) {
                           is_pos=false;
                           break;
                       }
                   }
                   if(!is_pos) {
                       break;
                   }
                   
                   for(int k1=str[i].length()-1,k2=str[j].length()-1;k1>=0 && k2>=0;k1--,k2--) {
                       if(str[i].charAt(k1)=='*' || str[j].charAt(k2)=='*') {
                           break;
                       }
                       if(str[i].charAt(k1)!=str[j].charAt(k2)) {
                           is_pos=false;
                           break;
                       }
                   }
                   if(!is_pos) {
                       break;
                   }
               }
               if(!is_pos) {
                   break;
               }
           }
           if(!is_pos) {
               System.out.println("Case #"+t+": "+"*");
           }
           else {
               int max_indx=0;
               for(int i=1;i<n;i++) {
                   if(str[i].length()>str[max_indx].length()) {
                       max_indx=i;
                   }
               }
               StringBuilder ans=new StringBuilder(str[max_indx]);
               for(int i=0;i<n;i++) {
                   if(ans.charAt(i)=='*') {
                       ans.deleteCharAt(i);
                       break;
                   }
               }
               System.out.println("Case #"+t+": "+ans);
           }
       }
   } 
}
