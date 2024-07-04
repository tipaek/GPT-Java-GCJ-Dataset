import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            Map<int[], Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                indexMap.put(intervals[i], i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            char[] result = new char[n];
            Stack<int[]> jStack = new Stack<>();
            Stack<int[]> cStack = new Stack<>();
            boolean isImpossible = false;
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

            System.out.println("Case #" + (t + 1) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}