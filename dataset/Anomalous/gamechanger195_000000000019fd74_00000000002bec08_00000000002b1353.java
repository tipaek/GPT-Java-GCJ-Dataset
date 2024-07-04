import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder result = new StringBuilder();
        int testCaseCount = in.nextInt();
        
        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            int n = in.nextInt();
            result.append("Case #").append(testCaseNumber).append(":\n");
            
            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    result.append(i).append(" 1\n");
                }
            } else {
                StringBuilder path = new StringBuilder();
                if (n % 2 == 0) {
                    path.append("1 1\n2 2\n3 3\n4 4\n5 5\n5 4\n5 3\n5 2\n5 1\n");
                    int sum = 20;
                    for (int i = 6; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            path.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        path.append(i).append(" 1\n");
                    }
                } else {
                    path.append("1 1\n2 2\n3 3\n3 2\n4 3\n4 2\n4 1\n");
                    int sum = 12;
                    for (int i = 5; i <= 500; i++) {
                        if (n - (sum + 1) == (i - 1)) {
                            path.append(i).append(" 1\n").append(i).append(" 2\n");
                            break;
                        }
                        sum++;
                        path.append(i).append(" 1\n");
                    }
                }
                result.append(path);
            }
        }
        System.out.print(result);
    }
}

class FastReader {
    private final byte[] buffer = new byte[2048];
    private int index, total;
    private final InputStream input;

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

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    int nextInt() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        boolean isNegative = c == '-';
        if (isNegative || c == '+') {
            c = scan();
        }
        int value = 0;
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return isNegative ? -value : value;
    }

    long nextLong() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        boolean isNegative = c == '-';
        if (isNegative || c == '+') {
            c = scan();
        }
        long value = 0;
        do {
            value = value * 10 + (c - '0');
        } while ((c = scan()) >= '0' && c <= '9');
        return isNegative ? -value : value;
    }
}