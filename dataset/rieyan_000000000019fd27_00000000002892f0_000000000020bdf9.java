import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
//import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Charset charset = Charset.forName("ascii");
        FastIO rd = new FastIO(System.in, System.out, charset);
        int p = rd.readInt();
        for (int x = 1; x <= p; x++) {
            int n = rd.readInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = rd.readInt();
                }
            }
            /*java.util.Arrays.sort(a, new java.util.Comparator<int[]>() {
                @Override
                public Comparator<int[]> reversed() {
                    return null;
                }

                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }});*/

            boolean g = true;
            for (int i = 0; i < n; i++) {
                int st = a[i][0];
                int fn = a[i][1];
                for (int j = i+1; j < n; j++) {
                    if (a[j][0] >= st && a[j][0] <= fn) {
                        st = a[j][0];
                        if (a[j][1] <= fn) fn = a[j][1];
                        for (int k = 0; k < n; k++){
                            if (k != i && k != j){
                                if ((a[k][0] >= st && a[k][0] < fn) || (a[k][1] < fn && a[k][1] > st)){
                                    g = false;
                                }
                            }
                        }
                    }
                }
            }
            if (!g) System.out.println("Case #" + x + ": IMPOSSIBLE");
            else {
                char q = 'C';
                System.out.print("Case #" + x + ": " + q);
                for (int i = 1; i < n; i++) {
                    if (a[i - 1][1] > a[i][0]) {
                        if (q == 'C') q = 'J';
                        else q = 'C';
                    }
                    System.out.print(q);
                }
                System.out.println();
            }
        }
    }
}


class FastIO {
    public final StringBuilder cache = new StringBuilder(1 << 20);
    private final InputStream is;
    private final OutputStream os;
    private final Charset charset;
    private StringBuilder defaultStringBuf = new StringBuilder(1 << 8);
    private byte[] buf = new byte[1 << 13];
    private int bufLen;
    private int bufOffset;
    private int next;

    public FastIO(InputStream is, OutputStream os, Charset charset) {
        this.is = is;
        this.os = os;
        this.charset = charset;
    }

    public FastIO(InputStream is, OutputStream os) {
        this(is, os, Charset.forName("ascii"));
    }

    private int read() {
        while (bufLen == bufOffset) {
            bufOffset = 0;
            try {
                bufLen = is.read(buf);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (bufLen == -1) {
                return -1;
            }
        }
        return buf[bufOffset++];
    }

    public void skipBlank() {
        while (next >= 0 && next <= 32) {
            next = read();
        }
    }

    public int readInt() {
        int sign = 1;

        skipBlank();
        if (next == '+' || next == '-') {
            sign = next == '+' ? 1 : -1;
            next = read();
        }

        int val = 0;
        if (sign == 1) {
            while (next >= '0' && next <= '9') {
                val = val * 10 + next - '0';
                next = read();
            }
        } else {
            while (next >= '0' && next <= '9') {
                val = val * 10 - next + '0';
                next = read();
            }
        }

        return val;
    }

    public long readLong() {
        int sign = 1;

        skipBlank();
        if (next == '+' || next == '-') {
            sign = next == '+' ? 1 : -1;
            next = read();
        }

        long val = 0;
        if (sign == 1) {
            while (next >= '0' && next <= '9') {
                val = val * 10 + next - '0';
                next = read();
            }
        } else {
            while (next >= '0' && next <= '9') {
                val = val * 10 - next + '0';
                next = read();
            }
        }

        return val;
    }

    public double readDouble() {
        boolean sign = true;
        skipBlank();
        if (next == '+' || next == '-') {
            sign = next == '+';
            next = read();
        }

        long val = 0;
        while (next >= '0' && next <= '9') {
            val = val * 10 + next - '0';
            next = read();
        }
        if (next != '.') {
            return sign ? val : -val;
        }
        next = read();
        long radix = 1;
        long point = 0;
        while (next >= '0' && next <= '9') {
            point = point * 10 + next - '0';
            radix = radix * 10;
            next = read();
        }
        double result = val + (double) point / radix;
        return sign ? result : -result;
    }

    public String readString(StringBuilder builder) {
        skipBlank();

        while (next > 32) {
            builder.append((char) next);
            next = read();
        }

        return builder.toString();
    }

    public String readString() {
        defaultStringBuf.setLength(0);
        return readString(defaultStringBuf);
    }

    public int readLine(char[] data, int offset) {
        int originalOffset = offset;
        while (next != -1 && next != '\n') {
            data[offset++] = (char) next;
            next = read();
        }
        return offset - originalOffset;
    }

    public int readString(char[] data, int offset) {
        skipBlank();

        int originalOffset = offset;
        while (next > 32) {
            data[offset++] = (char) next;
            next = read();
        }

        return offset - originalOffset;
    }

    public int readString(byte[] data, int offset) {
        skipBlank();

        int originalOffset = offset;
        while (next > 32) {
            data[offset++] = (byte) next;
            next = read();
        }

        return offset - originalOffset;
    }

    public char readChar() {
        skipBlank();
        char c = (char) next;
        next = read();
        return c;
    }

    public void flush() {
        try {
            os.write(cache.toString().getBytes(charset));
            os.flush();
            cache.setLength(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasMore() {
        skipBlank();
        return next != -1;
    }
}
