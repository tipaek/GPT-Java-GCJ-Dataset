import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, br);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            tasks.add(new Task(start, end, i));
        }

        tasks.sort(Comparator.comparingInt(task -> task.start));

        int cEnd = 0, jEnd = 0;
        char[] schedule = new char[n];
        boolean isImpossible = false;

        for (Task task : tasks) {
            if (task.start >= cEnd) {
                cEnd = task.end;
                schedule[task.index] = 'C';
            } else if (task.start >= jEnd) {
                jEnd = task.end;
                schedule[task.index] = 'J';
            } else {
                isImpossible = true;
                break;
            }
        }

        String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}