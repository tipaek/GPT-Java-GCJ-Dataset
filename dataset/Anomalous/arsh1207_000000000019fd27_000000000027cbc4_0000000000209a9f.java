import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());

            for (int t = 1; t <= testCases; t++) {
                String[] digits = br.readLine().split("");
                StringBuilder result = new StringBuilder();
                int openParens = 0;

                for (String digitStr : digits) {
                    int digit = Integer.parseInt(digitStr);
                    while (openParens < digit) {
                        result.append("(");
                        openParens++;
                    }
                    while (openParens > digit) {
                        result.append(")");
                        openParens--;
                    }
                    result.append(digit);
                }

                while (openParens > 0) {
                    result.append(")");
                    openParens--;
                }

                System.out.println("Case #" + t + ": " + result.toString());
            }

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}