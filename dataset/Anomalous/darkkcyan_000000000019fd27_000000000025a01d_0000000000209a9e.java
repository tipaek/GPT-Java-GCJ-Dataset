import java.io.InputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final PrintStream out = System.out;
    private static final InputStream in = System.in;

    private static String next() {
        try {
            int ch;
            while (Character.isWhitespace(ch = in.read()));
            StringBuilder sb = new StringBuilder();
            sb.append((char) ch);
            while (!Character.isWhitespace(ch = in.read())) {
                sb.append((char) ch);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) {
        int ntest = nextInt();
        int n = nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            new Main(n).solve();
        }
    }

    private final int[] res;
    private int eqPos = -1;
    private int diffPos = -1;
    private int cntAsked = 0;

    public Main(int n) {
        System.err.println("=================");
        res = new int[n];
        Arrays.fill(res, -1);
    }

    private int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        char response = next().charAt(0);
        System.err.println(response);
        if (response == 'N') {
            throw new AssertionError("Received 'N' response");
        }
        cntAsked++;
        return response == '0' ? 0 : 1;
    }

    private void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        if (!"Y".equals(next())) {
            throw new AssertionError("Received non 'Y' response");
        }
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
            if (res[i] != -1) {
                res[i] = 1 - res[i];
            }
        }
    }

    private void fix() {
        System.err.println("do fix");
        if (diffPos == -1 && eqPos == -1) {
            return;
        }
        if (diffPos != -1 && eqPos != -1) {
            if (ask(eqPos) != res[eqPos]) {
                inverseRes();
            }
            if (ask(diffPos) != res[diffPos]) {
                reverseRes();
            }
        } else {
            int pos = (diffPos == -1) ? eqPos : diffPos;
            if (ask(pos) != res[pos]) {
                inverseRes();
            }
            ask(0);
        }
    }

    private void solve() {
        int l = 0, r = res.length - 1;
        while (l < r) {
            if (cntAsked % 10 == 0) {
                fix();
            }
            res[l] = ask(l);
            res[r] = ask(r);
            System.err.println(l + " " + r + " " + res[l] + " " + res[r]);
            if (res[l] == res[r]) {
                eqPos = l;
            } else {
                diffPos = l;
            }
            l++;
            r--;
        }
        answer(res);
    }
}