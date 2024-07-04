import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Pair<Integer, Integer>> times = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                times.add(new Pair<>(s, e));
            }

            // Sort the times based on start time
            Collections.sort(times, Comparator.comparingInt(Pair::getKey));

            int[] order = new int[n];
            for (int l = 0; l < n; l++) {
                order[l] = l;
            }

            StringBuilder y = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> j = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> c = new ArrayList<>();

            j.add(times.get(0));
            y.append("J");
            times.remove(0);

            boolean overlapJ, overlapC, impossible = false;

            for (Pair<Integer, Integer> p : times) {
                overlapJ = false;
                overlapC = false;

                for (Pair<Integer, Integer> q : j) {
                    if (isOverlap(q, p)) {
                        overlapJ = true;
                        break;
                    }
                }

                if (!overlapJ) {
                    j.add(p);
                    y.append("J");
                    continue;
                }

                for (Pair<Integer, Integer> r : c) {
                    if (isOverlap(r, p)) {
                        overlapC = true;
                        break;
                    }
                }

                if (!overlapC) {
                    c.add(p);
                    y.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            char[] fin = new char[n];
            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    fin[order[l]] = y.charAt(l);
                }
            }

            String out = impossible ? "IMPOSSIBLE" : new String(fin);
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static boolean isOverlap(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return (a.getKey() < b.getValue() && b.getKey() < a.getValue());
    }
}

class Pair<U, V> {
    private final U key;
    private final V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}