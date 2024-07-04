import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n + 1][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (hasDuplicates(arr[i], 1, n)) {
                    rowRepeats++;
                }
            }

            for (int j = 1; j <= n; j++) {
                int[] column = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    column[i] = arr[i][j];
                }
                if (hasDuplicates(column, 1, n)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            t--;
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array, int start, int end) {
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (seen.contains(array[i])) {
                return true;
            }
            seen.add(array[i]);
        }
        return false;
    }
}