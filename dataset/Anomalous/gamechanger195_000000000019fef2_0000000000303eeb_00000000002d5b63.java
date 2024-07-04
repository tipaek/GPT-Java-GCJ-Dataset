import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class Solution {
    static FastReader in;

    static boolean print(long x, long y) throws Exception {
        System.out.println(x + " " + y);
        String s = in.next();
        return s.equals("HIT") || s.equals("CENTER");
    }

    public static void main(String[] args) throws Exception {
        in = new FastReader(System.in);
        int t = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        long x = 1_000_000_000 / 2;

        for (int t0 = 0; t0 < t; t0++) {
            boolean found = false;
            long val = 0, l = 0, r = 0;

            outer:
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    System.out.println(x * i + " " + x * j);
                    String s = in.next();
                    if (s.equals("HIT") || s.equals("CENTER")) {
                        val = x * j;
                        l = x * i;
                        r = x * 2;
                        found = true;
                        break outer;
                    }
                }
            }

            if (!found) continue;

            long rightmost = binarySearch(l, r, val, true);
            long leftmost = binarySearch(x * -2, x * l, val, false);
            long val1 = (leftmost + rightmost) / 2;

            long down = binarySearch(x * -2, x * l, val1, false);
            long up = binarySearch(x * l, x * 2, val1, true);
            long val2 = (up + down) / 2;

            print(val1, val2);
        }
    }

    static long binarySearch(long l, long r, long val, boolean findRightmost) throws Exception {
        while (l <= r) {
            if (l == r) {
                return l;
            }
            if (l + 1 == r) {
                return print(findRightmost ? r : l, val) ? (findRightmost ? r : l) : (findRightmost ? l : r);
            }
            long mid = (l + r) / 2;
            if (print(mid, val)) {
                if (findRightmost) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (findRightmost) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        return -1;
    }
}

class FastReader {
    private final InputStream in;
    private final byte[] buf = new byte[2048];
    private int index, total;
    private StringTokenizer st;

    FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = scan()) != -1 && c != '\n') {
            sb.append((char) c);
        }
        return sb.toString();
    }
}