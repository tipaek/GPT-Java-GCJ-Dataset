import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static final int INF = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            int[] cs = new int[C];

            for (int i = 1; i < C; i++) {
                cs[i] = scanner.nextInt();
            }

            int[] us = new int[D];
            int[] vs = new int[D];

            for (int i = 0; i < D; i++) {
                us[i] = scanner.nextInt() - 1;
                vs[i] = scanner.nextInt() - 1;
            }

            int[] dists = new int[C];
            ArrayList<Integer> done = new ArrayList<>();
            done.add(0);

            for (int dist = 1; dist <= 1001; dist++) {
                ArrayList<Integer> current = new ArrayList<>();
                for (int i = 0; i < C; i++) {
                    if ((cs[i] < 0 && -cs[i] == done.size()) || (cs[i] > 0 && cs[i] == dist)) {
                        current.add(i);
                        dists[i] = dist;
                    }
                }
                done.addAll(current);
            }

            System.out.printf("Case #%d:", t);
            for (int i = 0; i < D; i++) {
                System.out.print(" " + Math.max(1, Math.abs(dists[us[i]] - dists[vs[i]])));
            }
            System.out.println();
        }
    }
}