import java.io.*;
import java.util.*;
 public class Solution{
     public static void main(String args[]){
         int prev=0;
         Scanner sc= new Scanner(System.in);
         int T = sc.nextInt();
         ArrayList<String> result = new ArrayList<String>();
         for(int k=0;k<T;k++){
            String s = sc.next();
            StringBuilder s1 = new StringBuilder();
            for(int i=0;i<s.length();i++){
                insert(prev - (s.charAt(i) - '0'),s1);
                s1.append(s.charAt(i));
                prev = (s.charAt(i) - '0');
            }
            for(int i=0;i<prev;i++){
                s1.append(")");
            }
            result.add(s1.toString());
            prev = 0;
         }
         for(int i=0;i<result.size();i++){
             System.out.println("Case #" + (i+1) + ": " + result.get(i));
         }
     }
     public static void insert(int val , StringBuilder s1){
         if(val<0){
             int d = val* -1;
             while(d!=0){
                 s1.append("(");
                 d--;
             }
         }
         else{
             while(val!=0){
                 s1.append(")");
                 val--;
             }
         }
    }
 }