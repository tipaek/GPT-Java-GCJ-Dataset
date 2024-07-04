import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    private static final String FILE_LOCATION = "NestingDepth/src/in/";
    private static final String[] FILE_NAMES = {"test1"};
    private static int currentFileIndex = 0;
    private static LineOfNumbers[] lines;
    private static int testCaseCount;

    static class LineOfNumbers {
        private final int[] numbers;
        private final int length;

        public LineOfNumbers(int length) {
            this.length = length;
            this.numbers = new int[length];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int number : numbers) {
                builder.append(number);
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        currentFileIndex = 0; // current file to scan
        start(false);
    }

    private static void start(boolean isLocal) throws Exception {
        long startTime = System.currentTimeMillis();
        readData(isLocal);
        solve();
    }

    private static void solve() {
        for (int i = 0; i < testCaseCount; i++) {
            solveLine(i);
        }
    }

    private static void solveLine(int lineIndex) {
        LineOfNumbers line = lines[lineIndex];
        StringBuilder output = new StringBuilder();
        int depth = 0;

        for (int number : line.numbers) {
            if (number > depth) {
                output.append("(".repeat(number - depth));
                depth = number;
            } else if (number < depth) {
                output.append(")".repeat(depth - number));
                depth = number;
            }
            output.append(number);
        }

        output.append(")".repeat(depth));
        printCase(lineIndex + 1, output.toString());
    }

    private static void printCase(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void readData(boolean isLocal) throws Exception {
        try (InputReader inputReader = new InputReader(isLocal ? new FileInputStream(FILE_LOCATION + FILE_NAMES[currentFileIndex] + ".in") : System.in)) {
            testCaseCount = inputReader.readInt();
            lines = new LineOfNumbers[testCaseCount];

            for (int i = 0; i < testCaseCount; i++) {
                String lineString = inputReader.readLine();
                int lineLength = lineString.length();
                LineOfNumbers line = new LineOfNumbers(lineLength);

                for (int j = 0; j < lineLength; j++) {
                    line.numbers[j] = Character.getNumericValue(lineString.charAt(j));
                }

                lines[i] = line;
            }
        }
    }

    static class InputReader implements AutoCloseable {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

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

        public String readLine() {
            int character = read();
            while (isSpaceChar(character)) {
                character = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(character);
                character = read();
            } while (!isEndOfLine(character));
            return result.toString();
        }

        public int readInt() {
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
                result *= 10;
                result += character - '0';
                character = read();
            } while (!isSpaceChar(character));
            return result * sign;
        }

        private boolean isSpaceChar(int character) {
            return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
        }

        private boolean isEndOfLine(int character) {
            return character == '\n' || character == '\r' || character == -1;
        }

        @Override
        public void close() {
            try {
                stream.close();
            } catch (IOException e) {
                System.err.println("Failed to close stream");
            }
        }
    }
}