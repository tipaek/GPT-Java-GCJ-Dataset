import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] list = new long[n];
            TreeMap<Long, Integer> frequencyMap = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                list[i] = sc.nextLong();
                updateFrequencyMap(frequencyMap, list[i]);
            }

            if (d == 1) {
                System.out.println("Case #" + test + ": 0");
                continue;
            }

            boolean found = false;
            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() == d) {
                    System.out.println("Case #" + test + ": 0");
                    found = true;
                    break;
                }
            }

            if (found) continue;

            if (d == 2) {
                System.out.println("Case #" + test + ": 1");
                continue;
            }

            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() == 2 && !entry.getKey().equals(frequencyMap.lastKey())) {
                    System.out.println("Case #" + test + ": 1");
                    found = true;
                    break;
                }
            }

            if (found) continue;

            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                long key = entry.getKey();
                if (entry.getValue() == 1 && frequencyMap.containsKey(key * 2)) {
                    System.out.println("Case #" + test + ": 1");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + test + ": 2");
            }
        }
    }

    static void updateFrequencyMap(TreeMap<Long, Integer> map, long value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
}