import java.util.*;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();  
    
    for (int i = 1; i <= cases; ++i) {
        
        String init = in.next();
        String res = "";
        int depth = 0;
    
        for(int j = 0; j < init.length(); j++){
            
            int current = Integer.parseInt(init.substring(j, j + 1));
            
            while(depth < current){
                res += '(';
                depth++;
            }
            
            while(depth > current){
                res += ')';
                depth--;
            }
            
            res += current;
            
        }
        
        while(depth > 0){
            res += ')';
            depth--;
        }
        
        System.out.println("Case #" + i + ": " + res);
        
    }
    
  }
  
}