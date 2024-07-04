import java.util.Scanner;
import java.math.*;
public class Solution
{
	public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
         int T=s.nextInt();
         for(int i=1;i<=T;i++){
             String str=s.next();
         
	   NestingDepth(str,"",i);
	
         }
	}
	public static void NestingDepth(String str,String res,int a){
         str="0"+str+"0";
       for(int i=0;i<str.length()-1;i++){
           char ch=str.charAt(i);
           char ch1=str.charAt(i+1);
             int p=Character.getNumericValue(ch)-Character.getNumericValue(ch1);
             int val=Math.abs(p);
             if(p>0){
                 while(p>0){
                     res=res+")";
                     p--;
                 }
                 if(i<str.length()-2){
                 res=res+ch1;
                 }
             }
             else if(p<0){
                 while(p<0){
                     res=res+"(";
                     p++;
                 }
                 if(i<str.length()-2){
                 res=res+ch1;
                       }
             }
             else{
                if(i<str.length()-2){
                 res=res+ch;
                       }
                 continue;
             }
             
       }
 
 System.out.println("Case #"+a+": "+res);
 
	}	
}
