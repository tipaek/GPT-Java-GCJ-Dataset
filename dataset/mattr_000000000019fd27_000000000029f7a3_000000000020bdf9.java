import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            doCase(in, i);
        }
    }

    public static void solve(Scanner sc) {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) {
        int n = Integer.parseInt(sc.nextLine());
        LinkedList<int[]> activities = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i ++) {
            String [] times = sc.nextLine().split(" ");
            activities.add(new int[]{ Integer.parseInt(times[0]), Integer.parseInt(times[1])});
        }

        LinkedList<int[]> cameronSchedule = new LinkedList<>();
        LinkedList<int[]> jamieSchedule = new LinkedList<>();

        for (int[] activity : activities) {
            if (canTakeIt(cameronSchedule, activity)) {
                cameronSchedule.add(activity);
                sb.append("C");
            } else if (canTakeIt(jamieSchedule, activity)) {
                jamieSchedule.add(activity);
                sb.append("J");
            } else {
                System.out.println("Case #" + Integer.toString(caseNumber) + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.toString());
    }

    private static boolean canTakeIt(LinkedList<int[]> schedule, int[] activity) {
        for (int[] scheduled : schedule) {
            if (activity[0] > scheduled[0] && activity[0] < scheduled[1]) {
                return false;
            } else if (activity[1] > scheduled[0] && activity[1] < scheduled[1]) {
                return false;
            } else if (activity[0] <= scheduled[0] && activity[1] >= scheduled[1]) {
                return false;
            }
        }

        return true;
    }
}
