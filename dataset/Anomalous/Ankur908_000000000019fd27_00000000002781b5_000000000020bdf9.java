import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scan.nextInt();

        for (int k = 0; k < testCases; k++) {
            int n = scan.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] job1 = new int[1441];
            int[] job2 = new int[1441];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scan.nextInt();
                endTimes[i] = scan.nextInt();
            }

            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                boolean conflictWithJob1 = false;
                boolean conflictWithJob2 = false;

                for (int i = startTimes[j]; i < endTimes[j]; i++) {
                    if (job1[i] == 1) {
                        conflictWithJob1 = true;
                    }
                    if (job2[i] == 1) {
                        conflictWithJob2 = true;
                    }
                }

                if (conflictWithJob1 && conflictWithJob2) {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    System.out.println("Case #" + (k + 1) + ": " + result);
                    isImpossible = true;
                    break;
                } else if (!conflictWithJob1) {
                    for (int i = startTimes[j]; i < endTimes[j]; i++) {
                        job1[i] = 1;
                    }
                    result.append('C');
                } else if (!conflictWithJob2) {
                    for (int i = startTimes[j]; i < endTimes[j]; i++) {
                        job2[i] = 1;
                    }
                    result.append('J');
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (k + 1) + ": " + result);
            }
        }

        scan.close();
    }
}