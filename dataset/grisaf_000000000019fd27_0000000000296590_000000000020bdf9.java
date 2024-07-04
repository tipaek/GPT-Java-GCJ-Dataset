import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static boolean middle(int x, int y, int z) {
        return x < y && y < z;
    }

    public static boolean overlaps(List<int[]> l, int s, int e) {
        for (int i = 0; i < l.size(); i++) {
            int ls = l.get(i)[0];
            int le = l.get(i)[1];
            if (
                middle(ls, s, le) ||
                middle(ls, e, le) ||
                middle(s, ls, e) ||
                middle(s, le, e)
            ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] m = new int[n][3];
            for (int i = 0; i < n; i++) {
                m[i][0] = sc.nextInt();
                m[i][1] = sc.nextInt();
                m[i][2] = i;
            }
            Arrays.sort(m, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return Integer.compare(a[1], b[1]);
                    } else {
                        return Integer.compare(a[0], b[0]);
                    }
                }
            });
            List<int[]> c = new LinkedList<>();
            List<int[]> j = new LinkedList<>();
            boolean possible = true;
            char[] r = new char[n];
            for (int i = 0; i < n && possible; i++) {
                if (!overlaps(c, m[i][0], m[i][1])) {
                    c.add(m[i]);
                    r[m[i][2]] = 'C';
                } else if (!overlaps(j, m[i][0], m[i][1])) {
                    j.add(m[i]);
                    r[m[i][2]] = 'J';
                } else {
                    possible = false;
                }
            }
            String dist = new String(r);
            String res = possible ? dist : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + res);
        }
    }
}
