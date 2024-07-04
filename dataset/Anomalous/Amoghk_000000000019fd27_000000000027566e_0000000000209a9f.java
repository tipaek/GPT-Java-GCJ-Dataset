import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static String ans(String str) {
        StringBuilder ss = new StringBuilder();
        if (str.length() == 1) {
            int n = str.charAt(0) - '0';
            for (int k = 0; k < n; k++) {
                ss.append("(");
            }
            ss.append(n);
            for (int k = 0; k < n; k++) {
                ss.append(")");
            }
            return ss.toString();
        }

        boolean[] v = new boolean[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (v[i]) {
                continue;
            } else {
                v[i] = true;
                int n = str.charAt(i) - '0';
                if (n == 0) {
                    ss.append(0);
                    continue;
                }
                int till = i;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) - '0' != n) {
                        till = j - 1;
                        break;
                    } else {
                        v[j] = true;
                    }
                }
                if (i == 0 || n > str.charAt(i - 1) - '0') {
                    for (int j = 0; j < n; j++) {
                        ss.append("(");
                    }
                }
                for (int j = 0; j <= till - i; j++) {
                    ss.append(n);
                }
                int next = str.charAt(till + 1) - '0';
                if (next < n) {
                    int diff = n - next;
                    for (int j = 0; j < diff; j++) {
                        ss.append(")");
                    }
                }
            }
        }

        if (!v[str.length() - 1]) {
            int n = str.charAt(str.length() - 1) - '0';
            if (n == 0) {
                ss.append(0);
            } else {
                if (n > str.charAt(str.length() - 2) - '0') {
                    for (int j = 0; j < n; j++) {
                        ss.append("(");
                    }
                }
                ss.append(n);
                for (int k = 0; k < n; k++) {
                    ss.append(")");
                }
            }
        }

        return ss.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            String str = s.next();
            String ss = ans(str);
            System.out.println("Case #" + (i + 1) + ": " + ss);
        }
    }
}