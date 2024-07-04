
import java.util.*;
import java.io.*;

/**
 *
 * @author usquare
 *
 */

public class Solution {

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    static boolean file = false;

    public static void main(String[] args) {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int t = in.ni();

        for(int ta = 1; ta <= t; ta++){
            int n = in.ni();
            String[] strings = new String[n];

            String endString = "";
            String startString = "";
            boolean ok = true;

            for(int i = 0; i < n; i++) {
                strings[i] = in.readString();
                StringBuilder temp = new StringBuilder();
                int j = strings[i].length() - 1;
                while(j >= 0 && strings[i].charAt(j) != '*') {
                    temp.append(strings[i].charAt(j));
                    j--;
                }
                String endTemp = temp.reverse().toString();
                if(endString.endsWith(endTemp)) {

                }
                else if(endTemp.endsWith(endString)) {
                    endString = endTemp;
                }
                else {
                    ok = false;
                    break;
                }


                temp = new StringBuilder();

                j = 0;
                while (j < strings[i].length() && strings[i].charAt(j) != '*') {
                    temp.append(strings[i].charAt(j));
                    j++;
                }

                String startTemp = temp.toString();
                if(startString.startsWith(startTemp)) {

                }
                else if(startTemp.startsWith(startString)) {
                    startString = startTemp;
                }
                else {
                    ok = false;
                    break;
                }

            }
            StringBuilder finalString = new StringBuilder();

            if(ok) {
                finalString.append(startString);

                for(int i = 0; i < n; i++) {
                    int k = 0;
                    while (k < strings[i].length() && strings[i].charAt(k) != '*') {
                        k++;
                    }
                    int j = strings[i].length() - 1;
                    while(j >= 0 && strings[i].charAt(j) != '*') {
                        j--;
                    }

                    for(int x = k; x <= j; x++) {
                        if(strings[i].charAt(x) != '*')
                            finalString.append(strings[i].charAt(x));
                    }

                }

                finalString.append(endString);
            }
            else {
                finalString.append('*');
            }

//            debug(startString, endString, ok, finalString);


            out.println("Case #"+ta+": " + finalString.toString());
        }

        out.close();
    }

    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nIArr(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nLArr(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

    }
}
