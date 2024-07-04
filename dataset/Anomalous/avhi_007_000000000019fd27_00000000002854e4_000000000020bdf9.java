import java.util.*;
import java.io.*;

public class Solution {

    public static String[] assignTasks(int[][] intervals, int[] currentTask, int currentIndex, String[] assignedTasks) {
        boolean isCOccupied = false, isJOccupied = false;

        for (int i = 0; i < currentIndex; i++) {
            if (currentTask[1] <= intervals[i][0]) {
                assignedTasks[currentIndex] = assignedTasks[i];
            } else if (currentTask[1] > intervals[i][0] && currentTask[0] <= intervals[i][0]) {
                assignedTasks[currentIndex] = assignedTasks[i].equals("C") ? "J" : "C";
                break;
            } else if (currentTask[1] < intervals[i][1] && currentTask[0] < intervals[i][0]) {
                assignedTasks[currentIndex] = assignedTasks[i].equals("C") ? "J" : "C";
                break;
            } else if (currentTask[1] < intervals[i][1] && currentTask[0] >= intervals[i][0]) {
                if (assignedTasks[i].equals("C")) {
                    isCOccupied = true;
                } else if (assignedTasks[i].equals("J")) {
                    isJOccupied = true;
                }

                if (!isJOccupied) {
                    assignedTasks[currentIndex] = "J";
                } else if (!isCOccupied) {
                    assignedTasks[currentIndex] = "C";
                }

                break;
            } else if (currentTask[1] >= intervals[i][1] && currentTask[0] >= intervals[i][1]) {
                assignedTasks[currentIndex] = assignedTasks[i];
                break;
            } else if (currentTask[1] >= intervals[i][1] && currentTask[0] < intervals[i][1] && currentTask[0] >= intervals[i][0]) {
                assignedTasks[currentIndex] = assignedTasks[i].equals("C") ? "J" : "C";
                break;
            } else if (currentTask[1] >= intervals[i][1] && currentTask[0] <= intervals[i][0]) {
                if (assignedTasks[i].equals("C")) {
                    isCOccupied = true;
                } else if (assignedTasks[i].equals("J")) {
                    isJOccupied = true;
                }

                if (!isJOccupied) {
                    assignedTasks[currentIndex] = "J";
                } else if (!isCOccupied) {
                    assignedTasks[currentIndex] = "C";
                }

                break;
            } else if (currentTask[1] == intervals[i][1] && currentTask[0] == intervals[i][0]) {
                if (assignedTasks[i].equals("C")) {
                    isCOccupied = true;
                } else if (assignedTasks[i].equals("J")) {
                    isJOccupied = true;
                }

                if (!isJOccupied) {
                    assignedTasks[currentIndex] = "J";
                } else if (!isCOccupied) {
                    assignedTasks[currentIndex] = "C";
                }

                break;
            }
        }
        return assignedTasks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String IMPOSSIBLE = "IMPOSSIBLE";
        int[] temp = new int[2];
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            String answer = "";
            String[] assignedTasks = new String[n];
            assignedTasks[0] = "C";
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            for (int l = 1; l < n; l++) {
                temp[0] = intervals[l][0];
                temp[1] = intervals[l][1];
                assignedTasks = assignTasks(intervals, temp, l, assignedTasks);
            }

            for (int m = 0; m < n; m++) {
                if (assignedTasks[m] != null) {
                    answer += assignedTasks[m];
                } else {
                    answer = IMPOSSIBLE;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}