import java.util.*;
import java.io.*;

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
                if (str.charAt(i) == '0') {
                    ss.append(0);
                    continue;
                }
                int n = str.charAt(i) - '0';
                int till = 0;

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
                    int diff = Math.abs(next - n);
                    for (int j = 0; j < diff; j++) {
                        ss.append(")");
                    }
                }
            }
        }
        if (!v[str.length() - 1]) {
            v[str.length() - 1] = true;
            if (str.charAt(str.length() - 1) == '0') {
                ss.append(0);
            } else {
                int n = str.charAt(str.length() - 1) - '0';
                if (n > str.charAt(str.length() - 2) - '0') {
                    for (int j = 0; j < n; j++) {
                        ss.append("(");
                    }
                }
                ss.append(n);
                int q = 0, z;
                for (z = str.length() - 1; z > -1; z--) {
                    if (str.charAt(z) - '0' > n) {
                        q = str.charAt(z) - '0';
                        break;
                    }
                }
                if (q == 0) {
                    for (int k = 0; k < n; k++) {
                        ss.append(")");
                    }
                } else {
                    for (int k = 0; k < n; k++) {
                        ss.append(")");
                    }
                    if (Math.abs(n - (str.charAt(z) - '0')) != n) {
                        for (int k = 0; k < Math.abs(n - (str.charAt(z) - '0')); k++) {
                            ss.append(")");
                        }
                    }
                }
            }
        }
        return ss.toString();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            String str = s.next();
            String ss = ans(str);
            System.out.println("Case #" + (i + 1) + ": " + ss);
        }
    }
}