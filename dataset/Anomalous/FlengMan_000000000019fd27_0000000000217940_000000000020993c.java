import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int N = in.nextInt();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> colList = new ArrayList<>();
                for (int k = 0; k < N; k++) {
                    colList.add(in.nextInt());
                }
                map.put(j, colList);
            }
        }
        
        int rowDups = countRowDuplicates(map, N);
        int colDups = countColDuplicates(map, N);
        
        System.out.println("Rows: " + rowDups + " Cols: " + colDups);
    }
    
    private static int countRowDuplicates(Map<Integer, List<Integer>> map, int N) {
        int rowDups = 0;
        
        for (int j = 0; j < N; j++) {
            List<Integer> row = map.get(j);
            if (hasDuplicates(row)) {
                rowDups++;
            }
        }
        
        return rowDups;
    }
    
    private static int countColDuplicates(Map<Integer, List<Integer>> map, int N) {
        int colDups = 0;
        
        for (int v = 0; v < N; v++) {
            Set<Integer> seen = new HashSet<>();
            boolean duplicateFound = false;
            
            for (int j = 0; j < N; j++) {
                int value = map.get(j).get(v);
                if (!seen.add(value)) {
                    duplicateFound = true;
                }
            }
            
            if (duplicateFound) {
                colDups++;
            }
        }
        
        return colDups;
    }
    
    private static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        for (int value : list) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}