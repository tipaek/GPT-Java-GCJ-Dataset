import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t = 1 ; t <= T; t++) {
            int N = scan.nextInt();
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                list.add(new Pair(i, start, end));
            }
            list.sort(new PairComparator());
            char[] ans = new char[N];
            int jamie_end = 0;
            int cameron_end = 0;
            boolean impossible = false;
            for (int i = 0; i < N; i++) {
                Pair p = list.get(i);
                if (jamie_end <= p.start) {
                    ans[p.id] = 'J';
                    jamie_end = p.end;
                    continue;
                }
                if (cameron_end <= p.start) {
                    ans[p.id] = 'C';
                    cameron_end = p.end;
                    continue;
                }
                impossible = true;
                break;
            }
            if (impossible) {
                System.out.printf("Case #%d: %s\n", t, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: %s\n", t, String.valueOf(ans));
            }
        }
    }
    class Pair {
        int id;
        int start;
        int end;
        Pair(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.start != o2.start) {
                return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
        }
    }
}
