import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt(); // num test cases
    int testCaseCounter = 0;
    while(testCaseCounter < testCases){
        int arraySize = in.nextInt();
        testCaseCounter++;
        int[][] input = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; ++i) {
            for (int j = 0; j < arraySize; ++j) {
                int node = in.nextInt();
                input[i][j] = node;
                
            }
            
            
        }
        String result = trace(input);
        System.out.println("Case #" + testCaseCounter + ": "+result);
        
    }
    
  }
  
  public static String trace(int[][] inputMatrix){
        int trace =0 ;
        int numRowsWithRepeating=0;
        int numColsWithRepeating=0;
        Map<Integer, Set<Integer>> colDupCheck = new HashMap<>();
        for (int i = 0; i < inputMatrix.length; i++) {
            Set<Integer> rowDupCheck = new HashSet<>();
            for (int j = 0; j < inputMatrix.length; j++) {
                rowDupCheck.add(inputMatrix[i][j]);
                if(colDupCheck.get(j) == null){
                    colDupCheck.put(j, new HashSet<>());
                }
                colDupCheck.get(j).add(inputMatrix[i][j]);
                if(i==j){
                    trace += inputMatrix[i][j];
                }
            }
            if(rowDupCheck.size() != inputMatrix.length){
                numRowsWithRepeating++;
            }
        }
        for (Integer i : colDupCheck.keySet()) {
            if (colDupCheck.get(i).size() != inputMatrix.length) {
                numColsWithRepeating++;
            }
        }
        return " "+trace+" "+numRowsWithRepeating +" " +numColsWithRepeating;
    }
}