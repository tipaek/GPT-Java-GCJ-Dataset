import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = solve(sc);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder res = new StringBuilder("POSSIBLE\n");
        List<Set<Integer>> ver = new ArrayList<>();
        for (int m = 0; m < n; m++) {
            ver.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            int diag = Math.max(k - n, Math.min(n, k - (n - i - 1)));
            int[] row = new int[n];
            boolean poss = true;
            k -= diag;
            row[i] = diag;
            ver.get(i).add(diag);

            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    boolean flag = true;
                    for (int x = 1; x <= n; x++) {
                        if (!contains(row, x) && !ver.get(j).contains(x)) {
                            row[j] = x;
                            ver.get(j).add(x);
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        poss = false;
                        break;
                    }
                }
            }
            for (int val : row) {
                res.append(val).append(" ");
            }
            res.append("\n");
        }
        return poss ? res.toString().trim() : "IMPOSSIBLE";
    }

    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}