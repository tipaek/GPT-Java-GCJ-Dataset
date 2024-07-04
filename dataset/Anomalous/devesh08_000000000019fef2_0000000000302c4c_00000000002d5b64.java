import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        int t = in.nextInt();
        for (int test = 1; test <= t; ++test) {
            StringBuilder sb = new StringBuilder();
            int x = in.nextInt();
            int y = in.nextInt();
            sb.append("Case #").append(test).append(": ");
            switch (x) {
                case 2:
                    switch (y) {
                        case 2:
                            sb.append("1\n2 1\n");
                            break;
                        case 3:
                            sb.append("2\n4 1\n3 1\n");
                            break;
                        case 4:
                            sb.append("3\n6 1\n5 1\n4 1\n");
                            break;
                        case 5:
                            sb.append("4\n8 1\n7 1\n6 1\n5 1\n");
                            break;
                        case 6:
                            sb.append("5\n10 1\n9 1\n8 1\n7 1\n6 1\n");
                            break;
                        case 7:
                            sb.append("6\n12 1\n11 1\n10 1\n9 1\n8 1\n7 1\n");
                            break;
                    }
                    break;
                case 3:
                    switch (y) {
                        case 2:
                            sb.append("2\n3 2\n2 1\n");
                            break;
                        case 3:
                            sb.append("4\n6 2\n5 2\n4 1\n3 1\n");
                            break;
                        case 4:
                            sb.append("6\n9 2\n8 2\n7 2\n6 1\n5 1\n4 1\n");
                            break;
                    }
                    break;
                case 4:
                    switch (y) {
                        case 2:
                            sb.append("3\n4 3\n3 2\n2 1\n");
                            break;
                        case 3:
                            sb.append("6\n8 3\n7 3\n6 2\n5 2\n4 1\n3 1\n");
                            break;
                    }
                    break;
                case 5:
                    if (y == 2) {
                        sb.append("4\n5 4\n4 3\n3 2\n2 1\n");
                    }
                    break;
            }
            System.out.print(sb);
        }
    }
}

class FastReader {
    private final byte[] buf = new byte[2048];
    private int index, total;
    private final InputStream in;

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
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c != 10 && c != 13; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    char nextChar() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        return (char) c;
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