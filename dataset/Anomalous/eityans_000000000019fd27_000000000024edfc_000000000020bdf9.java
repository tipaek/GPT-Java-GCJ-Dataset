import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            StringBuilder ans = new StringBuilder();
            int finishC = 0;
            int finishJ = 0;
            boolean isPossible = true;
            int[][] tasks = new int[N][2];

            for (int i = 0; i < N; i++) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            for (int[] task : tasks) {
                if (finishC <= task[0]) {
                    finishC = task[1];
                    ans.append("C");
                } else if (finishJ <= task[0]) {
                    finishJ = task[1];
                    ans.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + (isPossible ? ans.toString() : "IMPOSSIBLE"));
        }

        sc.close();
    }
}