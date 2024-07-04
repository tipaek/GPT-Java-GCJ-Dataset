package questions;
import java.util.*;

import java.util.*;
import java.io.*;
//10:38
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(in.nextLine());
            Map<Integer,Set<Integer>> rCol = new HashMap<>();
            int colCount = 0;
            int rowCount = 0;
            int trace = 0;
            for(int y = 0; y < n; y++) {
                String[] nums = in.nextLine().split(" ");
                Set<Integer> row = new HashSet<>();
                boolean rowRepeat = false;
                for(int x = 0; x < n; x++) {
                    int num = Integer.parseInt(nums[x]);
                    if (y == x) {
                        trace += num;
                    }
                    if (rowRepeat == false && row.contains(num)) {
                        rowRepeat = true;
                        rowCount++;
                    }
                    row.add(num);
                    Set<Integer> col = rCol.get(x);
                    if (col == null) {
                        col = new HashSet<Integer>();
                    }
                    col.add(num);
                    rCol.put(x, col);
                }
            }
            for(int c = 0; c < n; c++) {
                Set<Integer> col = rCol.get(c);
                if(col.size() != n) {
                    colCount++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount +" "+colCount);
        }
    }
}

