import java.util.*;

class Solution {

    public static void main(String[] args) {
        class Pair implements Comparable<Pair> {
            public final int index;
            public final int startTime;
            public int endTime;
            public char assignedPerson;

            public Pair(int index, int startTime, int endTime) {
                this.index = index;
                this.startTime = startTime;
                this.endTime = endTime;
            }

            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.startTime, other.startTime);
            }
        }

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int currentTestCase = 0;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            Pair[] activities = new Pair[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Pair(i, start, end);
            }

            Arrays.sort(activities);

            int endC = 0, endJ = 0;
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (Pair activity : activities) {
                if (activity.startTime >= endC) {
                    endC = activity.endTime;
                    activity.assignedPerson = 'C';
                } else if (activity.startTime >= endJ) {
                    endJ = activity.endTime;
                    activity.assignedPerson = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
                for (Pair activity : activities) {
                    result.append(activity.assignedPerson);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (++currentTestCase) + ": " + result.toString());
        }

        scanner.close();
    }
}