import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        // N is the number of Rows
        int N = in.nextInt();
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        // One for rows
        
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                ArrayList<Integer> colList = new ArrayList<Integer>();
                for (int k = 0; k < N; k++) {
                    int m = in.nextInt();
                    colList.add(m);
                    // This is the row values
                    // Add to map Col
                
                    }
                map.put(j, colList);
                }
        }
        // Iterate over the Rows and Check dups
        int rowDups = 0;
        for (int j: map.keySet()) {
            int count = 0;
            ArrayList<Integer> Temp = new ArrayList<Integer>();
            HashMap<Integer, Integer> dups = new HashMap<Integer, Integer>();
            
            Temp = map.get(j);
            for (int p : Temp) {
                if (dups.containsKey(p)) {
                    count++;
                    break;
                } else {
                    dups.put(p, 1);
                }
            }
            rowDups += count;
            //System.out.println("Row Dups: " + count);
            
        }
        int colDups = 0;
        for (int v = 0; v < N; v++) {
            HashMap<Integer, Integer> dups = new HashMap<Integer, Integer>();
            boolean match = false;
            for (int j : map.keySet()) {
                //boolean match = false;
                int count = 0;
                ArrayList<Integer> Temp = new ArrayList<Integer>();
                
                Temp = map.get(j);
                int index = Temp.get(v);
                if (dups.containsKey(index) && match == false) {
                    count++;
                    match = true;
                } else {
                    dups.put(index, 1);
                }
                
                colDups += count;
            }
        }
        System.out.println("Rows: " + rowDups + " Cols: " + colDups);
    }
}