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
        Activity c = null, j = null;
        for(Activity a : activities) {
            if (c == null) {
                c = a;
                sol[a.i] = 'C';
            }
            else if (j == null) {
                j = a;
                sol[a.i] = 'J';
            }
            else {
                if(a.s >= c.e) { 
                    c = a;
                    sol[a.i] = 'C';
                }
                else if (a.s >= j.e) {
                    j = a;
                    sol[a.i] = 'J';
                }
                else {
                    impossible = true;
                    break;
                }
            }
        }
        
        if (impossible) System.out.println("Case #" + x + ": IMPOSSIBLE");
        else { 
            String solString = new String(sol);
            System.out.println("Case #" + x + ": " + solString);
        }
    }
}