import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder solution = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            solution.append("Case #").append(currentCase).append(": ");
            int nbTasks = Integer.parseInt(scanner.nextLine());
            List<int[]> listC = new ArrayList<>();
            List<int[]> listJ = new ArrayList<>();
            StringBuilder currentSolution = new StringBuilder();

            for (int i = 0; i < nbTasks; i++) {
                String[] line = scanner.nextLine().split("\\s+");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);
                boolean taskAssigned = false;

                if (listC.isEmpty() || canAssignTask(listC, start, end)) {
                    listC.add(new int[]{start, end});
                    currentSolution.append("C");
                    taskAssigned = true;
                } else if (listJ.isEmpty() || canAssignTask(listJ, start, end)) {
                    listJ.add(new int[]{start, end});
                    currentSolution.append("J");
                    taskAssigned = true;
                } else {
                    currentSolution = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            solution.append(currentSolution).append("\n");
        }

        System.out.print(solution);
    }

    private static boolean canAssignTask(List<int[]> list, int start, int end) {
        for (int[] interval : list) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }
        return true;
    }
}