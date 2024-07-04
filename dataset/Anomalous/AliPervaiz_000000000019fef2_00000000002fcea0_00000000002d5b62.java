import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(reader.readLine());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            writer.print("Case #" + caseNumber + ": ");
            
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            
            if ((x + y) % 2 == 0) {
                writer.println("IMPOSSIBLE");
            } else {
                int sum = Math.abs(x) + Math.abs(y);
                int bits = 0;
                while ((1 << bits) < sum) {
                    bits++;
                }
                
                int total = (1 << bits) - 1;
                int difference = total - (x + y);
                difference >>= 1;
                
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < bits; i++) {
                    int value = 1 << i;
                    if ((difference & value) != 0) {
                        value *= -1;
                    }
                    value /= Math.abs(value);
                    
                    if (x % 2 != 0) {
                        if (value < 0) {
                            result.append("W");
                        } else {
                            result.append("E");
                        }
                        x -= value;
                    } else {
                        if (value < 0) {
                            result.append("S");
                        } else {
                            result.append("N");
                        }
                        y -= value;
                    }
                    
                    x /= 2;
                    y /= 2;
                }
                writer.println(result.toString());
            }
        }
        
        writer.flush();
        writer.close();
    }
}