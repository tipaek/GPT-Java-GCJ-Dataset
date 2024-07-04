import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static String processLines(List<String> lines) {
        String result = "";

        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            tasks.add(new Task(line));
        }

        List<Task> cTasks = new ArrayList<>();
        List<Task> jTasks = new ArrayList<>();

        for (Task task : tasks) {
            boolean overlapsWithC = false;
            for (Task cTask : cTasks) {
                if (task.overlapsWith(cTask)) {
                    overlapsWithC = true;
                    break;
                }
            }
            if (!overlapsWithC) {
                cTasks.add(task);
                result += "C";
            } else {
                boolean overlapsWithJ = false;
                for (Task jTask : jTasks) {
                    if (task.overlapsWith(jTask)) {
                        overlapsWithJ = true;
                        break;
                    }
                }
                if (!overlapsWithJ) {
                    jTasks.add(task);
                    result += "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> lines = new ArrayList<>();
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }

        int caseCount = Integer.parseInt(lines.get(0));
        int currentCaseNumber = 1;
        for (int i = 1; i < lines.size(); ) {
            int taskCount = Integer.parseInt(lines.get(i));
            String result = processLines(lines.subList(++i, i + taskCount));
            System.out.println("Case #" + currentCaseNumber++ + ": " + result);
            i += taskCount;
        }
    }
}
