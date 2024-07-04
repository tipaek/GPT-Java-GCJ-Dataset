import java.io.InputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final PrintStream out = System.out;
    private static final InputStream in = System.in;

    private static String next() {
        try {
            StringBuilder sb = new StringBuilder();
            char ch;
            while (Character.isWhitespace(ch = (char) in.read()));
            sb.append(ch);
            while (!Character.isWhitespace(ch = (char) in.read())) {
                sb.append(ch);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int nextInt() {
        try {
            char ch;
            while (Character.isWhitespace(ch = (char) in.read()));
            int num = ch - '0';
            while (Character.isDigit(ch = (char) in.read())) {
                num = num * 10 + (ch - '0');
            }
            return num;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        char res = next().charAt(0);
        assert(res != 'N');
        return res == '0' ? 0 : 1;
    }

    private static void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        assert("Y".equals(next()));
    }

    public static void main(String[] args) {
        int ntest = nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            int n = nextInt();
            new Main(n).solve();
        }
    }

    private int[] res;
    private int eqPos = -1;
    private int diffPos = -1;

    public Main(int n) {
        res = new int[n];
        Arrays.fill(res, -1);
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
            int pos = diffPos == -1 ? eqPos : diffPos;
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