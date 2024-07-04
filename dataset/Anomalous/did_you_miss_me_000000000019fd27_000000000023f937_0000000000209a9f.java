import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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
                return bufferedReader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    @Override
    public void run() {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int testCases = inputReader.nextInt();
        int caseCounter = testCases;

        while (testCases-- > 0) {
            String inputString = inputReader.next();
            char[] characters = inputString.toCharArray();
            StringBuilder result = new StringBuilder();

            int previousCharacter = 0;
            for (char character : characters) {
                int currentCharacter = character - '0';

                if (currentCharacter > previousCharacter) {
                    int difference = currentCharacter - previousCharacter;
                    result.append("(".repeat(difference));
                } else if (currentCharacter < previousCharacter) {
                    int difference = previousCharacter - currentCharacter;
                    result.append(")".repeat(difference));
                }
                result.append(currentCharacter);
                previousCharacter = currentCharacter;
            }

            int remaining = characters[characters.length - 1] - '0';
            result.append(")".repeat(remaining));

            int caseNumber = caseCounter - testCases;
            printWriter.println("Case #" + caseNumber + ": " + result);
        }

        printWriter.flush();
        printWriter.close();
    }
}