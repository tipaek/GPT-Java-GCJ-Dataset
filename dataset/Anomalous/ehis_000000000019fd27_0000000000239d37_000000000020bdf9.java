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
            if (currentParent.equals("C")) {
                boolean conflict = false;
                for (int j = 0; j < cStartTimes.size(); j++) {
                    if ((startTimes[i] < cEndTimes.get(j) && startTimes[i] >= cStartTimes.get(j)) ||
                        (endTimes[i] > cStartTimes.get(j) && endTimes[i] <= cEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "J";
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    result.append("C");
                    changeCount = 0;
                    cStartTimes.add(startTimes[i]);
                    cEndTimes.add(endTimes[i]);
                } else {
                    i--;
                }
            } else {
                boolean conflict = false;
                for (int j = 0; j < jStartTimes.size(); j++) {
                    if ((startTimes[i] < jEndTimes.get(j) && startTimes[i] >= jStartTimes.get(j)) ||
                        (endTimes[i] > jStartTimes.get(j) && endTimes[i] <= jEndTimes.get(j))) {
                        changeCount++;
                        currentParent = "C";
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    result.append("J");
                    changeCount = 0;
                    jStartTimes.add(startTimes[i]);
                    jEndTimes.add(endTimes[i]);
                } else {
                    i--;
                }
            }

            if (changeCount >= 2) {
                System.out.println("Case #" + iteration + ": IMPOSSIBLE");
                return;
            } else {
                taskCount++;
            }
        }

        System.out.println("Case #" + iteration + ": " + result);
    }
}