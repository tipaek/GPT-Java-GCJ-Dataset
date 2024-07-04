import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static int[] array;
    static String permutedString = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[][] matrix = new int[N][N];
            boolean[][] booleanMatrix = new boolean[N][N];
            int iterations = 0;
            array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = i + 1;
            }

            int permutationCount = 0;
            while (iterations++ <= 200) {
                permutedString = "";
                for (int i = 0; i < N; i++) {
                    permutedString += array[i];
                }
                permute(permutedString, 0, N - 1);
                for (int i = 0; i < N; i++) {
                    array[i] = Integer.parseInt(String.valueOf(permutedString.charAt(i)));
                }

                permutationCount++;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = array[j];
                    }
                    rotateRight(array);
                }

                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += matrix[i][i];
                }

                if (sum == K) {
                    if (isValidMatrix(matrix, N)) {
                        System.out.println("Case #" + caseNumber + ": POSSIBLE");
                        printMatrix(matrix, N);
                        continue;
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    static void rotateLeft(int[] array) {
        int temp = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = temp;
    }

    static void rotateRight(int[] array) {
        int temp = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = temp;
    }

    private static void permute(String str, int left, int right) {
        if (left == right) {
            permutedString = str;
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right);
                str = swap(str, left, i);
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

    private static boolean isValidMatrix(int[][] matrix, int N) {
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

    private static void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}