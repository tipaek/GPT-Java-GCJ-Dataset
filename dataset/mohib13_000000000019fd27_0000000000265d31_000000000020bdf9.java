import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        List<ArrayList<Integer>> JIntervals;
        List<ArrayList<Integer>> CIntervals;

        StringBuilder ans = new StringBuilder();

        for (int i = 1; i <= t; ++i) {
            int intervals = in.nextInt();

            JIntervals = new ArrayList<>();
            CIntervals = new ArrayList<>();
            ans = new StringBuilder();
            
            for(int interval = 0; interval < intervals; interval++) {
                int start = in.nextInt();
                int end = in.nextInt();

                boolean overlap = checkIfOverlap(JIntervals, start, end);

                if(overlap) {
                    overlap = checkIfOverlap(CIntervals, start, end);
                    if(overlap) {
                        ans = new StringBuilder();
                        ans.append("Impossible");
                        break;
                    }
                    else {
                        ans.append("C");
                        CIntervals.add(new ArrayList<>(Arrays.asList(start, end)));
                    }
                }
                else {
                    ans.append("J");
                    JIntervals.add(new ArrayList<>(Arrays.asList(start, end)));
                }
            }
            System.out.println("Case #" + i + ": " +  ans);
        }
    }
    
    static boolean checkIfOverlap(List<ArrayList<Integer>> list, int start, int end) {
        for(ArrayList<Integer> interval : list) {
            if((start > interval.get(0) && start < interval.get(1)) || (end > interval.get(0) && end < interval.get(1))) {
                return true;
            }
        }
        return false;
    }
    
}