import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfLines = Integer.parseInt(reader.readLine());
            String commonSubstring = "";

            for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
                String currentLine = reader.readLine().substring(1);

                if (commonSubstring == null) continue;

                if (currentLine.contains(commonSubstring)) {
                    commonSubstring = currentLine;
                } else if (!commonSubstring.contains(currentLine)) {
                    commonSubstring = null;
                }
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, commonSubstring == null ? "*" : commonSubstring);
        }
    }
}