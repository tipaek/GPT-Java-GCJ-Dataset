import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author schenevotot
 */
public class Solution {

    private static final boolean DEBUG = false;

    private List<Activity> cameron;
    private List<Activity> jamie;
    private StringBuilder curResult = new StringBuilder();

    public Solution(int nbr) {
        cameron = new ArrayList<>(nbr);
        jamie = new ArrayList<>(nbr);
    }


    public String solve() {
        return curResult.toString();
    }

    public boolean addActivity(String activity) {
        try {
            Activity ac = createActivity(activity);

            if (hasRoomForActivity(ac, cameron)) {
                cameron.add(ac);
                cameron.sort(Comparator.comparingInt(a -> a.from));
                curResult.append("C");
            } else if (hasRoomForActivity(ac, jamie)) {
                jamie.add(ac);
                jamie.sort(Comparator.comparingInt(a -> a.from));
                curResult.append("J");
            } else {
                curResult = new StringBuilder("IMPOSSIBLE");
                return false;
            }

            return true;
        }
        catch (Exception t) {
            return false;
        }
    }

    private boolean hasRoomForActivity(Activity a, List<Activity> activities) {
        try {
            boolean hasRoom = false;

            if (activities.isEmpty()) {
                return true;
            }

            //Test if first stored activity is after a
            Activity sActivity = activities.get(0);
            if (sActivity.from >= a.end) {
                return true;
            }

            ///Test if last stored activity is before a
            Activity lastActivity = activities.get(activities.size() - 1);
            if (lastActivity.end <= a.from) {
                return true;
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
                        //If the new activity ends before the start of the next existing one
                        hasRoom = storedActivity2.from >= a.end;
                    }
                }
            }

            return hasRoom;
        }
        catch (Exception t) {
            return false;
        }
    }

    private Activity createActivity(String activity) {
        String[] s = activity.split(" ");
        Activity ac = new Activity();
        if (s.length != 2) {
            ac.from = 24;
            ac.end = 42;
        }
        else {
            ac.from = Integer.parseInt(s[0]);
            ac.end = Integer.parseInt(s[1]);
        }
        
        return ac;
    }

    private static class Activity {
        int from;
        int end;

    }

    public static void main(String[] args) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Solution solver;

        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream(Objects.requireNonNull(classLoader.getResource("Parenting-1.in")).getPath()) : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int activitCount = scanner.nextInt();
                scanner.nextLine();
                solver = new Solution(activitCount);
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