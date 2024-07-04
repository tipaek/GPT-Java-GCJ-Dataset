import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] tasks = new int[N][3];
            for (int j = 0; j < N; j++) {
                tasks[j][0] = scanner.nextInt(); // Start time
                tasks[j][1] = scanner.nextInt(); // End time
                tasks[j][2] = j; // Original index
            }
            insertionSort(tasks);
            boolean[] isOccupied = new boolean[2]; // Tracks whether C or J is occupied
            int[] endTime = new int[2]; // Tracks end times for C and J
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < N; j++) {
                if (tasks[j][0] >= endTime[0]) {
                    isOccupied[0] = false;
                }
                if (tasks[j][0] >= endTime[1]) {
                    isOccupied[1] = false;
                }
                if (isOccupied[0] && isOccupied[1]) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                if (!isOccupied[0]) {
                    endTime[0] = tasks[j][1];
                    result.append('C');
                    isOccupied[0] = true;
                } else if (!isOccupied[1]) {
                    endTime[1] = tasks[j][1];
                    result.append('J');
                    isOccupied[1] = true;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + (i + 1) + ": ");
                char[] output = new char[N];
                for (int j = 0; j < N; j++) {
                    output[tasks[j][2]] = result.charAt(j);
                }
                System.out.println(new String(output));
            }
        }
        scanner.close();
    }

    public static void insertionSort(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            int[] key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j][0] > key[0]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}