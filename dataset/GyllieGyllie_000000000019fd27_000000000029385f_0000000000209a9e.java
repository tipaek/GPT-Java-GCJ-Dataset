import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Locale;

public class Solution {
    static InputReader in;

    // Example with interaction
    public static void main(String[] args) throws Exception {
        in = new InputReader(System.in);
        Locale.setDefault(Locale.US);
        int T = in.readInt();
        int B = in.readInt();
        for (int t = 1; t <= T; t++) {
            // read
            boolean[] result = new boolean[B];
            int index = 0;

            // ignore first bit
            readBit(0);

            // Decide first 10
            readBits(result, index, 5, B);
            index += 5;

            // Decide first change
            result = decideChange(result);

            // Keep looping till we have all
            while (index < B / 2) {
                int changed = readBits(result, index, 4, B);
                index += changed;

                if (changed == 4) {
                    result = decideChange(result);
                }
            }

            for (int i = 0; i < B; i++) {
                System.out.print(result[i] ? '1' : '0');
            }
            System.out.println();
            if (in.readChar() != 'Y') {
                break;
            }
        }
        System.out.close();
    }

    static int readBits(boolean[] result, int index, int amount, int max) {
        for (int i = 0; i < amount; i++) {
            if (index + i >= max / 2) return index;

            result[index + i] = readBit(index + i);

            int contra = result.length - 1 - index - i;
            result[contra] = readBit(contra);
        }

        return amount;
    }

    static boolean[] decideChange(boolean[] result) {
        boolean left = true;
        boolean right = false;
        int index = 0;

        while (left != right) {
            left = result[index];
            right = result[result.length - 1 - index];
            index++;
        }

        boolean current = readBit(index - 1);

        if (current == left) {

            index = 0;

            while (left == right) {
                left = result[index];
                right = result[result.length - 1 - index];
                index++;
            }

            current = readBit(index - 1);

            if (left == current) {
                return result;
            } else {
                return reverse(result);
            }

        } else {
            index = 0;

            while (left == right) {
                left = result[index];
                right = result[result.length - 1 - index];
                index++;
            }

            current = readBit(index -1);

            if (left != current) {
                return complementate(result);
            } else {
                return complementate(reverse(result));
            }
        }
    }

    public static boolean[] reverse(boolean[] current) {
        boolean[] newArray = new boolean[current.length];

        for (int i = 0; i < current.length; i++) {
            newArray[i] = current[current.length - i - 1];
        }

        return newArray;
    }

    public static boolean[] complementate(boolean[] current) {
        boolean[] newArray = new boolean[current.length];

        for (int i = 0; i < current.length; i++) {
            newArray[i] = !current[i];
        }

        return newArray;
    }

    static boolean readBit(int b) {
        System.out.println(b + 1);
        return in.readChar() == '1';
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public char readChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}
