import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.Character.*;

class Main {
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);

    static int nextInt() {
        return Integer.parseInt(in.next());
    }

    public static void main(String[] args) {
        int ntest = nextInt();
        int n = nextInt();
        for (int testcase = 1; testcase <= ntest; ++testcase) {
            new Main(n).solve();
        }
    }

    int[] res;
    int eqPos = -1;
    int diffPos = -1;
    int cntAsked = 0;

    public Main(int n) {
        // System.err.println("================="); System.err.flush(); 
        res = new int[n];
        Arrays.fill(res, -1);
    }

    int ask(int pos) {
        out.println(pos + 1);
        out.flush();
        char res = in.next().charAt(0);
        // System.err.println(res); System.err.flush(); 
        assert(res != 'N');
        ++cntAsked;
        return res == '0' ? 0 : 1;
    }

    void answer(int[] res) {
        Arrays.stream(res).forEach(out::print);
        out.println();
        out.flush();
        if (in.next() != "Y") assert(false);
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
        // System.err.println("do fix"); System.err.flush(); 
        if (diffPos == -1 && eqPos == -1) return ;
        if (diffPos != -1 && eqPos != -1) {
            if (ask(eqPos) != res[eqPos]) inverseRes();
            if (ask(diffPos) != res[diffPos]) reverseRes();
        } else {
            int pos = diffPos == -1 ? eqPos : diffPos;
            if (ask(pos) != res[pos]) inverseRes();
            ask(0);
        }
    }

    void solve() {
        int l = 0, r = res.length - 1;
        for (; l < r; ++l, --r) {
            if (cntAsked % 10 == 0) fix();
            res[l] = ask(l);
            res[r] = ask(r);
            // System.err.println(l + " " + r + " " + res[l] + " " + res[r]); System.err.flush();  
            if (res[l] == res[r]) eqPos = l;
            else diffPos = l;
        }
        answer(res);
    }
}
