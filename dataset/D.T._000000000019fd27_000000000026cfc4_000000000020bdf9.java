import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {


    public static void solve(int ks, Scanner scanner, int n) {

        PriorityQueue<Activity> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.start));
        List<Activity> list = new ArrayList<>();
        int[] cameron = new int[1440];
        int[] jamie = new int[1440];

        for (int i = 0; i < n; i++) {
            Activity activity = new Activity();
            activity.start = scanner.nextInt();
            activity.end = scanner.nextInt();
            list.add(activity);
            queue.add(activity);
        }

        boolean impossible = false;
        while (!queue.isEmpty()) {
            Activity activity = queue.remove();
//            System.err.println("start:" + activity.start + ", end:" + activity.end);

            if (impossible) {
                continue;
            }
            boolean cameronAble = ifAvailable(activity, cameron);
            if (cameronAble) {
                activity.owner = "C";
            } else if (ifAvailable(activity, jamie)) {
                activity.owner = "J";
            } else {
                impossible = true;
            }
        }

//        System.err.println("cameron:" + Arrays.toString(cameron));
//        System.err.println("jamie:" + Arrays.toString(jamie));

        if (impossible) {
            System.out.println("Case #" + ks + ": IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Activity activity : list) {
                sb.append(activity.owner);
            }
            System.out.println("Case #" + ks + ": " + sb.toString());
        }
    }

    private static boolean ifAvailable(final Activity activity, final int[] timeSlot) {
        boolean able = true;
        for (int i = activity.start; i < activity.end; i++) {
            if (timeSlot[i] == 1) {
                able = false;
                break;
            }
        }

        if (able) {
            for (int i = activity.start; i < activity.end; i++) {
                timeSlot[i] = 1;
            }
        }
        return able;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            solve(ks, input, n);
        }
    }

    public static class Activity {
        int start;
        int end;
        String owner;
    }
}