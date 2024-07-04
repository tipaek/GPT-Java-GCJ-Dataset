import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static int[] a;
    static String s2 = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[][] matrix = new int[N][N];
            a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = i + 1;
            }

            if (solve(N, K, matrix)) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean solve(int N, int K, int[][] matrix) {
        for (int attempt = 0; attempt <= 500; attempt++) {
            generatePermutation(N);
            fillMatrix(N, matrix);
            if (checkMatrix(N, K, matrix)) {
                return true;
            }
            rotateRight(a);

            generatePermutation(N);
            fillMatrix(N, matrix);
            if (checkMatrix(N, K, matrix)) {
                return true;
            }
            rotateLeft(a);
        }
        return false;
    }

    private static void generatePermutation(int N) {
        s2 = "";
        permute(a, 0, N - 1);
    }

    private static void fillMatrix(int N, int[][] matrix) {
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = a[index++];
            }
            rotateRight(a);
        }
    }

    private static boolean checkMatrix(int N, int K, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][i];
        }
        if (sum != K) {
            return false;
        }

        for (int i = 0; i < N; i++) {
            if (!isUniqueRow(matrix[i]) || !isUniqueColumn(matrix, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueRow(int[] row) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int value : row) {
            set.add(value);
        }
        return set.size() == row.length;
    }

    private static boolean isUniqueColumn(int[][] matrix, int colIndex) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] row : matrix) {
            set.add(row[colIndex]);
        }
        return set.size() == matrix.length;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void rotateLeft(int[] array) {
        int first = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = first;
    }

    private static void rotateRight(int[] array) {
        int last = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = last;
    }

    private static void permute(int[] array, int left, int right) {
        if (left == right) {
            s2 = arrayToString(array);
        } else {
            for (int i = left; i <= right; i++) {
                swap(array, left, i);
                permute(array, left + 1, right);
                swap(array, left, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value);
        }
        return sb.toString();
    }
}