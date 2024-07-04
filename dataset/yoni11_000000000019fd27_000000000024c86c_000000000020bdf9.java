import java.util.*;

public class Solution {

    private static class Activity implements Comparable<Activity> {

        private int start, end;
        private char person;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() { return start; }
        int getEnd() { return end; }

        char getPerson() { return person; }

        void setPerson(char person) {
            this.person = person;
        }

        @Override
        public int compareTo(Activity activity) {
            return Integer.compare(start, activity.getStart());
        }

        boolean overlapsWith(Activity activity) {
            return this.start < activity.getEnd() && this.end > activity.getEnd() ||
                   this.start < activity.getStart() && this.end > activity.getStart() ||
                   activity.start < this.getEnd() && activity.end > this.getEnd() ||
                   activity.start < this.getStart() && activity.end > this.getStart();
        }
    }

    private static String getSchedule(List<Activity> sorted, List<Activity> original) {
        StringBuilder result = new StringBuilder();

        char person = 'C';
        Activity currentOfC = null;
        Activity currentOfJ = null;
        for (Activity current : sorted) {
            if (currentOfJ != null && currentOfC != null && currentOfC.overlapsWith(currentOfJ) &&
                currentOfC.overlapsWith(current) && currentOfJ.overlapsWith(current)) {
                return "IMPOSSIBLE";
            }
            if(person == 'C') {
                if(currentOfC != null && currentOfC.overlapsWith(current)) {
                    person = 'J';
                    currentOfJ = current;
                } else {
                    currentOfC = current;
                }
            } else {
                if(currentOfJ != null && currentOfJ.overlapsWith(current)) {
                    person = 'C';
                    currentOfC = current;
                } else {
                    currentOfJ = current;
                }
            }
            current.setPerson(person);
        }

        for(Activity activity : original) {
            result.append(activity.getPerson());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(s.nextInt(), s.nextInt()));
            }
            List<Activity> sorted = new ArrayList<>(activities);
            Collections.sort(sorted);
            System.out.println(String.format("Case #%d: %s", i+1, getSchedule(sorted, activities)));
        }
    }
}
