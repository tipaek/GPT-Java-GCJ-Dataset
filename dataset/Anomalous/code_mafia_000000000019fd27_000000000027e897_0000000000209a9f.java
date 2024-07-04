import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            char[] input = br.readLine().toCharArray();
            StringBuilder result = new StringBuilder();

            if (input[0] == '1') {
                result.append("(1");
            } else {
                result.append('0');
            }

            for (int i = 1; i < input.length; i++) {
                if (input[i] == '1' && input[i - 1] == '1') {
                    result.append('1');
                } else if (input[i] == '1' && input[i - 1] == '0') {
                    result.append("(1");
                } else if (input[i] == '0' && input[i - 1] == '1') {
                    result.append(")0");
                } else {
                    result.append('0');
                }
            }

            if (input[input.length - 1] == '1') {
                result.append(')');
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}