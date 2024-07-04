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
    }

    public static void solve(int[] startTimes, int[] endTimes, int taskCount, int caseNumber) {
        StringBuilder result = new StringBuilder("C");
        String currentParent = "C";

        List<Integer> cStartTimes = new ArrayList<>();
        List<Integer> cEndTimes = new ArrayList<>();
        List<Integer> jStartTimes = new ArrayList<>();
        List<Integer> jEndTimes = new ArrayList<>();

        cStartTimes.add(startTimes[0]);
        cEndTimes.add(endTimes[0]);

        int possibleTasks = 1;
        int changes = 0;

        for (int i = 1; i < taskCount; i++) {
            if (currentParent.equals("C")) {
                if (isOverlapping(startTimes[i], endTimes[i], cStartTimes, cEndTimes)) {
                    changes++;
                    currentParent = "J";
                    i--;
                } else {
                    result.append("C");
                    changes = 0;
                    cStartTimes.add(startTimes[i]);
                    cEndTimes.add(endTimes[i]);
                }
            } else {
                if (isOverlapping(startTimes[i], endTimes[i], jStartTimes, jEndTimes)) {
                    changes++;
                    currentParent = "C";
                    i--;
                } else {
                    result.append("J");
                    changes = 0;
                    jStartTimes.add(startTimes[i]);
                    jEndTimes.add(endTimes[i]);
                }
            }

            if (changes >= 2) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else {
                possibleTasks++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static boolean isOverlapping(int start, int end, List<Integer> startTimes, List<Integer> endTimes) {
        for (int j = 0; j < startTimes.size(); j++) {
            if ((start < endTimes.get(j) && start > startTimes.get(j)) || (end > startTimes.get(j) && end < endTimes.get(j))) {
                return true;
            }
        }
        return false;
    }
}