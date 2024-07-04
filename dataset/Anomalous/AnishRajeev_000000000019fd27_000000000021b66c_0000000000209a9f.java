import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++) {
            String s = scanner.next();
            int[] nums = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (int i = 0; i < nums.length; i++) {
                while (openBrackets < nums[i]) {
                    result.append("(");
                    openBrackets++;
                }
                while (openBrackets > nums[i]) {
                    result.append(")");
                    openBrackets--;
                }
                result.append(nums[i]);
            }
            
            while (openBrackets > 0) {
                result.append(")");
                openBrackets--;
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}