import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int caseCount = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            String result = "Case #" + caseIndex + ": ";
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[][] patterns = new String[patternCount][3];

            for (int i = 0; i < patternCount; i++) {
                String[] splitPattern = (scanner.nextLine() + "\n").split("\\*");
                patterns[i][0] = splitPattern[0];
                patterns[i][1] = "";
                patterns[i][2] = splitPattern[splitPattern.length - 1];

                for (int j = 1; j < splitPattern.length - 1; j++) {
                    patterns[i][1] += splitPattern[j];
                }
            }

            String prefix = "";
            String suffix = "";
            boolean isImpossible = false;

            for (int i = 0; i < patternCount && !isImpossible; i++) {
                if (!prefix.startsWith(patterns[i][0])) {
                    if (patterns[i][0].startsWith(prefix)) {
                        prefix = patterns[i][0];
                    } else {
                        isImpossible = true;
                    }
                }

                if (!suffix.endsWith(patterns[i][2])) {
                    if (patterns[i][2].endsWith(suffix)) {
                        suffix = patterns[i][2];
                    } else {
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                result += "*\n";
            } else {
                result += prefix;
                for (int i = 0; i < patternCount; i++) {
                    result += patterns[i][1];
                }
                result += suffix;
            }

            writer.print(result);
        }

        scanner.close();
        writer.close();
    }
}