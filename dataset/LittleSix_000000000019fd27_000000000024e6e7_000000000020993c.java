import java.util.*;
import java.io.*;
import java.lang.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            Map<Integer, Set<Integer>> rowMap = new HashMap();
            Map<Integer, Set<Integer>> colMap = new HashMap();
            int r1 = 0;
            Set r2 = new HashSet();
            Set r3 = new HashSet();
            
            int dimension = in.nextInt();
            
            for (int j = 1; j <= dimension; j++) {
                rowMap.put(j, new HashSet());
                colMap.put(j, new HashSet());
            }
            
            for (int row = 1; row <= dimension; row++) {
                for (int col = 1; col <= dimension; col++) {
                    int num = in.nextInt();
                    if (row == col) {
                        r1 += num;
                    }
                    
                    if (rowMap.get(row).contains(num)) {
                        r2.add(row);
                    } else {
                        rowMap.get(row).add(num);
                    }
                    
                    if (colMap.get(col).contains(num)) {
                        r3.add(col);
                    } else {
                        colMap.get(col).add(num);
                    }
                }
            }
            System.out.println("Case #" + i + ": " + r1 + " " + r2.size() + " " + r3.size());
        }
    }
}