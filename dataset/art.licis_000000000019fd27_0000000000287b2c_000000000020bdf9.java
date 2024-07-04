import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            List<Work> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new Work(null, new int[] { sc.nextInt(), sc.nextInt() }, i));
            }

            intervals.sort(Comparator.comparingInt(w -> w.interval[0]));

            String solution = solution(intervals);
            System.out.printf("Case #%d: %s%n", tc, solution);
        }
        System.out.flush();
    }

    static class Work {
        Character worker;
        int[] interval;
        int order;

        Work(Character worker, int[] interval, int order) {
            this.worker = worker;
            this.interval = interval;
            this.order = order;
        }
    }

    static String solution(List<Work> workList) {
        Deque<Character> workers = new ArrayDeque<>();
        workers.push('C');
        workers.push('J');

        List<Work> inProgressList = new ArrayList<>(2);
        List<Work> toRemove = new ArrayList<>(2);

        for (Work w : workList) {
            final int start = w.interval[0];

            toRemove.clear();
            for (Work inProgress : inProgressList) {
                if (inProgress.interval[1] <= start) { toRemove.add(inProgress); workers.push(inProgress.worker); }
            }
            inProgressList.removeAll(toRemove);

            if (inProgressList.size() >= 2) return "IMPOSSIBLE";

            w.worker = workers.pop();
            inProgressList.add(w);
        }

        workList.sort(Comparator.comparingInt(w -> w.order));
        return workList.stream().map(w -> w.worker + "").collect(Collectors.joining());
    }
}
