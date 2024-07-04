import java.io.*;
import java.util.*;

public class Solution {

    static class Pair {
        int start;
        int end;

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

            if (!isPossibleSchedule(startTimes, endTimes)) {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            } else {
                String result = findSchedule(startTimes, endTimes, N);
                System.out.println("Case #" + test_case + ": " + result);
            }
        }
    }

    private static boolean isPossibleSchedule(int[] startTimes, int[] endTimes) {
        int[] check = new int[1441];
        for (int i = 0; i < startTimes.length; i++) {
            for (int j = startTimes[i]; j < endTimes[i]; j++) {
                check[j]++;
                if (check[j] > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String findSchedule(int[] startTimes, int[] endTimes, int N) {
        List<Pair> cameron = new ArrayList<>();
        List<Pair> jamie = new ArrayList<>();
        return scheduleRecursively(cameron, jamie, startTimes, endTimes, 0, N, "");
    }

    private static String scheduleRecursively(List<Pair> cameron, List<Pair> jamie, int[] startTimes, int[] endTimes, int index, int N, String result) {
        if (index >= N) {
            return result;
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        int cameronAvail = getAvailableSlot(cameron, startTime, endTime);
        int jamieAvail = getAvailableSlot(jamie, startTime, endTime);

        if (cameronAvail >= 0 && jamieAvail >= 0) {
            List<Pair> cameronClone = new ArrayList<>(cameron);
            cameronClone.add(cameronAvail, new Pair(startTime, endTime));
            String cameronResult = scheduleRecursively(cameronClone, jamie, startTimes, endTimes, index + 1, N, result + "C");
            if (!cameronResult.equals("IMPOSSIBLE")) {
                return cameronResult;
            }
            List<Pair> jamieClone = new ArrayList<>(jamie);
            jamieClone.add(jamieAvail, new Pair(startTime, endTime));
            return scheduleRecursively(cameron, jamieClone, startTimes, endTimes, index + 1, N, result + "J");
        } else if (cameronAvail >= 0) {
            cameron.add(cameronAvail, new Pair(startTime, endTime));
            return scheduleRecursively(cameron, jamie, startTimes, endTimes, index + 1, N, result + "C");
        } else if (jamieAvail >= 0) {
            jamie.add(jamieAvail, new Pair(startTime, endTime));
            return scheduleRecursively(cameron, jamie, startTimes, endTimes, index + 1, N, result + "J");
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static int getAvailableSlot(List<Pair> list, int start, int end) {
        for (int i = 0; i < list.size(); i++) {
            Pair current = list.get(i);
            if (i == 0 && end <= current.start) {
                return i;
            }
            if (i == list.size() - 1 && start >= current.end) {
                return i + 1;
            }
            if (i > 0) {
                Pair previous = list.get(i - 1);
                if (start >= previous.end && end <= current.start) {
                    return i;
                }
            }
        }
        return list.isEmpty() ? 0 : -1;
    }
}