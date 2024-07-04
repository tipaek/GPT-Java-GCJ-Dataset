import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class Solution {
    private static class TooManyRespsException extends Exception {
        public TooManyRespsException(String too_many_resps) {
            super(too_many_resps);
        }
    }

    public class Activity {
        public Activity(String start, String end, int index) {
            this.start = Integer.parseInt(start);
            this.end = Integer.parseInt(end);
            this.index = index;
        }
        int index;
        int start;
        int end;
        String responsable;

        public void setResponsable(String responsable) {
            this.responsable = responsable;
        }

        public String getResponsable() {
            return responsable;
        }




        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", end=" + end +
                    ", responsable='" + responsable + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution sol = new Solution();

        Scanner sc = new Scanner(new File("resources/input1.txt"));
        //Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        /****************************************************************************/
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            List<Activity> activities = new ArrayList<>();
            int nbActivities = Integer.parseInt(sc.nextLine());
            for (int a = 0; a < nbActivities; a++) {
                String activity = sc.nextLine();

                String[] tabAct = activity.split(" ");
                activities.add(sol.new Activity(tabAct[0], tabAct[1], a));
            }

            boolean impossible = false;
            for (Activity activity : activities) {
                // is there overlapping activities ?

                List<Activity> overlappingActivities = getOverlapActivities(activity, activities);

                if (overlappingActivities.size() == 0) {
                    activity.setResponsable("J");
                } else {
                    Set<String> resps = findRespForActivities(overlappingActivities);
                    String resp = null;

                    if (resps.size() > 1) {
                        impossible = true;
                    }
                    resp = resps.iterator().hasNext() ? resps.iterator().next() : null;
                    if (resp != null && resp.equals("J")) {
                        activity.setResponsable("C");
                    } else {
                        activity.setResponsable("J");
                    }
                }
            }
            String result = impossible ? "IMPOSSIBLE"
                    : activities.stream().map((activity) -> activity.responsable).collect(Collectors.joining(""));

            System.out.printf("Case #%d: %s", t + 1, result);
            System.out.println("");

        }
    }

    private static Set<String> findRespForActivities(List<Activity> overlappingActivities) {
        Set<String> resps = new HashSet<>();
        for (Activity activity : overlappingActivities) {
            if (activity.responsable != null) {
                resps.add(activity.responsable);
            }
        }

        return resps;
    }

    private static List<Activity> getOverlapActivities(Activity activity, List<Activity> sortedActivities) {
        List<Activity> overlappingActs = new ArrayList<>();
        for (Activity act : sortedActivities
        ) {
            if (act != activity
                    && overlap(act.start, act.end, activity.start, activity.end)) {
                overlappingActs.add(act);
            }
        }
        return overlappingActs;
    }

    public static boolean overlap(int beginAct1, int endAct1, int beginAct2, int endAct2) {
        if (beginAct2 >= beginAct1 && beginAct2 < endAct1
                || beginAct1 > beginAct2 && beginAct1 < endAct2
        ) {
            return true;
        } else {
            return false;
        }

    }


}
