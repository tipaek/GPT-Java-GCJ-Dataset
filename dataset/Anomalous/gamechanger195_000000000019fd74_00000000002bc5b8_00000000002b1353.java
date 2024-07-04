import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCaseCount = reader.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int n = reader.nextInt();
            result.append("Case #").append(t).append(": \n");
            StringBuilder caseResult = new StringBuilder();

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    caseResult.append(i).append(" 1\n");
                }
            } else {
                if (n % 2 == 0) {
                    caseResult.append("1 1\n2 2\n3 3\n4 4\n4 3\n4 2\n4 1\n");
                    int sum = 11;
                    for (int i = 5; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            caseResult.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        caseResult.append(i).append(" 1\n");
                    }
                } else {
                    caseResult.append("1 1\n2 1\n2 2\n3 3\n3 2\n3 1\n");
                    int sum = 7;
                    for (int i = 4; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            caseResult.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        caseResult.append(i).append(" 1\n");
                    }
                }
            }
            result.append(caseResult);
        }

        System.out.print(result);
    }
}

class FastReader {
    private byte[] buffer = new byte[2048];
    private int index, total;
    private InputStream input;

    FastReader(InputStream input) {
        this.input = input;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = input.read(buffer);
            if (total <= 0) {
                return -1;
            }
        }
        return buffer[index++];
    }

    public String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }

    public long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32);
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