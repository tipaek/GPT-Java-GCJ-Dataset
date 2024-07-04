import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
public static void main(String[] args){
   Scanner scan=new Scanner(System.in);
   int t=scan.nextInt();
   int k;
  //  scan.next();
   for(k=0;k<=t;k++){
       int i,j;
       int count=0;
       
       String s=scan.next();
       String st="";
       st=st+"0";
       st=st+s;
       int len=st.length();
       String str="cccc";
       int m=0;
       for(i=0;i<len-1;i++){
           int p=(st.charAt(i));
           int q=(st.charAt(i+1));
           if(p<q){
               count=q-p;
               m=m+count;
               for(j=0;j<count;j++){
                   str=str+"(";
               }
               str=str+st.charAt(i+1);
           }
           else if(q<p){
               count=p-q;
               m=m-count;
               for(j=0;j<count;j++){
                   str=str+")";
               }
               str=str+st.charAt(i+1);
           }
           else{
                str=str+st.charAt(i+1);
           }
           
       }
       for(i=0;i<m;i++){
           str=str+")";
       }
       int z=k+1;
       System.out.print("Case #"+z+": "+str);
   }
   
	    

}
}