import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCaseCount = reader.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = reader.nextInt();
            result.append("Case #").append(testCase).append(":\n");
            result.append(generateOutput(n));
        }
        
        System.out.print(result);
    }

    private static String generateOutput(int n) {
        StringBuilder output = new StringBuilder();
        
        if (n <= 500) {
            for (int i = 1; i <= n; i++) {
                output.append(i).append(" 1\n");
            }
        } else {
            if (n % 2 == 1) {
                int z = (n + 1) / 2;
                for (int i = 1; i <= z; i++) {
                    output.append(i).append(" 1\n");
                }
                output.append(z).append(" 2\n");
            } else {
                output.append("1 1\n2 2\n2 1\n");
                for (int i = 3; i <= n / 2; i++) {
                    output.append(i).append(" 1\n");
                }
                output.append(n / 2).append(" 2\n");
            }
        }
        
        return output.toString();
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream inputStream;

    public FastReader(InputStream inputStream) {
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

    public String next() throws IOException {
        int c;
        while ((c = scan()) <= 32) ;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int c, value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = scan();
        }
        return negative ? -value : value;
    }

    public long nextLong() throws IOException {
        int c;
        long value = 0;
        while ((c = scan()) <= 32) ;
        boolean negative = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        while (c >= '0' && c <= '9') {
            value = value * 10 + (c - '0');
            c = scan();
        }
        return negative ? -value : value;
    }
}