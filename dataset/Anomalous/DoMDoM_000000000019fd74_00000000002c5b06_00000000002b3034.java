import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(READER.readLine());
            StringBuilder resultBuilder = new StringBuilder();

            for (int i = 0; i < testCases; i++) {
                int numberOfStrings = Integer.parseInt(READER.readLine());
                String result = findPattern(numberOfStrings);
                resultBuilder.append(String.format("CASE #%d: %s%n", i + 1, result));
            }

            System.out.print(resultBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findPattern(int numberOfStrings) throws IOException {
        String[] patterns = new String[numberOfStrings];
        patterns[0] = READER.readLine().replace("*", "");
        String keyPattern = patterns[0];
        boolean isContained = false;

        for (int i = 1; i < numberOfStrings; i++) {
            patterns[i] = READER.readLine().replace("*", "");
            if (patterns[i].contains(keyPattern)) {
                keyPattern = patterns[i];
                for (int j = 0; j < i; j++) {
                    if (!keyPattern.contains(patterns[j])) {
                        return "*";
                    }
                }
            } else if (keyPattern.contains(patterns[i])) {
                isContained = true;
            } else {
                return "*";
            }
        }

        return isContained ? keyPattern : "*";
    }
}