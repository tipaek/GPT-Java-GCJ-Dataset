import java.util.*;
import java.io.*;

public class Main {
    static int numb;
    static int[] ret = new int[200];
    static int numq;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        numb = sc.nextInt();
        for (int casenum = 1; casenum <= t; casenum++) {
            rsolve(sc);
        }
    }

    static int qry(int idx, FastScanner sc) {
        numq++;
        assert idx >= 1 && idx <= numb;
        System.out.println(idx);
        System.out.flush();
        int ans = sc.nextInt();
        return ans;
    }

    static void refresh(int amt, FastScanner sc) {
        int equal = -1;
        int different = -1;
        for (int a = 1; a <= amt; a++) {
            if (ret[a] == ret[numb + 1 - a]) {
                equal = a;
            } else {
                different = a;
            }
        }
        if (equal != -1) {
            int ans = qry(equal, sc);
            if (ans != ret[equal]) {
                for (int a = 1; a <= amt; a++) {
                    ret[a] ^= 1;
                    ret[numb + 1 - a] ^= 1;
                }
            }
            if (different != -1) {
                ans = qry(different, sc);
                if (ans != ret[different]) {
                    assert ans == ret[numb + 1 - different];
                    for (int a = 1; a <= amt; a++) {
                        int temp = ret[a];
                        ret[a] = ret[numb + 1 - a];
                        ret[numb + 1 - a] = temp;
                    }
                }
            } else {
                qry(equal, sc);
            }
        } else {
            assert equal == -1;
            assert different != -1;
            int ans = qry(different, sc);
            if (ans != ret[different]) {
                assert ans == ret[numb + 1 - different];
                for (int a = 1; a <= amt; a++) {
                    int temp = ret[a];
                    ret[a] = ret[numb + 1 - a];
                    ret[numb + 1 - a] = temp;
                }
            }
            qry(different, sc);
        }
    }

    static void rsolve(FastScanner sc) {
        numq = 0;
        Arrays.fill(ret, -1);
        for (int i = 1; i <= numb / 2; i++) {
            assert numq % 2 == 0;
            if (numq != 0 && numq % 10 == 0) {
                refresh(i - 1, sc);
            }
            ret[i] = qry(i, sc);
            ret[numb + 1 - i] = qry(numb + 1 - i, sc);
        }
        for (int i = 1; i <= numb; i++) {
            System.out.print(ret[i]);
        }
        System.out.println();
        System.out.flush();
        String s = sc.next();
        assert s.equals("Y");
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}