//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         int n = Integer.parseInt(f.readLine());
      
         String[] array = new String[n];
         for(int k = 0; k < n; k++){
            array[k] = f.readLine();
         }
         String start = "";
         StringJoiner mid = new StringJoiner("");
         String end = "";
         
         boolean fail = false;
         for(int k = 0; k < n; k++){
            //find first and last *
            int first = -1;
            int last = -1;
            for(int j = 0; j < array[k].length(); j++){
               if(array[k].charAt(j) == '*'){
                  first = j;
                  break;
               }
            }
            
            for(int j = array[k].length()-1; j >= 0; j--){
               if(array[k].charAt(j) == '*'){
                  last = j;
                  break;
               }
            }
            if(first > 0){
               String startsub = array[k].substring(0,first);
               if(equalstart(startsub,start)){
                  start = combine(startsub,start);
               } else {
                  fail = true;
               }
            }
            
            if(last < array[k].length()-1){
               String endsub = array[k].substring(last+1);
               if(equalend(endsub,end)){
                  end = combine(endsub,end);
               } else {
                  fail = true;
               }
            }
            
            if(fail) {
               break;
            }
            
            for(int j = first+1; j <= last-1; j++){
               if(array[k].charAt(j) != '*'){
                  mid.add("" + array[k].charAt(j));
               }
            }
         }
         
         if(fail){
            out.println("Case #" + q + ": *");
         } else {
            out.println("Case #" + q + ": " + start + mid.toString() + end);
         }
      }
      
      
      
      
      out.close();
   }
   
   public static boolean equalstart(String a, String b){
      
      for(int k = 0; k < Math.min(a.length(),b.length()); k++){
         if(a.charAt(k) != b.charAt(k)) 
            return false;
      }
      return true;
   }
   public static boolean equalend(String a, String b){
      int len = Math.min(a.length(),b.length());
      for(int k = 0; k < len; k++){
         if(a.charAt(a.length()-k-1) != b.charAt(b.length()-k-1)) 
            return false;
      }
      return true;
   }
   
   public static String combine(String a, String b){
      if(a.length() >= b.length()) 
         return a;
      return b;
   }
      
}