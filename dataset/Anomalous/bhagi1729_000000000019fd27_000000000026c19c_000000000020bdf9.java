import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                indices[i] = i;
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            // Sort intervals by start time using selection sort
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (startTimes[j] < startTimes[minIndex]) {
                        minIndex = j;
                    }
                }
                swap(startTimes, i, minIndex);
                swap(endTimes, i, minIndex);
                swap(indices, i, minIndex);
            }

            int[] duties = new int[2]; // duties[0] for C, duties[1] for J
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= duties[0]) {
                    duties[0] = endTimes[i];
                    schedule.append('C');
                } else if (startTimes[i] >= duties[1]) {
                    duties[1] = endTimes[i];
                    schedule.append('J');
                } else {
                    impossible = true;
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[indices[i]] = schedule.charAt(i);
                }
                schedule = new StringBuilder(new String(result));
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
            caseNumber++;
        }

        sc.close();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}