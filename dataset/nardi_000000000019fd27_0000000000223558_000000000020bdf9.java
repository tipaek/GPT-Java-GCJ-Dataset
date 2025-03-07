
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static String solve(Activity[] activities) {
        Arrays.sort(activities);
        int jend = 0;
        int cend = 0;
        char[] ans = new char[activities.length];
        for (Activity activity : activities) {
            int start = activity.start;
            int end = activity.end;
            if (start >= jend) {
                jend = end;
                ans[activity.id] = 'J';
            } else if (start >= cend) {
                cend = end;
                ans[activity.id] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.copyValueOf(ans);
    }

    public static void main(String[] args) {
        int T = ni();
        for (int i = 1; i <= T; i++) {
            int N = ni();
            Activity[] activities = new Activity[N];
            for (int j = 0; j < N; j++) {
                activities[j] = new Activity(j, ni(), ni());
            }
            System.out.println("Case #" + i + ": " + solve(activities));
        }
    }

    static class Activity implements Comparable<Activity> {
        int id;
        int start;
        int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity o) {
            return Integer.compare(start, o.start);
        }
    }

    static Scanner io = new Scanner(System.in);

    static int ni() {
        return io.nextInt();
    }

    static long nl() {
        return io.nextLong();
    }

    static String ns() {
        return io.next();
    }

    static int[] nia(int N) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = ni();
        }
        return array;
    }

    static int[][] nim(int N, int cols) {
        int[][] matrix = new int[N][cols];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ni();
            }
        }
        return matrix;
    }
}
