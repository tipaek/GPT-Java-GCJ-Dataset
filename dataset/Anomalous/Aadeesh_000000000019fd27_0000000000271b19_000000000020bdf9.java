import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; ++k) {
            int N = in.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }

            String result = assignActivities(N, startTimes, endTimes);
            System.out.println("Case #" + k + ": " + result);
        }
    }

    private static String assignActivities(int N, int[] startTimes, int[] endTimes) {
        List<Integer> jStartTimes = new ArrayList<>();
        List<Integer> jEndTimes = new ArrayList<>();
        List<Integer> cStartTimes = new ArrayList<>();
        List<Integer> cEndTimes = new ArrayList<>();

        StringBuilder schedule = new StringBuilder("J");

        jStartTimes.add(startTimes[0]);
        jEndTimes.add(endTimes[0]);

        for (int i = 1; i < N; i++) {
            boolean canAssignJ = canAssign(startTimes[i], endTimes[i], jStartTimes, jEndTimes);
            boolean canAssignC = canAssign(startTimes[i], endTimes[i], cStartTimes, cEndTimes);

            if (canAssignC) {
                schedule.append("C");
                cStartTimes.add(startTimes[i]);
                cEndTimes.add(endTimes[i]);
            } else if (canAssignJ) {
                schedule.append("J");
                jStartTimes.add(startTimes[i]);
                jEndTimes.add(endTimes[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssign(int start, int end, List<Integer> startTimes, List<Integer> endTimes) {
        for (int i = 0; i < startTimes.size(); i++) {
            if (!(start >= endTimes.get(i) || end <= startTimes.get(i))) {
                return false;
            }
        }
        return true;
    }
}