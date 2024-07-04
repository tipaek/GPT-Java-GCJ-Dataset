import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            indexMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            result[indexMap.get(intervals[i])] = currentPerson;
            if (i < n - 1 && doesOverlap(intervals[i], intervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(intervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), intervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(intervals[i]);
                } else {
                    cStack.push(intervals[i]);
                }
            }
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}