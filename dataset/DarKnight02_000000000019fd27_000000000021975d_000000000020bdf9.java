import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Pair {

        public int first;
        public int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int maxOverlap(int[] start, int[] end, int n) {
        int maxa = Arrays.stream(start).max().getAsInt();
        int maxb = Arrays.stream(end).max().getAsInt();
        int maxc = Math.max(maxa, maxb);
        int[] x = new int[maxc + 2];
        Arrays.fill(x, 0);
        int cur = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            ++x[start[i]];
            --x[end[i] + 1];
        }

        int maxy = Integer.MIN_VALUE;
        for (int i = 0; i <= maxc; i++) {
            cur += x[i];
            if (maxy < cur) {
                maxy = cur;
                idx = i;

            }
        }
        return maxy;

    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(next());
            Pair[] pairs = new Pair[N];
            int[] start = new int[N];
            int[] end = new int[N];
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(next());
                int b = Integer.parseInt(next()) - 1;
                start[i] = a;
                end[i] = b;
                pairs[i] = new Pair(a, b);
            }
            Arrays.sort(pairs, (Pair p1, Pair p2) -> p1.first - p2.first);
            if (maxOverlap(start, end, N) > 2) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                String seq = "";
                ArrayList<Pair> C = new ArrayList<>();
                ArrayList<Pair> J = new ArrayList<>();
                C.add(new Pair(-1, -1));
                J.add(new Pair(-1, -1));
                for (int i = 0; i < N; i++) {
                    if (pairs[i].first > C.get(C.size() - 1).second) {
                        C.add(pairs[i]);
                        continue;
                    }
                    if (pairs[i].first > J.get(J.size() - 1).second) {
                        J.add(pairs[i]);
                    }
                }
                for(Pair p:pairs){
                    System.out.println(p.first+" "+p.second);
                    if(C.contains(p)){
                        seq+="C";
                    }
                    if(J.contains(p)){
                        seq+="J";
                    }
                }
                System.out.println("Case #" + t + ": " + seq);
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}