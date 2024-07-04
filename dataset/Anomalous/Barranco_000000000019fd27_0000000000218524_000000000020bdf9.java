import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int ncases = 1; ncases <= cases; ncases++) {
            int tasks = sc.nextInt();
            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < tasks; i++) {
                taskList.add(new Task(sc.nextInt(), sc.nextInt(), i));
            }

            Collections.sort(taskList);

            boolean isImpossible = false;
            StringBuilder res = new StringBuilder();
            int cEnd = 0, jEnd = 0;

            for (Task task : taskList) {
                if (task.start >= cEnd) {
                    task.assignee = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    task.assignee = 'J';
                    jEnd = task.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                Collections.sort(taskList, Comparator.comparingInt(task -> task.index));
                for (Task task : taskList) {
                    res.append(task.assignee);
                }
                System.out.println(res);
            }
        }
        sc.close();
    }
}

class Task implements Comparable<Task> {
    int start, end, index;
    char assignee;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.assignee = '?';
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}