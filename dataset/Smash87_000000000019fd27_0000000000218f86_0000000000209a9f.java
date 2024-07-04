
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String result = "";
            String s = in.nextLine();

            int p = 0;
            int[] L = new int[2];
            int a = 0;
            for (int m = 0; m < s.length(); m++) {


                L[1] = Integer.valueOf(s.charAt(m) + "");
                p = L[1] - L[0];
                a = a + p;

                if (p > 0) {
                    for (int t0 = 0; t0 < p; t0++) {
                        result += "(";
                    }
                } else {
                    for (int t0 = 0; t0 > p; t0--) {
                        result += ")";
                    }
                }
                L[0] = L[1];
                result += "" + L[1]; // repetir la cantidad de veces
                while (m < s.length() - 1 && s.charAt(m + 1) == L[1]) {
                    result += "" + L[1];
                    m++;
                }
            }
            if (a > 0) {
                for (int t0 = 0; t0 < a; t0++) {
                    result += ")";
                }
            } else {
                for (int t0 = 0; t0 > a; t0--) {
                    result += "(";
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}