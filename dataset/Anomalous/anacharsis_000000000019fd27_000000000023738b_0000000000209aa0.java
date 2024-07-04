import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private StringBuilder buffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; ++t) {
            int N = reader.nextInt();
            int trace = reader.nextInt();
            boolean foundSolution = false;

            for (TracePos pos : generateTracePositions(N, trace)) {
                SudokuPuzzle puzzle = new SudokuPuzzle(N);

                for (int n = 0; n < N; ++n) {
                    puzzle.setCell(n, n, pos.diagonal[n]);
                }

                SudokuSolution solution = new SudokuSolver().solve(puzzle);

                if (solution.isSolved()) {
                    buffer.append(String.format("Case #%d: POSSIBLE\n", t + 1));
                    int[][] solvedPuzzle = solution.getSolvedPuzzle().getPuzzle();
                    for (int r = 0; r < N; ++r) {
                        for (int c = 0; c < N; ++c) {
                            if (c > 0) {
                                buffer.append(' ');
                            }
                            buffer.append(solvedPuzzle[r][c]);
                        }
                        buffer.append('\n');
                    }
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                buffer.append(String.format("Case #%d: IMPOSSIBLE\n", t + 1));
            }
        }

        System.out.print(buffer);
    }

    private List<TracePos> generateTracePositions(int N, int trace) {
        List<TracePos> positions = new ArrayList<>();
        backtrackTrace(N, trace, 0, new int[N], positions, 0);
        return positions;
    }

    private void backtrackTrace(int N, int trace, int idx, int[] diagonal, List<TracePos> positions, int sum) {
        if (sum == trace && idx == N) {
            positions.add(new TracePos(diagonal));
        } else if (idx < N) {
            for (int i = 1; i <= N; ++i) {
                if (sum + i <= trace) {
                    diagonal[idx] = i;
                    backtrackTrace(N, trace, idx + 1, diagonal, positions, sum + i);
                }
            }
        }
    }

    private static class TracePos {
        private final int[] diagonal;

        public TracePos(int[] diagonal) {
            this.diagonal = diagonal.clone();
        }
    }

    private static class SudokuSolver {
        private SudokuSolution solution;
        private int rows;
        private int cols;

        public SudokuSolution solve(SudokuPuzzle puzzle) {
            rows = puzzle.getRows();
            cols = puzzle.getCols();
            solution = null;
            backtrack(0, 0, puzzle);

            if (solution == null) {
                solution = new SudokuSolution(puzzle, null);
            }

            return solution;
        }

        private void backtrack(int r, int c, SudokuPuzzle puzzle) {
            if (isSolved()) {
                return;
            } else if (c == cols) {
                backtrack(r + 1, 0, puzzle);
            } else if (r == rows) {
                solution = new SudokuSolution(puzzle.getUnsolved(), new SudokuPuzzle(puzzle));
                return;
            } else if (!puzzle.needsPlacement(r, c)) {
                backtrack(r, c + 1, puzzle);
            } else {
                for (int numeral : puzzle.getPossiblePlacements(r, c)) {
                    puzzle.place(r, c, numeral);
                    backtrack(r, c + 1, puzzle);

                    if (!isSolved()) {
                        puzzle.remove(r, c);
                    }
                }
            }
        }

        private boolean isSolved() {
            return solution != null;
        }
    }

    private static class SudokuSolution {
        private final SudokuPuzzle original;
        private final SudokuPuzzle solved;

        public SudokuSolution(SudokuPuzzle original, SudokuPuzzle solved) {
            this.original = original;
            this.solved = solved;
        }

        public boolean isSolved() {
            return solved != null;
        }

        public SudokuPuzzle getSolvedPuzzle() {
            return solved;
        }
    }

    private static class SudokuPuzzle {
        private final int dimension;
        private final int[][] puzzle;
        private final int rows;
        private final int cols;
        private boolean prepared;
        private Set<Integer>[] rowSets;
        private Set<Integer>[] colSets;
        private Set<Integer> possibleNumbers;

        public SudokuPuzzle(int dimension) {
            this(dimension, new int[dimension][dimension]);
        }

        public SudokuPuzzle(int dimension, int[][] puzzle) {
            this.dimension = dimension;
            this.puzzle = puzzle;
            this.rows = dimension;
            this.cols = dimension;
        }

        public SudokuPuzzle(SudokuPuzzle other) {
            this.dimension = other.dimension;
            this.puzzle = new int[other.rows][other.cols];
            this.rows = other.rows;
            this.cols = other.cols;

            for (int r = 0; r < other.rows; ++r) {
                System.arraycopy(other.puzzle[r], 0, this.puzzle[r], 0, this.cols);
            }
        }

        public int[][] getPuzzle() {
            return puzzle;
        }

        public int getRows() {
            return rows;
        }

        public int getCols() {
            return cols;
        }

        public SudokuPuzzle getUnsolved() {
            return new SudokuPuzzle(this);
        }

        public void setCell(int r, int c, int number) {
            puzzle[r][c] = number;
        }

        public boolean needsPlacement(int r, int c) {
            return puzzle[r][c] == 0;
        }

        public boolean canPlace(int r, int c, int number) {
            prepareIfNeeded();
            return !rowSets[r].contains(number) && !colSets[c].contains(number);
        }

        public Set<Integer> getPossiblePlacements(int r, int c) {
            prepareIfNeeded();
            Set<Integer> possible = new HashSet<>(possibleNumbers);
            possible.removeAll(rowSets[r]);
            possible.removeAll(colSets[c]);
            return possible;
        }

        public void place(int r, int c, int number) {
            prepareIfNeeded();
            puzzle[r][c] = number;
            rowSets[r].add(number);
            colSets[c].add(number);
        }

        public void remove(int r, int c) {
            prepareIfNeeded();
            int number = puzzle[r][c];
            puzzle[r][c] = 0;
            rowSets[r].remove(number);
            colSets[c].remove(number);
        }

        private void prepareIfNeeded() {
            if (!prepared) {
                initializeSets();
                initializePossibleNumbers();
                prepared = true;
            }
        }

        private void initializeSets() {
            rowSets = new Set[rows];
            colSets = new Set[cols];
            for (int i = 0; i < rows; ++i) {
                rowSets[i] = new HashSet<>();
            }
            for (int i = 0; i < cols; ++i) {
                colSets[i] = new HashSet<>();
            }
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    if (puzzle[r][c] != 0) {
                        rowSets[r].add(puzzle[r][c]);
                        colSets[c].add(puzzle[r][c]);
                    }
                }
            }
        }

        private void initializePossibleNumbers() {
            possibleNumbers = new HashSet<>();
            for (int i = 1; i <= rows; ++i) {
                possibleNumbers.add(i);
            }
        }
    }

    private static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}