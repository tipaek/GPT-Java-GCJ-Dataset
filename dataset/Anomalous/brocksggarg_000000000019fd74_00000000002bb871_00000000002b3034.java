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
            System.out.print(solve(br, i));
        }
    }

    private static String solve(BufferedReader br, int t) throws IOException {
        System.out.println();
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> patterns = new ArrayList<>();
        Map<Integer, Integer> endIndices = new HashMap<>();
        Map<Integer, Integer> startIndices = new HashMap<>();
        Map<Integer, Boolean> endActive = new HashMap<>();
        Map<Integer, Boolean> startActive = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String pattern = br.readLine();
            patterns.add(pattern);
            endIndices.put(i, pattern.length() - 1);
            startIndices.put(i, 0);
            endActive.put(i, true);
            startActive.put(i, true);
        }

        StringBuilder result = new StringBuilder();
        String endResult = processEnd(patterns, endIndices, endActive);
        if (endResult.equals("*")) {
            return "*";
        }
        result.append(endResult);

        String startResult = processStart(patterns, startIndices, startActive);
        if (startResult.equals("*")) {
            return "*";
        }
        result.insert(0, startResult);

        String middleResult = processMiddle(patterns, startIndices, endIndices);
        result.insert(startResult.length(), middleResult);

        return result.toString();
    }

    private static String processEnd(ArrayList<String> patterns, Map<Integer, Integer> endIndices, Map<Integer, Boolean> endActive) {
        StringBuilder res = new StringBuilder();
        while (true) {
            char check = '@';
            for (int j = 0; j < patterns.size(); j++) {
                if (endActive.get(j)) {
                    char c = patterns.get(j).charAt(endIndices.get(j));
                    if (c == '*') {
                        endActive.put(j, false);
                    } else if (check == '@') {
                        check = c;
                        endIndices.put(j, endIndices.get(j) - 1);
                    } else if (check != c) {
                        return "*";
                    } else {
                        endIndices.put(j, endIndices.get(j) - 1);
                    }
                }
            }
            if (check == '@') {
                break;
            } else {
                res.insert(0, check);
            }
        }
        return res.toString();
    }

    private static String processStart(ArrayList<String> patterns, Map<Integer, Integer> startIndices, Map<Integer, Boolean> startActive) {
        StringBuilder res = new StringBuilder();
        while (true) {
            char check = '@';
            for (int j = 0; j < patterns.size(); j++) {
                if (startActive.get(j)) {
                    char c = patterns.get(j).charAt(startIndices.get(j));
                    if (c == '*') {
                        startActive.put(j, false);
                    } else if (check == '@') {
                        check = c;
                        startIndices.put(j, startIndices.get(j) + 1);
                    } else if (check != c) {
                        return "*";
                    } else {
                        startIndices.put(j, startIndices.get(j) + 1);
                    }
                }
            }
            if (check == '@') {
                break;
            } else {
                res.append(check);
            }
        }
        return res.toString();
    }

    private static String processMiddle(ArrayList<String> patterns, Map<Integer, Integer> startIndices, Map<Integer, Integer> endIndices) {
        StringBuilder mid = new StringBuilder();
        for (int j = 0; j < patterns.size(); j++) {
            mid.append(patterns.get(j), startIndices.get(j), endIndices.get(j) + 1);
        }
        return mid.toString().replace("*", "");
    }
}