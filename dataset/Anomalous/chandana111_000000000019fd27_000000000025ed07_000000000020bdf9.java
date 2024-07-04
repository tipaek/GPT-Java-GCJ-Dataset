import java.util.*;

class Main {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] matSorted = new int[n][2];
        char[] chars = new char[n];
        boolean impossible = false;

        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();
            matSorted[i] = mat[i].clone();
            map.put(mat[i], i);
        }

        Arrays.sort(matSorted, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        char person = 'J';

        for (int i = 0; i < n; i++) {
            chars[map.get(matSorted[i])] = person;

            if (i < n - 1 && doesOverlap(matSorted[i], matSorted[i + 1])) {
                if (person == 'J') {
                    JStack.push(matSorted[i]);
                    person = getPerson(person);

                    if (!CStack.isEmpty() && doesOverlap(matSorted[i + 1], CStack.peek())) {
                        impossible = true;
                        break;
                    }
                } else {
                    CStack.push(matSorted[i]);
                    person = getPerson(person);

                    if (doesOverlap(matSorted[i], JStack.peek())) {
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

        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
    }

    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}