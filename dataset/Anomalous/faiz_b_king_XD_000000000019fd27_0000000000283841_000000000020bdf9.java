import java.util.Scanner;

class Solution {
    static int partition(int[][] arr, int low, int high) {
        int pivot = arr[high][0];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j][0] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            quickSort(intervals, 0, n - 1);
            StringBuilder result = new StringBuilder("C");
            int currentC = 0, currentJ = -1;
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[currentC][1]) {
                    result.append("C");
                    currentC = i;
                } else if (currentJ == -1 || intervals[i][0] >= intervals[currentJ][1]) {
                    result.append("J");
                    currentJ = i;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
        sc.close();
    }
}