import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] schedule = new int[n][3];
            for (int j = 0; j < n; ++j) {
                schedule[j][0] = in.nextInt();
                schedule[j][1] = in.nextInt();
                schedule[j][2] = j;
            }
            quickSort(schedule, 0, n - 1);
            char[] result = new char[n];
            int cEnd = 0, jEnd = 0;

            boolean isPossible = true;
            for (int j = 0; j < n; ++j) {
                if (schedule[j][0] >= cEnd) {
                    result[schedule[j][2]] = 'C';
                    cEnd = schedule[j][1];
                } else if (schedule[j][0] >= jEnd) {
                    result[schedule[j][2]] = 'J';
                    jEnd = schedule[j][1];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + new String(result));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        in.close();
    }

    private static void quickSort(int[][] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[][] arr, int begin, int end) {
        int pivot = arr[end][1];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j][1] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}