import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    class Task {
        Integer start;
        Integer end;
        int initialOrder;
        Character assignedTo;
        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                in.nextLine();
                ArrayList<Task> tasks = new ArrayList<>();
                int[] endTime = new int[n];

                for(int j = 0; j < n; j++) {
                    Task task = new Task(in.nextInt(), in.nextInt());
                    task.initialOrder = j;
                    tasks.add(task);
                    endTime[j] = task.end;
                }
                System.out.println("Case #" + i + ": " + solve(tasks, endTime));
            }
        }
    }

    private String solve(ArrayList<Task> tasks, int[] endTime) {
        int counter = 0;
        int i = 0;
        int j = 0;
        Integer cbusyTill = null;
        Integer jbusyTill = null;
        Collections.sort(tasks, Comparator.comparing(t -> t.start));
        Arrays.sort(endTime);
        while(i < tasks.size() && j < endTime.length) {
            if(tasks.get(i).start < endTime[j]) {
                if(counter == 2) {
                    return "IMPOSSIBLE";
                }

                if(cbusyTill == null || cbusyTill <= tasks.get(i).start) {
                    cbusyTill = tasks.get(i).end;
                    tasks.get(i).assignedTo = 'C';
                } else if(jbusyTill == null || jbusyTill <= tasks.get(i).start) {
                    jbusyTill = tasks.get(i).end;
                    tasks.get(i).assignedTo = 'J';
                }
                counter++;
                i++;
            } else if(endTime[j] <= tasks.get(i).start) {
                counter--;
                counter = Math.max(counter, 0);
                j++;
            }
        }

        while(i < tasks.size()) {
            if(cbusyTill == null || cbusyTill <= tasks.get(i).start) {
                cbusyTill = tasks.get(i).end;
                tasks.get(i).assignedTo = 'C';
            } else if(jbusyTill == null || jbusyTill <= tasks.get(i).start) {
                jbusyTill = tasks.get(i).end;
                tasks.get(i).assignedTo = 'J';
            }
            i++;
        }

        Collections.sort(tasks, Comparator.comparing(t -> t.initialOrder));
        return tasks.stream().map(t -> String.valueOf(t.assignedTo)).collect(Collectors.joining());
    }
}
