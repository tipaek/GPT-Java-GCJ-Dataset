import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int j = 0; j < n; j++) {
                start[j] = scanner.nextInt();
                end[j] = scanner.nextInt();
            }

            quickSort(start, end, 0, n - 1);
            List<String> schedule = new ArrayList<>();
            schedule.add("J");

            if (n == 1) {
                System.out.println(Arrays.toString(schedule.toArray()));
                continue;
            }

            if (n == 2) {
                schedule.add("C");
                System.out.println(Arrays.toString(schedule.toArray()));
                continue;
            }

            if ((start[0] < start[1] && start[0] < start[2]) && (end[0] > end[1] && end[0] > end[2])) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            for (int j = 1; j < n; j++) {
                if (noOverlap(start, end, j, j - 1)) {
                    schedule.add(schedule.get(j - 1));
                } else {
                    schedule.add(schedule.get(j - 1).equals("C") ? "J" : "C");
                }
            }

            System.out.println(Arrays.toString(schedule.toArray()));
        }
    }

    private static void quickSort(int[] arr, int[] arr1, int low, int high) {
        if (low < high) {
            int pi = partition(arr, arr1, low, high);
            quickSort(arr, arr1, low, pi - 1);
            quickSort(arr, arr1, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int[] arr1, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                swap(arr1, i, j);
            }
        }

        swap(arr, i + 1, high);
        swap(arr1, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean noOverlap(int[] start, int[] end, int cur, int prev) {
        return start[cur] > end[prev];
    }
}