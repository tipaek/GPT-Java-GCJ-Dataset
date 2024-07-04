import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] input = in.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];
            processCase(x, y, directions, i, out);
        }
        out.flush();
        out.close();
    }

    private static void processCase(int x, int y, String directions, int caseNumber, PrintWriter out) {
        int initialDistance = Math.abs(x) + Math.abs(y);
        int currentDistance = 0;
        int steps = 0;
        int currentX = x;
        int currentY = y;

        while (initialDistance > currentDistance && steps < directions.length()) {
            char direction = directions.charAt(steps++);
            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'E':
                    currentX++;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'W':
                    currentX--;
                    break;
            }

            initialDistance = Math.abs(currentX) + Math.abs(currentY);
            currentDistance = Math.abs(currentX - x) + Math.abs(currentY - y);
        }

        if (initialDistance <= currentDistance) {
            out.println("Case #" + caseNumber + ": " + steps);
        } else {
            out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public int nextInt() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }
            int result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + character - '0';
                character = read();
            } while (!isSpaceChar(character));
            return result * sign;
        }

        public long nextLong() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }
            long result = 0;
            do {
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + character - '0';
                character = read();
            } while (!isSpaceChar(character));
            return result * sign;
        }

        public double nextDouble() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            int sign = 1;
            if (character == '-') {
                sign = -1;
                character = read();
            }
            double result = 0;
            while (!isSpaceChar(character) && character != '.') {
                if (character == 'e' || character == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (character < '0' || character > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + character - '0';
                character = read();
            }
            if (character == '.') {
                character = read();
                double multiplier = 1;
                while (!isSpaceChar(character)) {
                    if (character == 'e' || character == 'E') {
                        return result * Math.pow(10, nextInt());
                    }
                    if (character < '0' || character > '9') {
                        throw new InputMismatchException();
                    }
                    multiplier /= 10;
                    result += (character - '0') * multiplier;
                    character = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = read();
            } while (!isSpaceChar(character));
            return result.toString();
        }

        public boolean isSpaceChar(int character) {
            return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}