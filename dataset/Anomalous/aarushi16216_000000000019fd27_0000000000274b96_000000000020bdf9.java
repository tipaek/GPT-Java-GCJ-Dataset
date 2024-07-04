import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            int[] startTimes = new int[numTasks];
            int[] originalStartTimes = new int[numTasks];
            int[] endTimes = new int[numTasks];
            Map<Integer, Integer> taskMap = new HashMap<>();

            for (int i = 0; i < numTasks; i++) {
                startTimes[i] = scanner.nextInt();
                originalStartTimes[i] = startTimes[i];
                endTimes[i] = scanner.nextInt();
                taskMap.put(startTimes[i], endTimes[i]);
            }

            Arrays.sort(startTimes);
            Arrays.sort(endTimes);

            int freeJ = -1;
            int freeC = -1;
            int startIndex = 0;
            int endIndex = 0;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            while (startIndex < numTasks || endIndex < numTasks) {
                if (startIndex < numTasks && startTimes[startIndex] < endTimes[endIndex]) {
                    if (freeJ == -1) {
                        schedule.append("J");
                        freeJ = startTimes[startIndex];
                    } else if (freeC == -1) {
                        schedule.append("C");
                        freeC = startTimes[startIndex];
                    } else {
                        isImpossible = true;
                        break;
                    }
                    startIndex++;
                } else {
                    if (freeJ != -1 && taskMap.get(freeJ) == endTimes[endIndex]) {
                        freeJ = -1;
                    }
                    if (freeC != -1 && taskMap.get(freeC) == endTimes[endIndex]) {
                        freeC = -1;
                    }
                    endIndex++;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                Map<Integer, Character> taskOrder = new HashMap<>();
                for (int i = 0; i < numTasks; i++) {
                    taskOrder.put(startTimes[i], schedule.charAt(i));
                }
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < numTasks; i++) {
                    result.append(taskOrder.get(originalStartTimes[i]));
                }
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }
}