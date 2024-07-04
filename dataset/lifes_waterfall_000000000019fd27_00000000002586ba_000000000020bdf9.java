import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static class Pair {
        final int x;
        final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canTake(Pair pair) {
            if (this.y <= pair.x || this.x >= pair.y) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            StringBuilder result = new StringBuilder();
            Set<Pair> cameronSet = new HashSet<>();
            Set<Pair> jamieSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int si = in.nextInt();
                int ei = in.nextInt();

                if (result.toString().length() == i) {
                    Pair newPair = new Pair(si, ei);

                    boolean cameronCanTake = true;
                    for (Pair pair : cameronSet) {
                        if (!pair.canTake(newPair)) {
                            cameronCanTake = false;
                        }
                    }
                    if (cameronCanTake) {
                        cameronSet.add(newPair);
                        result.append("C");
                    } else {
                        boolean jamieCanTake = true;
                        for (Pair pair : jamieSet) {
                            if (!pair.canTake(newPair)) {
                                jamieCanTake = false;
                            }
                        }
                        if (jamieCanTake) {
                            jamieSet.add(newPair);
                            result.append("J");
                        }
                    }
                }
            }
            System.out.println("Case #" + x + ": " + (result.toString().length() == n ?
                    result.toString() : "IMPOSSIBLE"));
        }
    }
}
