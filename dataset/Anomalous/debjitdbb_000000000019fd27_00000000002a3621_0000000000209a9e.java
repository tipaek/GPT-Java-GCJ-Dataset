import java.io.*;
import java.util.*;

public class Qrd {

    public static StringBuffer complement(StringBuffer arr) {
        StringBuffer result = new StringBuffer();
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            result.append(1 - arr.charAt(i) + '0');
        }
        return result;
    }

    public static boolean checkEquality(StringBuffer x, StringBuffer y) {
        for (int i = 0; i < 5; i++) {
            if (x.charAt(i) != y.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static StringBuffer reverseBuffer(StringBuffer arr) {
        StringBuffer result = new StringBuffer();
        int length = arr.length();
        for (int i = length - 1; i >= 0; i--) {
            result.append(arr.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        while (T-- > 0) {
            if (B == 10) {
                StringBuffer buffer = new StringBuffer();
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffer.append(n);
                }
                System.out.println(buffer);
                System.out.flush();
                reader.readLine().charAt(0);  // Read and discard the character
            } else if (B == 20) {
                StringBuffer[] buffers = new StringBuffer[6];
                for (int i = 0; i < 6; i++) {
                    buffers[i] = new StringBuffer();
                }

                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[0].append(n);
                }
                for (int i = 16; i <= 20; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[1].append(n);
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[2].append(n);
                }
                for (int i = 11; i <= 15; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[3].append(n);
                }
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[4].append(n);
                }
                for (int i = 6; i <= 10; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = reader.readLine().charAt(0) - '0';
                    buffers[5].append(n);
                }

                StringBuffer[] complements = new StringBuffer[4];
                complements[0] = complement(buffers[0]);
                complements[1] = reverseBuffer(buffers[1]);
                complements[2] = complement(complements[1]);
                complements[3] = complement(reverseBuffer(buffers[0]));

                StringBuffer[] reversedBuffers = new StringBuffer[2];
                reversedBuffers[0] = reverseBuffer(buffers[3]);
                reversedBuffers[1] = complement(reversedBuffers[0]);

                StringBuffer answer = new StringBuffer();
                if (checkEquality(buffers[2], buffers[5])) {
                    answer.append(buffers[2]).append(buffers[3]);
                } else if (checkEquality(complement(buffers[2]), buffers[5])) {
                    answer.append(complement(buffers[2])).append(complement(buffers[3]));
                } else if (checkEquality(reversedBuffers[0], buffers[5])) {
                    answer.append(reversedBuffers[0]).append(reverseBuffer(buffers[2]));
                } else {
                    answer.append(reversedBuffers[1]).append(complement(reverseBuffer(buffers[2])));
                }

                if (checkEquality(buffers[0], buffers[4])) {
                    System.out.println(buffers[0] + "" + answer + "" + buffers[1]);
                } else if (checkEquality(complements[0], buffers[4])) {
                    System.out.println(complements[0] + "" + answer + "" + complement(buffers[1]));
                } else if (checkEquality(complements[1], buffers[4])) {
                    System.out.println(complements[1] + "" + answer + "" + reverseBuffer(buffers[0]));
                } else {
                    System.out.println(complements[2] + "" + answer + "" + complement(reverseBuffer(buffers[0])));
                }
                reader.readLine();  // Read and discard the line
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
        StringBuilder result = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                result.appendCodePoint(c);
            }
            c = read();
        }
        return result.toString();
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
            result *= 10;
            result += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double fraction = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                fraction /= 10;
                result += (c - '0') * fraction;
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