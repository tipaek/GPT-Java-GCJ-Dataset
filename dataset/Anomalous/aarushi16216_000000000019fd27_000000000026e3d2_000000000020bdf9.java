import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int numTasks = sc.nextInt();
            int[] startTime = new int[numTasks];
            int[] endTime = new int[numTasks];
            HashMap<Integer, Integer> taskMap = new HashMap<>();

            for (int i = 0; i < numTasks; i++) {
                startTime[i] = sc.nextInt();
                endTime[i] = sc.nextInt();
                taskMap.put(startTime[i], endTime[i]);
            }

            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int freeJ = -1, freeC = -1;
            int startIndex = 0, endIndex = 0;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            while (startIndex < numTasks || endIndex < numTasks) {
                if (startIndex < numTasks && startTime[startIndex] < endTime[endIndex]) {
                    if (freeJ == -1) {
                        schedule.append("J");
                        freeJ = startTime[startIndex];
                    } else if (freeC == -1) {
                        schedule.append("C");
                        freeC = startTime[startIndex];
                    } else {
                        isImpossible = true;
                        break;
                    }
                    startIndex++;
                } else {
                    if (freeJ != -1 && taskMap.get(freeJ) == endTime[endIndex]) {
                        freeJ = -1;
                    }
                    if (freeC != -1 && taskMap.get(freeC) == endTime[endIndex]) {
                        freeC = -1;
                    }
                    endIndex++;
                }
            }

            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + k + ": " + schedule.toString());
        }
    }
}