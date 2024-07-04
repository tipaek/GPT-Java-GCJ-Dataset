import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = input.nextInt();
                endTimes[i] = input.nextInt();
            }

            solve(startTimes, endTimes, N, ks);
        }

        input.close();
    }

    public static void solve(int[] startTimes, int[] endTimes, int N, int iteration) {
        StringBuilder result = new StringBuilder("C");
        String currentParent = "C";

        List<Integer> cStartTimes = new ArrayList<>();
        List<Integer> cEndTimes = new ArrayList<>();
        List<Integer> jStartTimes = new ArrayList<>();
        List<Integer> jEndTimes = new ArrayList<>();

        cStartTimes.add(startTimes[0]);
        cEndTimes.add(endTimes[0]);

        int taskCount = 1;
        int changeCount = 0;

        for (int i = 1; i < N; i++) {
            boolean taskAssigned = false;
            if (currentParent.equals("C")) {
                for (int j = 0; j < cStartTimes.size(); j++) {
                    if (conflicts(startTimes[i], endTimes[i], cStartTimes.get(j), cEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "J";
                        taskAssigned = true;
                        break;
                    }
                }
                if (!taskAssigned) {
                    result.append("C");
                    changeCount = 0;
                    cStartTimes.add(startTimes[i]);
                    cEndTimes.add(endTimes[i]);
                }
            } else {
                for (int j = 0; j < jStartTimes.size(); j++) {
                    if (conflicts(startTimes[i], endTimes[i], jStartTimes.get(j), jEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "C";
                        taskAssigned = true;
                        break;
                    }
                }
                if (!taskAssigned) {
                    result.append("J");
                    changeCount = 0;
                    jStartTimes.add(startTimes[i]);
                    jEndTimes.add(endTimes[i]);
                }
            }

            if (taskAssigned) {
                i--;
            } else {
                taskCount++;
            }

            if (changeCount >= 2) {
                System.out.println("Case #" + iteration + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + iteration + ": " + result);
    }

    private static boolean conflicts(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start1 >= start2) ||
               (end1 > start2 && end1 <= end2) ||
               (start1 <= start2 && end1 >= end2) ||
               (start1 >= start2 && end1 <= end2);
    }
}