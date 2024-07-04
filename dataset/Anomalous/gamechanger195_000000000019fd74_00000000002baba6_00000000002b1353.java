import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCaseCount = in.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = in.nextInt();
            output.append("Case #").append(testCase).append(": \n");
            
            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    output.append(i).append(" 1\n");
                }
            } else {
                output.append("1 1\n2 2\n3 3\n4 4\n4 3\n4 2\n4 1\n");
                int sum = 11;
                for (int i = 5; i <= 500; i++) {
                    if (n - (sum + 1) == (i - 1)) {
                        output.append(i).append(" 1\n").append(i).append(" 2\n");
                        break;
                    }
                    sum++;
                    output.append(i).append(" 1\n");
                }
            }
        }
        
        System.out.print(output);
    }
}

class FastReader {
    private byte[] buffer = new byte[2048];
    private int index, total;
    private InputStream inputStream;

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
        while ((c = scan()) <= 32);
        StringBuilder result = new StringBuilder();
        do {
            result.append((char) c);
        } while ((c = scan()) > 32);
        return result.toString();
    }

    int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (negative || c == '+') {
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
        while ((c = scan()) <= 32);
        boolean negative = c == '-';
        if (negative || c == '+') {
            c = scan();
        }
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return negative ? -value : value;
    }
}