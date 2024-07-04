import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Solution {
    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int i, j;
        int t0 = 0;
        int t = in.nextInt();
        while (t0++ < t) {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            int tr = 0, row = 0, col = 0;
            for (i = 0; i < n; i++) {
                int freq[] = new int[n + 1];
                for (j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                    freq[arr[i][j]]++;
                }
                int f = 0;
                for (j = 1; j <= n; j++) {
                    if (freq[j] > 1) {
                        f = 1;
                        break;
                    }
                }
                row += f;
            }
            for (j = 0; j < n; j++) {
                int freq[] = new int[n + 1];
                for (i = 0; i < n; i++) {
                    freq[arr[i][j]]++;
                }
                int f = 0;
                for (i = 1; i <= n; i++) {
                    if (freq[i] > 1) {
                        f = 1;
                        break;
                    }
                }
                col += f;
            }
            for (i = 0; i < n; i++)
                tr += arr[i][i];
            sb.append("Case #" + t0 + ": " + tr + " " + row + " " + col).append("\n");
        }
        System.out.println(sb);


    }
}

class FastReader {

    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    int scan() throws IOException {
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
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}
