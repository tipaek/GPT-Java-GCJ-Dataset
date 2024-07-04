import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];

            for (int i = 0; i < activityCount; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(activities);
            activities[0].assignedPerson = 'C';
            int lastCIndex = 0;
            int lastJIndex = -1;
            boolean isImpossible = false;

            for (int i = 1; i < activityCount; i++) {
                char previousPerson = activities[i - 1].assignedPerson;

                if (!activities[i].overlaps(activities[i - 1])) {
                    activities[i].assignedPerson = previousPerson;
                    if (previousPerson == 'C') {
                        lastCIndex = i;
                    } else {
                        lastJIndex = i;
                    }
                } else {
                    if (previousPerson == 'C') {
                        if (lastJIndex == -1 || !activities[lastJIndex].overlaps(activities[i])) {
                            activities[i].assignedPerson = 'J';
                            lastJIndex = i;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        if (lastCIndex == -1 || !activities[lastCIndex].overlaps(activities[i])) {
                            activities[i].assignedPerson = 'C';
                            lastCIndex = i;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }

            char[] result = new char[activityCount];
            for (int i = 0; i < activityCount; i++) {
                result[activities[i].index] = activities[i].assignedPerson;
            }

            System.out.printf("Case #%d: %s\n", caseNumber++, isImpossible ? "IMPOSSIBLE" : new String(result));
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, end, index;
        char assignedPerson;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        public boolean overlaps(Activity other) {
            return (other.start < this.end && other.start >= this.start) || (this.start < other.end && this.start >= other.start);
        }
    }
}