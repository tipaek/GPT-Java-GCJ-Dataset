import java.util.ArrayList;
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

            StringBuilder y = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> j = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> c = new ArrayList<>();

            if (n > 0) {
                j.add(times.get(0));
                y.append("J");
            }
            if (n > 1) {
                c.add(times.get(1));
                y.append("C");
            }

            boolean impossible = false;

            for (int k = 2; k < n; k++) {
                Pair<Integer, Integer> p = times.get(k);
                boolean overlapJ = hasOverlap(j, p);
                boolean overlapC = hasOverlap(c, p);

                if (!overlapJ) {
                    j.add(p);
                    y.append("J");
                } else if (!overlapC) {
                    c.add(p);
                    y.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String out = impossible ? "IMPOSSIBLE" : y.toString();
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static boolean hasOverlap(ArrayList<Pair<Integer, Integer>> list, Pair<Integer, Integer> p) {
        for (Pair<Integer, Integer> q : list) {
            if ((q.getKey() < p.getValue() && q.getValue() > p.getKey())) {
                return true;
            }
        }
        return false;
    }
}

class Pair<U, V> {
    private final U a;
    private final V b;

    public Pair(U a, V b) {
        this.a = a;
        this.b = b;
    }

    public U getKey() {
        return a;
    }

    public V getValue() {
        return b;
    }
}