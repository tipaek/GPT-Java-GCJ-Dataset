import java.io.*;
import java.util.*;

public class Solution {

    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int n = 0; n < N; n++) {
                startTimes[n] = sc.nextInt();
                endTimes[n] = sc.nextInt();
            }

            if (isPossibleSchedule(startTimes, endTimes, N)) {
                List<Pair> cameron = new ArrayList<>();
                List<Pair> jamie = new ArrayList<>();
                String result = scheduleTasks(cameron, jamie, startTimes, endTimes, 0, N, "");
                System.out.println("Case #" + test_case + ": " + result);
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossibleSchedule(int[] startTimes, int[] endTimes, int N) {
        int[] check = new int[1441];
        for (int n = 0; n < N; n++) {
            for (int i = startTimes[n]; i < endTimes[n]; i++) {
                check[i]++;
                if (check[i] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String scheduleTasks(List<Pair> cameron, List<Pair> jamie, int[] startTimes, int[] endTimes, int index, int N, String result) {
        if (index >= N) {
            return result;
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        int cameronPos = findAvailablePosition(cameron, startTime, endTime);
        int jamiePos = findAvailablePosition(jamie, startTime, endTime);

        if (cameronPos >= 0 && jamiePos >= 0) {
            List<Pair> cameronClone = new ArrayList<>(cameron);
            cameronClone.add(cameronPos, new Pair(startTime, endTime));
            String cameronResult = scheduleTasks(cameronClone, jamie, startTimes, endTimes, index + 1, N, result + "C");
            if (!"IMPOSSIBLE".equals(cameronResult)) {
                return cameronResult;
            }
            List<Pair> jamieClone = new ArrayList<>(jamie);
            jamieClone.add(jamiePos, new Pair(startTime, endTime));
            return scheduleTasks(cameron, jamieClone, startTimes, endTimes, index + 1, N, result + "J");
        } else if (cameronPos >= 0) {
            cameron.add(cameronPos, new Pair(startTime, endTime));
            return scheduleTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result + "C");
        } else if (jamiePos >= 0) {
            jamie.add(jamiePos, new Pair(startTime, endTime));
            return scheduleTasks(cameron, jamie, startTimes, endTimes, index + 1, N, result + "J");
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static int findAvailablePosition(List<Pair> list, int start, int end) {
        if (list.isEmpty()) {
            return 0;
        }

        if (end <= list.get(0).start) {
            return 0;
        }

        if (start >= list.get(list.size() - 1).end) {
            return list.size();
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (start >= list.get(i).end && end <= list.get(i + 1).start) {
                return i + 1;
            }
        }

        return -1;
    }
}