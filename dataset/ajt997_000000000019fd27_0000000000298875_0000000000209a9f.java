import java.util.*;
import java.io.*;

public class Solution {
    
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(f.readLine());
    for(int i = 0; i < T; i++) {
        int depth = 0;
        String s = f.readLine();
        StringBuilder ans = new StringBuilder();
        
        for(int j = 0; j < s.length(); j++) {
            int curr = s.charAt(j) - '0';
            while(depth < curr) {
                ans.append("(");
                depth++;
            }
            
            while(depth > curr) {
                ans.append(")");
                depth--;
            }
            
            ans.append(s.charAt(j));
        }
        
        
        while(depth > 0) {
            ans.append(")");
            depth--;
        }
        
        System.out.println("Case #" + (i + 1) + ": " + ans);
    }
  }
}