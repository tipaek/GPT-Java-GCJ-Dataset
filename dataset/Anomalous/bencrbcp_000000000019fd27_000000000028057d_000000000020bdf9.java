import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int caseIndex = 1; caseIndex <= cases; caseIndex++) {
            int tasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cameronStarts = new ArrayList<>();
            ArrayList<Integer> jamieStarts = new ArrayList<>();
            ArrayList<Integer> cameronEnds = new ArrayList<>();
            ArrayList<Integer> jamieEnds = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int taskIndex = 0; taskIndex < tasks; taskIndex++) {
                String[] task = br.readLine().split(" ");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);
                boolean assigned = false;

                if (canAssignTask(cameronStarts, cameronEnds, start, end)) {
                    output.append("C");
                    cameronStarts.add(start);
                    cameronEnds.add(end);
                    assigned = true;
                } else if (canAssignTask(jamieStarts, jamieEnds, start, end)) {
                    output.append("J");
                    jamieStarts.add(start);
                    jamieEnds.add(end);
                    assigned = true;
                }

                if (!assigned) {
                    output.setLength(0);
                    for (int j = taskIndex + 1; j < tasks; j++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (output.length() < tasks) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + output);
            }
        }
    }

    private static boolean canAssignTask(ArrayList<Integer> starts, ArrayList<Integer> ends, int start, int end) {
        for (int i = 0; i < starts.size(); i++) {
            if (!(start >= ends.get(i) || end <= starts.get(i))) {
                return false;
            }
        }
        return true;
    }
}