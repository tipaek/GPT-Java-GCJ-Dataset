import java.util.*;

class Pair implements Comparable<Pair> {
    int si, ei, ind;

    Pair(int x, int y, int i) {
        si = x;
        ei = y;
        ind = i;
    }

    @Override
    public int compareTo(Pair p) {
        return this.ei - p.ei;
    }

    @Override
    public String toString() {
        return "{" + this.si + ":" + this.ei + ":" + this.ind + "}";
    }
}

public class Solution {
    public static String getSolution(int[] ans, int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(ans[i] == -1 ? "C" : "J");
        }
        return str.toString();
    }

    public static int getIndex(int[] ans, int n) {
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                int si = scanner.nextInt();
                int ei = scanner.nextInt();
                intervals[i] = new Pair(si, ei, i);
            }

            Pair[] intervalsCopy = intervals.clone();
            Arrays.sort(intervals);

            int[] ans = new int[n];
            int prev = 0;
            ans[intervals[prev].ind] = 1;

            for (int i = 1; i < n; i++) {
                if (intervals[i].ei <= intervals[prev].si || intervals[i].si >= intervals[prev].ei) {
                    ans[intervals[i].ind] = 1;
                    prev = i;
                }
            }

            int x = getIndex(ans, n);

            if (x == -1) {
                System.out.println("Case #" + caseNumber + ": " + getSolution(ans, n));
                caseNumber++;
                continue;
            } else {
                prev = x;
                ans[prev] = -1;

                for (int i = 1; i < n; i++) {
                    if (ans[intervals[i].ind] == 0 && (intervals[i].ei <= intervalsCopy[prev].si || intervals[i].si >= intervalsCopy[prev].ei)) {
                        ans[intervals[i].ind] = -1;
                        prev = i;
                    }
                }
            }

            x = getIndex(ans, n);

            if (x == -1) {
                System.out.println("Case #" + caseNumber + ": " + getSolution(ans, n));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }
}