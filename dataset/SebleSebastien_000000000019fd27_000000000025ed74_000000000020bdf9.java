import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author schenevotot
 */
public class Solution {

    private static final boolean DEBUG = false;

    //private Set<Activity> cameron;
    private List<Activity> cameron;
    //private Set<Activity> jamie;
    private List<Activity> jamie;
    private StringBuilder curResult = new StringBuilder();

    public Solution() {
        //cameron = new TreeSet<>((a1, a2) -> (a1.from - a2.from) * 24 * 60 + (a1.end - a2.end));
        //jamie = new TreeSet<>((a1, a2) -> (a1.from - a2.from) * 24 * 60 + (a1.end - a2.end));
        cameron = new ArrayList<>();
        jamie = new ArrayList<>();
    }


    public String solve() {
        return curResult.toString();
    }

    public boolean addActivity(String activity) {
        Activity ac = createActivity(activity);

        if (hasRoomForActivity(ac, cameron)) {
            cameron.add(ac);
            cameron.sort((a1, a2) -> (a1.from - a2.from) * 24 * 60 + (a1.end - a2.end));
            curResult.append("C");
        } else if (hasRoomForActivity(ac, jamie)) {
            jamie.add(ac);
            jamie.sort((a1, a2) -> (a1.from - a2.from) * 24 * 60 + (a1.end - a2.end));
            curResult.append("J");
        } else {
            curResult = new StringBuilder("IMPOSSIBLE");
            return false;
        }

        return true;
    }

    private boolean hasRoomForActivity(Activity a, List<Activity> activities) {
        boolean hasRoom = false;

        if (activities.isEmpty()) {
            return true;
        }

        if (activities.size() == 1) {
            //Corner case, only one stored activity which starts after the end of a
            Activity storedActivity = activities.iterator().next();
            if (storedActivity.end <= a.from || storedActivity.from >= a.end) {
                return true;
            }
        }
        ListIterator<Activity> iterator = activities.listIterator();
        while (iterator.hasNext()) {
            Activity storedActivity1 = iterator.next();
            if (storedActivity1.end <= a.from) {
                //The new activity starts after the end of the existing one
                if (iterator.hasNext()) {
                    Activity storedActivity2 = iterator.next();
                    //Jump back
                    iterator.previous();
                    if (storedActivity2.from >= a.end) {
                        //If the new activity ends before the start of the next existing one
                        hasRoom = true;
                    } else {
                        hasRoom = false;
                    }
                } else {
                    hasRoom = true;
                }
            }
        }

        return hasRoom;
    }

    //  private Activity nextActivity(Activity a, List<Activity> activitiesSet) {
    //      activitiesSet.listIterator()
    //  }

    private Activity createActivity(String activity) {
        String[] s = activity.split(" ");
        Activity ac = new Activity();
        ac.from = Integer.parseInt(s[0]);
        ac.end = Integer.parseInt(s[1]);
        return ac;
    }

    private static class Activity {
        int from;
        int end;

    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Solution solver = null;

        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(Objects.requireNonNull(classLoader.getResource("Parenting-1.in")).getPath()) : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            scanner.nextLine();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int activitCount = scanner.nextInt();
                scanner.nextLine();
                solver = new Solution();
                for (int i = 0; i < activitCount; i++) {
                    String line = scanner.nextLine();
                    boolean success = solver.addActivity(line);
                    if (!success) {
                        break;
                    }
                }

                String result = solver.solve();


                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
        //System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}