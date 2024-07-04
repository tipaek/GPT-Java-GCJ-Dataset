import java.util.*;

/**
 * Solution
 */
class Activity implements Comparable<Activity> {
    public int s, e;
    public Activity (int s, int e) { this.s = s; this.e = e; }

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
            activities.add(new Activity(s, e));
        }

        Collections.sort(activities); // sort based on start time
        
        String sol = "";
        for (int i = 0; i < n - 2; i++) {
            Activity curr = activities.get(i);
            Activity next = activities.get(i+2);
            
            if (curr.e > next.e) {
                sol = "IMPOSSIBLE";
                break;
            } else {
                if (i%2==0) sol += "C";
                else sol += "J";
            }
        }
        if (!sol.equals("IMPOSSIBLE")) {
            if (sol.length()%2==0) sol += "CJ";
            else sol += "JC";
        } 
        System.out.println("Case #" + x + ": " + sol);
    }
}