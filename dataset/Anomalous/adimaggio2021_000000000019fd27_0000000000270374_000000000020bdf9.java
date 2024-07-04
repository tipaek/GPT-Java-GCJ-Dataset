import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            boolean possible = true;
            int[][] tasks = new int[x][2];
            int[] originalOrder = new int[24 * 60 + 1];
            char[] assignments = new char[x];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < x; i++) {
                tasks[i][0] = in.nextInt();
                originalOrder[tasks[i][0]] = i;
                tasks[i][1] = in.nextInt();
                assignments[i] = 't';
            }

            sort(tasks, 0, x - 1);

            int endC = -1, endJ = -1;

            for (int i = 0; i < x; i++) {
                if (tasks[i][0] >= endC) {
                    endC = -1;
                }
                if (tasks[i][0] >= endJ) {
                    endJ = -1;
                }

                if (endC == -1) {
                    endC = tasks[i][1];
                    assignments[originalOrder[tasks[i][0]]] = 'C';
                } else if (endJ == -1) {
                    endJ = tasks[i][1];
                    assignments[originalOrder[tasks[i][0]]] = 'J';
                } else {
                    System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + (m + 1) + ": " + result);
            }
        }
    }

    static void merge(int[][] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            L[i][0] = arr[left + i][0];
            L[i][1] = arr[left + i][1];
        }
        for (int j = 0; j < n2; j++) {
            R[j][0] = arr[middle + 1 + j][0];
            R[j][1] = arr[middle + 1 + j][1];
        }

        int i = 0, j = 0, k = left;
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

    static void sort(int[][] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
}