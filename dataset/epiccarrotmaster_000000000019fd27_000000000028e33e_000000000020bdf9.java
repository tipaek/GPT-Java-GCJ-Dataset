import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int k = 1; k <= T; k++) {
            int S = in.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
                if (a.s == b.s) return a.e - b.e;
                return a.s - b.s;
            });

            for (int i = 0; i < S; i ++) pq.add(new Pair(in.nextInt(), in.nextInt(), i));

            int C = 0, J = 0;
            boolean isImpossible = false;
            char[] res = new char[S];
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (C <= p.s) {
                    C = p.e;
                    res[p.index] = 'C';
                } else if (J <= p.s) {
                    J = p.e;
                    res[p.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
            else System.out.println("Case #" + k + ": " + new String(res));
        }
    }

    static class Pair {
        int s, e, index;

        Pair(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }
    }
}