import java.util.*;

public class Solution {
    private static int caseCount = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner);
        }
        scanner.close();
    }

    private static void processTestCase(Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, end));
        }

        activities.sort(Activity.START_TIME_COMPARATOR);

        int cameronEndTime = 0;
        int jaimeEndTime = 0;
        boolean isImpossible = false;

        for (Activity activity : activities) {
            if (cameronEndTime <= activity.getStart()) {
                cameronEndTime = activity.getEnd();
                activity.setPerson('C');
            } else if (jaimeEndTime <= activity.getStart()) {
                jaimeEndTime = activity.getEnd();
                activity.setPerson('J');
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + caseCount + ": IMPOSSIBLE");
        } else {
            activities.sort(Comparator.comparingInt(Activity::getIndex));
            StringBuilder result = new StringBuilder();
            for (Activity activity : activities) {
                result.append(activity.getPerson());
            }
            System.out.println("Case #" + caseCount + ": " + result.toString());
        }
        caseCount++;
    }

    private static class Activity {
        private final int index;
        private final int start;
        private final int end;
        private char person;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public char getPerson() {
            return person;
        }

        public void setPerson(char person) {
            this.person = person;
        }

        public static final Comparator<Activity> START_TIME_COMPARATOR = Comparator.comparingInt(Activity::getStart);
    }
}