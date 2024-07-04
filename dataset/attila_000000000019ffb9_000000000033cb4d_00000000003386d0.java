//package codejam2020r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int ttt = Integer.parseInt(sc.readLine());
        for (int tt = 1; tt <= ttt; tt++) {
            int n = Integer.parseInt(sc.readLine());
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] line = sc.readLine().split(" ");
                int r = Integer.parseInt(line[0]);
                int c = Integer.parseInt(line[1]);
                row.merge(r, 1, Integer::sum);
                col.merge(c, 1, Integer::sum);
            }
            int r1 = calc(row);
            int r2 = calc(col);
            System.out.println("Case #" + tt + ": " + Math.max(r1, r2));
        }
    }

    private static int calc(Map<Integer, Integer> row) {
        int sum = 0;
        int oddCount = 0;
        int oneCount = 0;
        for (int c : row.values()) {
            if (c == 1) {
                oneCount++;
            } else if (c % 2 == 0) {
                sum += c;
            } else {
                sum += c - 1;
                oddCount++;
            }
        }

        if (oddCount % 2 == 1) oddCount--;

        return sum + Math.min(oneCount, 2) + oddCount;
    }
}
