import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    static class Task {
        int start;
        int end;
        int id;
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = in.nextInt();
            in.nextLine();


            for (int t = 1; t <= T; ++t) {
                int count = in.nextInt();
                in.nextLine();

                List<Task> tasks = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    Task task = new Task();
                    task.start = in.nextInt();
                    task.end = in.nextInt();
                    task.id = i;
                    tasks.add(task);
                }

                tasks.sort((a, b) -> {
                    if (a.start == b.start) {
                        return a.end - b.end;
                    }

                    return a.start - b.start;
                });

                StringBuilder builder = new StringBuilder();
                builder.setLength(count);
                int currentJ = -1;
                int currentC = -1;

                for (Task task: tasks) {
                    if(currentJ <= task.start) {
                        builder.setCharAt(task.id, 'J');
                        currentJ = task.end;
                    } else if (currentC <= task.start) {
                        builder.setCharAt(task.id, 'C');
                        currentC = task.end;
                    } else {
                        builder = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

                System.out.println("Case #" + t + ": " + builder.toString());
            }
        }
    }
}


