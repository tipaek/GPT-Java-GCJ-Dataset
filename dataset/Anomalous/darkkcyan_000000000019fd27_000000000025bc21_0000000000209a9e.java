import java.util.*;
import java.io.*;

public class Main {
    private static final PrintStream out = System.out;
    private static final Scanner in = new Scanner(System.in);

    private int[] res;
    private int eqPos = -1;
    private int diffPos = -1;
    private int cntAsked = 0;

    public static void main(String[] args) {
        int ntest = in.nextInt();
        int n = in.nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            new Main(n).solve();
        }
    }

    public Main(int n) {
        res = new int[n];
    }

    private int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        char response = in.next().charAt(0);
        cntAsked++;
        return response == '0' ? 0 : 1;
    }

    private void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        in.next();
    }

    private void reverseRes() {
        for (int l = 0, r = res.length - 1; l < r; ++l, --r) {
            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;
        }
    }

    private void inverseRes() {
        for (int i = 0; i < res.length; ++i) {
            if (res[i] != -1) res[i] = 1 - res[i];
        }
    }

    private void fix() {
        if (diffPos == -1 && eqPos == -1) return;
        if (diffPos != -1 && eqPos != -1) {
            if (ask(eqPos) != res[eqPos]) inverseRes();
            if (ask(diffPos) != res[diffPos]) reverseRes();
        } else {
            int pos = (diffPos == -1) ? eqPos : diffPos;
            if (ask(pos) != res[pos]) inverseRes();
            ask(0);
        }
    }

    private void solve() {
        int l = 0, r = res.length - 1;
        while (l < r) {
            if (cntAsked % 10 == 0) fix();
            res[l] = ask(l);
            res[r] = ask(r);
            if (res[l] == res[r]) eqPos = l;
            else diffPos = l;
            l++;
            r--;
        }
        answer(res);
    }
}