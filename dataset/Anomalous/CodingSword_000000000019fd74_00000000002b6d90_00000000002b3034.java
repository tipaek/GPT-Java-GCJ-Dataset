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
            char[][] characters = new char[n][];

            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
                parts[i] = words[i].split("\\*");
                characters[i] = words[i].toCharArray();
            }

            String result = findPrefix(characters, parts);
            if (result == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String suffix = findSuffix(characters, parts);
            if (suffix == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            int prefixLength = result.length();

            for (int i = 0; i < n; i++) {
                int start = characters[i][0] == '*' ? 0 : 1;
                int end = characters[i][characters[i].length - 1] == '*' ? parts[i].length : parts[i].length - 1;

                int currentIndex = prefixLength;
                for (int j = start; j < end; j++) {
                    int index = result.indexOf(parts[i][j], currentIndex);
                    if (index < 0) {
                        result += parts[i][j];
                        currentIndex = result.length();
                    } else {
                        currentIndex = index + parts[i][j].length();
                    }
                }
            }

            if (!result.equals(suffix)) {
                result += suffix;
            }

            if (result.isEmpty()) {
                result += "A";
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    public static String findPrefix(char[][] characters, String[][] parts) {
        String prefix = "";

        for (int i = 0; i < n; i++) {
            if (characters[i][0] == '*') {
                continue;
            }

            String current = parts[i][0];

            if (prefix.contains(current) || current.contains(prefix)) {
                if (current.length() > prefix.length()) {
                    prefix = current;
                }
            } else {
                return null;
            }
        }

        return prefix;
    }

    public static String findSuffix(char[][] characters, String[][] parts) {
        String suffix = "";

        for (int i = 0; i < n; i++) {
            if (characters[i][characters[i].length - 1] == '*') {
                continue;
            }

            String current = parts[i][parts[i].length - 1];

            if (suffix.contains(current) || current.contains(suffix)) {
                if (current.length() > suffix.length()) {
                    suffix = current;
                }
            } else {
                return null;
            }
        }

        return suffix;
    }
}