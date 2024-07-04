import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Solution {

    public static StringBuffer complement(StringBuffer arr) {
        StringBuffer result = new StringBuffer();
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            result.append(1 - (arr.charAt(i) - '0'));
        }
        return result;
    }

    public static boolean isEqual(StringBuffer x, StringBuffer y) {
        for (int i = 0; i < 5; i++) {
            if (x.charAt(i) != y.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static StringBuffer reverse(StringBuffer arr) {
        return new StringBuffer(arr).reverse();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        while (T-- > 0) {
            if (B == 10) {
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                reader.readLine();
            } else if (B == 20) {
                StringBuffer[] parts = new StringBuffer[6];
                for (int i = 0; i < 6; i++) {
                    parts[i] = new StringBuffer();
                }

                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[0].append(reader.readLine().charAt(0) - '0');
                }
                for (int i = 16; i <= 20; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[1].append(reader.readLine().charAt(0) - '0');
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[2].append(reader.readLine().charAt(0) - '0');
                }
                for (int i = 11; i <= 15; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[3].append(reader.readLine().charAt(0) - '0');
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[4].append(reader.readLine().charAt(0) - '0');
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    parts[5].append(reader.readLine().charAt(0) - '0');
                }

                StringBuffer comp1 = complement(parts[0]);
                StringBuffer rev2 = reverse(parts[1]);
                StringBuffer comp2 = complement(rev2);
                StringBuffer comp3 = complement(parts[2]);
                StringBuffer rev4 = reverse(parts[3]);
                StringBuffer comp4 = complement(rev4);

                StringBuffer answer = new StringBuffer();
                if (isEqual(parts[2], parts[5])) {
                    answer.append(parts[2]).append(parts[3]);
                } else if (isEqual(comp3, parts[5])) {
                    answer.append(comp3).append(complement(parts[3]));
                } else if (isEqual(rev4, parts[5])) {
                    answer.append(rev4).append(reverse(parts[2]));
                } else {
                    answer.append(comp4).append(complement(reverse(parts[2])));
                }

                if (isEqual(parts[0], parts[4])) {
                    System.out.println(parts[0].append(answer).append(parts[1]));
                } else if (isEqual(comp1, parts[4])) {
                    System.out.println(comp1.append(answer).append(complement(parts[1])));
                } else if (isEqual(rev2, parts[4])) {
                    System.out.println(rev2.append(answer).append(reverse(parts[0])));
                } else {
                    System.out.println(comp2.append(answer).append(complement(reverse(parts[0]))));
                }
                System.out.flush();
                reader.readLine();
            }
        }
    }
}

class Bolt {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public Bolt(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new UnknownError();
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new UnknownError();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar];
    }

    public void skip(int x) {
        while (x-- > 0) {
            read();
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String nextString() {
        return next();
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return result.toString();
    }

    public String nextLine() {
        StringBuilder buffer = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buffer.appendCodePoint(c);
            }
            c = read();
        }
        return buffer.toString();
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        double result = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return result * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            result = result * 10 + (c - '0');
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                result += (c - '0') * m;
                c = read();
            }
        }
        return result * sign;
    }

    public boolean hasNext() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value != -1;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}