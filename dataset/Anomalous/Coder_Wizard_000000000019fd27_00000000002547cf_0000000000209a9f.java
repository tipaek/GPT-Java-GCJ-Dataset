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

            for (int j = 0; j < len; ++j) {
                int currentDigit = Character.getNumericValue(input[j]);

                if (j == 0) {
                    for (int k = 0; k < currentDigit; ++k) {
                        output.append("(");
                    }
                } else {
                    int previousDigit = Character.getNumericValue(input[j - 1]);
                    if (currentDigit > previousDigit) {
                        for (int k = 0; k < currentDigit - previousDigit; ++k) {
                            output.append("(");
                        }
                    } else if (currentDigit < previousDigit) {
                        for (int k = 0; k < previousDigit - currentDigit; ++k) {
                            output.append(")");
                        }
                    }
                }

                output.append(currentDigit);

                if (j == len - 1) {
                    for (int k = 0; k < currentDigit; ++k) {
                        output.append(")");
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}