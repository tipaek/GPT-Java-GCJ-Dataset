import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    
    for (int i = 1; i <= t; ++i) {
        int num_act = in.nextInt();
        List<Integer> startsOrdered = new ArrayList<Integer>();
        List<Integer> starts = new ArrayList<Integer>();
        List<Integer> ends = new ArrayList<Integer>();
        for (int j = 0; j<num_act; j++) {
            int start = in.nextInt();
            int end = in.nextInt();
            
            startsOrdered.add(start);
            starts.add(start);
            ends.add(end);
        }
        
        Collections.sort(startsOrdered);
        
        String[] result = new String[num_act];
        int c_end = 0;
        int j_end = 0;
        for (Integer startAtOrdered : startsOrdered) {
            int idx = 0;
            while (idx<num_act) {
                if (starts.get(idx).equals(startAtOrdered)) {
                    int new_start = starts.get(idx);
                    int new_end = ends.get(idx);
                    starts.set(idx, -1);
                    
                    if (j_end <= new_start) {
                        j_end = new_end;
                        result[idx] = "J";
                    } else if (c_end <= new_start) {
                        c_end = new_end;
                        result[idx] = "C";
                    } else {
                        result = null;
                    }
                    break;
                }
                idx++;
            }
            
            if (result == null) break;
        }
        
        if (result != null) {
            System.out.print("Case #" + i + ": ");
            for (String strTemp : result){
                System.out.print(strTemp);
            }
            System.out.println("");
        } else {
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        }
    }
  }
}