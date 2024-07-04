import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte testCaseCount = scanner.nextByte();
        String[] testCases = new String[testCaseCount];

        for (byte i = 0; i < testCaseCount; i++) {
            testCases[i] = scanner.next();
        }

        for (byte i = 0; i < testCaseCount; i++) {
            StringBuilder result = new StringBuilder();
            char previousChar = '0';

            for (char currentChar : testCases[i].toCharArray()) {
                while (previousChar < currentChar) {
                    result.append("(");
                    previousChar++;
                }
                while (previousChar > currentChar) {
                    result.append(")");
                    previousChar--;
                }
                result.append(currentChar);
            }

            while (previousChar > '0') {
                result.append(")");
                previousChar--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}