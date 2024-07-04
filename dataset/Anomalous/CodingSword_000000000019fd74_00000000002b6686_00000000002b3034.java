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
            char[][] charArrays = new char[n][];

            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
                parts[i] = words[i].split("\\*");
                charArrays[i] = words[i].toCharArray();
            }

            String prefix = findPrefix(charArrays, parts);
            if (prefix == null) {
                System.out.println("*");
                continue;
            }

            String suffix = findSuffix(charArrays, parts);
            if (suffix == null) {
                System.out.println("*");
                continue;
            }

            int prefixLength = prefix.length();

            for (int i = 0; i < n; i++) {
                int start = charArrays[i][0] == '*' ? 0 : 1;
                int last = charArrays[i][charArrays[i].length - 1] == '*' ? parts[i].length : parts[i].length - 1;

                int startIndex = prefixLength;
                for (int j = start; j < last; j++) {
                    int index = prefix.indexOf(parts[i][j], startIndex);
                    if (index < 0) {
                        prefix += parts[i][j];
                        startIndex = prefix.length();
                    } else {
                        startIndex = index + parts[i][j].length();
                    }
                }
            }

            if (!prefix.equals(suffix)) {
                prefix += suffix;
            }
            System.out.println(prefix);
        }

        scanner.close();
    }

    public static String findPrefix(char[][] charArrays, String[][] parts) {
        String result = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][0] == '*') {
                continue;
            }

            String temp = parts[i][0];

            if (result.contains(temp) || temp.contains(result)) {
                if (temp.length() > result.length()) {
                    result = temp;
                }
            } else {
                return null;
            }
        }

        return result;
    }

    public static String findSuffix(char[][] charArrays, String[][] parts) {
        String result = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][charArrays[i].length - 1] == '*') {
                continue;
            }

            String temp = parts[i][parts[i].length - 1];

            if (result.contains(temp) || temp.contains(result)) {
                if (temp.length() > result.length()) {
                    result = temp;
                }
            } else {
                return null;
            }
        }

        return result;
    }
}