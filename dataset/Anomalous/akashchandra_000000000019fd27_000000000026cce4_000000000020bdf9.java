import java.util.*;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        int caseNumber = 1;

        while (t1-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] positions = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                positions[i] = i;
            }

            // Sorting based on start times
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (startTimes[j] < startTimes[minIndex]) {
                        minIndex = j;
                    }
                }
                // Swap start times
                int temp = startTimes[minIndex];
                startTimes[minIndex] = startTimes[i];
                startTimes[i] = temp;

                // Swap end times
                temp = endTimes[minIndex];
                endTimes[minIndex] = endTimes[i];
                endTimes[i] = temp;

                // Swap positions
                temp = positions[minIndex];
                positions[minIndex] = positions[i];
                positions[i] = temp;
            }

            int jcEnd = 0, ccEnd = 0;
            char[] assignments = new char[n];
            String result = "";

            for (int i = 0; i < n; i++) {
                if (jcEnd <= startTimes[i]) {
                    jcEnd = endTimes[i];
                    assignments[positions[i]] = 'J';
                } else if (ccEnd <= startTimes[i]) {
                    ccEnd = endTimes[i];
                    assignments[positions[i]] = 'C';
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (result.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                for (char c : assignments) {
                    result += c;
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            }
            caseNumber++;
        }
    }
}