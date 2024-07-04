import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = in.nextInt();
                y[j] = in.nextInt();
            }
            Map<Coord, Map<Integer, Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    int xd = x[j] - x[k];
                    int yd = y[j] - y[k];
                    int g = gcd(Math.abs(xd), Math.abs(yd));
                    xd /= g;
                    yd /= g;
                    Coord cd = new Coord(xd, yd);
                    map.putIfAbsent(cd, new HashMap<>());
                    if (map.get(cd).containsKey(k)) {
                        int mn = map.get(cd).get(k);
                        int tempx = x[mn] - x[k];
                        int tempy = y[mn] - y[k];
                        if (Math.abs(tempx) + Math.abs(tempy) > Math.abs(xd) + Math.abs(yd)) {
                            map.get(cd).put(k, j);
                        }
                    } else {
                        map.get(cd).put(k, j);
                    }
                }
            }
            int maxy = 0;
            for (Map.Entry<Coord, Map<Integer, Integer>> e : map.entrySet()) {
                maxy = Math.max(maxy, e.getValue().size());
            }
            System.out.println("Case #" + i + ": " + Math.min(n, maxy * 2 + 2));
        }
        in.close();
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coord coord = (Coord) obj;
            return x == coord.x && y == coord.y;
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}