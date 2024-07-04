import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        byte t = in.nextByte();
        String s;
        StringBuilder answer;
        int currentDigit, lastDigit = 0;
        for (byte i = 1; i <= t; ++i) {
            s = in.next();
            answer = new StringBuilder();
            for (byte j = 0; j < s.length(); j++) {
                currentDigit = Integer.parseInt(s.substring(j, j+1));
                answer.append(getP(Math.abs(currentDigit - lastDigit), currentDigit - lastDigit > 0));
                answer.append(currentDigit);
                lastDigit = currentDigit;
                if (j == s.length() - 1) {
                    answer.append(getP(currentDigit, false));
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static String getP(int n, boolean openP) {
        if (n == 0) return "";
        String p = openP ? "(" : ")";
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            answer.append(p);
            n--;
        }
        return answer.toString();
    }
}
    