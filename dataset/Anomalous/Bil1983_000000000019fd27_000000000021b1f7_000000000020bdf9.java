import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            System.out.print("Case #" + test + ": ");
            compute();
            System.out.println();
        }
    }

    static void compute() {
        PriorityQueue<Integer> partners = new PriorityQueue<>();
        PriorityQueue<Req> requests = new PriorityQueue<>(Comparator
                .comparingInt((Req rr) -> rr.from)
                .thenComparingInt(rr -> rr.to));

        int m = sc.nextInt();
        int[] ans = new int[m];
        for (int i = 1; i <= 2; ++i) {
            partners.add(i);
        }
        for (int i = 0; i < m; ++i) {
            Req r = new Req(sc.nextInt(), sc.nextInt(), i);
            requests.add(r);
        }
        List<Req> seen = new ArrayList<>();
        boolean[] rem = new boolean[m];

        while (!requests.isEmpty()) {
            Req cur = requests.poll();
            if (partners.isEmpty()) {
                for (Req req : seen) {
                    if (req.to <= cur.from && !rem[req.index]) {
                        partners.add(ans[req.index]);
                        rem[req.index] = true;
                    }
                }
            }
            if (partners.isEmpty()) {
                System.out.print("IMPOSSIBLE");
                return;
            } else {
                ans[cur.index] = partners.poll();
                seen.add(cur);
            }
        }

        for (int i = 0; i < m; ++i) {
            System.out.print(ans[i] == 1 ? "C" : "J");
        }
    }

    static class Req {
        int from, to, index;

        public Req(int from, int to, int index) {
            this.from = from;
            this.to = to;
            this.index = index;
        }
    }
}