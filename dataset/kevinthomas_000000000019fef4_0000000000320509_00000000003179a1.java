
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int t = 0; t < testCount; t++) {
                int u = scanner.nextInt();
                Map<String, Integer> dataPoints = new HashMap<String, Integer>();
                for (int i = 0; i < 10000; i++) {
                    int q = scanner.nextInt();
                    String r = scanner.next();
                    if (q == -1) {

                    } else if (dataPoints.containsKey(r)) {
                        dataPoints.put(r, Math.min(q, dataPoints.get(r)));
                    } else {
                        dataPoints.put(r, q);
                    }
                }
                System.out.println("Case #" + (t+1) + ": " + solve(u, dataPoints));
            }
        }
    }

    private static String solve(int u, Map<String, Integer> data) {
        // LEADING STRING THEORY
        Map<Character, Integer> maxVals = new HashMap<Character, Integer>();
        for (String r : data.keySet()) {
            if (r.length() == String.valueOf(data.get(r)).length()) {
                Character c = r.charAt(0);
                int first = data.get(r);
                while(first >= 10)
                    first = first / 10;
                if (maxVals.containsKey(c)) {
                    maxVals.put(c, Math.min(first, maxVals.get(c)));
                } else {
                    maxVals.put(c, first);
                }
            }
        }
        for (String r : data.keySet()) {
            Character missing = null;
            for (int x = 0; x < r.length(); x++) {
                if (!maxVals.containsKey(r.charAt(x))) {
                    missing = r.charAt(x);
                    break;
                }
            }
            if (missing != null) {
                maxVals.put(missing, 0);
                break;
            }
        }
        char[] results = new char[10];
        for (Character c : maxVals.keySet()) {
            results[maxVals.get(c)] = c;
        }
        String acc = "";
        for (int i = 0; i < 10; i++) {
            acc += results[i];
        }
        return acc;
    }
}
