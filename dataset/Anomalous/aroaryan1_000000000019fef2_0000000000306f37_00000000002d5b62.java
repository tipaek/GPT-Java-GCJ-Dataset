import java.util.*;

public class Main {
    private static int numb;
    private static int[] ret = new int[200];
    private static int numq;

    private static int qry(int idx, Scanner scanner) {
        numq++;
        assert idx >= 1 && idx <= numb;
        System.out.println(idx);
        System.out.flush();
        int ans = scanner.nextInt();
        return ans;
    }

    private static void refresh(int amt, Scanner scanner) {
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
            int ans = qry(equal, scanner);
            if (ans != ret[equal]) {
                for (int a = 1; a <= amt; a++) {
                    ret[a] ^= 1;
                    ret[numb + 1 - a] ^= 1;
                }
            }
            if (different != -1) {
                ans = qry(different, scanner);
                if (ans != ret[different]) {
                    assert ans == ret[numb + 1 - different];
                    for (int a = 1; a <= amt; a++) {
                        int temp = ret[a];
                        ret[a] = ret[numb + 1 - a];
                        ret[numb + 1 - a] = temp;
                    }
                }
            } else {
                qry(equal, scanner);
            }
        } else {
            assert equal == -1;
            assert different != -1;
            int ans = qry(different, scanner);
            if (ans != ret[different]) {
                assert ans == ret[numb + 1 - different];
                for (int a = 1; a <= amt; a++) {
                    int temp = ret[a];
                    ret[a] = ret[numb + 1 - a];
                    ret[numb + 1 - a] = temp;
                }
            }
            qry(different, scanner);
        }
    }

    private static void rsolve(Scanner scanner) {
        System.err.println(numb);
        numq = 0;
        Arrays.fill(ret, -1);
        for (int i = 1; i <= numb / 2; i++) {
            assert numq % 2 == 0;
            if (numq != 0 && numq % 10 == 0) {
                refresh(i - 1, scanner);
            }
            ret[i] = qry(i, scanner);
            ret[numb + 1 - i] = qry(numb + 1 - i, scanner);
        }
        for (int i = 1; i <= numb; i++) {
            System.out.print(ret[i]);
        }
        System.out.println();
        System.out.flush();
        String s = scanner.next();
        assert s.equals("Y");
    }

    private static void solve(Scanner scanner) {
        int t = scanner.nextInt();
        numb = scanner.nextInt();
        for (int casenum = 1; casenum <= t; casenum++) {
            rsolve(scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solve(scanner);
    }
}