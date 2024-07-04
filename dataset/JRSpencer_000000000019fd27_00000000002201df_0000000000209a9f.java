import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.next();
            String output = "";
            int prevInt = 0;
            int bracketCount = 0;
            for (int j = 0; j < S.length(); j++) {
                int num = Integer.parseInt(String.valueOf(S.charAt(j)));
                if (bracketCount == 0) {
                    for (int k = 0; k < num; k++) {
                        output += "(";
                        bracketCount++;
                    }
                    output += S.charAt(j);
                } else if (num >= prevInt) {
                    while (bracketCount < num) {
                        output += "(";
                        bracketCount++;
                    }
                    output += S.charAt(j);
                } else if (num <= prevInt) {
                    while (num < bracketCount) {
                        output += ")";
                        bracketCount--;
                    }
                    output += S.charAt(j);
                }
                if (j == S.length() - 1) {
                    for (int k = 0; k < bracketCount; k++) {
                        output += ")";
                    }
                }
                prevInt = num;
            }

            System.out.println(String.format("Case #%d: %s", i, output));
        }
    }
}
