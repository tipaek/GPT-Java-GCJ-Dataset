import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        String responsible;
        int id;

        public Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "Activity [start=" + start + ", end=" + end + ", responsible=" + responsible + ", id=" + id + "]";
        }
    }

    static class Input {
        int n; // number of activities
        ArrayList<Activity> activities;
        ArrayList<Activity> sortedActivities;

        public Input(int n, ArrayList<Activity> activities) {
            this.n = n;
            this.activities = new ArrayList<>(activities);
            this.sortedActivities = new ArrayList<>(activities);
            Collections.sort(this.sortedActivities);
        }

        @Override
        public String toString() {
            return "Input [n=" + n + ", activities=" + activities + ", sortedActivities=" + sortedActivities + "]";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        int T = Integer.parseInt(scan.nextLine());
        for (int ks = 1; ks <= T; ks++) {
            Input input = readInput(scan);
            String solution = solve(input);
            System.out.println("Case #" + ks + ": " + solution);
        }
    }

    private static String solve(Input input) {
        int endC = 0;
        int endJ = 0;

        for (Activity activity : input.sortedActivities) {
            if (endC <= activity.start) {
                activity.responsible = "C";
                endC = activity.end;
            } else if (endJ <= activity.start) {
                activity.responsible = "J";
                endJ = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder solution = new StringBuilder();
        for (Activity activity : input.activities) {
            solution.append(activity.responsible);
        }

        return solution.toString();
    }

    private static Input readInput(Scanner scan) {
        int n = scan.nextInt();
        ArrayList<Activity> activities = new ArrayList<>();
        for (int id = 0; id < n; id++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            activities.add(new Activity(start, end, id));
        }
        return new Input(n, activities);
    }
}