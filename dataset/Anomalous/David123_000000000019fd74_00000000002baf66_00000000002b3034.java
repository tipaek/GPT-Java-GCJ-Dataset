import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isPatternFinished(char[] pattern, int index) {
        return index == -1 || (index == 0 && pattern[0] == '*');
    }

    public static boolean areAllPatternsFinished(List<char[]> patterns, int[] indices) {
        for (int i = 0; i < patterns.size(); i++) {
            if (!isPatternFinished(patterns.get(i), indices[i])) {
                return false;
            }
        }
        return true;
    }

    public static String findSolution(List<char[]> patterns) {
        StringBuilder result = new StringBuilder();
        int[] indices = new int[patterns.size()];
        for (int i = 0; i < patterns.size(); i++) {
            indices[i] = patterns.get(i).length - 1;
        }

        char currentChar = Character.MIN_VALUE;

        while (!areAllPatternsFinished(patterns, indices)) {
            int starCount = 0;

            for (int i = 0; i < patterns.size(); i++) {
                char[] pattern = patterns.get(i);
                int index = indices[i];

                if (isPatternFinished(pattern, index)) {
                    starCount++;
                    continue;
                }

                if (pattern[index] != '*') {
                    if (currentChar == Character.MIN_VALUE) {
                        currentChar = pattern[index];
                        indices[i]--;
                    } else if (pattern[index] == currentChar) {
                        indices[i]--;
                    } else {
                        return "*";
                    }
                } else {
                    starCount++;
                }
            }

            if (starCount == patterns.size()) {
                for (int i = 0; i < patterns.size(); i++) {
                    if (indices[i] > 0) {
                        indices[i]--;
                        break;
                    }
                }
            }

            if (currentChar != Character.MIN_VALUE) {
                result.append(currentChar);
            }
            currentChar = Character.MIN_VALUE;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int patternCount = scanner.nextInt();
            List<char[]> patterns = new ArrayList<>();

            for (int j = 0; j < patternCount; j++) {
                patterns.add(scanner.next().toCharArray());
            }

            String solution = findSolution(patterns);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}