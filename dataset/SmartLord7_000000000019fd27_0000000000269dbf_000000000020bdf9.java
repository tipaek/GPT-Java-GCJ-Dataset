
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    
    static class actComparator <T extends Comparable<T>> implements Comparator<int[]> {

        @Override
        public int compare(int[] act1, int[] act2) {
            if (act1[0] > act2[0]) {
                return 1;
            } else if (act1[0] < act2[1]) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    static String solve(ArrayList <int[]> timetable) {
        ArrayList<int[]> copy = (ArrayList<int[]>) timetable.clone();
        copy.sort(new actComparator());
        HashMap <int[], Character> corresp = new HashMap<>();
        for (int i = 0; i < copy.size(); i++) {
            corresp.putIfAbsent(timetable.get(i), Character.MIN_VALUE);
        }
        int lastCameron = -1, lastJason = -1;
        String result = "";
        for (int[] activity : copy) {
            if (lastCameron == -1 || !(lastCameron > activity[0])) {
                corresp.replace(activity, 'C');
                lastCameron = activity[1];
            } else if (lastJason == -1 || !(lastJason > activity[0])) {
                corresp.replace(activity, 'J');
                lastJason = activity[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        for (int[] act : timetable) {
            result += corresp.get(act);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(in.readLine());
        for (int i = 0; i < numCases; i++){
            ArrayList <int[]> timetable = new ArrayList<>();
            int numAct = Integer.parseInt(in.readLine());
            for (int j = 0; j < numAct; j++) {
                StringTokenizer data = new StringTokenizer(in.readLine());
                int pair[] = {Integer.parseInt(data.nextToken()), Integer.parseInt(data.nextToken())};
                timetable.add(pair);
            }
            System.out.println("Case #" + Integer.toString(i + 1) + ": " + solve(timetable));
        }
    }
}
