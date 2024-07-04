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

            String result = getBeginning(charArrays, parts);
            if (result == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            String end = getEnding(charArrays, parts);
            if (end == null) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }

            int beginningLength = result.length();

            for (int i = 0; i < n; i++) {
                int start = charArrays[i][0] == '*' ? 0 : 1;
                int last = charArrays[i][charArrays[i].length - 1] == '*' ? parts[i].length : parts[i].length - 1;

                int startingIndex = beginningLength;
                for (int j = start; j < last; j++) {
                    int index = result.indexOf(parts[i][j], startingIndex);
                    if (index < 0) {
                        result += parts[i][j];
                        startingIndex = result.length();
                    } else {
                        startingIndex = index + parts[i][j].length();
                    }
                }
            }

            if (!result.equals(end)) {
                result += end;
            }
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    public static String getBeginning(char[][] charArrays, String[][] parts) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][0] == '*') {
                continue;
            }

            String temp = parts[i][0];

            if (answer.contains(temp) || temp.contains(answer)) {
                if (temp.length() > answer.length()) {
                    answer = temp;
                }
            } else {
                return null;
            }
        }

        return answer;
    }

    public static String getEnding(char[][] charArrays, String[][] parts) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (charArrays[i][charArrays[i].length - 1] == '*') {
                continue;
            }

            String temp = parts[i][parts[i].length - 1];

            if (answer.contains(temp) || temp.contains(answer)) {
                if (temp.length() > answer.length()) {
                    answer = temp;
                }
            } else {
                return null;
            }
        }

        return answer;
    }
}