import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            List<Tuple<Integer, Integer>> vals = new ArrayList<>();
            int size = in.nextInt();
            for (int i = 0; i < size; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                vals.add(new Tuple<>(n, m));
            }
            System.out.println("Case #" + x + ": " + solve(vals));
        }
    }

    static String solve(List<Tuple<Integer, Integer>> input) {
        int n = input.size();
        List<Tuple<Integer, Integer>> cam = new ArrayList<>();
        List<Tuple<Integer, Integer>> jam = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        if (!input.isEmpty()) {
            cam.add(input.get(0));
            ans.append("C");
            input.remove(0);
        }

        for (Tuple<Integer, Integer> val : new ArrayList<>(input)) {
            boolean assigned = false;

            if (canAssign(val, cam)) {
                cam.add(val);
                ans.append("C");
                assigned = true;
            } else if (canAssign(val, jam)) {
                jam.add(val);
                ans.append("J");
                assigned = true;
            }

            if (assigned) {
                input.remove(val);
            }
        }

        return ans.length() == n ? ans.toString() : "IMPOSSIBLE";
    }

    static boolean canAssign(Tuple<Integer, Integer> val, List<Tuple<Integer, Integer>> schedule) {
        for (Tuple<Integer, Integer> scheduled : schedule) {
            if (!(val.a < scheduled.a && val.b <= scheduled.a || val.a >= scheduled.b && val.b > scheduled.b)) {
                return false;
            }
        }
        return true;
    }
}

class Tuple<A, B> {
    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        if (!a.equals(tuple.a)) return false;
        return b.equals(tuple.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}