import java.util.*;

/**
 * Solution
 */
class Activity implements Comparable<Activity> {
    public int s, e, i;
    public Activity (int s, int e, int i) { this.s = s; this.e = e; this. i = i; }

    @Override
    public int compareTo(Activity o) {
        return Integer.compare(this.s, o.s);
    }
}

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            solve(x);
        }
    }


    private static void solve(long x) {
        int n = sc.nextInt();
        
        ArrayList<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(), e = sc.nextInt();
            activities.add(new Activity(s, e, i));
        }

        Collections.sort(activities); // sort based on start time
        
        char sol[] = new char[n];
        boolean impossible = false;
        for (int i = 0; i < n - 2; i++) {
            Activity curr = activities.get(i);
            Activity next = activities.get(i+2);
            
            if (curr.e > next.e) {
                impossible = true;
                break;
            } else {
                if (i%2==0) sol[curr.i] = 'C';
                else sol[curr.i] = 'J';
            }
        }
        if(impossible) System.out.println("Case #" + x + ": IMPOSSIBLE");
        else {
            if (n%2==0) { sol[activities.get(n - 2).i] = 'C'; sol[activities.get(n - 1).i] = 'J'; }
            else { sol[activities.get(n - 2).i] = 'J'; sol[activities.get(n - 1).i] = 'C'; }
            String solString = new String(sol);
            System.out.println("Case #" + x + ": " + solString);
        }
    }
}