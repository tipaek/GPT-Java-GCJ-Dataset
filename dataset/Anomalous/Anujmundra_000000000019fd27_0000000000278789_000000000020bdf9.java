import java.util.*;

public class Solution {

    public static char togglePerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    public static boolean isOverlapping(int[] a, int[] b) {
        return a[1] > b[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int intervals = sc.nextInt();
            int[][] tasks = new int[intervals][2];
            int[][] sortedTasks = new int[intervals][2];
            char[] assignments = new char[intervals];
            char currentPerson = 'J';
            Stack<int[]> jStack = new Stack<>();
            Stack<int[]> cStack = new Stack<>();
            boolean impossible = false;
            Map<int[], Integer> indexMap = new HashMap<>();

            for (int j = 0; j < intervals; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
                sortedTasks[j] = tasks[j].clone();
                indexMap.put(tasks[j], j);
            }

            Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < sortedTasks.length; j++) {
                assignments[indexMap.get(sortedTasks[j])] = currentPerson;

                if (j < sortedTasks.length - 1 && isOverlapping(sortedTasks[j], sortedTasks[j + 1])) {
                    if (currentPerson == 'J') {
                        jStack.push(sortedTasks[j]);
                        currentPerson = togglePerson(currentPerson);
                        if (!cStack.isEmpty() && isOverlapping(cStack.peek(), sortedTasks[j + 1])) {
                            impossible = true;
                            break;
                        }
                    } else {
                        cStack.push(sortedTasks[j]);
                        currentPerson = togglePerson(currentPerson);
                        if (!jStack.isEmpty() && isOverlapping(jStack.peek(), sortedTasks[j + 1])) {
                            impossible = true;
                            break;
                        }
                    }
                } else {
                    if (currentPerson == 'J') {
                        jStack.push(sortedTasks[j]);
                    } else {
                        cStack.push(sortedTasks[j]);
                    }
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
        }
    }
}