import java.io.*;
import java.util.*;

public class Solution {

    public static void nestingDepth(String[] s) {
        for (int a = 0; a < s.length; a++) {
            StringBuilder res = new StringBuilder();
            if (s[a].charAt(0) == '0') {
                res.append('0');
            } else {
                res.append("(1");
            }

            for (int i = 1; i < s[a].length() - 1; i++) {
                char prev = s[a].charAt(i - 1);
                char curr = s[a].charAt(i);
                char next = s[a].charAt(i + 1);

                if (prev == '0' && curr == '0' && next == '0') {
                    res.append('0');
                } else if (prev == '0' && curr == '0' && next == '1') {
                    res.append("0(");
                } else if (prev == '0' && curr == '1' && next == '0') {
                    res.append("1)");
                } else if (prev == '0' && curr == '1' && next == '1') {
                    res.append('1');
                } else if (prev == '1' && curr == '0' && next == '0') {
                    res.append(i == 1 ? ")0" : "0");
                } else if (prev == '1' && curr == '0' && next == '1') {
                    res.append(i == 1 ? ")0(" : "0(");
                } else if (prev == '1' && curr == '1' && next == '0') {
                    res.append("1)");
                } else if (prev == '1' && curr == '1' && next == '1') {
                    res.append('1');
                }
            }

            if (s[a].charAt(s[a].length() - 1) == '0') {
                res.append('0');
            } else {
                res.append(s[a].length() == 1 ? ")" : "1)");
            }

            System.out.println("Case #" + (a + 1) + ": " + res.toString());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] sArr = new String[q];
        for (int qItr = 0; qItr < q; qItr++) {
            sArr[qItr] = scanner.nextLine();
        }

        nestingDepth(sArr);
        scanner.close();
    }
}