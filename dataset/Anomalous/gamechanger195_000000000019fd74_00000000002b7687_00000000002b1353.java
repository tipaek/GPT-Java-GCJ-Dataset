import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            output.append("Case #").append(t).append(":").append("\n");
            StringBuilder caseOutput = new StringBuilder();

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    caseOutput.append(i).append(" 1\n");
                }
            } else {
                if (n % 2 == 1) {
                    int mid = (n + 1) / 2;
                    for (int i = 1; i <= mid; i++) {
                        caseOutput.append(i).append(" 1\n");
                    }
                    caseOutput.append(mid).append(" 2\n");
                } else {
                    caseOutput.append("1 1\n2 2\n2 1\n");
                    for (int i = 3; i <= n / 2; i++) {
                        caseOutput.append(i).append(" 1\n");
                    }
                }
            }

            output.append(caseOutput);
        }

        System.out.print(output);
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream inputStream;

    FastReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = inputStream.read(buffer);
            if (total <= 0) {
                return -1;
            }
        }
        return buffer[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32) ;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }
}