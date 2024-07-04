import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            String S = br.readLine().trim();
            StringBuilder result = new StringBuilder();
            boolean isOneSequence = false;
            
            for (char ch : S.toCharArray()) {
                if (ch == '1') {
                    if (!isOneSequence) {
                        result.append('(');
                        isOneSequence = true;
                    }
                    result.append('1');
                } else {
                    if (isOneSequence) {
                        result.append(')');
                        isOneSequence = false;
                    }
                    result.append('0');
                }
            }
            
            if (isOneSequence) {
                result.append(')');
            }
            
            pw.println("Case #" + i + ": " + result.toString());
        }
        
        pw.flush();
    }
}