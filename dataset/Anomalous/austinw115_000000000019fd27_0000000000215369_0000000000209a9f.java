import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            String S = br.readLine().trim();
            StringBuilder result = new StringBuilder();
            boolean isOpen = false;
            
            for (int j = 0; j < S.length(); j++) {
                char currentChar = S.charAt(j);
                
                if (currentChar == '1') {
                    if (!isOpen) {
                        result.append('(');
                        isOpen = true;
                    }
                    result.append('1');
                } else {
                    if (isOpen) {
                        result.append(')');
                        isOpen = false;
                    }
                    result.append('0');
                }
            }
            
            if (isOpen) {
                result.append(')');
            }
            
            pw.println("Case #" + i + ": " + result.toString());
        }
        
        pw.flush();
        pw.close();
    }
}