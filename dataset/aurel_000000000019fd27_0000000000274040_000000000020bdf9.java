import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author Aurelien
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int t = ir.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            testCase(ir, i);
        }
    }

    private static void testCase(InputReader ir, int cas) {
        int n = ir.nextInt();
        Activity[] activities = new Activity[n];
        
        for (int i = 0; i < n; ++i) {
            activities[i] = new Activity(ir.nextInt(), ir.nextInt());
        }
        
        // Sort activities according to beginning time
        // Arrays.sort(activities);
        
        Activity actC = activities[0];
        Activity actJ = null;
        
        StringBuilder sb = new StringBuilder().append('C');
        
        for (int i = 1; i < n; ++i) {
            // System.out.println(actC + " " + actJ);
            if (actC.overlaps(activities[i])) {
                // The other parent can be called
                if (actJ == null || !actJ.overlaps(activities[i])) {
                    sb.append('J');
                    actJ = activities[i];
                } else {
                    System.out.println("Case #" + cas + ": IMPOSSIBLE");
                    return;
                }
            } else {
                sb.append('C');
                actC = activities[i];
            }
        }
        
        System.out.println("Case #" + cas + ": " + sb.toString());
    }
    
    static class Activity implements Comparable<Activity> {
        public int begin;
        public int end;

        public Activity(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        
        public boolean overlaps(Activity a) {
            return !(this.begin >= a.end || a.begin >= this.end);
        }

        @Override
        public int compareTo(Activity o) {
            return new Integer(this.begin).compareTo(o.begin);
        }

        @Override
        public String toString() {
            return "Activity{" + "begin=" + begin + ", end=" + end + '}';
        }
        
        
    }
    
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
        
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int snext() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
        
        public int nextInt() {
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public long nextLong() {
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
        
        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
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
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
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
