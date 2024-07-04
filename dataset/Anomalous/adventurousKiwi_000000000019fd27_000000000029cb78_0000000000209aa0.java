import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    private List<int[][]> matrices;

    public Solution() {
        matrices = new ArrayList<>();
    }

    public static int[] shiftLeft(int[] arr, int n) {
        if (n == 0) return arr;
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < n; i++) {
            int temp = newArr[0];
            System.arraycopy(newArr, 1, newArr, 0, arr.length - 1);
            newArr[arr.length - 1] = temp;
        }
        return newArr;
    }

    public static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public static int[] shiftRight(int[] arr, int n) {
        if (n == 0) return arr;
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < n; i++) {
            int temp = newArr[arr.length - 1];
            System.arraycopy(newArr, 0, newArr, 1, arr.length - 1);
            newArr[0] = temp;
        }
        return newArr;
    }

    public static int[][] findMatrix(int[] row) {
        int N = row.length;
        int[][] matrix = new int[N][N];
        System.arraycopy(row, 0, matrix[0], 0, N);
        for (int i = 1; i < N; i++) {
            row = shiftLeft(row, 1);
            System.arraycopy(row, 0, matrix[i], 0, N);
        }
        return matrix;
    }

    public static int[][] findMatrixRight(int[] row) {
        int N = row.length;
        int[][] matrix = new int[N][N];
        System.arraycopy(row, 0, matrix[0], 0, N);
        for (int i = 1; i < N; i++) {
            row = shiftRight(row, 1);
            System.arraycopy(row, 0, matrix[i], 0, N);
        }
        return matrix;
    }

    public static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public void printAllRecursive(int n, int[] elements, int t) {
        if (this.matrices.size() == 1) {
            return;
        }
        if (n == 1) {
            int[][] matrix = findMatrix(elements);
            int trace = Arrays.stream(matrix).mapToInt(row -> row[matrix.length - row.length]).sum();
            if (trace == t) {
                this.matrices.add(matrix);
            } else {
                matrix = findMatrixRight(elements);
                trace = Arrays.stream(matrix).mapToInt(row -> row[matrix.length - row.length]).sum();
                if (trace == t) {
                    this.matrices.add(matrix);
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements, t);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements, t);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int trace = sc.nextInt();
            Solution ind = new Solution();
            int[] all = new int[N];
            for (int j = 0; j < N; j++) {
                all[j] = j + 1;
            }
            ind.printAllRecursive(N, all, trace);

            if (ind.matrices.size() == 1) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                int[][] mat = ind.matrices.get(0);
                for (int[] row : mat) {
                    for (int j = 0; j < row.length; j++) {
                        if (j == row.length - 1) {
                            System.out.println(row[j]);
                        } else {
                            System.out.print(row[j] + " ");
                        }
                    }
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}