import java.io.*;
import java.util.*;

class Solution {

    static void schedulingTasks(List<Integer> start, List<Integer> end, int testNo, int n) {
        char[] assignTask = new char[start.size()];
        int[] sortedStart = new int[start.size()];
        List<Integer> remaining = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < start.size(); i++) {
            sortedStart[i] = start.get(i);
        }
        Arrays.sort(sortedStart);

        int eTime = end.get(start.indexOf(sortedStart[0]));
        assignTask[start.indexOf(sortedStart[0])] = 'C';

        for (int j = 1; j < sortedStart.length; j++) {
            if (eTime <= sortedStart[j]) {
                eTime = end.get(start.indexOf(sortedStart[j]));
                assignTask[start.indexOf(sortedStart[j])] = 'C';
            } else {
                remaining.add(sortedStart[j]);
            }
        }

        if (!remaining.isEmpty()) {
            eTime = end.get(start.indexOf(remaining.get(0)));
            assignTask[start.indexOf(remaining.get(0))] = 'J';
            for (int j = 1; j < remaining.size(); j++) {
                if (eTime <= remaining.get(j)) {
                    eTime = end.get(start.indexOf(remaining.get(j)));
                    assignTask[start.indexOf(remaining.get(j))] = 'J';
                }
            }
        }

        for (char c : assignTask) {
            if (c == 'C' || c == 'J') {
                ans.append(c);
            }
        }

        PrintWriter writer = new PrintWriter(System.out);
        if (ans.length() < n) {
            writer.write("Case #" + testNo + ": IMPOSSIBLE\n");
        } else {
            writer.write("Case #" + testNo + ": " + ans.toString() + "\n");
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> startTime = new ArrayList<>(n);
            List<Integer> endTime = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                String[] taskTimes = br.readLine().split(" ");
                startTime.add(Integer.parseInt(taskTimes[0]));
                endTime.add(Integer.parseInt(taskTimes[1]));
            }

            schedulingTasks(startTime, endTime, k, n);
        }
    }
}