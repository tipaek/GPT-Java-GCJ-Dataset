import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int size = scanner.nextInt();
                int trace = 0, repeatedRows = 0, repeatedCols = 0;

                int[][] martix = new int[size][size];
                Map<Integer, Set<Integer>> colSet = new HashMap<Integer, Set<Integer>>();
                for (int i = 0; i < size; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        martix[i][j] = scanner.nextInt();
                        rowSet.add(martix[i][j]);
                        Set<Integer> temp = colSet.getOrDefault(j, new HashSet<>());
                        temp.add(martix[i][j]);
                        colSet.put(j, temp);
                    }
                    if (rowSet.size() != size) {
                        repeatedRows++;
                    }
                }

                for (int k = 0; k < martix.length; k++) {
                    trace += martix[k][k];
                }
                
                for (Map.Entry<Integer, Set<Integer>> entry : colSet.entrySet()) {
                    if (entry.getValue().size() != size) {
                        repeatedCols++;
                    }
                }

                System.out.println("Case #" + (idx+1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}