import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FasterScanner sc = new FasterScanner(System.in);

        int numberOfTasks = sc.nextInt();
        for (int task = 1; task <= numberOfTasks; task++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            long[][] dancers = new long[rows][cols];
            long partialSum = 0;
            TreeSet<Long> toProcess = new TreeSet<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    long value = sc.nextInt();
                    dancers[i][j] = value;
                    toProcess.add(((long) i) * 1000000L + j);
                    partialSum += value;
                }
            }

            boolean hasChanged = true;
            long totalSum = 0;

            while (hasChanged) {
                totalSum += partialSum;
                hasChanged = false;
                TreeSet<Long> newToProcess = new TreeSet<>();
                TreeSet<Long> toChange = new TreeSet<>();

                for (long pos : toProcess) {
                    int i = (int) (pos / 1000000L);
                    int j = (int) (pos % 1000000L);
                    long value = dancers[i][j];

                    long neighborSum = 0;
                    long neighborCount = 0;
                    TreeSet<Long> possibleNew = new TreeSet<>();
                    int index;

                    index = i - 1;
                    while (index >= 0 && dancers[index][j] == -1) index--;
                    if (index >= 0) {
                        neighborCount++;
                        neighborSum += dancers[index][j];
                        possibleNew.add(((long) index) * 1000000L + j);
                    }

                    index = i + 1;
                    while (index < rows && dancers[index][j] == -1) index++;
                    if (index < rows) {
                        neighborCount++;
                        neighborSum += dancers[index][j];
                        possibleNew.add(((long) index) * 1000000L + j);
                    }

                    index = j - 1;
                    while (index >= 0 && dancers[i][index] == -1) index--;
                    if (index >= 0) {
                        neighborCount++;
                        neighborSum += dancers[i][index];
                        possibleNew.add(((long) i) * 1000000L + index);
                    }

                    index = j + 1;
                    while (index < cols && dancers[i][index] == -1) index++;
                    if (index < cols) {
                        neighborCount++;
                        neighborSum += dancers[i][index];
                        possibleNew.add(((long) i) * 1000000L + index);
                    }

                    if (neighborCount > 0 && neighborCount * value < neighborSum) {
                        toChange.add(pos);
                        partialSum -= value;
                        newToProcess.addAll(possibleNew);
                        hasChanged = true;
                    }
                }

                for (long pos : toChange) {
                    int i = (int) (pos / 1000000L);
                    int j = (int) (pos % 1000000L);
                    dancers[i][j] = -1;
                }

                toProcess = newToProcess;
            }

            System.out.println("Case #" + task + ": " + totalSum);
        }

        sc.close();
    }

    public class FasterScanner {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FasterScanner(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = inputStream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}