package Codejam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            int tasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cStartTimes = new ArrayList<>();
            ArrayList<Integer> jStartTimes = new ArrayList<>();
            ArrayList<Integer> cEndTimes = new ArrayList<>();
            ArrayList<Integer> jEndTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < tasks; i++) {
                String[] taskDetails = br.readLine().split(" ");
                int start = Integer.parseInt(taskDetails[0]);
                int end = Integer.parseInt(taskDetails[1]);

                boolean assigned = false;

                if (cStartTimes.isEmpty() || canAssign(cStartTimes, cEndTimes, start, end)) {
                    schedule.append("C");
                    cStartTimes.add(start);
                    cEndTimes.add(end);
                    assigned = true;
                } else if (jStartTimes.isEmpty() || canAssign(jStartTimes, jEndTimes, start, end)) {
                    schedule.append("J");
                    jStartTimes.add(start);
                    jEndTimes.add(end);
                    assigned = true;
                }

                if (!assigned) {
                    possible = false;
                    for (int j = i + 1; j < tasks; j++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (possible && schedule.length() == tasks) {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean canAssign(ArrayList<Integer> startTimes, ArrayList<Integer> endTimes, int start, int end) {
        for (int i = 0; i < startTimes.size(); i++) {
            if (!(start >= endTimes.get(i) || end <= startTimes.get(i))) {
                return false;
            }
        }
        return true;
    }
}