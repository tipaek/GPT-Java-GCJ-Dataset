import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Task {
    int start;
    int end;
    int index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {
    public static String solve(List<Task> taskList) {
        StringBuilder res = new StringBuilder();
        res.append('J');
        String w = "jam";
        int jam = taskList.get(0).end;
        int cam = 0;

        for (int i = 1; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (w.equals("cam")) {
                if (task.start >= cam) {
                    res.append('C');
                    cam = task.end;
                    w = "cam";
                } else if (task.start >= jam) {
                    res.append('J');
                    jam = task.end;
                    w = "jam";
                }
            } else {
                if (task.start >= jam) {
                    res.append('J');
                    jam = task.end;
                    w = "jam";
                } else if (task.start >= cam) {
                    res.append('C');
                    cam = task.end;
                    w = "cam";
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for (int t = 1; t <= testcases; t++) {
            int nTask = scanner.nextInt();
            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < nTask; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                taskList.add(new Task(start, end, i));
            }

            Collections.sort(taskList, Comparator.comparingInt(o -> o.start));
            String res = solve(taskList);

            if (res.length() == nTask) {
                char[] resultArray = new char[nTask];
                for (int i = 0; i < nTask; i++) {
                    resultArray[taskList.get(i).index] = res.charAt(i);
                }
                System.out.printf("Case #%d: %s%n", t, new String(resultArray));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            }
        }
    }
}