import java.util.*;

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

            // Sort based on start times
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

            int[] duties = new int[2]; // duties[0] for Cameron, duties[1] for Jamie
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
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[indices[i]] = schedule.charAt(i);
                }
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            }

            caseNumber++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}