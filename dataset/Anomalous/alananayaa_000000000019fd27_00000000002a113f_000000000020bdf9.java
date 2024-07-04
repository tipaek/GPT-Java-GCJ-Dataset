import java.util.*;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            processTestCase(t);
        }
    }

    private static void processTestCase(int testCaseNumber) {
        int numberOfTasks = scanner.nextInt();
        int[][] tasks = new int[numberOfTasks][2];
        int[][] sortedTasks = new int[numberOfTasks][2];
        char[] result = new char[numberOfTasks];
        Map<int[], Integer> taskIndexMap = new HashMap<>();

        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
            sortedTasks[i] = tasks[i];
            taskIndexMap.put(tasks[i], i);
        }

        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jamieTasks = new Stack<>();
        Stack<int[]> cameronTasks = new Stack<>();
        char currentPerson = 'J';
        boolean isImpossible = false;

        for (int i = 0; i < sortedTasks.length; i++) {
            int originalIndex = taskIndexMap.get(sortedTasks[i]);
            result[originalIndex] = currentPerson;

            if (i < sortedTasks.length - 1 && hasOverlap(sortedTasks[i], sortedTasks[i + 1])) {
                if (currentPerson == 'J') {
                    jamieTasks.push(sortedTasks[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!cameronTasks.isEmpty() && hasOverlap(cameronTasks.peek(), sortedTasks[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cameronTasks.push(sortedTasks[i]);
                    currentPerson = switchPerson(currentPerson);

                    if (!jamieTasks.isEmpty() && hasOverlap(jamieTasks.peek(), sortedTasks[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jamieTasks.push(sortedTasks[i]);
                } else {
                    cameronTasks.push(sortedTasks[i]);
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean hasOverlap(int[] task1, int[] task2) {
        return task1[1] > task2[0];
    }
}