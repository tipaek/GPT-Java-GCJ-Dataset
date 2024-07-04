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
               int lft_max=-1,lft_max_indx=-1,right_max=-1,right_max_indx=-1;
               for(int i=0;i<n;i++) {
                   int tmp=0;
                   for(int j=0;j<str[i].length();j++) {
                       if(str[i].charAt(j)=='*') {
                           break;
                       }
                       tmp++;
                   }
                   if(tmp>lft_max) {
                       lft_max=tmp;
                       lft_max_indx=i;
                   }
                   
                   tmp=0;
                   for(int j=str[i].length()-1;j>=0;j--) {
                       if(str[i].charAt(j)=='*') {
                           break;
                       }
                       tmp++;
                   }
                   if(tmp>right_max) {
                       right_max=tmp;
                       right_max_indx=i;
                   }
               }
               StringBuilder ans=new StringBuilder("");
               for(int j=0;j<str[lft_max_indx].length();j++) {
                   if(str[lft_max_indx].charAt(j)=='*') {
                       break;
                   }
                   ans.append(str[lft_max_indx].charAt(j));
               }
               boolean strt=false;
               for(int j=0;j<str[right_max_indx].length();j++) {
                   if(strt) {
                       ans.append(str[right_max_indx].charAt(j));
                   }
                   if(str[right_max_indx].charAt(j)=='*') {
                       strt=true;
                   }
               }
               System.out.println("Case #"+t+": "+ans);
           }
       }
   } 
}
