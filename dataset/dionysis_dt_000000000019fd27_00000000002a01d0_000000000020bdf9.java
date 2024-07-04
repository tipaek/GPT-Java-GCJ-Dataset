import java.util.*;

public class Solution {

    private int T;
    private ArrayList<ArrayList<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.readInput();

        for (int x = 0; x< solution.days.size(); x++) {
            ArrayList activities = solution.days.get(x);
//            System.out.println("===================================================");
            System.out.println(String.format("Case #%d: %s", x+1, solution.schedule(activities)));
//            activities.sort(new Comparator<Activity>() {
//                @Override
//                public int compare(Activity activity1, Activity activity2) {
//                    return activity1.start - activity2.start;
//                }
//            });
//            activities.forEach(System.out::println);
        }

    }

    private String schedule(ArrayList<Activity> activities) {
        String schedule = "";
        boolean allAssigned = true;

        ArrayList<Activity> Cameron = new ArrayList<>();
        ArrayList<Activity> Jamie  = new ArrayList<>();

        for (final ListIterator<Activity> i = activities.listIterator(); i.hasNext();) {
            final Activity element = i.next();

            boolean assignedToCameron = false;
            boolean assignedToJamie = false;

            assignedToCameron = assignActivity(element, Cameron, "C");
            if(assignedToCameron) schedule += "C";
            else {
                assignedToJamie = assignActivity(element, Jamie, "J");
                if(assignedToJamie) schedule += "J";
            }
            allAssigned = allAssigned && (assignedToCameron || assignedToJamie);

            i.set(element);
        }

        if(!allAssigned) return "IMPOSSIBLE";
        else return schedule;
    }

    public boolean assignActivity(Activity activity, ArrayList<Activity> parentActivities, String initial) {
        boolean assigned = false;
        boolean clashes = false;
        if(parentActivities.isEmpty()) {
            activity.assignee = initial;
            parentActivities.add(activity);
            assigned = true;
        } else {
            for (int i=0; i<parentActivities.size(); i++) {
                Activity parentActivity = parentActivities.get(i);
                boolean checkWithCurrent = activity.start >= parentActivity.end || activity.end <= parentActivity.start;
                boolean checkWithNext = true;
                if(i != parentActivities.size() - 1) {
                    Activity nextParentActivity = parentActivities.get(i+1);
                    checkWithNext = activity.start >= nextParentActivity.end || activity.end <= nextParentActivity.start;
                }
                if (checkWithCurrent && checkWithNext) {
                    activity.assignee = initial;
                    assigned = true;
                }
            }
            if(assigned) {
                parentActivities.add(activity);
                parentActivities.sort(new Comparator<Activity>() {
                    @Override
                    public int compare(Activity activity1, Activity activity2) {
                        return activity1.start - activity2.start;
                    }
                });
            }
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
                Activity activity = new Activity(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
                activities.add(activity);
            }

            this.days.add(activities);

        }

        reader.close();

    }

    public class Activity {
        int start;
        int end;
        String assignee;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignee = "";
        }

        @Override
        public String toString() {
            return String.format("Assignee: %s\t\t Start: %d\t\t End: %d", assignee, start, end);
        }
    }

}