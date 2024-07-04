import java.util.*;
     
     public class Solution {
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int t=scn.nextInt();
         for(int i=1;i<=t;i++){
             String s=scn.next();
             StringBuilder str=new StringBuilder();
             char ch=s.charAt(0);
             int a1=(ch-'0');
             startbracket(str,a1);
             str.append(ch);
             int count=a1;
             for(int j=1;j<s.length();j++){
                 int x=s.charAt(j)-s.charAt(j-1);
                 if(x>0){
                     startbracket(str,x);
                     count+=x;
                 }
                 else{
                     closebracket(str,x);
                     count+=x;
                 }
                 str.append(s.charAt(j));
                 
             }
             closebracket(str,-1*count);
             System.out.println("Case #"+i+":"+str);
         }
         
        
      }
      public static void startbracket(StringBuilder s,int a){
          if(a>0){
              for(int i=0;i<a;i++){
                  s.append('(');
              }
          }
      }
      public static void closebracket(StringBuilder s,int a){
          a*=-1;
          for(int i=0;i<a;i++){
              s.append(')');
          }
      }
     }