import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        Solution pp = new Solution();
        for (int i = 1; i <= testCases; i++) {
            int tasks = in.nextInt();

            List<Integer>[] startToEnd = new List[1441];
            for (int t = 1; t <= tasks; t++) {
                int start = in.nextInt();
                int end = in.nextInt();
                List<Integer> sameStartTasks = startToEnd[start];
                if (sameStartTasks == null) {
                    sameStartTasks = new ArrayList<>();
                }
                sameStartTasks.add(end);
                startToEnd[start] = sameStartTasks;
            }
            String output = pp.schedule(startToEnd);
            System.out.printf("Case #%d: %s%n", i, output);
        }
    }

    public String schedule(List<Integer>[] startToEnd) {
        int jamie = -1;
        int cameron = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < startToEnd.length; i++) {
            List<Integer> ends = startToEnd[i];
            if (ends != null) {
                for (int end: ends) {
                    if (jamie <= i) {
                        jamie = end;
                        sb.append("J");
                    } else if (cameron <= i) {
                        cameron = end;
                        sb.append("C");
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        return sb.toString();
    }
}
