import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            ArrayList<Dancer> dancersToUpdate = new ArrayList<>();
            Dancer[][] grid = new Dancer[rows][cols];
            long totalSkill = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = new Dancer(i, j, scanner.nextInt());
                    dancersToUpdate.add(grid[i][j]);
                    totalSkill += grid[i][j].skill;
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i > 0) grid[i][j].up = grid[i - 1][j];
                    if (i < rows - 1) grid[i][j].down = grid[i + 1][j];
                    if (j > 0) grid[i][j].left = grid[i][j - 1];
                    if (j < cols - 1) grid[i][j].right = grid[i][j + 1];
                }
            }

            long result = 0;
            while (true) {
                result += totalSkill;
                ArrayList<Dancer> dancersToRemove = new ArrayList<>();
                ArrayList<Dancer> nextDancersToUpdate = new ArrayList<>();

                for (Dancer dancer : dancersToUpdate) {
                    if (dancer.eliminated) continue;
                    Iterable<Dancer> adjacentDancers = getAdjacentDancers(dancer);
                    if (!shouldStay(dancer, adjacentDancers)) {
                        dancersToRemove.add(dancer);
                        dancer.eliminated = true;
                        for (Dancer adjDancer : adjacentDancers) {
                            nextDancersToUpdate.add(adjDancer);
                        }
                    }
                }

                if (dancersToRemove.isEmpty()) break;

                for (Dancer dancer : dancersToRemove) {
                    totalSkill -= dancer.skill;
                    if (dancer.left != null) dancer.left.right = dancer.right;
                    if (dancer.right != null) dancer.right.left = dancer.left;
                    if (dancer.up != null) dancer.up.down = dancer.down;
                    if (dancer.down != null) dancer.down.up = dancer.up;
                }

                dancersToUpdate = nextDancersToUpdate;
            }

            System.out.printf("Case #%d: %d\n", t, result);
        }
    }

    static boolean shouldStay(Dancer dancer, Iterable<Dancer> adjacentDancers) {
        long adjacentSkillSum = 0;
        for (Dancer adjDancer : adjacentDancers) {
            adjacentSkillSum += adjDancer.skill;
        }
        return dancer.skill >= adjacentSkillSum;
    }

    static Iterable<Dancer> getAdjacentDancers(Dancer dancer) {
        return Arrays.stream(new Dancer[]{dancer.left, dancer.right, dancer.up, dancer.down})
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    static class Dancer {
        boolean eliminated = false;
        int row, col, skill;
        Dancer left, right, up, down;

        public Dancer(int row, int col, int skill) {
            this.row = row;
            this.col = col;
            this.skill = skill;
        }
    }

    static class FastScanner {
        private static final int BUFFER_SIZE = 1 << 16;
        private static final char NULL_CHAR = (char) -1;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private final BufferedInputStream inputStream;
        private int bufferIdx = 0, bufferSize = 0;
        private char currentChar = NULL_CHAR;
        private boolean endOfFile = false;

        public FastScanner(InputStream inputStream) {
            this.inputStream = new BufferedInputStream(inputStream, BUFFER_SIZE);
        }

        public int nextInt() {
            long value = nextLong();
            if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
                throw new ArithmeticException("Scanned value overflows integer");
            }
            return (int) value;
        }

        public long nextLong() {
            boolean negative = false;
            if (currentChar == NULL_CHAR) {
                currentChar = nextChar();
            }
            while (!endOfFile && (currentChar < '0' || currentChar > '9')) {
                if (currentChar == '-') {
                    negative = true;
                }
                currentChar = nextChar();
            }
            checkEndOfFile();
            long result = 0;
            while (currentChar >= '0' && currentChar <= '9') {
                result = (result << 3) + (result << 1) + currentChar - '0';
                currentChar = nextChar();
            }
            return negative ? -result : result;
        }

        private char nextChar() {
            if (endOfFile) {
                return NULL_CHAR;
            }
            while (bufferIdx == bufferSize) {
                try {
                    bufferSize = inputStream.read(buffer);
                    if (bufferSize == -1) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    endOfFile = true;
                    return NULL_CHAR;
                }
                bufferIdx = 0;
            }
            return (char) buffer[bufferIdx++];
        }

        private void checkEndOfFile() {
            if (endOfFile) {
                throw new EndOfFileException();
            }
        }

        public class EndOfFileException extends RuntimeException {
        }
    }
}