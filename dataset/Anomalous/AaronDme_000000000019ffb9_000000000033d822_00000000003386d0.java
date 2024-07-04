import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());

        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            int n = Integer.parseInt(input.readLine().trim());
            int[][] positions = new int[n][2];

            for (int j = 0; j < n; j++) {
                String[] line = input.readLine().trim().split(" ");
                positions[j][0] = Integer.parseInt(line[0]);
                positions[j][1] = Integer.parseInt(line[1]);
            }

            HashMap<String, Integer> amounts = new HashMap<>();
            int max = 0;

            for (int j = 0; j < n; j++) {
                HashSet<String> added = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;

                    int x = positions[j][0] - positions[k][0];
                    int y = positions[j][1] - positions[k][1];

                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    if (y == 0) {
                        x = 1;
                    } else if (x == 0) {
                        y = 1;
                    } else {
                        int gcd = gcd(Math.abs(x), Math.abs(y));
                        x /= gcd;
                        y /= gcd;
                    }

                    String key = x + " " + y;
                    if (added.contains(key)) continue;

                    amounts.put(key, amounts.getOrDefault(key, 0) + 1);
                    max = Math.max(max, amounts.get(key));
                    added.add(key);
                }
            }

            System.out.println(Math.min(max + 2, n));
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}