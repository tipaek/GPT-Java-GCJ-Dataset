import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            int n = Integer.parseInt(br.readLine());
            String result = findPattern(n);
            resultBuilder.append(String.format("CASE #%d: %s\n", i + 1, result));
        }

        System.out.print(resultBuilder);
    }

    private static String findPattern(int n) throws IOException {
        String[] patterns = new String[n];
        patterns[0] = br.readLine().replace("*", "");
        String currentKey = patterns[0];
        boolean isContained = false;

        for (int i = 1; i < n; i++) {
            patterns[i] = br.readLine().replace("*", "");
            if (patterns[i].contains(currentKey)) {
                currentKey = patterns[i];
                for (int j = 0; j < i; j++) {
                    if (!currentKey.contains(patterns[j])) {
                        return "*";
                    }
                }
            } else if (currentKey.contains(patterns[i])) {
                isContained = true;
            } else {
                return "*";
            }
        }

        return isContained ? currentKey : "*";
    }
}