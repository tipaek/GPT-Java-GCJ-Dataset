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
        Map<Interval, Integer> ansMap = new HashMap<>();
        List<Interval> schedule = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            schedule.add(new Interval(from, to));
        }

        List<Interval> sortedSchedule = new ArrayList<>(schedule);
        sortedSchedule.sort(Comparator.comparingInt(Interval::getTo));

        int first = sortedSchedule.get(0).getTo();
        ansMap.put(sortedSchedule.get(0), 1);
        int second = -1;

        for (int i = 1; i < schedule.size(); i++) {
            Interval currInterval = sortedSchedule.get(i);
            if (currInterval.getFrom() >= first) {
                ansMap.put(currInterval, 1);
                first = currInterval.getTo();
            } else if (currInterval.getFrom() >= second) {
                ansMap.put(currInterval, -1);
                second = currInterval.getTo();
            } else {
                System.out.println("Case #" + T + ": " + "IMPOSSIBLE");
                return;
            }
        }

        schedule.forEach(interval -> {
            Integer color = ansMap.get(interval);
            ans.append(color == 1 ? "C" : "J");
        });
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
