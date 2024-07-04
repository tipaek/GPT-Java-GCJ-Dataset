import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    private final StringBuilder buffer = new StringBuilder(16384);

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    void solve() throws IOException {
        InputReader reader = new InputReader(System.in);
        int T = reader.nextInt();

        for (int t = 0; t < T; ++t) {
            int N = reader.nextInt();
            int trace = reader.nextInt();

            SudokuPuzzle puzzle = new SudokuPuzzle(N);
            fillInAsManyPossibleForTrace(N, puzzle, trace);

            SudokuSolution solution = new BacktrackingSudokuSolver().solve(puzzle);
            if (solution.isSolved()) {
                buffer.append(String.format("Case #%d: POSSIBLE\n", t + 1));
                int[][] solvedGrid = solution.getSolvedPuzzle().getGrid();
                for (int r = 0; r < N; ++r) {
                    for (int c = 0; c < N; ++c) {
                        if (c > 0) buffer.append(' ');
                        buffer.append(solvedGrid[r][c]);
                    }
                    buffer.append('\n');
                }
            } else {
                buffer.append(String.format("Case #%d: IMPOSSIBLE\n", t + 1));
            }
        }
        System.out.print(buffer);
    }

    private void fillInAsManyPossibleForTrace(int N, SudokuPuzzle puzzle, int trace) {
        int placed = 0;

        while (trace > 0) {
            int spotsLeft = N - placed;

            if (trace == spotsLeft) {
                for (int n = placed; n < N; ++n) {
                    puzzle.setCell(n, n, 1);
                }
                trace = 0;
            } else if (spotsLeft == 1) {
                puzzle.setCell(placed, placed, trace);
                trace = 0;
            } else {
                int place = Math.min(N, trace - spotsLeft);
                puzzle.setCell(placed, placed, place);
                trace -= place;
                ++placed;
            }
        }
    }

    private static class BacktrackingSudokuSolver {
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
            if (isSolved()) return;
            if (c == cols) {
                backtrack(r + 1, 0, puzzle);
            } else if (r == rows) {
                solution = new SudokuSolution(puzzle.getUnsolved(), new SudokuPuzzle(puzzle));
            } else if (!puzzle.needsPlacement(r, c)) {
                backtrack(r, c + 1, puzzle);
            } else {
                for (int numeral : puzzle.getPossiblePlacements(r, c)) {
                    puzzle.place(r, c, numeral);
                    backtrack(r, c + 1, puzzle);
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
        private final int dim;
        private final int[][] grid;
        private boolean prepared;
        private Set<Integer>[] rows;
        private Set<Integer>[] cols;
        private Set<Integer> possibleNumerals;
        private SudokuPuzzle unsolved;

        public SudokuPuzzle(int dim) {
            this(dim, new int[dim][dim]);
        }

        public SudokuPuzzle(SudokuPuzzle other) {
            this.dim = other.dim;
            this.grid = new int[other.dim][other.dim];
            for (int r = 0; r < other.dim; ++r) {
                System.arraycopy(other.grid[r], 0, this.grid[r], 0, other.dim);
            }
        }

        public SudokuPuzzle(int dim, int[][] grid) {
            this.dim = dim;
            this.grid = grid;
        }

        public int[][] getGrid() {
            return grid;
        }

        public int getRows() {
            return dim;
        }

        public int getCols() {
            return dim;
        }

        public SudokuPuzzle getUnsolved() {
            return unsolved;
        }

        public void setCell(int r, int c, int numeral) {
            grid[r][c] = numeral;
        }

        public boolean needsPlacement(int r, int c) {
            return grid[r][c] == 0;
        }

        public boolean canPlace(int r, int c, int numeral) {
            if (!prepared) prepareForSolution();
            return !rows[r].contains(numeral) && !cols[c].contains(numeral);
        }

        public Set<Integer> getPossiblePlacements(int r, int c) {
            if (!prepared) prepareForSolution();
            Set<Integer> possibles = new HashSet<>(possibleNumerals);
            possibles.removeAll(rows[r]);
            possibles.removeAll(cols[c]);
            return possibles;
        }

        public void place(int r, int c, int numeral) {
            if (!prepared) prepareForSolution();
            grid[r][c] = numeral;
            rows[r].add(numeral);
            cols[c].add(numeral);
        }

        public void undoPlacement(int r, int c) {
            if (!prepared) prepareForSolution();
            int numeral = grid[r][c];
            grid[r][c] = 0;
            rows[r].remove(numeral);
            cols[c].remove(numeral);
        }

        private void prepareForSolution() {
            initSolutionSets();
            initPossibleSet();
            unsolved = new SudokuPuzzle(this);
            prepared = true;
        }

        @SuppressWarnings("unchecked")
        private void initSolutionSets() {
            rows = new Set[dim];
            cols = new Set[dim];
            for (int i = 0; i < dim; ++i) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                for (int j = 0; j < dim; ++j) {
                    if (grid[i][j] != 0) rows[i].add(grid[i][j]);
                    if (grid[j][i] != 0) cols[i].add(grid[j][i]);
                }
            }
        }

        private void initPossibleSet() {
            possibleNumerals = new HashSet<>();
            for (int i = 1; i <= dim; ++i) {
                possibleNumerals.add(i);
            }
        }
    }

    class InputReader {
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