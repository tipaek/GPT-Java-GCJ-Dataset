import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Pair<Integer, Integer>> times = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                times.add(new Pair<>(s, e));
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> jTasks = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> cTasks = new ArrayList<>();

            if (times.size() > 0) {
                jTasks.add(times.get(0));
                schedule.append("J");
            }
            if (times.size() > 1) {
                cTasks.add(times.get(1));
                schedule.append("C");
            }

            times.remove(0);
            if (times.size() > 0) times.remove(0);

            boolean impossible = false;

            for (Pair<Integer, Integer> task : times) {
                if (!hasOverlap(task, jTasks)) {
                    jTasks.add(task);
                    schedule.append("J");
                } else if (!hasOverlap(task, cTasks)) {
                    cTasks.add(task);
                    schedule.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static boolean hasOverlap(Pair<Integer, Integer> task, ArrayList<Pair<Integer, Integer>> taskList) {
        for (Pair<Integer, Integer> existingTask : taskList) {
            if ((existingTask.getKey() < task.getValue() && existingTask.getValue() > task.getKey())) {
                return true;
            }
        }
        return false;
    }
}