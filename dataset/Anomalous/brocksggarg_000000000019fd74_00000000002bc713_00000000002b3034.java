import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + solve(br));
        }
    }

    private static String solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        Map<Integer, Integer> endIndices = new HashMap<>();
        Map<Integer, Integer> startIndices = new HashMap<>();
        Map<Integer, Boolean> activeEnd = new HashMap<>();
        Map<Integer, Boolean> activeStart = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            strings.add(s);
            endIndices.put(i, s.length() - 1);
            startIndices.put(i, 0);
            activeEnd.put(i, true);
            activeStart.put(i, true);
        }

        StringBuilder result = new StringBuilder();
        if (!processPattern(strings, endIndices, activeEnd, result, true)) {
            return "*";
        }

        StringBuilder startResult = new StringBuilder();
        if (!processPattern(strings, startIndices, activeStart, startResult, false)) {
            return "*";
        }

        StringBuilder midResult = new StringBuilder();
        for (int i = 0; i < n; i++) {
            midResult.append(strings.get(i), startIndices.get(i), endIndices.get(i) + 1);
        }

        String midString = midResult.toString().replace("*", "");
        StringBuilder finalResult = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i--) {
            finalResult.append(result.charAt(i));
        }
        startResult.append(midString).append(finalResult);

        return startResult.toString();
    }

    private static boolean processPattern(List<String> strings, Map<Integer, Integer> indices, Map<Integer, Boolean> activeMap, StringBuilder result, boolean isEnd) {
        while (true) {
            char currentChar = '@';
            for (int i = 0; i < strings.size(); i++) {
                if (activeMap.get(i)) {
                    char c = isEnd ? strings.get(i).charAt(indices.get(i)) : strings.get(i).charAt(indices.get(i));
                    if (c == '*') {
                        activeMap.put(i, false);
                    } else if (currentChar == '@') {
                        currentChar = c;
                        indices.put(i, isEnd ? indices.get(i) - 1 : indices.get(i) + 1);
                    } else {
                        if (currentChar != c) {
                            return false;
                        }
                        indices.put(i, isEnd ? indices.get(i) - 1 : indices.get(i) + 1);
                    }
                }
            }
            if (currentChar == '@') {
                break;
            } else {
                result.append(currentChar);
            }
        }
        return true;
    }
}