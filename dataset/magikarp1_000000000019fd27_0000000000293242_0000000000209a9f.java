import java.util.*;
import java.io.*;
public class Solution{
   public static void main(String[] main) throws Exception{
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for(int trial = 1; trial <= t; trial++){
         String st = s.next();
         String newst = "";
         for(int i = 0; i < st.length(); i++){
            if(i == 0){
               for(int j = 0; j < st.charAt(i) - 48; j++)
                  newst += "(";
               newst += st.substring(0,1);
            }
            else{
               int diff = st.charAt(i) - st.charAt(i-1);
               if(diff > 0){
                  for(int j = 0; j < diff; j++)
                     newst += "(";
               }
               else if(diff < 0){
                  for(int j = 0; j < -diff; j++)
                     newst += ")";
               }
               newst += st.substring(i,i+1);
            }
            if(i == st.length() - 1){
               for(int j = 0; j < st.charAt(i) - 48; j++)
                  newst += ")";
            }
         }
         System.out.println("Case #" + trial + ": " + newst);
      }
   }
}