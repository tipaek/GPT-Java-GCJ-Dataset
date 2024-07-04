import java.util.*;

class Pair {
    int start, end, idx;
    Pair(int s, int e, int idx) {
        this.start = s;
        this.end = e;
        this.idx = idx;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if (p1.start > p2.start) return 1;
        else if(p1.start == p2.start && p1.end > p2.end) return 1;
        else return -1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = in.nextInt();

            List<Pair> times = new ArrayList<>();

            for(int j = 0; j < N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                times.add(new Pair(start, end, j));
            }

            Collections.sort(times, new PairComparator());

            int CStart = 0;
            int CEnd = 0;
            int JStart = 0;
            int JEnd = 0;

            char[] result = new char[N];

            boolean isImpossible = false;

            for(Pair p : times) {
                if(p.start >= CEnd) {
                    CStart = p.start;
                    CEnd = p.end;
                    result[p.idx] = 'C';
                } else if (p.start >= JEnd) {
                    JStart = p.start;
                    JEnd = p.end;
                    result[p.idx] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", i, isImpossible ? "IMPOSSIBLE" : new String(result));
        }
    }
}
