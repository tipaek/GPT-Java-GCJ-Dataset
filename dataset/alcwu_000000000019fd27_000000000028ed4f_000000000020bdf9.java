import java.util.*;
import java.io.*;

public class Solution{
    static HashMap<int[], Boolean> parentResponsible;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            ArrayList<int[]> arr = new ArrayList<int[]>();
            for(int a = 0; a < n; a++){
                int[] pair = new int[2];
                for(int j = 0; j < 2; j++){
                    pair[j] = in.nextInt();
                }
                arr.add(pair);
            }
            String ans = parentSchedule(arr);
            System.out.println(print(i, ans));
          }
    }

    public static String print(int input, String str){
        return "Case #" + input + ": " + str;
    }

    public static String parentSchedule(List<int[]> activities){
        parentResponsible = new HashMap<int[], Boolean>();
        List<int[]> chronAct = sortSchedule(activities);

        // updates the mapper
        overlapActivities(chronAct);

        return finalSchedule(activities);
    }

    public static void overlapActivities(List<int[]> chronAct){
        int[] active = chronAct.get(0);
        int[] waiting = null;
        parentResponsible.put(active, true);
        for(int i = 1; i < chronAct.size(); i++){
            int[] nextActivity = chronAct.get(i);
            if(active[0] == nextActivity[0] || active[1] > nextActivity[0]){
                if(waiting == null){
                    waiting = nextActivity;
                    parentResponsible.put(waiting, false);
                }else{
                    // if both parents are occupied
                    if(waiting[1] > nextActivity[0]){
                        parentResponsible.put(nextActivity, null);
                    } else { // if the second parent has time to do the next task
                        waiting = nextActivity;
                        parentResponsible.put(waiting, false);
                    }
                }
            } else {
                active = nextActivity;
                parentResponsible.put(active, true);
                waiting = null;
            }
        }
    }

        // returns c of j
    public static ArrayList<int[]> sortSchedule(List<int[]> activities){
        ArrayList<int[]> ans = new ArrayList<int[]>(activities);
            Comparator c = new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return (a[0] - b[0]);
                }
            };
            Collections.sort(ans, c);
            return ans;
    }

    public static String finalSchedule(List<int[]> activities){
        StringBuilder sb = new StringBuilder();
        for(int[] activityInterval : activities){
            Boolean parent = parentResponsible.get(activityInterval);
            if (parent == null){
                return "IMPOSSIBLE";
            } else {
                if(parent){
                    sb.append('C');
                } else {
                    sb.append('J');
                }
            }
        }
        return sb.toString();
    }
}