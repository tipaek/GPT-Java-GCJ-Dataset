import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String args[]) {
         Scanner input = new Scanner(System.in);
         int T = input.nextInt();
         for (int ks = 1; ks <= T; ks++) {
              int N = input.nextInt();
              int[][] square  = new int[N][N];
              int trace = 0;
              int duplicateInRow = 0;
              int duplicateInColumn = 0;
             final HashSet<Integer> row = new HashSet<>(N);
             final List<HashSet<Integer>> columns = new ArrayList<>(N);
              for(int i=0;i<N;i++){
                  columns.add(new HashSet<>(N));
              }
              for(int i=0;i<N;i++){
                  row.clear();
                  for(int j=0;j<N;j++){
                    int value = input.nextInt();
                    row.add(value);
                    columns.get(j).add(value);
                    if(i==j){
                        trace+=value;
                    }
                  }
                  if(row.size()<N){
                      duplicateInRow++;
                  }
              }
              for(int i=0;i<N;i++){
                  if(columns.get(i).size()<N){
                      duplicateInColumn++;
                  }
              }
           System.out.println("Case #"+ks+": "+trace+" "+duplicateInRow+" "+duplicateInColumn);
        }
    }
}