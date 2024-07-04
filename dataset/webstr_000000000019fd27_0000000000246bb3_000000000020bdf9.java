import javafx.util.Pair;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            Set<Pair<Pair<Integer, Integer>, Integer>> set = new TreeSet<>((o1, o2) -> {
                if (o1.getKey().getKey() > o2.getKey().getKey()) {
                    return 1;
                } else if (o1.getKey().getKey() < o2.getKey().getKey()) {
                    return -1;
                }
                return 0;
            });
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                set.add(new Pair<>(new Pair<>(s, e), i));
            }

            char[] res = new char[n];

            int[] end = new int[2];
            char[] arr = {'C', 'J'};
            boolean isImpossible = false;
            for (Pair<Pair<Integer, Integer>, Integer> entry : set) {
                int s = entry.getKey().getKey();
                int e = entry.getKey().getValue();
                int i = entry.getValue();
                if (s >= end[0]) {
                    end[0] = e;
                    res[i] = arr[0];
                } else if (s >= end[1]) {
                    end[1] = e;
                    res[i] = arr[1];
                } else {
                    isImpossible = true;
                    break;
                }

            }
            String val = isImpossible ? "IMPOSSIBLE" : new String(res);
            System.out.println("Case #" + t + ": " + val);
        }
    }
}