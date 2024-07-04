
import java.util.HashSet;
import java.util.Scanner;

public class rough {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            while (n > 0) {
                int trace_ans = 0;
                int[][] arr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = sc.nextInt();
                        if (i == j) {
                            trace_ans += arr[i][i];
                        }
                    }
                }
                trace(arr, trace_ans);
                n--;
            }
            test--;
        }
    }

    static int case_test = 1;

    public static void trace(int[][] arr, int trace_ans) {

        HashSet<Integer> rr = new HashSet<>();
        HashSet<Integer> cr = new HashSet<>();

        int r = 0;
        int c = 0;
        for (int row = 0; row < arr[0].length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (!rr.contains(arr[row][col])) {
                    rr.add(arr[row][col]);
                } else {
                    rr.clear();
                    r++;
                    break;
                }
            }
        }
        for (int col = 0; col < arr[0].length; col++) {
            for (int row = 0; row < arr.length; row++) {
                if (!cr.contains(arr[row][col])) {
                    cr.add(arr[row][col]);
                } else {
                    cr.clear();
                    c++;
                    break;
                }
            }
        }

        System.out.print("Case #" + case_test + ": " + trace_ans + " " + r + " " + c);
        case_test++;
    }
}