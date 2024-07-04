import java.util.*;

class Task implements Comparable<Task> {
    private int start;
    private int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.end, other.end);
    }

    @Override
    public String toString() {
        return "[ start=" + start + ", end=" + end + "]";
    }
}

class Parent {
    private int end;

    public Parent(int end) {
        this.end = end;
    }

    public boolean addTask(Task newTask) {
        if (end > newTask.getStart()) {
            return false;
        }
        end = newTask.getEnd();
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            Parent C = new Parent(-1);
            Parent J = new Parent(-1);

            Map<String, Integer> map = new HashMap<>();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                Task task = new Task(start, end);
                tasks.add(task);
                map.put(start + "|" + end, i);
            }

            Collections.sort(tasks);

            String[] can = new String[n];
            boolean impossible = false;
            for (Task t : tasks) {
                int index = map.get(t.getStart() + "|" + t.getEnd());
                if (C.addTask(t)) {
                    can[index] = "C";
                } else if (J.addTask(t)) {
                    can[index] = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : String.join("", can);
            System.out.println("Case #" + ks + ": " + result);
        }
        input.close();
    }
}