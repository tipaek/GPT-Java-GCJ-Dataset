import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
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
    
    public static String processLines(List<String> lines) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(new Task(i, lines.get(i)));
        }
        tasks.sort(Comparator.comparingInt(task -> task.startTime));

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
                task.letter = "C";
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
                    task.letter = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        String result = "";
        tasks.sort(Comparator.comparingInt(task -> task.id));
        for (Task task : tasks) {
            result += task.letter;
        }
        return result;
    }

    public static class Task {
        private int id;
        private int startTime;
        private int endTime;
        private String letter;

        public Task(int id, int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Task(int id, String input) {
            this.id = id;
            String[] inputs = input.split(" ");
            this.startTime = Integer.parseInt(inputs[0]);
            this.endTime = Integer.parseInt(inputs[1]);
        }

        public boolean overlapsWith(Task task) {
            return (this.startTime < task.startTime && this.endTime > task.startTime) ||
                    (task.startTime < this.startTime && task.endTime > this.startTime);
        }
    }
}
