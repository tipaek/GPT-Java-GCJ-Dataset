import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Solution {
    static Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        int T = readLine()[0];
        for (int i = 0; i < T; i++) {
            int N = readLine()[0];

            Asterisk[] as = new Asterisk[101];
            for (int j = 0; j < as.length; j++) {
                as[j] = new Asterisk();
            }

            for (int j = 0; j < N; j++) {
                String line = scanner.nextLine();

                int currAs = 0;
                int last = 0;
                for (int k = 0; k < line.length(); k++) {
                    char c = line.charAt(k);

                    if (c == '*') {
                        String s = line.substring(last, k);
                        as[currAs].add(s);
                        last = k + 1;
                        currAs++;
                    }
                }
                String s = line.substring(last, line.length());
                as[currAs].add(s);
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < as.length; j++) {
                String c = as[j].contained();
                if (c.equals("\\*")) {
                    sb.setLength(0);
                    sb.append('*');
                    break;
                } else {
                    sb.append(c);
                }
            }

            out.println("Case #" + (i + 1) + ": " + sb.toString());
        }

    }

    static int[] readLine() {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Asterisk {
    HashSet<String> after;

    Asterisk() {
        after = new HashSet<>();
    }

    void add(String line) {
        after.add(line);
    }

    String contained() {
        if (after.size() == 0) {
            return "";
        }
        String[] strs = after.toArray(new String[0]);
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        String largest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!largest.contains(strs[i])) {
                return "\\*";
            }
        }
        return largest;
    }
}