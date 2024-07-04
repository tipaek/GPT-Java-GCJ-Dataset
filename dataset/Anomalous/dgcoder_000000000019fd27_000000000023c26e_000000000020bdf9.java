import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            String result = assignTasks(intervals);
            System.out.printf("Case #%d: %s\n", t, result);
        }
        br.close();
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        ArrayList<int[]> cTasks = new ArrayList<>();
        ArrayList<int[]> jTasks = new ArrayList<>();

        for (int[] interval : intervals) {
            if (canAssign(cTasks, interval[0], interval[1])) {
                result.append('C');
            } else if (canAssign(jTasks, interval[0], interval[1])) {
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAssign(ArrayList<int[]> taskList, int start, int end) {
        for (int[] task : taskList) {
            if (start < task[1] && end > task[0]) {
                return false;
            }
        }
        taskList.add(new int[]{start, end});
        return true;
    }
}