import java.io.*;
import java.util.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      int t = Integer.parseInt(sc.nextLine());
      for(int i = 1; i <= t; i++){
         String n = sc.nextLine();
         String ans = "";
         for(int j = 0; j < n.length(); j++){
            if(n.charAt(j) == '0'){
               ans += ")0(";
            }
            else{
               ans += n.charAt(j);
            }
         }
         ans = "(" + ans + ")";
         String fin = "";
         int j = 0;
         while(j < ans.length()){
            if(ans.charAt(j) == '(' && ans.charAt(j+1) == ')'){
               j += 2;
            }
            else{
               fin += ans.charAt(j);
               j++;
            }
         }
         System.out.println("Case #" + i + ": " + fin);
      }
   }
}