import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // File myObj = new File("test.txt");
        // Scanner in = new Scanner(myObj);

        final String JARED = "J";
        final String CAMER = "C";

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        HashMap<String, Integer> endsAt = new HashMap<>();
        StringBuilder actions;

        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();

            ArrayList<Action> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                a.add(new Action(s,e,i));            
            }
            
            Collections.sort(a, (a1, a2) -> a1.start.compareTo(a2.start));
            endsAt.put(JARED, 0);
            endsAt.put(CAMER, 0);
            boolean impossible = false;

            Action oldAction = null;
            for (Action action : a) {
                if (impossible) break;
                if (oldAction == null) {
                    action.who = JARED;
                    oldAction = action;
                    endsAt.put(JARED, action.end);
                    continue;
                }

                if (action.overlaps(oldAction)) {
                    String who = theOther(oldAction.who);
                    if (endsAt.get(who) <= action.start) {
                        action.who = who;
                    } else {
                        impossible = true;
                    }
                } else {
                    action.who = oldAction.who;
                }
                endsAt.put(action.who, action.end);
                oldAction = action;
            }

            if (impossible) {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE"); 
                continue;
            }

            // sort by id
            Collections.sort(a, (a1, a2) -> a1.id.compareTo(a2.id));

            // extract actions string
            actions = new StringBuilder();
            for (Action action : a) {
                actions.append(action.who);
            }

            System.out.println("Case #" + tt + ": " + actions.toString());
            
        }

        in.close();
    }

    private static String theOther(String name) {
        if (name.equals("J")) return "C";
        if (name.equals("C")) return "J";
        System.out.println("error in name");
        throw new RuntimeException("Error in name");
    }

    
}

class Action {
    Integer start;
    int end;
    String who;
    Integer id;

    public Action(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    boolean overlaps(Action a2) {
        if ((this.start < a2.end && this.start >= a2.start) || (a2.start >= this.start && a2.start < this.end)) {
            return true;
        }
        return false;
    }
}