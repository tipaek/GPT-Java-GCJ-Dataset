import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] mat = new int[n][2];
            for (int j = 0; j < n; j++) {
                mat[j][0] = in.nextInt();
                mat[j][1] = in.nextInt();
            }

            StringBuilder answer = new StringBuilder("C"); // C first
            ArrayList<Integer> Cam = new ArrayList<>();
            ArrayList<Integer> Jam = new ArrayList<>();
            Cam.add(0);

            boolean isPossible = true;
            outerloop:
            for (int x = 1; x < n; x++) {
                boolean assigned = false;
                for (int k : Cam) {
                    if (overlaps(mat[x], mat[k])) {
                        if (assignToJam(mat, x, Jam)) {
                            answer.append("J");
                            Jam.add(x);
                            assigned = true;
                            break;
                        } else {
                            isPossible = false;
                            break outerloop;
                        }
                    }
                }
                if (!assigned && isPossible) {
                    answer.append("C");
                    Cam.add(x);
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + answer);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean overlaps(int[] a, int[] b) {
        return (a[0] < b[1] && a[1] > b[0]);
    }

    private static boolean assignToJam(int[][] mat, int x, ArrayList<Integer> Jam) {
        for (int m : Jam) {
            if (overlaps(mat[x], mat[m]) || contains(mat[x], mat[m]) || containedBy(mat[x], mat[m])) {
                return false;
            }
        }
        return true;
    }

    private static boolean contains(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[1]);
    }

    private static boolean containedBy(int[] a, int[] b) {
        return (a[0] >= b[0] && a[1] <= b[1]);
    }
}