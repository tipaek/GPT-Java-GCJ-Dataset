
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int t = 0; t < testCount; t++) {
                int u = scanner.nextInt();
                List<String> dataPoints = new ArrayList<String>();
                for (int i = 0; i < 10000; i++) {
                    int q = scanner.nextInt();
                    String r = scanner.next();
                    dataPoints.add(r);
                }
                System.out.println("Case #" + (t+1) + ": " + solve(u, dataPoints));
            }
        }
    }

    private static String solve(int u, List<String> data) {
        Map<Character, Integer> occurrence = new HashMap<Character, Integer>();
        for (String r : data) {
            if (r.length() > 0) {
                Character c = r.charAt(0);
                if (occurrence.containsKey(c)) {
                    occurrence.put(c, occurrence.get(c) + 1);
                } else {
                    occurrence.put(c, 1);
                }
            }
        }
        for (String r : data) {
            Character missing = null;
            for (int x = 0; x < r.length(); x++) {
                if (!occurrence.containsKey(r.charAt(x))) {
                    missing = r.charAt(x);
                    break;
                }
            }
            if (missing != null) {
                occurrence.put(missing, Integer.MAX_VALUE - 1);
                break;
            }
        }
        char[] results = new char[10];
        int roof = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            char maxChar = 0;
            int max = -1;
            for (Character c : occurrence.keySet()) {
                int v = occurrence.get(c);
                if (max < v && v < roof) {
                    maxChar = c;
                    max = v;
                }
            }
            results[i] = maxChar;
            roof = max;

        }
        String acc = "";
        for (int i = 0; i < 10; i++) {
            acc += results[i];
        }
        return acc;
    }
}
