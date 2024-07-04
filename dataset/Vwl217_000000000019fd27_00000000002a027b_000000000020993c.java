import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    
    for (int numCase = 1; numCase <= t; numCase++) {
        int n = in.nextInt();
        int trace = 0;
        int numRepeatRow = 0;
        int numRepeatColumn = 0;
        List<HashSet<Integer>> columnList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            columnList.add(new HashSet<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            HashSet<Integer> rowSet = new HashSet<Integer>();
            for(int j = 0; j < n; j++){
                int cur = in.nextInt();
                if(i == j){
                    trace += cur;
                }
                rowSet.add(cur);
                HashSet<Integer> col = columnList.get(j);
                col.add(cur);
                columnList.set(j, col);
            }
            if(rowSet.size() != n){
                numRepeatRow++;
            }
        }
        for(int i = 0; i < n; i++){
            if(columnList.get(i).size() != n){
                numRepeatColumn++;
            }
        }
      System.out.println("Case #" + numCase + ": " +trace + " " + numRepeatRow + " " + numRepeatColumn);
    }
  }
}