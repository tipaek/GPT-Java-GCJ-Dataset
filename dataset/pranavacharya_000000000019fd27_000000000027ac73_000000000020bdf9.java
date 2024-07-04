import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public void ParentingPartnerReturns(int caseno, int[][] tasks) {
        int[][] temp = tasks.clone();
        HashMap<String, Character> map = new HashMap<>();
        Arrays.sort(tasks, (a, b) -> Double.compare(a[0], b[0]));
        int cmax = Integer.MIN_VALUE;
        int jmax = Integer.MIN_VALUE;
        for (int[] task : tasks) {
            if (task[0] >= cmax) {
                cmax = task[1];
                map.put("" + task[0] + "_" + task[1], 'C');
            } else if (task[0] >= jmax) {
                jmax = task[1];
                map.put("" + task[0] + "_" + task[1], 'J');
            } else {
                System.out.format("Case #%d: %s", caseno, "IMPOSSIBLE");
                System.out.println();
                return;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int[] task : temp) {
            answer.append(map.get("" + task[0] + "_" + task[1]));
        }
        System.out.format("Case #%d: %s", caseno, answer.toString());
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            v.ParentingPartnerReturns(t, arr);
        }
    }
}
