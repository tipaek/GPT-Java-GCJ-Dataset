import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private StringBuilder buffer = new StringBuilder(16384);

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();

        for (int t = 0; t < T; ++t) {
            int N = reader.nextInt();
            int trace = reader.nextInt();

            SudokuPuzzle puzzle = new SudokuPuzzle(N);
            boolean canProceed = fillTrace(N, puzzle, trace);

            if (!canProceed) {
                buffer.append(String.format("Case #%d: IMPOSSIBLE\n", t + 1));
                continue;
            }

            SudokuSolution solution = new BacktrackingSudokuSolver().solve(puzzle);
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
            } else {
                buffer.append(String.format("Case #%d: IMPOSSIBLE\n", t + 1));
            }
        }

        System.out.print(buffer);
    }

    private boolean fillTrace(int N, SudokuPuzzle puzzle, int trace) {
        int placed = 0;

        while (trace > 0) {
            int spotsLeft = N - placed;

            if (trace == spotsLeft) {
                for (int n = placed; n < N; ++n) {
                    puzzle.setCell(n, n, 1);
                }
                trace = 0;
            } else if (spotsLeft == 1) {
                if (trace > N) {
                    return false;
                }
                puzzle.setCell(placed, placed, trace);
                trace = 0;
            } else {
                int placeValue = Math.min(N, trace - spotsLeft);
                puzzle.setCell(placed, placed, placeValue);
                trace -= placeValue;
                ++placed;
            }
        }

        return true;
    }

    protected static class BacktrackingSudokuSolver {
        private SudokuSolution solution;
        private int R, C;

        public SudokuSolution solve(SudokuPuzzle puzzle) {
            R = puzzle.getR();
            C = puzzle.getC();
            solution = null;
            solveSudoku(0, 0, puzzle);
            if (solution == null) {
                solution = new SudokuSolution(puzzle, null);
            }
            return solution;
        }

        private void solveSudoku(int r, int c, SudokuPuzzle puzzle) {
            if (isSolved()) return;
            if (c == C) {
                solveSudoku(r + 1, 0, puzzle);
            } else if (r == R) {
                solution = new SudokuSolution(puzzle.getUnsolved(), new SudokuPuzzle(puzzle));
                return;
            } else if (!puzzle.needsPlacement(r, c)) {
                solveSudoku(r, c + 1, puzzle);
            } else {
                for (int numeral : puzzle.getPossiblePlacements(r, c)) {
                    puzzle.place(r, c, numeral);
                    solveSudoku(r, c + 1, puzzle);
                    if (!isSolved()) {
                        puzzle.undoPlacement(r, c);
                    }
                }
            }
        }

        private boolean isSolved() {
            return solution != null;
        }
    }

    protected static class SudokuSolution {
        private SudokuPuzzle original, solved;

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

    protected static class SudokuPuzzle {
        private SudokuPuzzle unsolved;
        private int dim, R, C;
        private int[][] puzzle;
        private boolean prepared;
        private Set<Integer>[] rows, cols;
        private Set<Integer> possibleNumerals;

        public SudokuPuzzle(SudokuPuzzle other) {
            this.dim = other.dim;
            this.R = other.R;
            this.C = other.C;
            this.puzzle = new int[R][C];
            for (int r = 0; r < R; ++r) {
                System.arraycopy(other.puzzle[r], 0, this.puzzle[r], 0, C);
            }
        }

        public SudokuPuzzle(int dim) {
            this(dim, new int[dim][dim]);
        }

        public SudokuPuzzle(int dim, int[][] puzzle) {
            this.dim = dim;
            this.puzzle = puzzle;
            this.R = dim;
            this.C = dim;
        }

        public int[][] getPuzzle() {
            return puzzle;
        }

        public int getR() {
            return R;
        }

        public int getC() {
            return C;
        }

        public SudokuPuzzle getUnsolved() {
            return unsolved;
        }

        public void setCell(int r, int c, int value) {
            puzzle[r][c] = value;
        }

        public boolean needsPlacement(int r, int c) {
            return puzzle[r][c] == 0;
        }

        public boolean canPlace(int r, int c, int value) {
            if (!prepared) prepareForSolution();
            return !rows[r].contains(value) && !cols[c].contains(value);
        }

        public Set<Integer> getPossiblePlacements(int r, int c) {
            if (!prepared) prepareForSolution();
            Set<Integer> possibles = new HashSet<>(possibleNumerals);
            possibles.removeAll(rows[r]);
            possibles.removeAll(cols[c]);
            return possibles;
        }

        public void place(int r, int c, int value) {
            if (!prepared) prepareForSolution();
            puzzle[r][c] = value;
            rows[r].add(value);
            cols[c].add(value);
        }

        public void undoPlacement(int r, int c) {
            if (!prepared) prepareForSolution();
            int value = puzzle[r][c];
            puzzle[r][c] = 0;
            rows[r].remove(value);
            cols[c].remove(value);
        }

        public void prepareForSolution() {
            initSolutionSets();
            initPossibleSet();
            unsolved = new SudokuPuzzle(this);
            prepared = true;
        }

        private void initSolutionSets() {
            initRows();
            initCols();
        }

        private void initPossibleSet() {
            possibleNumerals = new HashSet<>();
            for (int i = 1; i <= R; ++i) {
                possibleNumerals.add(i);
            }
        }

        private void initRows() {
            rows = new HashSet[R];
            for (int r = 0; r < R; ++r) {
                rows[r] = new HashSet<>();
                for (int c = 0; c < C; ++c) {
                    if (puzzle[r][c] != 0) {
                        rows[r].add(puzzle[r][c]);
                    }
                }
            }
        }

        private void initCols() {
            cols = new HashSet[C];
            for (int c = 0; c < C; ++c) {
                cols[c] = new HashSet<>();
                for (int r = 0; r < R; ++r) {
                    if (puzzle[r][c] != 0) {
                        cols[c].add(puzzle[r][c]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String readLine() throws IOException {
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
    }
}