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

        int amountOfTasks = sc.nextInt();
        for (int task = 1; task <= amountOfTasks; task++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            long[][] dancers = new long[r][c];
            long partSum = 0;
            TreeSet<Long> toDo = new TreeSet<>();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    long val = sc.nextInt();
                    dancers[i][j] = val;
                    toDo.add(((long) i) * 1000000L + j);
                    partSum += val;
                }
            }

            boolean changed = true;
            long sum = 0;

            while (changed) {
                sum += partSum;
                changed = false;
                TreeSet<Long> newToDo = new TreeSet<>();
                TreeSet<Long> toChange = new TreeSet<>();

                for (long l : toDo) {
                    int i = (int) (l / 1000000L);
                    int j = (int) (l % 1000000L);
                    long val = dancers[i][j];

                    long neighbourSum = 0;
                    long neighbourCount = 0;
                    TreeSet<Long> possNew = new TreeSet<>();

                    int[] directions = {-1, 1};
                    for (int dir : directions) {
                        for (int index = i + dir; index >= 0 && index < r; index += dir) {
                            if (dancers[index][j] != -1) {
                                neighbourCount++;
                                neighbourSum += dancers[index][j];
                                possNew.add(((long) index) * 1000000L + j);
                                break;
                            }
                        }
                        for (int index = j + dir; index >= 0 && index < c; index += dir) {
                            if (dancers[i][index] != -1) {
                                neighbourCount++;
                                neighbourSum += dancers[i][index];
                                possNew.add(((long) i) * 1000000L + index);
                                break;
                            }
                        }
                    }

                    if (neighbourCount > 0 && neighbourCount * val < neighbourSum) {
                        toChange.add(l);
                        newToDo.addAll(possNew);
                        changed = true;
                    }
                }

                for (long l : toChange) {
                    int i = (int) (l / 1000000L);
                    int j = (int) (l % 1000000L);
                    partSum -= dancers[i][j];
                    dancers[i][j] = -1;
                }

                toDo.clear();
                for (long l : newToDo) {
                    int i = (int) (l / 1000000L);
                    int j = (int) (l % 1000000L);
                    if (dancers[i][j] != -1) {
                        toDo.add(l);
                    }
                }
            }

            System.out.println("Case #" + task + ": " + sum);
        }

        sc.close();
    }

    public class FasterScanner {

        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FasterScanner(InputStream is) {
            this.mIs = is;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                mIs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}