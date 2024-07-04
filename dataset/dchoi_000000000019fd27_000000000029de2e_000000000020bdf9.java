import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner sc = new Scanner(new FileInputStream("/Users/dhchoi/Documents/Workspaces/WorkspaceJava/algorithm-practice/src/main/resources/online/codejam/codejam2020/qualification/ParentingPartneringReturns-test.in"));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            String result = "";

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (result.equals("IMPOSSIBLE")) {
                    continue;
                }

                boolean isCameronAvail = true;
                for (int i = startTime; i < endTime; i++) {
                    if (cameron[i] > 0) {
                        isCameronAvail = false;
                    }
                }

                boolean isJamieAvail = true;
                for (int i = startTime; i < endTime; i++) {
                    if (jamie[i] > 0) {
                        isJamieAvail = false;
                    }
                }

                if (isCameronAvail) {
                    result += "C";
                    for (int i = startTime; i < endTime; i++) {
                        cameron[i]++;
                    }
                }
                else if (isJamieAvail) {
                    result += "J";
                    for (int i = startTime; i < endTime; i++) {
                        jamie[i]++;
                    }
                }
                else {
                    result = "IMPOSSIBLE";
                }
            }

            String line = "Case #" + test_case + ": " + result;
            System.out.println(line);
        }
    }
}
