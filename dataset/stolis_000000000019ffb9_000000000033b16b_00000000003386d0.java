import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    
    static int gcd(int a, int b) {
        if (a == 0) {
            return  b;
        }
        return (b == 0) ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            int[] X = new int[N];
            int[] Y = new int[N];
            for (int n=0; n<N; n++) {
                X[n] = in.nextInt();
                Y[n] = in.nextInt();
            }
            Map<Point,List<Point>> map = new HashMap<Point,List<Point>>();
            for (int from=0; from<N; from++) {
                for (int to=0; to<N; to++) {
                    if (from != to) {
                        int dx = X[to]-X[from];
                        int dy = Y[to]-Y[from];
                        int gcd = gcd(Math.abs(dx), Math.abs(dy));
                        dx /= gcd;
                        dy /= gcd;
                        Point dir = new Point(dx, dy);
                        List<Point> list = map.get(dir);
                        if (list == null) {
                            list = new ArrayList<>();
                            map.put(dir, list);
                        }
                        list.add(new Point(from,to));
                    }
                }
            }
            int answer = 1;
            for (List<Point> list : map.values()) {
                UnionFind uf = new UnionFind(N);
                for (Point p : list) {
                    uf.union(p.x, p.y);
                }
                int count = 0;
                for (int group : uf.group) {
                    if (group < -1) {
                        count += -group;
                    }
                }
                count -= count%2;
                count = Math.min(count + 2, N);
                answer = Math.max(count, answer);
            }
            System.out.printf("Case #%d: %d\n", t, answer);
        }
    }

    static class UnionFind {
        final int[] group;
        
        public UnionFind(int size) {
            group = new int[size];
            Arrays.fill(group, -1);
        }

        public final int find(int x) {
            while (group[x] >= 0) {
                x = group[x];
            }
            return x;
        }

        public final boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                if (group[x] > group[y]) {
                    group[y] += group[x];
                    group[x] = y;
                } else {
                    group[x] += group[y];
                    group[y] = x;
                }
            }
            return (x != y);
        }

        public final int size(int x) {
            return -group[find(x)];
        }
    }

}
