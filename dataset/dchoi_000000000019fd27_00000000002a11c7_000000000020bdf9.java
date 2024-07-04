import java.io.*;
import java.util.*;

public class Solution {

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
                int[] cameron = new int[1441];
                int[] jamie = new int[1441];
                String result = recursive(cameron, jamie, startTimes, endTimes, 1, N, "");
                String line = "Case #" + test_case + ": " + result;
                System.out.println(line);
            }
        }
    }

    public static String recursive(int[] cameron, int[] jamie, int[] startTimes, int[] endTimes, int index, int N, String result) {
        if (index > N) {
            return result;
        }

        int startTime = startTimes[index];
        int endTime = endTimes[index];

        boolean isCameronAvail = isAvailable(cameron, startTime, endTime);
        boolean isJamieAvail = isAvailable(jamie, startTime, endTime);

        if (isCameronAvail && isJamieAvail) {
            int[] cameronClone = cameron.clone();
            fill(cameronClone, startTime, endTime);
            String resultClone = result;
            resultClone = recursive(cameronClone.clone(), jamie.clone(), startTimes, endTimes, index + 1, N, resultClone + "C");
            if (resultClone.equals("IMPOSSIBLE")) {
                int[] jamieClone = jamie.clone();
                fill(jamieClone, startTime, endTime);
                result = recursive(cameron.clone(), jamieClone.clone(), startTimes, endTimes, index + 1, N, result + "J");
            }
            else {
                result = resultClone;
            }
        }
        else if (isCameronAvail) {
            fill(cameron, startTime, endTime);
            result = recursive(cameron.clone(), jamie.clone(), startTimes, endTimes, index + 1, N, result + "C");
        }
        else if (isJamieAvail) {
            fill(jamie, startTime, endTime);
            result = recursive(cameron.clone(), jamie.clone(), startTimes, endTimes, index + 1, N, result + "J");
        }
        else {
            result = "IMPOSSIBLE";
        }

        return result;
    }

    public static boolean isAvailable(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void fill(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            arr[i]++;
        }
    }
}
