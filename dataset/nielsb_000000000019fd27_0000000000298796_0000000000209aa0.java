import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            new Solution(scanner).solve();
        }
    }

    final int N, K;

    public Solution(Scanner scanner) {
        N = scanner.nextInt();
        K = scanner.nextInt();
    }

    private void solve() {
        if (K == N + 1 || K == N * N - 1 || N == 3 && K == 5 || N == 3 && K == 7) {
            System.out.println("IMPOSSIBLE");
            return;
        } else {
            System.out.println("POSSIBLE");
        }

        int[][] square = createLatinSquare(N, K);
        print(square);
    }

    public int[][] createLatinSquare(int n, int k) {
        if (k % n == 0) {
            int[][] square = createLatinSquareWithOnesOnDiagonal(n);
            return swap(1, k / n, square);

        } else if ((k % n == 2 || k % n == n - 2) && n % 2 == 0) {
            int[][] square = createLatinSquareWithOnesOnDiagonal(n);
            square = swapRows(0, n / 2, square);
            int mainDiagonalElement = 1, secondDiagonalElement = n / 2 + 1;

            if (k % n == 2) {
                int d = k / n;
                square = swap(mainDiagonalElement, d, square);
                if (secondDiagonalElement == d)
                    secondDiagonalElement = mainDiagonalElement;

                square = swap(secondDiagonalElement, d + 1, square);
            } else {
                int d = k / n + 1;
                square = swap(mainDiagonalElement, d, square);
                if (secondDiagonalElement == d)
                    secondDiagonalElement = mainDiagonalElement;

                square = swap(secondDiagonalElement, d - 1, square);
            }
            return square;

        } else if ((k == n + 2 || k == n * n - 2) && n % 2 == 1) {
            int[][] square = createLatinSquareWithOnesOnDiagonal(n);
            square[0][0] = 2;
            square[0][1] = 1;
            square[0][2] = 3;
            square[1][0] = 1;
            square[1][1] = 2;
            square[1][2] = n;
            square[2][1] = n;
            square[3][0] = n;
            int c = 0;
            for (int i = 2; i < n - 2; i ++) {
                square[i][c] = n + 1- i;
                if ((n + 1 - i) % 2 == 0) {
                    c += 2;
                } else {
                    c++;
                }
                c %= 3;
                square[i+1][c] = n + 1- i;
                if ((n + 1 - i) % 2 == 0) {
                    c += 2;
                } else {
                    c++;
                }
                c %= 3;
                square[i+2][c] = n + 1- i;
            }
            square[n-2][1] = 3;
            square[n-1][0] = 3;
            square[n-1][2] = 2;

            if (k == n * n - 2) {
                square = swap(1, n, square);
                square = swap(2, n - 1, square);
            }
            return square;

        } else {
            int[][] square = createLatinSquareWithOnesOnDiagonal(n);
            square = swapRows(0, 1, square);
            int mainDiagonalElement = 1, secondDiagonalElement = 2, thirdDiagonalElement = n;

            int[] m = findMultipliers(n, k);
            square = swap(mainDiagonalElement, m[0], square);
            if (secondDiagonalElement == m[0])
                secondDiagonalElement = mainDiagonalElement;
            if (thirdDiagonalElement == m[0])
                thirdDiagonalElement = mainDiagonalElement;

            square = swap(secondDiagonalElement, m[1], square);
            if (thirdDiagonalElement == m[1])
                thirdDiagonalElement = secondDiagonalElement;

            square = swap(thirdDiagonalElement, m[2], square);
            return square;
        }
    }

    private int[] findMultipliers(int n, int k) {
        boolean inverse = false;
        if (k > (n + n * n) / 2) {
            k = (n + n * n) - k;
            inverse = true;
        }
        int b, c;
        int d = k / n;
        int r = k % n;
        if (r <= 2 && d > 1) {
            d--;
        }
        if ((n - 2) * d + (d + 1) + n >= k) {
            b = d + 1;
            c = k - ((n - 2) * d + (d + 1));
        } else {
            b = k - ((n - 2) * d + n);
            c = n;
        }
        if (inverse) {
            d = n + 1 - d;
            b = n + 1 - b;
            c = n + 1 - c;
        }
        if (d < 1 || d > n || b < 1 || b > n || c < 1 || c > n)
            throw new RuntimeException("d = 0");

        return new int[]{d, b, c};
    }

    private int[][] swapRows(int a, int b, int[][] square) {
        int[] temp = square[a];
        square[a] = square[b];
        square[b] = temp;
        return square;
    }

    private int[][] createLatinSquareWithOnesOnDiagonal(int n) {
        int[][] square = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = (j - i + n) % n + 1;
            }
        }
        return square;
    }

    private int[][] swap(int a, int b, int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (square[i][j] == a) {
                    square[i][j] = b;
                } else if (square[i][j] == b) {
                    square[i][j] = a;
                }
            }
        }
        return square;
    }

    private static void print(int[][] square) {
        for (int[] row : square) {
            String s = Arrays.stream(row)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(s);
        }
    }

}
