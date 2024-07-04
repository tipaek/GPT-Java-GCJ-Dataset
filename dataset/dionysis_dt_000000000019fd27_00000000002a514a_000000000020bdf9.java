import java.util.*;

public class Solution {

    private int T;
    private ArrayList<ArrayList<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.readInput();

        for (int x = 0; x < solution.days.size(); x++) {
            ArrayList<Activity> activities = solution.days.get(x);

            activities.sort(new Comparator<Activity>() {
                @Override
                public int compare(Activity activity1, Activity activity2) {
                    return activity1.start - activity2.start;
                }
            });
            boolean possible = solution.schedule(activities);

            String schedule = "";
            if (possible) {
                activities.sort(new Comparator<Activity>() {
                    @Override
                    public int compare(Activity activity1, Activity activity2) {
                        return activity1.order - activity2.order;
                    }
                });

                for (Activity activity : activities) {
                    schedule += activity.assignee;
                }
            } else {
                schedule = "IMPOSSIBLE";
            }
            System.out.println(String.format("Case #%d: %s", x + 1, schedule));

//            activities.forEach(System.out::println);
//            System.out.println("================================================================");


        }

    }

    private boolean schedule(ArrayList<Activity> activities) {
        boolean allAssigned = true;

        ArrayList<Activity> Cameron = new ArrayList<>();
        ArrayList<Activity> Jamie = new ArrayList<>();

        for (final ListIterator<Activity> i = activities.listIterator(); i.hasNext(); ) {
            final Activity element = i.next();

            boolean assignedToCameron, assignedToJamie = false;
            assignedToCameron = assignActivity(element, Cameron, "C");
            if (!assignedToCameron) {
                assignedToJamie = assignActivity(element, Jamie, "J");
            }
            allAssigned = allAssigned && (assignedToCameron || assignedToJamie);

            i.set(element);
        }

        return allAssigned;
    }

    public boolean assignActivity(Activity activity, ArrayList<Activity> parentActivities, String initial) {
        boolean assigned = false;
        if (parentActivities.isEmpty()) assigned = true;
        else {
            Activity lastElement = parentActivities.get(parentActivities.size() - 1);
            if (activity.start >= lastElement.end) assigned = true;
        }

        if (assigned) {
            activity.assignee = initial;
            parentActivities.add(activity);
        }
        return assigned;
    }

    private void readInput() {

        Scanner reader = new Scanner(System.in);
        String data;

        if (reader.hasNextLine()) {
            data = reader.nextLine();
            T = Integer.parseInt(data);
        }

        for (int i = 0; i < T; i++) {

            data = reader.nextLine();
            int N = Integer.parseInt(data);
            ArrayList<Activity> activities = new ArrayList<>();

            for (int j = 0; j < N; j++) {

                data = reader.nextLine();
                String[] cells = data.split(" ", 0);
                Activity activity = new Activity(j, Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
                activities.add(activity);
            }

            this.days.add(activities);

        }

        reader.close();

    }

    public class Activity {
        int order;
        int start;
        int end;
        String assignee;

        public Activity(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
            this.assignee = "";
        }

        @Override
        public String toString() {
            return String.format("Assignee: %s\t\t Order: %d \t\t Start: %d\t\t End: %d", assignee, order, start, end);
        }
    }

}