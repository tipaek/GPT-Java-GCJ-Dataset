import java.util.*;
import java.io.*;

/*
Andres Arrieche
SDE @ AWS
https://www.linkedin.com/in/andresarrieche/
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int test = 1; test <= testCount; test++) {
            String s = in.next();
            System.out.printf("Case #%d: %s\n", test, balanceParentheses(s));
        }
    }

    private static String balanceParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int previousOpening = 0;
        for (char c: s.toCharArray()) {
            int d = (int)c - (int)'0';

            while (previousOpening < d) {
                previousOpening++;
                sb.append("(");
            }

            while (previousOpening > d) {
                previousOpening--;
                sb.append(")");
            }
            sb.append(d);
        }

        while (previousOpening > 0) {
            previousOpening--;
            sb.append(")");
        }

        return sb.toString();
    }
}