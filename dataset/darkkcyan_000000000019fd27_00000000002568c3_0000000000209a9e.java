import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.Character.*;

class Main {
    static PrintStream out = System.out;
    static InputStream in = System.in;

    static String next() {
        try {
            char ch;
            while (isWhitespace(ch = (char) in.read()));
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            while (!isWhitespace(ch = (char) in.read())) {
                sb.append(ch);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int nextInt() {
        try {
            char ch;
            while (isWhitespace(ch = (char)in.read()));
            int num = (int)ch - (int)'0';
            while (isDigit(ch = (char)in.read())) {
                num = num * 10 + (int)ch - (int)'0';
            }
            return num;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        char res = next().charAt(0);
        assert(res != 'N');
        return res == '0' ? 0 : 1;
    }

    static void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        assert(next() == "Y");
    }

    public static void main(String[] args) {
        int ntest = nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            int n = nextInt();
            new Main(n).solve();
        }
    }

    int[] res;
    int eqPos = -1;
    int diffPos = -1;

    public Main(int n) {
        res = new int[n];
        Arrays.fill(res, -1);
    }

    void reverseRes() {
        for (int l = 0, r = res.length - 1; l < r; ++l, --r) {
            int temp = res[l];
            res[l] = res[r];
            res[r] = temp;
        }
    }

    void inverseRes() {
        for (int i = 0; i < res.length; ++i) {
            if (res[i] != -1) res[i] = 1 - res[i];
        }
    }

    void fix() {
        if (diffPos == -1 && eqPos == -1) return ;
        if (diffPos != -1 && eqPos != -1) {
            if (ask(eqPos) != res[eqPos]) inverseRes();
            if (ask(diffPos) != res[diffPos]) reverseRes();
        } else {
            int pos = diffPos == -1 ? eqPos : diffPos;
            if (ask(pos) != res[pos]) inverseRes();
        }
    }

    void solve() {
        int curQues = 0;
        int l = 0, r = res.length - 1;
        for (; l < r; ++l, --r) {
            ++curQues;
            if (curQues % 10 == 1) fix();
            res[l] = ask(l);
            res[r] = ask(r);
        }
        answer(res);
    }
}
