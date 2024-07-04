import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
            int rounds = scanner.nextInt();
            scanner.nextLine();

            String[] patterns = new String[rounds];

            for (int roundIndex = 0; roundIndex < rounds; roundIndex++) {
                patterns[roundIndex] = scanner.nextLine();
            }

            boolean isMatchFound = false;

            for (int j = 0; j < rounds; j++) {
                String currentPattern = patterns[j].replace("*", "");

                boolean match = true;
                for (int k = 0; k < rounds; k++) {
                    if (!currentPattern.contains(patterns[k].replace("*", ""))) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    String result = patterns[j].replace("*", "A");
                    System.out.println("Case #" + (caseIndex + 1) + ": " + result);
                    isMatchFound = true;
                    break;
                }
            }

            if (!isMatchFound) {
                System.out.println("Case #" + (caseIndex + 1) + ": *");
            }
        }
    }
}