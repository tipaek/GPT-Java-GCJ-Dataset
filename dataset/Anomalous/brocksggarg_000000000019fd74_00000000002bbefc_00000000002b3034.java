import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": " + solve(br));
        }
    }

    private static String solve(BufferedReader br) throws IOException {
        System.out.println();
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        Map<Integer, Integer> startIndexMap = new HashMap<>();
        Map<Integer, Boolean> lastActiveMap = new HashMap<>();
        Map<Integer, Boolean> startActiveMap = new HashMap<>();
        ArrayList<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            patterns.add(pattern);
            lastActiveMap.put(i, true);
            startActiveMap.put(i, true);
            startIndexMap.put(i, 0);
            lastIndexMap.put(i, pattern.length() - 1);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder startResult = new StringBuilder();

        // Process from the end
        while (true) {
            char check = '@';
            for (int j = 0; j < n; j++) {
                if (lastActiveMap.get(j)) {
                    char c = patterns.get(j).charAt(lastIndexMap.get(j));
                    if (c == '*') {
                        lastActiveMap.put(j, false);
                    } else if (check == '@') {
                        check = c;
                        lastIndexMap.put(j, lastIndexMap.get(j) - 1);
                    } else if (check != c) {
                        return "*";
                    } else {
                        lastIndexMap.put(j, lastIndexMap.get(j) - 1);
                    }
                }
            }
            if (check == '@') {
                break;
            } else {
                result.append(check);
            }
        }

        // Process from the start
        while (true) {
            char check = '@';
            for (int j = 0; j < n; j++) {
                if (startActiveMap.get(j)) {
                    char c = patterns.get(j).charAt(startIndexMap.get(j));
                    if (c == '*') {
                        startActiveMap.put(j, false);
                    } else if (check == '@') {
                        check = c;
                        startIndexMap.put(j, startIndexMap.get(j) + 1);
                    } else if (check != c) {
                        return "*";
                    } else {
                        startIndexMap.put(j, startIndexMap.get(j) + 1);
                    }
                }
            }
            if (check == '@') {
                break;
            } else {
                startResult.append(check);
            }
        }

        // Construct the middle part
        StringBuilder middle = new StringBuilder();
        for (int j = 0; j < n; j++) {
            middle.append(patterns.get(j), startIndexMap.get(j), lastIndexMap.get(j) + 1);
        }

        // Remove asterisks from the middle part
        String middleCleaned = middle.toString().replace("*", "");

        // Reverse the result from the end processing
        result.reverse();

        // Combine the parts and return the final result
        return startResult.append(middleCleaned).append(result).toString();
    }
}