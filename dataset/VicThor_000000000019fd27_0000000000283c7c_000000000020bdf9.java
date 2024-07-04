import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine()); //  Integer.parseInt(System.console().readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int activitiesCount = in.nextInt();
            StringBuilder result = new StringBuilder();
            List<Pair> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                Pair activity = new Pair();
                activity.start = in.nextInt();
                activity.finish = in.nextInt();
                activities.add(activity);
            }

            activities.sort(Comparator.comparing(pair -> pair.start));

            Pair currCActitivity = null;
            Pair currJActivity = null;
            for (Pair activity : activities) {
                if (currCActitivity == null || currCActitivity.finish <= activity.start) {
                    currCActitivity = activity;
                    result.append("C");
                } else if (currJActivity == null || currJActivity.finish <= activity.start) {
                    currJActivity = activity;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }
            System.out.println(String.format("Case #%s: %s", testCase +1, result));
        }
    }

    private static class Pair {
        int start;
        int finish;
    }
}