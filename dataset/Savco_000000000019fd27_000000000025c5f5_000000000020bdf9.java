import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            ArrayList<Activity> activities = new ArrayList<>();
            int count = in.nextInt();
            for (int j = 0; j < count; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end, j));
            }
            Collections.sort(activities);

            char[] result = new char[count];
            Activity ja = activities.get(0);
            Activity ca = null;
            result[ja.getOriginalOrder()] = 'J';
            boolean impossible = false;
            for (int j = 1; j < count; j++) {
                Activity current = activities.get(j);
                if (current.getStart() >= ja.getEnd()) {
                    ja = current;
                    result[ja.getOriginalOrder()] = 'J';
                }
                else if (ca == null){
                    ca = current;
                    result[ca.getOriginalOrder()] = 'C';
                }
                else if (current.getStart() >= ca.getEnd()) {
                    ca = current;
                    result[ca.getOriginalOrder()] = 'C';
                }
                else impossible = true;
            }
            if (impossible) System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            else System.out.println("Case #" + i + ": " + String.valueOf(result));
        }
    }
}

class Activity implements Comparable<Activity>{
    private int start;
    private int end;
    private int originalOrder;

    Activity(int start, int end, int originalOrder){
        this.start = start;
        this.end = end;
        this.originalOrder = originalOrder;
    }

    int getStart() {
        return this.start;
    }

    int getEnd() {
        return this.end;
    }

    int getOriginalOrder(){
        return this.originalOrder;
    }

    public int compareTo(Activity a) {
        return this.start - a.start;
    }
}