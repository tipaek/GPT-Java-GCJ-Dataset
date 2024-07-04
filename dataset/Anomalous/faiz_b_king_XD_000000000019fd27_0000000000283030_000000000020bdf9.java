import java.util.Scanner;

class Solution {

    private static int partition(int[][] array, int low, int high) {
        int pivot = array[high][0];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j][0] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[][] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
            int cameronEnd = intervals[0][1];
            int jamieEnd = 0;
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= cameronEnd) {
                    result.append('C');
                    cameronEnd = intervals[i][1];
                } else if (intervals[i][0] >= jamieEnd) {
                    result.append('J');
                    jamieEnd = intervals[i][1];
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