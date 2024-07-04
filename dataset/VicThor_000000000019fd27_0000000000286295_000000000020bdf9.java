import java.util.*;

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

            Pair currCActivity = null;
            Pair currJActivity = null;
            for (Pair activity : activities) {
                if (currJActivity == null || currJActivity.finish <= activity.start) {
                    currJActivity = activity;
                    result.append("J");
                } else if (currCActivity == null || currCActivity.finish <= activity.start) {
                    currCActivity = activity;
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }
            System.out.println(String.format("Case #%s: %s", testCase + 1, result));
        }
    }

    private static class Pair {
        int start;
        int finish;

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                .add("start=" + start)
                .add("finish=" + finish)
                .toString();
        }
    }
}