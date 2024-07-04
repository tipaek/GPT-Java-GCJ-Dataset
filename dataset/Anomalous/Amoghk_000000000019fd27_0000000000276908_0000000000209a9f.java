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

        boolean[] visited = new boolean[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
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
                        visited[j] = true;
                    }
                }

                if (till == 0 && i == str.length() - 1) {
                    for (int k = 0; k < n; k++) {
                        ss.append("(");
                    }
                    ss.append(n);
                    for (int k = 0; k < n; k++) {
                        ss.append(")");
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

        if (!visited[str.length() - 1]) {
            visited[str.length() - 1] = true;
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
                for (z = str.length() - 1; z >= 0; z--) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            String ss = ans(str);
            System.out.println("Case #" + (i + 1) + ": " + ss);
        }
    }
}