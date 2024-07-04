import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int j = 0; j < T; j++) {
            boolean possible = false;
            int N = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] arr = IntStream.rangeClosed(1, N).toArray();
            List<List<Integer>> permutations = new ArrayList<>();
            generateSubsets(arr, permutations, N, sum, "");
            for (List<Integer> diag : permutations) {
                int[][] grid = new int[N][N];
                for (int i = 0; i < N; i++) {
                    grid[i][i] = diag.get(i);
                }
                Sudoku sudoku = new Sudoku(grid, N);

                if (sudoku.solve()) {
                    System.out.println("Case #" + T + ": POSSIBLE");
                    sudoku.display();
                    possible = true;
                    break;
                }
            }
            if (!possible) {
                System.out.println("Case #" + T + ": IMPOSSIBLE");
            }
        }
    }

    private static void generateSubsets(int[] arr, List<List<Integer>> permutations, int N, int sum, String result) {
        List<Integer> subset = new ArrayList<>();
        if (sum == 0 && result.length() == 2 * N) {
            for (String num : result.split(" ")) {
                subset.add(Integer.parseInt(num));
            }
            permutations.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (sum >= arr[i]) {
                generateSubsets(arr, permutations, N, sum - arr[i], result + arr[i] + " ");
            }
        }
    }
}

class Sudoku {

    private int[][] board;
    public static final int EMPTY = 0;
    public static int SIZE;

    public Sudoku(int[][] board, int size) {
        SIZE = size;
        this.board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number);
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            board[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}