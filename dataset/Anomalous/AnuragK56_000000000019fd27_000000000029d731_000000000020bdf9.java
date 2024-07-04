import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] time = new int[n][4];

            for (int i = 0; i < n; i++) {
                time[i][0] = sc.nextInt(); // start time
                time[i][1] = sc.nextInt(); // end time
                time[i][2] = i + 1;        // original index
                time[i][3] = -1;           // to store assignment (C or J)
            }

            // Sort the activities based on start time
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0 && time[j][0] < time[j - 1][0]; j--) {
                    swap(time, j, j - 1);
                }
            }

            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (cEnd <= time[i][0]) {
                    cEnd = time[i][1];
                    time[i][3] = 0; // Assigned to C
                } else if (jEnd <= time[i][0]) {
                    jEnd = time[i][1];
                    time[i][3] = 1; // Assigned to J
                } else {
                    possible = false;
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            // Sort back based on the original index
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0 && time[j][2] < time[j - 1][2]; j--) {
                    swap(time, j, j - 1);
                }
            }

            if (possible) {
                for (int i = 0; i < n; i++) {
                    result.append(time[i][3] == 0 ? 'C' : 'J');
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}