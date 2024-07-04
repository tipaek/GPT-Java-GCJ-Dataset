import java.util.*;

public class Solution {
    private static Scanner sc;
    static int t = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] matSorted = new int[n][2];
        char[] chars = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;

        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
            matSorted[i] = mat[i];
            map.put(mat[i], i);
        }

        Arrays.sort(matSorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        char person = 'J';

        for (int i = 0; i < matSorted.length; i++) {
            chars[map.get(matSorted[i])] = person;

            if (i < matSorted.length - 1 && doesOverlap(matSorted[i], matSorted[i + 1])) {
                if (person == 'J') {
                    JStack.push(matSorted[i]);
                    person = getPerson(person);

                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), matSorted[i + 1])) {
                        impossible = true;
                        break;
                    }

                } else {
                    CStack.push(matSorted[i]);
                    person = getPerson(person);

                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), matSorted[i + 1])) {
                        impossible = true;
                        break;
                    }
                }
            } else {
                if (person == 'J') {
                    JStack.push(matSorted[i]);
                } else {
                    CStack.push(matSorted[i]);
                }
            }
        }

        System.out.println("Case #" + (t++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
    }

    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}