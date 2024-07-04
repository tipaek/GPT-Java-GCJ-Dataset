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
            int arr[][] = new int[n][2];
            for (i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            Integer ind[] = new Integer[n];
            for (i = 0; i < n; i++)
                ind[i] = i;
            Arrays.sort(ind, (a, b) -> arr[a][0] != arr[b][0] ? Integer.compare(arr[a][0], arr[b][0])
                    : Integer.compare(arr[a][1], arr[b][1]));

            char ans[] = new char[n];
            int endj = 0, endc = 0, f = 0;
            for (i = 0; i < n; i++) {
                int id = ind[i];
                if (arr[id][0] >= endj) {
                    ans[id] = 'J';
                    endj = arr[id][1];
                } else if (arr[id][0] >= endc) {
                    ans[id] = 'C';
                    endc = arr[id][1];
                } else {
                    f = 1;
                    break;
                }

            }
            if (f == 1)
                sb.append("Case #" + t0 + ": IMPOSSIBLE").append("\n");
            else {
                sb.append("Case #" + t0 + ": ");
                for (i = 0; i < n; i++)
                    sb.append(ans[i]);
                sb.append("\n");
            }
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
