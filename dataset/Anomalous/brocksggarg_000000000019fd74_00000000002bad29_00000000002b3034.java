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
            System.out.println(solve(br));
        }
    }

    private static String solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> endPosMap = new HashMap<>();
        Map<Integer, Integer> startPosMap = new HashMap<>();
        Map<Integer, Boolean> lastPosCheck = new HashMap<>();
        Map<Integer, Boolean> startPosCheck = new HashMap<>();
        ArrayList<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            patterns.add(pattern);
            lastPosCheck.put(i, true);
            startPosCheck.put(i, true);
            startPosMap.put(i, 0);
            endPosMap.put(i, pattern.length() - 1);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder startResult = new StringBuilder();

        // Check from the end
        while (true) {
            char checkChar = '@';
            for (int j = 0; j < n; j++) {
                if (lastPosCheck.get(j)) {
                    char currentChar = patterns.get(j).charAt(endPosMap.get(j));
                    if (currentChar == '*') {
                        lastPosCheck.put(j, false);
                    } else if (checkChar == '@') {
                        checkChar = currentChar;
                        endPosMap.put(j, endPosMap.get(j) - 1);
                    } else {
                        if (checkChar != currentChar) {
                            return "*";
                        }
                        endPosMap.put(j, endPosMap.get(j) - 1);
                    }
                }
            }
            if (checkChar == '@') {
                break;
            } else {
                result.append(checkChar);
            }
        }

        // Check from the start
        while (true) {
            char checkChar = '@';
            for (int j = 0; j < n; j++) {
                if (startPosCheck.get(j)) {
                    char currentChar = patterns.get(j).charAt(startPosMap.get(j));
                    if (currentChar == '*') {
                        startPosCheck.put(j, false);
                    } else if (checkChar == '@') {
                        checkChar = currentChar;
                        startPosMap.put(j, startPosMap.get(j) + 1);
                    } else {
                        if (checkChar != currentChar) {
                            return "*";
                        }
                        startPosMap.put(j, startPosMap.get(j) + 1);
                    }
                }
            }
            if (checkChar == '@') {
                break;
            } else {
                startResult.append(checkChar);
            }
        }

        StringBuilder middle = new StringBuilder();
        for (int j = 0; j < n; j++) {
            middle.append(patterns.get(j), startPosMap.get(j), endPosMap.get(j) + 1);
        }

        String middleStr = middle.toString().replace("*", "");
        String reversedResult = result.reverse().toString();

        return startResult.append(middleStr).append(reversedResult).toString();
    }
}