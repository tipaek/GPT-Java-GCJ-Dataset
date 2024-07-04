import java.util.*;

class Task {
    int id;
    int start;
    int end;
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= t; x++) {
            int n = Integer.parseInt(sc.nextLine());

            List<Task> taskList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                Task task = new Task();
                task.id = i;
                task.start = Integer.parseInt(input[0]);
                task.end = Integer.parseInt(input[1]);

                taskList.add(task);
            }

            List<Task> jag = new ArrayList<>();
            List<Task> cag = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean success = true;

            for (Task current : taskList) {
                boolean jflag = true;
                for (Task task : jag) {
                    if ((current.start < task.end && current.end > task.start)) {
                        jflag = false;
                        break;
                    }
                }

                if (jflag) {
                    jag.add(current);
                    result.append("J");
                    continue;
                }

                boolean cflag = true;
                for (Task task : cag) {
                    if ((current.start < task.end && current.end > task.start)) {
                        cflag = false;
                        break;
                    }
                }

                if (cflag) {
                    cag.add(current);
                    result.append("C");
                    continue;
                }

                success = false;
                System.out.println("Case #" + x + ": IMPOSSIBLE");
                break;
            }

            if (success) {
                System.out.println("Case #" + x + ": " + result.toString());
            }
        }
    }
}