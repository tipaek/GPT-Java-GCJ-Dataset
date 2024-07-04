import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= T; ++i) {
            helpParents(in, i);
        }
    }

    private static void helpParents(Scanner scanner, int T) {
        int N = scanner.nextInt();
        StringBuilder ans = new StringBuilder();
        Map<Interval, Character> ansMap = new HashMap<>();
        List<Interval> schedule = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            schedule.add(new Interval(from, to));
        }

        List<Interval> sortedSchedule = new ArrayList<>(schedule);
        sortedSchedule.sort((Interval interval1, Interval interval2) -> {
            if (interval1.getTo() != interval2.getTo())
                return interval1.getTo() - interval2.getTo();
            else {
                return interval1.getFrom() - interval2.getFrom();
            }
        });

        int size = sortedSchedule.size();
        int first = sortedSchedule.get(size - 1).getFrom();
        ansMap.put(sortedSchedule.get(size - 1), 'C');
        int second = Integer.MAX_VALUE;

        for (int i = size - 2; i >= 0; i--) {
            Interval currInterval = sortedSchedule.get(i);
            if (currInterval.getTo() <= first) {
                ansMap.put(currInterval, 'C');
                first = currInterval.getFrom();
            } else if (currInterval.getTo() <= second) {
                ansMap.put(currInterval, 'J');
                second = currInterval.getFrom();
            } else {
                System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
                return;
            }
        }

        schedule.forEach(interval -> ans.append(ansMap.get(interval)));
        System.out.println("Case #" + T + ": " + ans);
    }

    static class Interval {
        int from;
        int to;

        int getFrom() {
            return from;
        }

        int getTo() {
            return to;
        }

        Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

    }
}
