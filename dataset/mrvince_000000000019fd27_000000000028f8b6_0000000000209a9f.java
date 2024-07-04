import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int x = 1; x <= testCases; x++) {
            String answer = "Case #" + x + ": ";
            String builder = "";
            
            String s = in.next();
            
            int depth = 0;
            for (int i = 0; i < s.length(); i++) {
            	int val = Integer.parseInt(s.charAt(i) + "");
            	
            	if (val > depth) {
            		for (int j = 0; j < val - depth; j++) {
            			builder = builder + "(";
            		}
            	} else if (val < depth) {
            		for (int j = 0; j < depth - val; j++) {
            			builder = builder + ")";
            		}
            	}
            	
            	builder = builder + Integer.toString(val);
            	depth = val;
            }
            
            while (depth > 0) {
            	builder = builder + ")";
            	depth--;
            }
            
            System.out.println(answer + builder);
        }
        
        in.close();
    }
}