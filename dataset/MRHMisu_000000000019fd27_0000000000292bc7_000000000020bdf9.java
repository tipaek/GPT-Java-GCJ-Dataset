import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            int numberOfWork = scan.nextInt();
            Map<Integer, Integer> pair = new TreeMap<>();
            for (int i = 0; i < numberOfWork; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                pair.put(start, end);
            }
            String result = getSchedule(pair);
            System.out.println("Case #" + (test_no + 1) + ": " + result);
        }
    }

    private static String getSchedule(Map<Integer, Integer> pair) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> temp = new HashMap<>();
        for (int start : pair.keySet()) {
            if (temp.containsKey("C")) {
                int end = temp.get("C");
                if (start >= end) {
                    temp.put("C", pair.get(start));
                    sb.append("C");
                    continue;
                } else if (temp.containsKey("J") && start < temp.get("J")) {
                    return "IMPOSSIBLE";
                }
            } else {
                temp.put("C", pair.get(start));
                sb.append("C");
                continue;
            }
            if (temp.containsKey("J")) {
                int end = temp.get("J");
                if (start >= end) {
                    temp.put("J", pair.get(start));
                    sb.append("J");
                    continue;
                } else if (temp.containsKey("C") && start < temp.get("C")) {
                    return "IMPOSSIBLE";
                }
            } else {
                temp.put("J", pair.get(start));
                sb.append("J");
                continue;
            }

        }
        return sb.toString();
    }
 
}