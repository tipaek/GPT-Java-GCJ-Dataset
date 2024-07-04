import static java.lang.String.format;
import static java.util.Comparator.comparingInt;
import static java.util.stream.IntStream.range;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase(i + 1);
        }
    }

    private void solveCase(int item) {
        Input input = getInput();
        System.out.println(format("Case #%d: %s", item, solve(input)));
    }

    private String solve(Input input) {
        Arrays.sort(input.activities, comparingInt(o -> o.end));

        SortedSet<List<Activity>> activitySet = new TreeSet<>((o1, o2) -> {
            int i = o2.get(o2.size() - 1).end - o1.get(o1.size() - 1).end;
            return i != 0 ? i : o2.get(o2.size() - 1).number - o1.get(o1.size() - 1).number;
        });
        List<Activity> list0 = new ArrayList<>();
        list0.add(new Activity(-1, 0, 0));
        List<Activity> list1 = new ArrayList<>();
        list1.add(new Activity(-2, 0, 0));
        activitySet.add(list0);
        activitySet.add(list1);

        for (Activity activity : input.activities) {
            Iterator<List<Activity>> iterator = activitySet.iterator();
            boolean found = false;
            while (!found && iterator.hasNext()) {
                List<Activity> next = iterator.next();
                if (next.get(next.size() - 1).end <= activity.start) {
                    activitySet.remove(next);
                    next.add(activity);
                    activitySet.add(next);
                    found = true;
                }
            }
            if (!found) {
                return "IMPOSSIBLE";
            }
        }
        List<Activity>[] array = new List[2];
        array[0] = activitySet.first();
        array[1] = activitySet.last();
        char[] chars = {'C', 'J'};
        char[] response = new char[input.n];
        for (int i = 0; i < 2; i++) {
            for (Activity activity : array[i]) {
                if (activity.number >= 0) {
                    response[activity.number] = chars[i];
                }
            }
        }

        return String.valueOf(response);
    }

    private Input getInput() {
        int n = scanner.nextInt();
        Activity[] activities = new Activity[n];
        range(0, n).forEach(i -> activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt()));
        return new Input(n, activities);
    }

    class Input {
        int n;
        Activity[] activities;

        public Input(int n, Activity[] activities) {
            this.n = n;
            this.activities = activities;
        }
    }

    class Activity {
        int number;
        int start;
        int end;

        public Activity(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }

}
