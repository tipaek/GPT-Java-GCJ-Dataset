import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int i = 1; i <= t; ++i) {
        int trace = 0;
        int matrixSize = in.nextInt();
        Map<Integer,List<Integer>> mat = new HashMap<>();
        for(int z = 0; z < matrixSize; z++){
            mat.put(z, new ArrayList<>());
            for(int j = 0; j < matrixSize; j++){
               int el =  in.nextInt();
               mat.get(z).add(el);
               if( z == j){
                   trace += el;
               }
               
            }
            in.nextLine();
        }
        
        int rowsDuplicate = 0;
        int colsDuplicate = 0;
        for(int r =0; r < matrixSize ; r++) {
            Set<Integer> rowSet = new HashSet<>();
            rowSet.addAll(mat.get(r));
            if(rowSet.size() != mat.get(r).size()){
                rowsDuplicate++;
            }
            Set<Integer> columnSet = new HashSet<>();
            for(int x =0 ; x < matrixSize; x++){
                columnSet.add(mat.get(x).get(r));
            }
            if(columnSet.size() != matrixSize){
                colsDuplicate++;
            }
        }
        System.out.println("Case #" + i + ": " + trace + " " + rowsDuplicate + " " + colsDuplicate);
    }
  }
}