import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }

            String combinedPattern = "";
            boolean isPossible = true;
            String basePattern = patterns[0];

            for (int i = 1; i < n; i++) {
                String nextPattern = patterns[i];
                combinedPattern = "";
                int baseStarIndex = basePattern.indexOf("*");
                int nextStarIndex = nextPattern.indexOf("*");

                if (baseStarIndex > 0 && nextStarIndex > 0) {
                    if (!basePattern.substring(0, baseStarIndex).startsWith(nextPattern.substring(0, nextStarIndex)) &&
                        !nextPattern.substring(0, nextStarIndex).startsWith(basePattern.substring(0, baseStarIndex))) {
                        isPossible = false;
                        break;
                    }
                } else if (baseStarIndex == 0 && nextStarIndex > 0) {
                    combinedPattern += nextPattern.substring(0, nextStarIndex);
                } else if (baseStarIndex > 0 && nextStarIndex == 0) {
                    combinedPattern += basePattern.substring(0, baseStarIndex);
                }

                nextPattern = nextPattern.substring(nextStarIndex + 1);
                basePattern = basePattern.substring(baseStarIndex + 1);

                baseStarIndex = basePattern.indexOf("*");
                nextStarIndex = nextPattern.indexOf("*");

                while (baseStarIndex != -1 && nextStarIndex != -1) {
                    String baseSegment = basePattern.substring(0, baseStarIndex);
                    String nextSegment = nextPattern.substring(0, nextStarIndex);

                    if (baseSegment.contains(nextSegment)) {
                        combinedPattern += baseSegment;
                    } else if (nextSegment.contains(baseSegment)) {
                        combinedPattern += nextSegment;
                    } else {
                        combinedPattern += baseSegment + "*" + nextSegment;
                    }

                    nextPattern = nextPattern.substring(nextStarIndex + 1);
                    basePattern = basePattern.substring(baseStarIndex + 1);

                    baseStarIndex = basePattern.indexOf("*");
                    nextStarIndex = nextPattern.indexOf("*");
                    combinedPattern += "*";
                }

                if (basePattern.length() == 0) {
                    combinedPattern += nextPattern;
                } else if (nextPattern.length() == 0) {
                    combinedPattern += basePattern;
                } else if (!basePattern.contains("*") && !nextPattern.contains("*")) {
                    if (nextPattern.endsWith(basePattern)) {
                        combinedPattern += nextPattern;
                    } else if (basePattern.endsWith(nextPattern)) {
                        combinedPattern += basePattern;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else if (basePattern.contains("*")) {
                    if (basePattern.substring(basePattern.lastIndexOf("*") + 1).endsWith(nextPattern)) {
                        combinedPattern += basePattern;
                    } else if (basePattern.endsWith("*")) {
                        combinedPattern += nextPattern;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (nextPattern.substring(nextPattern.lastIndexOf("*") + 1).endsWith(basePattern)) {
                        combinedPattern += nextPattern;
                    } else if (nextPattern.endsWith("*")) {
                        combinedPattern += basePattern;
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                basePattern = combinedPattern;
            }

            if (isPossible) {
                combinedPattern = combinedPattern.replace("*", "");
                System.out.println("Case #" + caseNumber + ": " + combinedPattern);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}