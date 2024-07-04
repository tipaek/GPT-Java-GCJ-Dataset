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

            boolean possible = false;
            for (int attempt = 0; attempt <= 500; attempt++) {
                if (attempt > 0) {
                    permuteAndRotate();
                }

                fillMatrix(matrix, N);
                if (isMagicSquare(matrix, N, K)) {
                    possible = true;
                    System.out.println("Case #" + caseNum + ": POSSIBLE");
                    printMatrix(matrix, N);
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    static void permuteAndRotate() {
        s2 = "";
        for (int i = 0; i < a.length; i++) {
            s2 += a[i];
        }
        permute(s2, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            a[i] = Character.getNumericValue(s2.charAt(i));
        }
        s2 = "";
    }

    static void fillMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(a, 0, matrix[i], 0, N);
            rotateLeft(a);
        }
    }

    static boolean isMagicSquare(int[][] matrix, int N, int K) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += matrix[i][i];
        }
        if (sum != K) {
            return false;
        }

        for (int i = 0; i < N; i++) {
            TreeSet<Integer> rowSet = new TreeSet<>();
            TreeSet<Integer> colSet = new TreeSet<>();
            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != N || colSet.size() != N) {
                return false;
            }
        }
        return true;
    }

    static void rotateLeft(int[] array) {
        int temp = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = temp;
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            s2 = str;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void printMatrix(int[][] matrix, int N) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}