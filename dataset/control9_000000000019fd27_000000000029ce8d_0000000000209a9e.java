
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
    public static final int FREQ = 10;
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
//        makeNumbersText();
        int t = nextInt();
        int b = nextInt();
        for (int cn = 1; cn <= t; cn++) {
            solve(b);
        }
    }

    private static void solve(int b) throws IOException {
        int same = -1;
        int opposite = -1;
        int tries = 0;
        int[] known = new int[b];
        int current = 0;
        Arrays.fill(known, -1);
        while (current < b / 2) {
            known[current] = read(current + 1);
            known[(b - 1) - current] = read((b - current));
            tries += 2;

            if (opposite == -1 && known[current] != known[(b - 1) - current]) opposite = current;
            if (same == -1 && known[current] == known[(b - 1) - current]) same = current;
            current++;

            if (tries == FREQ && current < b / 2) {
                boolean rev = false;
                boolean comp = false;
                if (same != -1) {
                    int r = read(same + 1);
                    if (r != known[same]) {
                        comp = true;
                    }
                } else {
                    read(1); // keeping read number even.
                }

                if (opposite != -1) {
                    int r = read(opposite + 1);
                    boolean changed = r != known[opposite];
                    if (changed ^ comp) rev = true;
                } else {
                    read(1); // keeping read number even.
                }
                if (rev) reverse(known);
                if (comp) comp(known);
                tries = 2;
//                System.out.println("Rev " + rev + "comp " + comp);
            }
        }
        respond(known);
    }

    private static void respond(int[] known) throws IOException {
        char[] res = new char[known.length];
        for (int i = 0; i < known.length; i++) {
            res[i] = (char) ('0' + known[i]);
        }
        System.out.println(res);
        System.out.flush();
        String s = next();
        if ("N".equals(s)) System.exit(0);
    }

    private static void comp(int[] known) {
        for (int i = 0; i < known.length; i++) {
            if (known[i] == 0) known[i] = 1;
            else known[i] = 0;
        }
    }

    private static void reverse(int[] known) {
        for (int i = 0; i < known.length / 2; i++) {
            int j = known.length - 1 - i;
            int t = known[i];
            known[i] = known[j];
            known[j] = t;
        }
    }

    private static int read(int x) throws IOException {
        System.out.println(x);
        System.out.flush();
        return nextInt();
    }

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static int nextIntFromStr() throws IOException {
        in.nextToken();
        return Integer.valueOf(in.sval);
    }

    private static void makeNumbersText() {
        in.resetSyntax();
        in.wordChars('a', 'z');
        in.wordChars('A', 'Z');
        in.wordChars(128 + 32, 255);
        in.whitespaceChars(0, ' ');
        in.commentChar('/');
        in.quoteChar('"');
        in.quoteChar('\'');
        in.wordChars('0', '9');
    }

    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
}
