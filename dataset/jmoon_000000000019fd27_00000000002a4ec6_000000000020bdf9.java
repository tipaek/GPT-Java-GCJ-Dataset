import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    
    static int findLatestRunningActivity(ArrayList<int[]> activities, HashMap <Integer, Integer> assignable){
        int latest_id = 0;
        int latest_time = 0;
        for (int i = 0; i < activities.size(); i++) {
            if (assignable.containsKey(i) && activities.get(i)[1] > latest_time) {
                latest_id = i;
                latest_time = activities.get(i)[1];
            }
        }
        return latest_id;
    }
    
    static void removeConflicting(HashMap <Integer, Integer> assignable, int id, ArrayList<int[]> activities) {
        int [] interval = activities.get(id);
        ArrayList <Integer> to_be_removed = new ArrayList <Integer> ();
        // System.out.println("Interval: [" + interval[0] + ", " + interval[1]+ "]");
        for (int curr_id : assignable.keySet()){
            int [] curr_interval = activities.get(curr_id);
            // System.out.println(curr_id + " has interval [" + curr_interval[0] + ", " + curr_interval[1] + "].");
            if ((curr_interval[0] > interval[0] && curr_interval[0] < interval[1]) ||
                (curr_interval[1] > interval[0] && curr_interval[1] < interval[1])) {
                // System.out.println("Removing " + curr_id + " from assignable");
                to_be_removed.add(curr_id);
            }
        }
        for (int x : to_be_removed){
            assignable.remove(x);
        }
    }

    static String parentingPartnering(int n, ArrayList<int[]> activities){
        String ans = "";
        HashMap<Integer, Integer> assignment = new HashMap<>();
        HashMap <Integer, Integer> assignable = new HashMap<>();
        int assigned_count = 0;
        // System.out.println("\nN: " + n);
        
        
        for (int i = 0; i < 2; i++) { // Once for Cameron and once for Jamie
            // System.out.println("\nTurn #:" + i);
            for (int j = 0; j < n; j++) { // For Cameron all tasks are assignable. For Jamie, choose from the ones left
                if (!assignment.containsKey(j)) {  // that Jamie hadn't chosen yet.
                    assignable.put(j, 0);
                }
            }
            while (!assignable.isEmpty()) { // While there are activities left to be assigned.
                // System.out.print("Assignable Activities: [");
                for (int id : assignable.keySet()){
                    // System.out.print(id+ ", ");
                }
                // System.out.println("]");
                int activity_id = findLatestRunningActivity(activities, assignable); // Find the last activity
                // System.out.println("Last Activity ID: " + activity_id);
                assignment.put(activity_id, i); // Assign this activity to the current person
                assignable.remove(activity_id); // Now this activity is no longer assignable.
                assigned_count++;
                removeConflicting(assignable, activity_id, activities); // Remove all of the activities that conflict with this activity
            }
           
        }
        if (assigned_count != n){ // If not all the activities were assigned, return IMPOSSIBLE
            return "IMPOSSIBLE";
        }
        for (int i = 0; i < n; i++) {
            ans += assignment.get(i) == 0 ? "C" : "J";
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++){
            int n = scanner.nextInt();
            scanner.nextLine();
            
            ArrayList <int []> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String [] se = scanner.nextLine().split(" ");
                int [] activity = new int [2];
                activity[0] = Integer.parseInt(se[0]);
                activity[1] = Integer.parseInt(se[1]);
                activities.add(activity);
            }

            System.out.println(String.format("Case #%d: %s", i+1, parentingPartnering(n, activities)));
        }

    }
    
}

