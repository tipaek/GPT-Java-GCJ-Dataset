import java.util.*;

class TestCase {
    private int[][] bigArr;
    private int n;
    private int[] rowArr;
    private int factorial;
    private static int rowCount;

    public TestCase(int n, int[] rowArr) {
        this.n = n;
        this.rowArr = rowArr;
        this.factorial = factorial(n);
        this.bigArr = new int[factorial][n];
        rowCount = 0;
    }

    private static int factorial(int n) {
        if (n < 3) return n;
        return n * factorial(n - 1);
    }

    public void permute() {
        permuteHelper(rowArr, 0, n);
    }

    private void permuteHelper(int[] arr, int index, int n) {
        if (index >= n - 1) {
            for (int i = 0; i < n; i++) {
                bigArr[rowCount][i] = arr[i];
            }
            rowCount++;
            return;
        }

        for (int i = index; i < n; i++) {
            swap(arr, index, i);
            permuteHelper(arr, index + 1, n);
            swap(arr, index, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printMatrix() {
        for (int i = 0; i < factorial; i++) {
            System.out.println(Arrays.toString(bigArr[i]));
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        TestCase[] testCases = new TestCase[t];

        for (int h = 1; h <= t; h++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (j + 1 + i) / (n + 1) + (j + 1 + i) % (n + 1);
                }
            }

            System.out.print("Case #" + h + ": ");
            int[] brr = new int[n];
            for (int i = 0; i < n; i++) {
                brr[i] = i;
            }

            testCases[h - 1] = new TestCase(n, brr);
            testCases[h - 1].permute();

            boolean found = false;
            for (int p = 0; p < testCases[h - 1].factorial; p++) {
                int sum = 0;
                for (int d = 0; d < n; d++) {
                    sum += arr[testCases[h - 1].bigArr[p][d]][d];
                }
                if (sum == k) {
                    System.out.println("POSSIBLE");
                    for (int g = 0; g < n; g++) {
                        int temp = testCases[h - 1].bigArr[p][g];
                        for (int u = 0; u < n; u++) {
                            System.out.print(arr[temp][u] + " ");
                        }
                        System.out.println();
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}