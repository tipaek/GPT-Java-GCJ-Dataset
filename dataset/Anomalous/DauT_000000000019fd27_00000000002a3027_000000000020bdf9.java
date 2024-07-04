import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Task {
        int startTime;
        int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                taskList.add(new Task(startTime, endTime));
            }
            String solution = findSolution(taskList, k + 1);
            System.out.println(solution);
        }
        in.close();
    }

    static String findSolution(List<Task> taskList, int caseNo) {
        StringBuilder sol = new StringBuilder();
        boolean[] cTime = new boolean[24 * 60 + 1];
        boolean[] jTime = new boolean[24 * 60 + 1];

        for (Task task : taskList) {
            int startTime = task.getStartTime();
            int endTime = task.getEndTime();
            boolean cOccupied = isTimeOccupied(cTime, startTime, endTime);
            boolean jOccupied = isTimeOccupied(jTime, startTime, endTime);

            if (!cOccupied) {
                sol.append("C");
                occupyTime(cTime, startTime, endTime);
            } else if (!jOccupied) {
                sol.append("J");
                occupyTime(jTime, startTime, endTime);
            } else {
                return "Case #" + caseNo + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNo + ": " + sol.toString();
    }

    static boolean isTimeOccupied(boolean[] timeArray, int startTime, int endTime) {
        for (int i = startTime + 1; i < endTime; i++) {
            if (timeArray[i]) {
                return true;
            }
        }
        return false;
    }

    static void occupyTime(boolean[] timeArray, int startTime, int endTime) {
        for (int i = startTime; i <= endTime; i++) {
            timeArray[i] = true;
        }
    }
}