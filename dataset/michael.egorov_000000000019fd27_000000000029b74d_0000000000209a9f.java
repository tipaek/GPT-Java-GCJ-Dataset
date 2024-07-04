import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k <= t; k++) {
            pw.println("Case #" + k + ": " + solveDigit(br.readLine(), 0));
        }
        pw.flush();
    }

    private static String solveDigit(String s, int digit) {
        if (digit > 9) {
            return s;
        }
        String digitString = digit + "";
        if (s.length() > 0 && s.startsWith(digitString)) {
            return digitString + solveDigit(s.substring(1), digit);
        }
        if (s.length() > 0 && s.endsWith(digitString)) {
            return solveDigit(s.substring(0, s.length() - 1), digit) + digitString;
        }
        int indexOfDigit = s.indexOf(digitString);
        if (indexOfDigit > 0) {
            return solveDigit(s.substring(0, indexOfDigit), digit) + solveDigit(s.substring(indexOfDigit), digit);
        }
        if (s.length() > 0) {
            return "(" + solveDigit(s, digit + 1) + ")";
        }
        return "";
    }

}
