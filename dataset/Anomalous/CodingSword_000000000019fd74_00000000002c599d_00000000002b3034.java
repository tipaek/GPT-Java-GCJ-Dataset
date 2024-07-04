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

            String beginning = findBeginning(charArrays, parts);
            if (beginning == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String ending = findEnding(charArrays, parts);
            if (ending == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String result = mergeParts(beginning, ending, parts);

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String findBeginning(char[][] charArrays, String[][] parts) {
        String longestBeginning = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][0] == '*') continue;

            String currentPart = parts[i][0];

            if (longestBeginning.isEmpty() || currentPart.startsWith(longestBeginning) || longestBeginning.startsWith(currentPart)) {
                if (currentPart.length() > longestBeginning.length()) {
                    longestBeginning = currentPart;
                }
            } else {
                return null;
            }
        }

        return longestBeginning;
    }

    private static String findEnding(char[][] charArrays, String[][] parts) {
        String longestEnding = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][charArrays[i].length - 1] == '*') continue;

            String currentPart = parts[i][parts[i].length - 1];

            if (longestEnding.isEmpty() || currentPart.endsWith(longestEnding) || longestEnding.endsWith(currentPart)) {
                if (currentPart.length() > longestEnding.length()) {
                    longestEnding = currentPart;
                }
            } else {
                return null;
            }
        }

        return longestEnding;
    }

    private static String mergeParts(String beginning, String ending, String[][] parts) {
        StringBuilder result = new StringBuilder(beginning);

        for (int i = 0; i < n; i++) {
            int startIndex = 0;
            int lastPartIndex = parts[i][parts[i].length - 1].isEmpty() ? parts[i].length - 1 : parts[i].length;

            for (int j = 0; j < lastPartIndex; j++) {
                int index = result.indexOf(parts[i][j], startIndex);
                if (index < 0) {
                    result.append(parts[i][j]);
                    startIndex = result.length();
                } else {
                    startIndex = index + parts[i][j].length();
                }
            }
        }

        if (!result.toString().endsWith(ending)) {
            result.append(ending);
        }

        if (result.length() == 0) {
            result.append("A");
        }

        return result.toString();
    }
}