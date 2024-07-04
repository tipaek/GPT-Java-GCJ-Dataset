import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(in));
        }
    }

    public static String solve(Scanner in) {
        int N = in.nextInt();
        String[] data = new String[N];
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();

        for (int i = 0; i < N; i++) {
            data[i] = in.next();
        }

        if (!processPrefix(data, prefix)) {
            return "*";
        }

        if (!processSuffix(data, suffix)) {
            return "*";
        }

        StringBuilder middle = new StringBuilder();
        for (String str : data) {
            middle.append(str.replace("*", ""));
        }

        return prefix.toString() + middle.toString() + suffix.toString();
    }

    private static boolean processPrefix(String[] data, StringBuilder prefix) {
        while (true) {
            Set<Character> chars = new HashSet<>();
            for (int i = 0; i < data.length; i++) {
                if (data[i].charAt(0) == '*') {
                    continue;
                }
                chars.add(data[i].charAt(0));
                data[i] = data[i].substring(1);
            }
            if (chars.isEmpty()) {
                break;
            }
            if (chars.size() == 1) {
                prefix.append(chars.iterator().next());
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean processSuffix(String[] data, StringBuilder suffix) {
        int dist = 1;
        while (true) {
            Set<Character> chars = new HashSet<>();
            for (int i = 0; i < data.length; i++) {
                if (data[i].length() - dist >= 0) {
                    char e = data[i].charAt(data[i].length() - dist);
                    if (e != '*') {
                        chars.add(e);
                    }
                }
            }
            if (chars.isEmpty()) {
                break;
            }
            if (chars.size() != 1) {
                return false;
            }
            suffix.insert(0, chars.iterator().next());
            dist++;
        }
        return true;
    }
}