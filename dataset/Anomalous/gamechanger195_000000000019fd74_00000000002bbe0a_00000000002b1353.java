import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = in.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            sb.append("Case #").append(t).append(": ").append("\n");
            StringBuilder caseOutput = new StringBuilder();
            
            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    caseOutput.append(i).append(" 1\n");
                }
            } else {
                if (n % 2 == 0) {
                    caseOutput.append("1 1\n2 2\n3 3\n4 4\n4 3\n4 2\n4 1\n");
                    int sum = 11;
                    for (int i = 5; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            caseOutput.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        caseOutput.append(i).append(" 1\n");
                    }
                } else {
                    caseOutput.append("1 1\n2 2\n3 3\n3 2\n3 1\n");
                    int sum = 7;
                    for (int i = 4; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            caseOutput.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        caseOutput.append(i).append(" 1\n");
                    }
                }
            }
            sb.append(caseOutput);
        }
        
        System.out.print(sb);
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream in;

    public FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buffer);
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
        int c, val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }

    public long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = val * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}