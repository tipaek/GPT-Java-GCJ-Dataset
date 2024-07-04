
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[][] results = new int[T][3];
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            //int[][] m = new int[N][N];
            int k = 0;
            int r = 0;
            int c = 0;
            Map<Integer, Set<Integer>> cm = new HashMap<>(N);
            for (int ri = 0; ri < N; ri++) {
                Set<Integer> rs = new HashSet<>(N);
                boolean hasRepeatR = false;
                for (int ci = 0; ci < N; ci++) {
                    int v = in.nextInt();
                    //m[ri][ci] = v;
                    if (ri == ci) {
                        k += v;
                    }
                    if (!hasRepeatR) {
                        if (rs.contains(v)) {
                            hasRepeatR = true;
                            r++;
                        } else {
                            rs.add(v);
                        }
                    }
                    if (!cm.containsKey(ci)) {
                        cm.put(ci, new HashSet<>(N));
                    }
                    cm.get(ci).add(v);
                }
            }
            for (int n = 0; n < N; n++) {
                if (cm.get(n).size() < N) {
                    c++;
                }
            }
            results[i][0] = k;
            results[i][1] = r;
            results[i][2] = c;
        }

        for (int i = 0; i < T; i++) {
            System.out.printf("#%d: %d %d %d\n", i+1, results[i][0], results[i][1], results[i][2]);
        }
    }
}
