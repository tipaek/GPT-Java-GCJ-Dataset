import java.util.*;
import java.io.*;

public class Solution {

    static String ans(String str) {
        StringBuilder ss = new StringBuilder();
        if (str.length() == 1) {
            int n = str.charAt(0) - '0';
            ss.append("(".repeat(n));
            ss.append(n);
            ss.append(")".repeat(n));
            return ss.toString();
        }

        boolean[] visited = new boolean[str.length()];
        for (int i = 0; i < str.length() - 1; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int currentDigit = str.charAt(i) - '0';
            if (currentDigit == 0) {
                ss.append(0);
                continue;
            }

            int till = 0, h;
            for (h = i + 1; h < str.length(); h++) {
                if (str.charAt(h) - '0' != currentDigit) {
                    till = h - 1;
                    break;
                }
                visited[h] = true;
            }

            if (till == 0 && h == str.length()) {
                ss.append("(".repeat(currentDigit));
                ss.append(currentDigit);
                ss.append(")".repeat(currentDigit));
                return ss.toString();
            }

            if (i == 0 || currentDigit > str.charAt(i - 1) - '0') {
                ss.append("(".repeat(currentDigit));
            }

            ss.append(String.valueOf(currentDigit).repeat(till - i + 1));

            int nextDigit = str.charAt(till + 1) - '0';
            if (nextDigit < currentDigit) {
                ss.append(")".repeat(currentDigit - nextDigit));
            }
        }

        if (!visited[str.length() - 1]) {
            visited[str.length() - 1] = true;
            int lastDigit = str.charAt(str.length() - 1) - '0';
            if (lastDigit == 0) {
                ss.append(0);
            } else {
                if (lastDigit > str.charAt(str.length() - 2) - '0') {
                    ss.append("(".repeat(lastDigit));
                }
                ss.append(lastDigit);
                int q = 0, z;
                for (z = str.length() - 1; z > -1; z--) {
                    if (str.charAt(z) - '0' > lastDigit) {
                        q = str.charAt(z) - '0';
                        break;
                    }
                }
                if (q == 0) {
                    ss.append(")".repeat(lastDigit));
                } else {
                    ss.append(")".repeat(lastDigit));
                    if (Math.abs(lastDigit - (str.charAt(z) - '0')) != lastDigit) {
                        ss.append(")".repeat(Math.abs(lastDigit - (str.charAt(z) - '0'))));
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
            String result = ans(str);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}