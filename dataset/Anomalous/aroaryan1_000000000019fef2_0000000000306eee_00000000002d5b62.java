import java.util.Scanner;

public class Main {

    private static int numb;
    private static int[] ret = new int[200];
    private static int numq;

    private static int qry(int idx) {
        numq++;
        assert idx >= 1 && idx <= numb;
        System.out.println(idx);
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        return ans;
    }

    private static void refresh(int amt) {
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
            int ans = qry(equal);
            if (ans != ret[equal]) {
                // flip everything
                for (int a = 1; a <= amt; a++) {
                    ret[a] ^= 1;
                    ret[numb + 1 - a] ^= 1;
                }
            }
            if (different != -1) {
                ans = qry(different);
                if (ans != ret[different]) {
                    assert ans == ret[numb + 1 - different];
                    for (int a = 1; a <= amt; a++) {
                        int temp = ret[a];
                        ret[a] = ret[numb + 1 - a];
                        ret[numb + 1 - a] = temp;
                    }
                }
            } else {
                qry(equal); // just to force it to not mess us up
            }
        } else {
            assert equal == -1;
            assert different != -1;
            int ans = qry(different);
            if (ans != ret[different]) {
                assert ans == ret[numb + 1 - different];
                for (int a = 1; a <= amt; a++) {
                    int temp = ret[a];
                    ret[a] = ret[numb + 1 - a];
                    ret[numb + 1 - a] = temp;
                }
            }
            // then reversal is "equivalent", so we just query one bit
            qry(different); // just to avoid getting wrecked
        }
    }

    private static void rsolve() {
        System.err.println(numb);
        numq = 0;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = -1;
        }
        for (int i = 1; i <= numb / 2; i++) {
            assert numq % 2 == 0;
            if (numq != 0 && numq % 10 == 0) {
                // we need to know if there was a reversal
                refresh(i - 1);
            }
            ret[i] = qry(i);
            ret[numb + 1 - i] = qry(numb + 1 - i);
        }
        for (int i = 1; i <= numb; i++) {
            System.out.print(ret[i]);
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        assert s.equals("Y");
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        numb = scanner.nextInt();
        for (int casenum = 1; casenum <= t; casenum++) {
            // System.out.print("Case #" + casenum + ": ");
            rsolve();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}