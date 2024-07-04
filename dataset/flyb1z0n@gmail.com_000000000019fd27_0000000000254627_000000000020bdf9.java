
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int activityCount = sc.nextInt();
            int[][] arr = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            String result = solve(arr);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    public static String solve(int[][] arr) {
        boolean[] cameron = new boolean[1441];
        boolean[] james = new boolean[1441];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (Solution.tryAssign(cameron, arr[i][0], arr[i][1])) {
                sb.append("C");
            } else if (Solution.tryAssign(james, arr[i][0], arr[i][1])) {
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }

    public static boolean tryAssign(boolean[] arr, int from, int to) {
        for (int i = from; i < to; i++) {
            if (arr[i]) {
                return false;
            }
        }

        for (int i = from; i < to; i++) {
            arr[i] = true;
        }
        return true;
    }
}
