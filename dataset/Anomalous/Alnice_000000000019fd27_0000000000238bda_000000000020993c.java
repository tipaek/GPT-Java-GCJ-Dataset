import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int[] columnSums = new int[N];
            int[] rowSums = new int[N];
            long trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    if (i == j) {
                        trace += value;
                    }
                    columnSums[j] += value;
                    rowSums[i] += value;
                }
            }

            int duplicateColumns = 0;
            int duplicateRows = 0;
            int expectedSum = (N * (N + 1)) / 2;

            for (int i = 0; i < N; i++) {
                if (columnSums[i] != expectedSum) {
                    duplicateColumns++;
                }
                if (rowSums[i] != expectedSum) {
                    duplicateRows++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}