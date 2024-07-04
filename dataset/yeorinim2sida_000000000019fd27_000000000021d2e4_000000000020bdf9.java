import java.util.Arrays;
import java.util.Scanner;

public class Solution {
        static char CAMERON = 'C'; // Cameron
    static char JAMIE = 'J'; // Jamie

    final static int NOT_RESOLVED = -1;
    
    final static int ORIGIN_IDX = 0;
    final static int S_TIME = 1;
    final static int E_TIME = 2;
    final static int PARENT = 3;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.next());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(sc.next()); // # of schedules
            int [][] activities = new int[N][4];
            for (int ir = 0; ir < activities.length; ir++) {
                activities[ir][ORIGIN_IDX] = ir; // mark origin index
                activities[ir][S_TIME] = Integer.parseInt(sc.next()); // starts at
                activities[ir][E_TIME] = Integer.parseInt(sc.next()); // ends at
                activities[ir][PARENT] = NOT_RESOLVED ; // index of next non-conflicting activity
            }
            // sory by start time
            Arrays.sort(activities, (a, b) -> a[S_TIME] - b[S_TIME]);
            resolveParenting(activities, 0, CAMERON, -1, -1);
            System.out.printf("Case #%d: %s\n", tc, schedule(activities));
        }
    }
    
    static String schedule(int [][] activities) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(activities, (a, b) -> a[ORIGIN_IDX] - b[ORIGIN_IDX]);
        for (int i = 0; i < activities.length; i++) {
            if(activities[i][PARENT] == NOT_RESOLVED) {
                return "IMPOSSIBLE";
            } else {
                sb.append((char)activities[i][PARENT]);
            }
        }
        return sb.toString();
    }

    static void resolveParenting(int[][] activies, int idx, 
            char parent, 
            int cameronIndex, int jamieIndex) {
        if(activies[idx][PARENT] != NOT_RESOLVED) {
            // already assigned to Cameron or Jamie
            return;
        }
        boolean isCameron = parent == CAMERON;
        
        int prevIndex = isCameron ? cameronIndex : jamieIndex;
        
        if(prevIndex >= 0 && activies[prevIndex][E_TIME] > activies[idx][S_TIME]) {
            // confliction 
            return;
        }
        activies[idx][PARENT] = parent; //assign parent
        
        if(idx+1 == activies.length) {
            return;
        }
        if(activies[idx][E_TIME] <= activies[idx+1][S_TIME]) {
            resolveParenting(activies, idx+1, parent, 
                    isCameron ? idx : cameronIndex,
                    isCameron ? jamieIndex : idx);
        } else {
            resolveParenting(activies, idx+1, isCameron ? JAMIE : CAMERON,
                    isCameron ? idx : cameronIndex,
                    isCameron ? jamieIndex : idx);
        }
    }
}