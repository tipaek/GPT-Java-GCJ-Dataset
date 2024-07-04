import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCaseCount = reader.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            char[] digits = reader.next().toCharArray();
            StringBuilder caseBuilder = new StringBuilder();
            int openBrackets = 0;

            for (char digitChar : digits) {
                int digit = digitChar - '0';

                while (openBrackets < digit) {
                    caseBuilder.append("(");
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    caseBuilder.append(")");
                    openBrackets--;
                }

                caseBuilder.append(digitChar);
            }

            while (openBrackets > 0) {
                caseBuilder.append(")");
                openBrackets--;
            }

            resultBuilder.append("Case #").append(testCase).append(": ").append(caseBuilder).append("\n");
        }

        System.out.print(resultBuilder);
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

    public String next() throws IOException {
        int character;
        while ((character = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) character);
        } while ((character = scan()) > 32);
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int character, value = 0;
        while ((character = scan()) <= 32);
        boolean negative = character == '-';
        if (negative || character == '+') {
            character = scan();
        }
        while (character >= '0' && character <= '9') {
            value = value * 10 + (character - '0');
            character = scan();
        }
        return negative ? -value : value;
    }

    public long nextLong() throws IOException {
        int character;
        long value = 0;
        while ((character = scan()) <= 32);
        boolean negative = character == '-';
        if (negative || character == '+') {
            character = scan();
        }
        while (character >= '0' && character <= '9') {
            value = value * 10 + (character - '0');
            character = scan();
        }
        return negative ? -value : value;
    }
}