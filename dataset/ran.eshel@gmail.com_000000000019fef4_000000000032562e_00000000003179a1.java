import java.util.*;
import java.io.*;

public class Solution {

    private static int NUM_SAMPLES = 10000;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        int t = s.nextInt();

        for (int i = 1; i <= t; ++i) {
    
            int numDigits = s.nextInt();

            boolean[] exists = new boolean[26];
            boolean[] first = new boolean[26];

            int[] n = new int[NUM_SAMPLES];
            String[] str = new String[NUM_SAMPLES];

            int nSamples = 0;
            for (int k = 0; s.hasNext(); k++) {
                n[k] = s.nextInt();
                str[k] = s.next();
                nSamples++;

                int len = str[k].length();
                for (int m = 0; m < len; m++) {
                    char c = str[k].charAt(m);
                    int cn = c - 'A';
                    exists[cn] = true;
                    if (m == 0)
                        first[cn] = true;
                }
            }

            StringBuffer res = new StringBuffer("0123456789");
            for (int m = 0; m < 26; m++) {
                if (exists[m] && !first[m]) {
                    res.setCharAt(0, (char)(m + 'A'));
                    break;
                }
            }

            for (int k = 0; k < nSamples; k++) {
                if (n[k] == 1) {
                    char c1 = str[k].charAt(0);
                    res.setCharAt(1, c1);
                    break;
                }
            }

            for (int digit = 2; digit <= 9; digit++) {
                for (int k = 0; k < NUM_SAMPLES; k++) {
                    if (n[k] == digit) {
                        char c1 = str[k].charAt(0);
                        boolean found = false;
                        for (int m = 1; m < digit; m++) {
                            if (res.charAt(m) == c1) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            res.setCharAt(digit, c1);
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + res);
        }
    }
}

