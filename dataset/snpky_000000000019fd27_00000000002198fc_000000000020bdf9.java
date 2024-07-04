import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();

            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int[][] arr = new int[n][2];
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                int c = 1 + tm.getOrDefault(arr[i][0], 0);
                tm.put(arr[i][0], c);

                arr[i][1] = sc.nextInt();
                c = -1 + tm.getOrDefault(arr[i][1], 0);
                tm.put(arr[i][1], c);

                List<Integer> ends = map.getOrDefault(arr[i][0], new ArrayList<>());
                ends.add(arr[i][1]);
                map.put(arr[i][0], ends);
            }

            boolean invalid = false;
            int val = 0;

            for (Map.Entry<Integer, Integer> en: tm.entrySet()) {
                int st = en.getKey();
                int end = en.getValue();
                val += end;
                if (val > 2) {
                    invalid = true;
                    break;
                }

            }
            if (invalid) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
                continue;
            }

            int c = -1, j = -1;
            Map<String, Integer> mm = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> en: map.entrySet()) {
                int st = en.getKey();
                List<Integer> l = en.getValue();

                if (c <= st) {
                    mm.put(st+ "_" + l.get(0), 1);
                    c = l.get(0);
                } else if (j <= st) {
                    mm.put(st+ "_" + l.get(0), 2);
                    j = l.get(0);
                }

                if (l.size() > 1) {
                    int val2 = mm.getOrDefault(st+ "_" + l.get(1), 0);
                    mm.put(st+ "_" + l.get(1), val2 | 2);
                    j = l.get(1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int val1 = mm.get(arr[i][0] + "_" + arr[i][1]);
                if (val1 == 1) {
                    sb.append("C");
                    val1 = val1-1;
                } else {
                    sb.append("J");
                    val1 = val1-2;
                }
                mm.put(arr[i][0] + "_" + arr[i][1], val1);
            }
            System.out.println("Case #" + tt + ": " + sb.toString());
        }

    }
}