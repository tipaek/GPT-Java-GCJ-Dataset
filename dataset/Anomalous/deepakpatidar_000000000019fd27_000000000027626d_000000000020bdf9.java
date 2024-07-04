import java.util.*;

class EquiTriangeInCircle {

    static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[][] tasks = new int[n][3];

        // Copy input intervals to tasks array with index
        for (int i = 0; i < n; i++) {
            tasks[i][0] = intervals[i][0];
            tasks[i][1] = intervals[i][1];
            tasks[i][2] = i;
        }

        // Sort tasks based on start time
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        int cEnd = 0, jEnd = 0;
        char[] result = new char[n];

        // Assign tasks to C or J
        for (int i = 0; i < n; i++) {
            if (tasks[i][0] >= cEnd) {
                result[tasks[i][2]] = 'C';
                cEnd = tasks[i][1];
            } else if (tasks[i][0] >= jEnd) {
                result[tasks[i][2]] = 'J';
                jEnd = tasks[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testCase = 1; testCase < t + 1; testCase++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + testCase + ": " + result);
        }

        sc.close();
    }
}