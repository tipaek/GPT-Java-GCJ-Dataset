import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int testCases = inputReader.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            processTestCase(inputReader, i);
        }
    }

    private static void processTestCase(InputReader inputReader, int caseNumber) {
        StringBuilder result = new StringBuilder();
        String inputString = inputReader.nextLine();

        int openBrackets = 0;

        for (int i = 0; i < inputString.length(); ++i) {
            int currentDigit = inputString.charAt(i) - '0';

            if (currentDigit > openBrackets) {
                appendCharacters(result, '(', currentDigit - openBrackets);
                openBrackets = currentDigit;
            } else if (currentDigit < openBrackets) {
                appendCharacters(result, ')', openBrackets - currentDigit);
                openBrackets = currentDigit;
            }

            result.append(currentDigit);
        }

        appendCharacters(result, ')', openBrackets);
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; ++i) {
            sb.append(character);
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int next() {
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

        public int nextInt() {
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = next();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = next();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String nextLine() {
            int c = next();
            while (isSpaceChar(c)) {
                c = next();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = next();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}