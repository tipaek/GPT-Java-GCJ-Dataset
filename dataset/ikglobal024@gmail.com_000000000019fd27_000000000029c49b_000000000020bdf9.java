import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.nextLine());

        for (int t=1; t<=T; t++) {
            int tasks = Integer.parseInt(in.nextLine());
            Person cameron = new Person();
            Person jamei = new Person();
            String result = "";
            boolean isImpossible = false;
            for (int i=1; i <= tasks; i++) {
                String[] S = in.nextLine().split(" ");
                int start = Integer.parseInt(S[0]);
                int end = Integer.parseInt(S[1]);
                if (isImpossible) continue;
                Task task = new Task(start, end);
                if (!cameron.isOverlapping(task)) {
                    cameron.addTask(task);
                    result += "C";
                } else if (!jamei.isOverlapping(task)) {
                    jamei.addTask(task);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + t +": " + result);
        }
    }

    static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Person {
        int[] timeSlot = new int[(24*60) + 1];

        boolean isOverlapping(Task newTask) {
            for (int i = newTask.start; i < newTask.end; i++) {
                if (timeSlot[i] == 1) {
                    return true;
                }
            }

            return false;
        }

        void addTask(Task newTask) {
            Arrays.fill(timeSlot, newTask.start, newTask.end, 1);
        }
    }

}
