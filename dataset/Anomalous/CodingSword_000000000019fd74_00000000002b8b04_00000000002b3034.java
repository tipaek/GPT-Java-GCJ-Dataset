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
            char[][] charArray = new char[n][];

            for (int i = 0; i < n; i++) {
                words[i] = scanner.nextLine();
                parts[i] = words[i].split("\\*");
                charArray[i] = words[i].toCharArray();
            }

            String startString = findStart(charArray, parts);
            if (startString == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String endString = findEnd(charArray, parts);
            if (endString == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            StringBuilder result = new StringBuilder(startString);
            int startLength = result.length();

            for (int i = 0; i < n; i++) {
                int startIndex = charArray[i][0] == '*' ? 0 : 1;
                int endIndex = charArray[i][charArray[i].length - 1] == '*' ? parts[i].length : parts[i].length - 1;

                int currentIndex = startLength;
                for (int j = startIndex; j < endIndex; j++) {
                    int index = result.indexOf(parts[i][j], currentIndex);
                    if (index < 0) {
                        result.append(parts[i][j]);
                        currentIndex = result.length();
                    } else {
                        currentIndex = index + parts[i][j].length();
                    }
                }
            }

            if (!result.toString().equals(endString)) {
                result.append(endString);
            }

            if (result.length() == 0) {
                result.append("A");
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    public static String findStart(char[][] charArray, String[][] parts) {
        String startString = "";

        for (int i = 0; i < n; i++) {
            if (charArray[i][0] == '*') {
                continue;
            }

            String temp = parts[i][0];

            if (startString.isEmpty() || startString.startsWith(temp) || temp.startsWith(startString)) {
                if (temp.length() > startString.length()) {
                    startString = temp;
                }
            } else {
                return null;
            }
        }

        return startString;
    }

    public static String findEnd(char[][] charArray, String[][] parts) {
        String endString = "";

        for (int i = 0; i < n; i++) {
            if (charArray[i][charArray[i].length - 1] == '*') {
                continue;
            }

            String temp = parts[i][parts[i].length - 1];

            int overlapIndex = Math.max(endString.lastIndexOf(temp), temp.lastIndexOf(endString));
            if (endString.isEmpty() || (overlapIndex >= 0 && (overlapIndex == endString.length() - temp.length() || overlapIndex == temp.length() - endString.length()))) {
                if (temp.length() > endString.length()) {
                    endString = temp;
                }
            } else {
                return null;
            }
        }

        return endString;
    }
}