import java.util.*;

class Period {
    public int s;
    public int e;
    public int i;
}

class PeriodComparator implements Comparator<Period> {
    public int compare (Period a, Period b) {
        return Integer.compare(a.s, b.s);
    }
}

class Solution {

    private static void solve(int N, Scanner sc, int x) {
        Period[] P = new Period[N];
        Period[] P2 = new Period[N];

        //int[] table = new int[1441];
        boolean[][] busy  = new boolean[2][1441]; //0:C, 1:J
        boolean[][] begin = new boolean[2][1441]; //0:C, 1:J

        boolean possible = true;

        for (int i = 0; i < N; i++) {
            P[i] = new Period();
            P[i].s = sc.nextInt();
            P[i].e = sc.nextInt();
            P[i].i = i;

            P2[i] = new Period();
            P2[i].s = P[i].s;
            P2[i].e = P[i].e;
            P2[i].i = P[i].i;
        }

        Arrays.sort(P, new PeriodComparator());

        for (int i = 0; i < N; i++) {
            int owner = 0;
            boolean ok = false;


            for (int o = 0; o < 2; o++) {
                for (int j = P[i].s; j < P[i].e; j++) {
                    if (busy[o][j]) {
                        //System.out.println(String.format("A[%d] O[%d] is BUSY: time: %d S:%d", i, o, j, S[i]));
                        ok = false;
                        break;
                    }
                    if (j == P[i].e - 1) {
                        ok = true;
                        owner = o;
                    }
                }
                if (ok) {
                    break;
                }
            }
            possible = ok;
            if (!possible) break;
            if (ok) {
                for (int j = P[i].s; j < P[i].e; j++) {
                    if (j == P[i].s) {
                        begin[owner][P2[P[i].i].s] = true;
                    }
                    busy[owner][j] = true;
                }
            }
        }

        if (possible) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < P2.length; i++) {
                if (begin[0][P2[i].s]) {
                    sb.append('C');
                } else if (begin[1][P2[i].s]){
                    sb.append('J');
                } else {
                    System.out.println("Error.");
                    System.exit(1);
                }
            }

            System.out.println(String.format("Case #%d: %s", x, sb.toString()));
        } else {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", x));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            solve(N, sc, i + 1);
        }
    }
}
