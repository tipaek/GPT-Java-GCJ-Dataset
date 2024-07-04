//package codejam2020b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int ttt = Integer.parseInt(sc.readLine());
        for (int tt = 1; tt <= ttt; tt++) {
            String[] line = sc.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int s = Integer.parseInt(line[1]);

            StringBuilder result = new StringBuilder();
            int steps = 0;

            while (r > 1) {
                int a0 = r;
                int b0 = r * s - r - 1;

                for (int i = 0; i < s - 1; i++) {
                    int b = b0 - i;
                    result.append("\n").append(a0).append(' ').append(b);
                    steps++;
                }
                r--;
            }

            System.out.println("Case #" + tt + ": " + steps);
            System.out.println(result.toString().substring(1));
        }
    }

    private static void xx(List<Integer> all, int a, int b) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            a1.add(all.get(i));
        }
        for (int i = a; i < a + b; i++) {
            b1.add(all.get(i));
        }
        for (int i = a + b; i < all.size(); i++) {
            c1.add(all.get(i));
        }
        all.clear();
        for (int x : b1) {
            all.add(x);
        }
        for (int x : a1) {
            all.add(x);
        }
        for (int x : c1) {
            all.add(x);
        }
    }
}

// 11 21 31 12 22 32
// (11 21 31) (12 22) 32
// 12 22 11 21 31 32
// (12 22) (11) 21 31 32
// 11 12 22 21 31 32

// 11 21 31 41 12 22 32 42
// (11 21 31 41) (12 22 32) 42
// 12 22 32 11 21 31 41 42
// (12 22 32) (11 21) 31 41 42
// (11 21) (12) 22 32 31 41 42
// 12 11 21 22 32 31 41 42

// 4 3
// 3 2
// 2 1