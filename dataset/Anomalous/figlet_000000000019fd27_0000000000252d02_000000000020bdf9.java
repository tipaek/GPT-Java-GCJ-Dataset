import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    private static boolean isOverlapping(ArrayList<Task> taskList, Task task) {
        for (Task t : taskList) {
            if ((t.s < task.s && t.e > task.s) || (task.s < t.s && task.e > t.s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();
            ArrayList<Task> cameron = new ArrayList<>();
            ArrayList<Task> jamie = new ArrayList<>();

            for (int i = 1; i <= t; i++) {
                cameron.clear();
                jamie.clear();
                int n = Integer.parseInt(br.readLine());
                result.setLength(0);

                for (int j = 0; j < n; j++) {
                    String[] data = br.readLine().split(" ");
                    if (result.toString().trim().equals("IMPOSSIBLE")) {
                        continue;
                    }

                    int s = Integer.parseInt(data[0]);
                    int e = Integer.parseInt(data[1]);
                    Task task = new Task(s, e);

                    if (!isOverlapping(cameron, task)) {
                        cameron.add(task);
                        result.append("C");
                    } else if (!isOverlapping(jamie, task)) {
                        jamie.add(task);
                        result.append("J");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                    }
                }

                System.out.println("Case #" + i + ": " + result.toString());
            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}

class Task {
    int s, e;

    Task(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String toString() {
        return s + ":" + e;
    }
}