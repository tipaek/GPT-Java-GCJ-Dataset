import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = Integer.parseInt(reader.readLine());
            List<Task> tasks = new ArrayList<>(numTasks);

            for (int i = 0; i < numTasks; i++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks.add(new Task(start, end));
            }

            tasks.sort((task1, task2) -> {
                int comparison = Integer.compare(task1.start, task2.start);
                return comparison != 0 ? comparison : Integer.compare(task1.end, task2.end);
            });

            StringBuilder schedule = new StringBuilder();
            boolean canAssignC = true, canAssignJ = true, isImpossible = false;
            int lastCIndex = -1, lastJIndex = -1;

            for (int i = 0; i < tasks.size() && !isImpossible; i++) {
                Task currentTask = tasks.get(i);
                if (canAssignC) {
                    canAssignC = false;
                    schedule.append("C");
                    lastCIndex = i;
                } else if (canAssignJ) {
                    canAssignJ = false;
                    schedule.append("J");
                    lastJIndex = i;
                } else {
                    Task lastCTask = tasks.get(lastCIndex);
                    Task lastJTask = tasks.get(lastJIndex);

                    if (lastCTask.end <= currentTask.start) {
                        schedule.append("C");
                        lastCIndex = i;
                    } else if (lastJTask.end <= currentTask.start) {
                        schedule.append("J");
                        lastJIndex = i;
                    } else {
                        isImpossible = true;
                    }
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            System.out.println(isImpossible ? "IMPOSSIBLE" : schedule.toString());
        }
    }
}

class Task {
    int start, end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}