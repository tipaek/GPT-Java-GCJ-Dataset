import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            n = scanner.nextInt();
            scanner.nextLine();

            String[] words = new String[n];
            String[][] parts = new String[n][];
            char[][] rays = new char[n][];

            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
                parts[i] = words[i].split("\\*");
                rays[i] = words[i].toCharArray();
            }

            String prefix = findPrefix(rays, parts);
            if (prefix == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String suffix = findSuffix(rays, parts);
            if (suffix == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            StringBuilder result = new StringBuilder(prefix);

            for (int i = 0; i < n; i++) {
                int start = rays[i][0] == '*' ? 0 : 1;
                int end = rays[i][rays[i].length - 1] == '*' ? parts[i].length : parts[i].length - 1;

                int startIndex = result.length();
                for (int j = start; j < end; j++) {
                    int index = result.indexOf(parts[i][j], startIndex);
                    if (index < 0) {
                        result.append(parts[i][j]);
                        startIndex = result.length();
                    } else {
                        startIndex = index + parts[i][j].length();
                    }
                }
            }

            if (!result.toString().equals(suffix))
                result.append(suffix);

            if (result.length() == 0)
                result.append("A");

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    public static String findPrefix(char[][] rays, String[][] parts) {
        String prefix = "";

        for (int i = 0; i < n; i++) {
            if (rays[i][0] == '*')
                continue;

            String temp = parts[i][0];

            if (prefix.startsWith(temp) || temp.startsWith(prefix) || prefix.isEmpty()) {
                if (temp.length() > prefix.length())
                    prefix = temp;
            } else {
                return null;
            }
        }

        return prefix;
    }

    public static String findSuffix(char[][] rays, String[][] parts) {
        String suffix = "";

        for (int i = 0; i < n; i++) {
            if (rays[i][rays[i].length - 1] == '*')
                continue;

            String temp = parts[i][parts[i].length - 1];

            int overlap = Math.max(suffix.indexOf(temp), temp.indexOf(suffix));
            if (suffix.isEmpty() || (overlap >= 0 && (overlap == suffix.length() - temp.length() || overlap == temp.length() - suffix.length()))) {
                if (temp.length() > suffix.length())
                    suffix = temp;
            } else {
                return null;
            }
        }

        return suffix;
    }
}