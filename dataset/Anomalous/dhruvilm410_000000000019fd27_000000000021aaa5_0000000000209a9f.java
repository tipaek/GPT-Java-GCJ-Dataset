package codejam;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            char[] ca = s.toCharArray();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;

            for (char c : ca) {
                int digit = c - '0';
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(c);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            out.println("#" + i + ": " + result);
        }

        out.flush();
        out.close();
    }
}