import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int C = 1000000000;
        for (int t = 1; t <= T;t++) {
            int N = sc.nextInt();

            int[][] holes = new int[N][2];
            for (int i = 0; i < N;i++) {
                holes[i][0] = sc.nextInt() + C;
                holes[i][1] = sc.nextInt() + C;
            }

            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < N-1;i++) {
                for (int j = i + 1; j < N;j++) {
                    int x = holes[i][0] - holes[j][0];
                    int y = holes[i][1] - holes[j][1];

                    if (x == 0) {
                        addPoints("vert", map, holes, i, j);
                    } else if (y == 0) {
                        addPoints("horz", map, holes, i, j);
                    } else {
                        int gc = gcd(Math.abs(x), Math.abs(y));
                        int sign = (x < 0 && y < 0 || x > 0 && y > 0) ? 1 : -1;
                        String line = sign + "_" + (Math.abs(y) / gc) + "_" + (Math.abs(x) / gc);
                        addPoints(line, map, holes, i, j);
                    }
                }
            }

            int max = 0;
            for (Set<String> lines: map.values()) {
                int v = lines.size();
                if ((N - v) >= 2) v += 2;
                else if ((N - v) == 1) v += 1;
                
                if (v > max) max = v;
            }
            
            if (max == 0) max = 1;

            System.out.println("Case #" + t + ": " + max);
        }
    }

    public static void addPoints(String line, Map<String, Set<String>> map, int[][] holes, int i, int j) {
        Set<String> set = map.get(line);
        if (set == null) {
            set = new HashSet<>();
            map.put(line, set);
        }
        set.add(holes[i][0] + "_" + holes[i][1]);
        set.add(holes[j][0] + "_" + holes[j][1]);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
