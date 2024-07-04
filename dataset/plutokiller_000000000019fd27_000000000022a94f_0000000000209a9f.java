import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String s = in.nextLine();
    for (int t = 1; t <= T; ++t) {
        String N = in.nextLine();
        
        // beginning of the answer
        StringBuilder sb = new StringBuilder();
        
        int cInt = Character.getNumericValue(N.charAt(0));
        
        for(int i = 0; i < cInt; i++) {
            
            sb.append('(');
            
        }
        
        sb.append(Integer.toString(cInt));
        
        // now look at next parentheses
        for(int i = 1; i < N.length(); i++) {
            int nextInt = Character.getNumericValue(N.charAt(i));
            
            
            //insert stuff here
            if(cInt > nextInt) {
                
                for(int j = 0; j < cInt - nextInt; j++) {
                    
                    sb.append(')');
                    
                }
                
            }
            else if(cInt < nextInt) {
                
                for(int j = 0; j < nextInt - cInt; j++) {
                    
                    sb.append('(');
                    
                }
                
                
            }
            sb.append(Integer.toString(nextInt));
            cInt = nextInt;
            
        }
        
        //sb.append(Integer.toString(cInt));
        
        for(int i = 0; i < cInt; i++) {
            
            sb.append(')');
            
        }
        
        System.out.println("Case #" + t + ": " + sb.toString());
    }
  }
}