import java.io.*;
import java.util.Arrays;

public class Main {
    private static final PrintStream out = System.out;
    private static final InputStream in = System.in;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    private static final int NOT_SET = -1;

    private int[] res;
    private int eqPos = NOT_SET;
    private int diffPos = NOT_SET;

    public static void main(String[] args) {
        int ntest = nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            int n = nextInt();
            new Main(n).solve();
        }
    }

    public Main(int n) {
        res = new int[n];
        Arrays.fill(res, NOT_SET);
    }

    private static String next() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    private int ask(int pos) {
        out.println(pos);
        out.flush();
        char res = next().charAt(0);
        if (res == 'N') throw new AssertionError();
        return res == '0' ? 0 : 1;
    }

    private static void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        if (!"Y".equals(next())) throw new AssertionError();
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
            if (res[i] != NOT_SET) res[i] = 1 - res[i];
        }
    }

    private void fix() {
        if (diffPos == NOT_SET && eqPos == NOT_SET) return;
        if (diffPos != NOT_SET && eqPos != NOT_SET) {
            if (ask(eqPos) != res[eqPos]) inverseRes();
            if (ask(diffPos) != res[diffPos]) reverseRes();
        } else {
            int pos = diffPos == NOT_SET ? eqPos : diffPos;
            if (ask(pos) != res[pos]) inverseRes();
        }
    }

    private void solve() {
        int curQues = 0;
        int l = 0, r = res.length - 1;
        while (l < r) {
            ++curQues;
            if (curQues % 10 == 1) fix();
            res[l] = ask(l);
            res[r] = ask(r);
            ++l;
            --r;
        }
        answer(res);
    }
}