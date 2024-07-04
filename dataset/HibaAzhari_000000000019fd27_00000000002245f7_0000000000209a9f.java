import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String ignore = in.nextLine();
    
      for (int s = 1; s <= t; ++s) {
        
        String S = in.nextLine();
        
        System.out.println("Case #" + s + ": " + paren(S));
      
      }
    in.close();
    System.exit(0);
    }

    public static String paren(String S){
      
      int open = 0;
      
      String S1 = "";
      
      for(int i = 0; i < S.length(); i++){
        
        int n = Character.getNumericValue(S.charAt(i));
        
        if(open < n){
          for(;open < n; open++){
            S1 = S1 + "(";
          }
        }
        
        else if(open > n){ 
          for(; open > n; open--){
             S1 = S1 + ")";
          }
        }
        
        S1 = S1 + String.valueOf(n);
      
      }
      
      for(int i = 0; i < open; i++){
        S1 = S1 + ")";
      }

      return S1;

    }
}