import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        
        for (int i = 0; i < t; ++i) {
            String preInput = scan.next();
            int len = preInput.length();
            char[] input = preInput.toCharArray();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < len; ++j) {
                int digit = input[j] - '0';

                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }

                output.append(digit);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}