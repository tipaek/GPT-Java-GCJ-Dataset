import java.util.*;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        char[] assignments = new char[n];
        List<int[]> sortedIntervals = new ArrayList<>();
        Map<int[], Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals.add(intervals[i]);
            indexMap.put(intervals[i], i);
        }

        sortedIntervals.sort(Comparator.comparingInt(a -> a[0]));

        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean impossible = false;
        char person = 'J';

        for (int i = 0; i < sortedIntervals.size(); i++) {
            int[] current = sortedIntervals.get(i);
            assignments[indexMap.get(current)] = person;

            if (i < sortedIntervals.size() - 1 && overlaps(current, sortedIntervals.get(i + 1))) {
                if (person == 'J') {
                    jStack.push(current);
                    person = switchPerson(person);

                    if (!cStack.isEmpty() && overlaps(cStack.peek(), sortedIntervals.get(i + 1))) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (person == 'J') {
                    jStack.push(current);
                } else {
                    cStack.push(current);
                }
            }
        }

        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(assignments)));
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean overlaps(int[] a, int[] b) {
        return a[1] > b[0];
    }
}