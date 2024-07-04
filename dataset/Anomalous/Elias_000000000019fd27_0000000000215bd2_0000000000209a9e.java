import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FasterScanner sc = new FasterScanner(System.in);

        int taskCount = sc.nextInt();
        int b = sc.nextInt();
        for (int task = 1; task <= taskCount; task++) {
            int[] array = new int[b];
            int[] same = new int[b]; // same == 1, diff == 2
            Arrays.fill(array, -1);

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                array[i - 1] = sc.nextInt();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(b - i + 1);
                array[b - i] = sc.nextInt();
            }

            int sameIndex = -1;
            int diffIndex = -1;
            for (int i = 0; i < 5; i++) {
                if (array[i] == array[b - i - 1]) {
                    same[i] = 1;
                    same[b - i - 1] = 1;
                    if (sameIndex == -1) {
                        sameIndex = i;
                    }
                } else {
                    same[i] = 2;
                    same[b - i - 1] = 2;
                    if (diffIndex == -1) {
                        diffIndex = i;
                    }
                }
            }

            int index = 6;
            while (index * 2 < b) {
                if (index % 5 == 1) {
                    int[] newArray = new int[b];
                    Arrays.fill(newArray, -1);

                    if (sameIndex != -1) {
                        System.out.println(sameIndex + 1);
                        int val = sc.nextInt();
                        boolean change = val == array[sameIndex];
                        if (change) {
                            for (int i = 0; i < b; i++) {
                                if (same[i] == 1) {
                                    newArray[i] = 1 - array[i];
                                }
                            }
                        }
                    } else {
                        System.out.println(0);
                        sc.nextInt();
                    }

                    if (diffIndex != -1) {
                        System.out.println(diffIndex + 1);
                        int val = sc.nextInt();
                        boolean change = val == array[diffIndex];
                        if (change) {
                            for (int i = 0; i < b; i++) {
                                if (same[i] == 2) {
                                    newArray[i] = 1 - array[i];
                                }
                            }
                        }
                    } else {
                        System.out.println(0);
                        sc.nextInt();
                    }
                    array = newArray;
                } else {
                    System.out.println(index);
                    int val1 = sc.nextInt();
                    System.out.println(b - index + 1);
                    int val2 = sc.nextInt();
                    array[index - 1] = val1;
                    array[b - index] = val2;
                    if (val1 == val2) {
                        same[index - 1] = 1;
                        same[b - index] = 1;
                    } else {
                        same[index - 1] = 2;
                        same[b - index] = 2;
                    }
                }
                index++;
            }

            StringBuilder solution = new StringBuilder();
            for (int i = 0; i < b; i++) {
                solution.append(array[i]);
            }
            System.out.println(solution);
            String verdict = sc.nextString();
            if (verdict.equals("N")) {
                break;
            }
        }

        sc.close();
    }

    public static class FasterScanner {
        private InputStream input;
        private byte[] buffer = new byte[1024];
        private int currentChar, numChars;

        public FasterScanner(InputStream input) {
            this.input = input;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = input.read(buffer);
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
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}