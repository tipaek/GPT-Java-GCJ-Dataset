import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
public static void main(String[] args){
   Scanner scan=new Scanner(System.in);
   int t=scan.nextInt();
   int i,j,k;
   
   for(k=0;k<t;k++){
       
       int count=0;
       
       String s=scan.nextLine();
       String st="0";
       st=st+s;
       int len=st.length();
       String str="";
       for(i=0;i<len;i++){
           int p=Integer.parseInt(st.charAt(i));
           int q=Integer.parseInt(st.charAt(i+1));
           if(p<q){
               count=q-p;
               for(j=0;j<count;j++){
                   str=str+'(';
               }
               str=str+st.charAt(i+1);
           }
           else if(q<p){
               count=p-q;
               for(j=0;j<count;j++){
                   str=str+')';
               }
               str=str+st.charAt(i+1);
           }
           else{
                str=str+st.charAt(i+1);
           }
           count=0;
       }
       
       System.out.println("Case #"+k+1+": "+str);
   }
   
    

}
}