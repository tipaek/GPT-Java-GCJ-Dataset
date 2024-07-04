import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int x, y;

        Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final Pair other = (Pair) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }

    static Map<Pair, String> map = new HashMap<>();

    private static void preprocess(int i, int j, String route, int jumps) {
        if (Math.abs(i) > 100 || Math.abs(j) > 100) {
            return;
        }
        Pair pair =  new Pair(i, j);
        if (map.containsKey(pair)) {
            String old = map.get(pair);
            map.put(pair, (route.length() < old.length()) ? route : old);
        } else {
            map.put(pair, route);
        }
        // Go north
        preprocess(i, j + (int)Math.pow(2, jumps), route + "N", jumps + 1);
        // Go south
        preprocess(i, j - (int)Math.pow(2, jumps), route + "S", jumps + 1);
        // Go East
        preprocess(i + (int)Math.pow(2, jumps), j , route + "E", jumps + 1);
        // Go West
        preprocess(i - (int)Math.pow(2, jumps), j, route + "W", jumps + 1);
    }

    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        preprocess(0, 0, "", 0);
        final int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            Pair pair = new Pair(X, Y);
            String output = map.get(pair);
            if (output == null) {
                output = "IMPOSSIBLE";
            }
            System.out.printf("Case #%d: %s\n", t, output);
        }
        sc.close();
    }
}