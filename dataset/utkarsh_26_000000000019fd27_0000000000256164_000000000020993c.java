
import java.util.*;
import java.io.*;

public class Solution {

        public static void main(String[] args) {
            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int testCaseCount = sc.nextInt();
            for (int testCase = 1; testCase <= testCaseCount; testCase++) {
                int n = sc.nextInt();
                long trace = 0;
                int dupRows = 0;
                int dupCols = 0;
                HashMap<Integer, Set<Integer>> cols = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    Set<Integer> row = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        Set<Integer> col = cols.getOrDefault(j, new HashSet<>());
                        int element = sc.nextInt();
                        if (i == j) {
                            trace += element;
                        }
                        col.add(element);
                        cols.put(j,col);
                        row.add(element);
                    }
                    if (row.size() != n) {
                        dupRows++;
                    }
                }
                for(Set<Integer> col : cols.values()){
                    if (col.size() != n) {
                        dupCols++;
                    }
                }
                System.out.println("Case #"+testCase+": "+trace+" "+dupRows+" "+dupCols);
            }
            sc.close();
        }
}