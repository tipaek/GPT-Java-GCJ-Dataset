import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int intervals = scanner.nextInt();
            int[][] tasks = new int[intervals][2];
            int[] order = new int[24 * 60 + 1];
            boolean possible = true;

            for (int i = 0; i < intervals; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                order[tasks[i][0]] = i;
            }

            if (possible) {
                char[] schedule = new char[intervals];
                mergeSort(tasks, 0, intervals - 1);
                int cEnd = tasks[0][1];
                int jEnd = -1;
                String result = "";
                schedule[order[tasks[0][0]]] = 'C';

                for (int i = 1; i < intervals; i++) {
                    if (tasks[i][0] >= cEnd) {
                        cEnd = -1;
                    }
                    if (tasks[i][0] >= jEnd) {
                        jEnd = -1;
                    }
                    if (cEnd == -1) {
                        cEnd = tasks[i][1];
                        schedule[order[tasks[i][0]]] = 'C';
                    } else if (jEnd == -1) {
                        jEnd = tasks[i][1];
                        schedule[order[tasks[i][0]]] = 'J';
                    } else {
                        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    for (char c : schedule) {
                        result += c;
                    }
                    System.out.println("Case #" + (t + 1) + ": " + result);
                }
            }
        }
    }

    static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            leftArray[i][0] = arr[left + i][0];
            leftArray[i][1] = arr[left + i][1];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j][0] = arr[mid + 1 + j][0];
            rightArray[j][1] = arr[mid + 1 + j][1];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][0] <= rightArray[j][0]) {
                arr[k][0] = leftArray[i][0];
                arr[k][1] = leftArray[i][1];
                i++;
            } else {
                arr[k][0] = rightArray[j][0];
                arr[k][1] = rightArray[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k][0] = leftArray[i][0];
            arr[k][1] = leftArray[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k][0] = rightArray[j][0];
            arr[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }
}