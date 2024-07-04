
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Arles
 */
class Activity implements Comparable<Activity> {

    Integer start;
    Integer end;
    Integer id;

    public Activity(Integer start, Integer end, Integer id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Activity o) {
        return end.compareTo(o.end);
    }

    @Override
    public String toString() {
        return "Activity{" + "start=" + start + ", end=" + end + ", id=" + id + "}\n";
    }

    
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cases = 1;
        while (cases <= T) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Activity> activities = new ArrayList<>();
            char[] solution = new char[N];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                Activity a = new Activity(Integer.parseInt(line[0]), Integer.parseInt(line[1]), i);
                activities.add(a);
            }
            Collections.sort(activities);
            //System.out.println("sorted"+ activities);
            ArrayList<Activity> activities2 = new ArrayList<>();

            Activity last = activities.get(0);
            solution[last.id] = 'C';
            for (int i = 1; i < activities.size(); i++) {
                //System.out.println(activities.get(i).start + " vs " + last.id);
                if (activities.get(i).start >= last.end) {
                    last = activities.get(i);
                    //System.out.println("C" + last);
                    solution[last.id] = 'C';
                } else {
                    activities2.add(activities.get(i));
                }
            }
            boolean impossible = false;

            if (!activities2.isEmpty()) {
                last = activities2.get(0);
                solution[last.id] = 'J';
                for (int i = 1; i < activities2.size(); i++) {
                    if (activities2.get(i).start >= last.end) {
                        last = activities2.get(i);
                        solution[last.id] = 'J';
                    } else {
                        System.out.println("Case #" + cases + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }
            
            if (!impossible) {
                String s = new String(solution);
                System.out.println("Case #" + cases + ": " + s);
            }
            cases++;
        }

    }

}

