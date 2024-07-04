import java.util.*;

public class Solution {
    private final int T ;
    private final ArrayList<int[]> activities;

    public Solution(int T, ArrayList<int[]> activities) {
        this.T = T;
        this.activities = activities;
    }

    public void solve() {
        activities.sort(Comparator.comparingInt(a -> a[0]));

        System.out.printf("Case #%s: ", T);


//        Case #1: CJC
        StringBuilder sb = new StringBuilder();

        int J = -1;
        int C = -1;

        for (int i = 0; i < activities.size(); i++) {
            final int[] time = activities.get(i);

            if(time[0] >= J) {
                sb.append("J");
                J = time[1];
            } else if(time[0] >= C) {
                sb.append("C");
                C = time[1];
            } else {
                sb = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            ArrayList<int[]> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                final int S = in.nextInt();
                final int E = in.nextInt();

                activities.add(new int[] {S,E});
            }

            final Solution solution = new Solution(t + 1, activities);

            solution.solve();
        }
    }
}
