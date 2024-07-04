import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
            String s = br.readLine();
            int firstNonZeroIndex = -1;
            
            // Find the first non-zero character index
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    firstNonZeroIndex = i;
                    break;
                }
            }

            if (firstNonZeroIndex == -1) {
                // If the string contains only zeros
                System.out.println("Case #" + c + ": " + s);
                continue;
            }

            StringBuilder result = new StringBuilder();
            StringBuilder test = new StringBuilder();
            int currentDepth = 0;

            // Append leading zeros
            for (int i = 0; i < firstNonZeroIndex; i++) {
                result.append('0');
            }

            // Process the string from the first non-zero character
            for (int i = firstNonZeroIndex; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                
                if (num > currentDepth) {
                    for (int j = 0; j < num - currentDepth; j++) {
                        test.append('(');
                    }
                } else if (num < currentDepth) {
                    for (int j = 0; j < currentDepth - num; j++) {
                        test.append(')');
                    }
                }
                
                test.append(num);
                currentDepth = num;
            }

            // Close any remaining open parentheses
            for (int i = 0; i < currentDepth; i++) {
                test.append(')');
            }

            result.append(test);
            System.out.println("Case #" + c + ": " + result.toString());
        }
    }
}