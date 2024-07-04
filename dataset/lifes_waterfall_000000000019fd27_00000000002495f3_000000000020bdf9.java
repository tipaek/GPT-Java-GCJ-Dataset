import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int x;
        int y;

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
            List<Pair> cameronList = new ArrayList<>();
            List<Pair> jamieList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int si = in.nextInt();
                int ei = in.nextInt();
                Pair newPair = new Pair(si, ei);

                boolean cameronCanTake = true;
                for (Pair pair : cameronList) {
                    if (!pair.canTake(newPair)) {
                        cameronCanTake = false;
                    }
                }
                if (cameronCanTake) {
                    cameronList.add(newPair);
                    result.append("C");
                } else {
                    boolean jamieCanTake = true;
                    for (Pair pair : jamieList) {
                        if (!pair.canTake(newPair)) {
                            jamieCanTake = false;
                        }
                    }
                    if (jamieCanTake) {
                        jamieList.add(newPair);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + x + ": " + result.toString());
        }
    }
}
