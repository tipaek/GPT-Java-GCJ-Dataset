import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner s =new Scanner(System.in);
        int x=s.nextInt();
        s.nextLine();
        for(int i=0;i<x;i++){
            String y=s.nextLine();
            System.out.println("Case #"+(i+1)+": "+answer(y));
        }
     }
     public static String answer(String input){
         String ans="";
         int number=0;
         String x="",y="";
         for(int i=0;i<input.length();i++){
             x=input.substring(i,i+1);
             if(i!=input.length()-1)
                y=input.substring(i+1,i+2);
             else
                y="0";
             int num1=Integer.parseInt(x);
             int num2=Integer.parseInt(y);
             int a=num1-number;
             int b=num1-num2;
             for(int j=0;j<a;j++){
                 ans+="(";
                 number++;
             }
             ans+=x;
             for(int j=0;j<b;j++){
                 ans+=")";
                 number--;
             }
         }
         return ans;
     }
         
}