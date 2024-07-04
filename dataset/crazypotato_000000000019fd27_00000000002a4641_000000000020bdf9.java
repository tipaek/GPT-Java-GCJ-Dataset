import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] input = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    input[j][k] = in.nextInt();
                }
            }
            String r = new Checker(n, input).getResult();
            System.out.println("Case #" + i + ": " + r);
        }

    }


    public static class Checker {
        private final int[][] input;
        private final int n;

        public Checker(int n, int[][] input) {
            this.n = n;
            this.input = input;
        }

        public String getResult() {

            int freeC = 0;
            int freeJ = 0;
            StringBuilder schedule = new StringBuilder();
            List<Activity> activityList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activityList.add(new Activity(input[i][0], input[i][1], i));
            }
            List<Activity> sorted = activityList.stream().sorted(Comparator.comparingInt(Activity::getFrom)).collect(Collectors.toList());

            for (Activity a : sorted) {
                if (freeC <= a.from) {
                    a.responsible = "C";
                    freeC = a.to;
                } else if (freeJ <= a.from) {
                    a.responsible = "J";
                    freeJ = a.to;
                } else {
                    return "IMPOSSIBLE";
                }
            }
            activityList.forEach(a -> schedule.append(a.responsible));

            return schedule.toString();
        }
    }

    public static class Activity {
        public final int from;
        public final int to;
        public final int id;
        public String responsible;

        public Activity(int from, int to, int id) {
            this.from = from;
            this.to = to;
            this.id = id;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getId() {
            return id;
        }
    }
}
