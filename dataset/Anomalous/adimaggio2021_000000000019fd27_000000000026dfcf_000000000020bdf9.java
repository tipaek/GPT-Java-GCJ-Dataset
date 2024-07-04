import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            boolean isPossible = true;
            int[][] intervals = new int[x][2];
            int[] order = new int[24 * 60 + 1];

            for (int i = 0; i < x; i++) {
                intervals[i][0] = in.nextInt();
                order[intervals[i][0]] = i;
                intervals[i][1] = in.nextInt();
            }

            char[] assignments = new char[x];
            for (int i = 0; i < x; i++) {
                assignments[i] = 't';
            }

            sort(intervals, 0, x - 1);
            int cEndTime = -1;
            int jEndTime = -1;
            String result = "";

            for (int i = 0; i < x; i++) {
                if (intervals[i][0] >= cEndTime) {
                    cEndTime = -1;
                }
                if (intervals[i][0] >= jEndTime) {
                    jEndTime = -1;
                }

                if (cEndTime == -1) {
                    cEndTime = intervals[i][1];
                    assignments[order[intervals[i][0]]] = 'C';
                } else if (jEndTime == -1) {
                    jEndTime = intervals[i][1];
                    assignments[order[intervals[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = 0; i < x; i++) {
                    if (assignments[i] == 't') {
                        assignments[i] = (assignments[i + 1] == 'C') ? 'J' : 'C';
                    }
                    result += assignments[i];
                }
                System.out.println("Case #" + (m + 1) + ": " + result);
            }
        }
    }

    static void merge(int[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        for (int i = 0; i < n1; ++i) {
            L[i][0] = arr[l + i][0];
            L[i][1] = arr[l + i][1];
        }
        for (int j = 0; j < n2; ++j) {
            R[j][0] = arr[m + 1 + j][0];
            R[j][1] = arr[m + 1 + j][1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
                arr[k][0] = L[i][0];
                arr[k][1] = L[i][1];
                i++;
            } else {
                arr[k][0] = R[j][0];
                arr[k][1] = R[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k][0] = L[i][0];
            arr[k][1] = L[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k][0] = R[j][0];
            arr[k][1] = R[j][1];
            j++;
            k++;
        }
    }

    static void sort(int[][] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}