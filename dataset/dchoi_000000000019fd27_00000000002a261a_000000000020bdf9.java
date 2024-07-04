import java.io.*;
import java.util.*;

public class Solution {

    public static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "(" + this.start + "," + this.end + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner sc = new Scanner(new FileInputStream("/Users/dhchoi/Documents/Workspaces/WorkspaceJava/algorithm-practice/src/main/resources/online/codejam/codejam2020/qualification/ParentingPartneringReturns-test.in"));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[] startTimes = new int[N + 1];
            int[] endTimes = new int[N + 1];

            for (int n = 1; n <= N; n++) {
                startTimes[n] = sc.nextInt();
                endTimes[n] = sc.nextInt();
            }

            // check possibility
            boolean isPossible = true;
            int[] check = new int[1441];
            for (int n = 1; n <= N; n++) {
                if (!isPossible) {
                    break;
                }
                int startTime = startTimes[n];
                int endTime = endTimes[n];
                for (int i = startTime; i < endTime; i++) {
                    check[i]++;

                    if (check[i] > 2) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!isPossible) {
                String line = "Case #" + test_case + ": IMPOSSIBLE";
                System.out.println(line);
            }
            else {
                List<Pair> cameron = new ArrayList<>();
                List<Pair> jamie = new ArrayList<>();
                String result = recursive(cameron, jamie, startTimes, endTimes, 1, N, "");
                String line = "Case #" + test_case + ": " + result;
                System.out.println(line);
            }
        }
    }

    public static String recursive(List<Pair> cameron, List<Pair> jamie, int[] startTimes, int[] endTimes, int index, int N, String result) {
        if (index > N) {
            return result;
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        int isCameronAvail = isAvailable(cameron, startTime, endTime);
        int isJamieAvail = isAvailable(jamie, startTime, endTime);

        if (isCameronAvail >= 0 && isJamieAvail >= 0) {
            List<Pair> cameronClone = new ArrayList<>(cameron);
            cameronClone.add(isCameronAvail, new Pair(startTime, endTime));
            String resultClone = result;
            resultClone = recursive(cameronClone, jamie, startTimes, endTimes, index + 1, N, resultClone + "C");
            if (resultClone.equals("IMPOSSIBLE")) {
                List<Pair> jamieClone = new ArrayList<>(jamie);
                jamieClone.add(isJamieAvail, new Pair(startTime, endTime));
                result = recursive(cameron, jamieClone, startTimes, endTimes, index + 1, N, result + "J");
            }
            else {
                result = resultClone;
            }
        }
        else if (isCameronAvail >= 0) {
            cameron.add(isCameronAvail, new Pair(startTime, endTime));
            result = recursive(cameron, jamie, startTimes, endTimes, index + 1, N, result + "C");
        }
        else if (isJamieAvail >= 0) {
            jamie.add(isJamieAvail, new Pair(startTime, endTime));
            result = recursive(cameron, jamie, startTimes, endTimes, index + 1, N, result + "J");
        }
        else {
            result = "IMPOSSIBLE";
        }

        return result;
    }

    public static int isAvailable(List<Pair> arr, int start, int end) {
        if (arr.size() <= 0) {
            return 0;
        }

        for (int i = 0; i < arr.size(); i++) {
            Pair cur = arr.get(i);

            if (i == 0 && end <= cur.start) {
                return i;
            }

            if (i == arr.size() - 1 && start >= cur.end) {
                return i + 1;
            }

            if (i > 0) {
                Pair prev = arr.get(i - 1);
                if (start >= prev.end && end <= cur.start) {
                    return i;
                }
            }

            if (i < arr.size() - 1) {
                Pair next = arr.get(i + 1);
                if (start >= cur.end && end <= next.start) {
                    return i;
                }
            }
        }

        return -1;
    }
}
