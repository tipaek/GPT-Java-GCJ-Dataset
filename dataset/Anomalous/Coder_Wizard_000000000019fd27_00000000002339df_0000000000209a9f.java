import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int j = 0; j < testCases; ++j) {
            String inputString = scanner.next();
            int length = inputString.length();
            char[] inputChars = inputString.toCharArray();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < length; ++i) {
                char currentChar = inputChars[i];

                if (i == 0) {
                    if (currentChar == '0') {
                        output.append("0");
                    } else if (currentChar == '1') {
                        output.append("(1");
                    }
                } else {
                    char previousChar = inputChars[i - 1];
                    if (currentChar > previousChar) {
                        output.append("(").append(currentChar);
                    } else if (currentChar == previousChar) {
                        output.append(currentChar);
                    } else if (currentChar < previousChar) {
                        output.append(")").append(currentChar);
                    }
                }

                if (i == length - 1 && currentChar == '1') {
                    output.append(")");
                }
            }

            results[j] = output.toString();
        }

        for (int i = 0; i < testCases; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}