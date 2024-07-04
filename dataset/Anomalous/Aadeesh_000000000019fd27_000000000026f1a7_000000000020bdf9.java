import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int k = 1; k <= t; ++k) {
            int N = scanner.nextInt();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            List<Integer> jStartTimes = new ArrayList<>();
            List<Integer> jEndTimes = new ArrayList<>();
            List<Integer> cStartTimes = new ArrayList<>();
            List<Integer> cEndTimes = new ArrayList<>();
            StringBuilder result = new StringBuilder("J");

            jStartTimes.add(startTimes[0]);
            jEndTimes.add(endTimes[0]);

            for (int i = 1; i < N; i++) {
                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int j = 0; j < jStartTimes.size(); j++) {
                    if (!(startTimes[i] >= jEndTimes.get(j) || endTimes[i] <= jStartTimes.get(j))) {
                        canAssignToJ = false;
                        break;
                    }
                }

                for (int j = 0; j < cStartTimes.size(); j++) {
                    if (!(startTimes[i] >= cEndTimes.get(j) || endTimes[i] <= cStartTimes.get(j))) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToJ) {
                    result.append("J");
                    jStartTimes.add(startTimes[i]);
                    jEndTimes.add(endTimes[i]);
                } else if (canAssignToC) {
                    result.append("C");
                    cStartTimes.add(startTimes[i]);
                    cEndTimes.add(endTimes[i]);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + k + ": " + result);
        }
    }
}