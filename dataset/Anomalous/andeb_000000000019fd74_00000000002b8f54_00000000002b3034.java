import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());
            for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
                int numberOfLines = Integer.parseInt(reader.readLine());
                String resultingWord = "";
                boolean isValid = true;

                for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
                    String currentLine = reader.readLine().substring(1);
                    if (resultingWord == null) continue;

                    if (currentLine.endsWith(resultingWord)) {
                        resultingWord = currentLine;
                    } else if (!resultingWord.endsWith(currentLine)) {
                        isValid = false;
                        resultingWord = null;
                    }
                }

                System.out.printf("Case #%d: %s%n", caseIndex + 1, isValid ? resultingWord : "*");
            }
        }
    }
}