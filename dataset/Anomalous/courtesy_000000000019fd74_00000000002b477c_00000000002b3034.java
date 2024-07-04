import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {
                strings[i] = scanner.next();
            }

            System.out.print("Case #" + cs + ": ");

            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            boolean conflict = false;

            for (String str : strings) {
                if (conflict) break;

                int j = 0;
                while (j < str.length() && str.charAt(j) != '*') {
                    if (prefix.length() > j && prefix.charAt(j) != str.charAt(j)) {
                        conflict = true;
                        break;
                    }
                    if (prefix.length() <= j) {
                        prefix.append(str.charAt(j));
                    }
                    j++;
                }
                if (conflict) break;

                int k = str.length() - 1;
                while (k >= 0 && str.charAt(k) != '*') {
                    int suffixIndex = suffix.length() - (str.length() - 1 - k);
                    if (suffixIndex >= 0 && suffix.charAt(suffixIndex) != str.charAt(k)) {
                        conflict = true;
                        break;
                    }
                    if (suffixIndex < 0) {
                        suffix.insert(0, str.charAt(k));
                    }
                    k--;
                }
            }

            if (conflict) {
                System.out.println("*");
                continue;
            }

            List<String> middleParts = new ArrayList<>();
            for (String str : strings) {
                String[] parts = str.split("\\*");
                for (int i = 1; i < parts.length - 1; i++) {
                    middleParts.add(parts[i]);
                }
            }

            StringBuilder result = new StringBuilder();
            result.append(prefix);
            for (String part : middleParts) {
                result.append(part);
            }
            result.append(suffix);

            System.out.println(result.toString());
        }
    }
}