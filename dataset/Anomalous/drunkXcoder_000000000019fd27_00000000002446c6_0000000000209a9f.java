import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
            String s = br.readLine();
            int index = findFirstNonZeroIndex(s);
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(c).append(" ");
            
            if (index != -1) {
                result.append(generateNestedString(s, index));
            } else {
                result.append(s); // if all are zeros
            }
            
            System.out.println(result);
        }
    }

    private static int findFirstNonZeroIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return i;
            }
        }
        return -1; // if all characters are zero
    }

    private static String generateNestedString(String s, int startIndex) {
        StringBuilder nestedString = new StringBuilder();
        int currentDepth = 0;
        int maxDepth = Character.getNumericValue(s.charAt(startIndex));
        
        for (int i = 0; i < maxDepth; i++) {
            nestedString.append('(');
        }
        nestedString.append(s.charAt(startIndex));
        currentDepth = maxDepth;
        
        for (int i = startIndex + 1; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num > currentDepth) {
                for (int j = 0; j < num - currentDepth; j++) {
                    nestedString.append('(');
                }
            } else if (num < currentDepth) {
                for (int j = 0; j < currentDepth - num; j++) {
                    nestedString.append(')');
                }
            }
            nestedString.append(s.charAt(i));
            currentDepth = num;
        }
        
        for (int i = 0; i < currentDepth; i++) {
            nestedString.append(')');
        }
        
        return nestedString.toString();
    }
}