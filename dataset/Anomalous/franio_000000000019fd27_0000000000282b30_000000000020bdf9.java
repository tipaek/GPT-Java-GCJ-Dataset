import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int tests = scanner.nextInt();

            for (int t = 0; t < tests; t++) {
                int N = scanner.nextInt();
                Schedule schedule = new Schedule();
                boolean isPossible = true;

                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    Task task = new Task(start, end, i + 1);

                    if (!schedule.addTask(task)) {
                        isPossible = false;
                        break;
                    }
                }

                printResult(t + 1, isPossible ? schedule.getAnswer() : "IMPOSSIBLE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Task {
    private final int start;
    private final int end;
    private final int id;

    public Task(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public boolean overlaps(Task other) {
        return (this.start < other.end && this.end > other.start);
    }
}

class Schedule {
    private final StringBuilder answer;
    private final List<Task> cSchedule;
    private final List<Task> jSchedule;

    public Schedule() {
        this.answer = new StringBuilder();
        this.cSchedule = new ArrayList<>();
        this.jSchedule = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        if (cSchedule.stream().noneMatch(existingTask -> existingTask.overlaps(task))) {
            cSchedule.add(task);
            answer.append("C");
            return true;
        }

        if (jSchedule.stream().noneMatch(existingTask -> existingTask.overlaps(task))) {
            jSchedule.add(task);
            answer.append("J");
            return true;
        }

        return false;
    }

    public String getAnswer() {
        return answer.toString();
    }
}