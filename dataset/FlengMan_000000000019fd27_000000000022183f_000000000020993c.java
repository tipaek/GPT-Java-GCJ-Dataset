import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        // N is the number of Rows
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        HashMap<Integer, ArrayList<Integer>> map;
        // One for rows
        
        for (int i = 0; i < T; i++) {
            map = new HashMap<Integer, ArrayList<Integer>>();
            int N = in.nextInt();
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
        
        
        // Calculate diagonal Values
        int diagCount = 0;
        for (int v = 0; v < N; v++) {
            //for (int j: map.keySet()) {
                ArrayList<Integer> Temp = new ArrayList<Integer>();
                
                Temp = map.get(v);
                diagCount += Temp.get(v);
            //}
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
                    //System.out.println(p);
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
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        newArr.add(diagCount);
        newArr.add(rowDups);
        newArr.add(colDups);
        result.add(newArr);
        
        //System.out.println("Rows: " + rowDups + " Cols: " + colDups);
            
            
        }
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Case #" + (i + 1) + ": " + result.get(i).get(0) + " "+ result.get(i).get(1) + " "+ result.get(i).get(2));
            }
        }
}