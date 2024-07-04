 
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t ; ++i) {
      int size = in.nextInt();
      int matrix[][] = new int[size][size];
      for(int j = 0; j<size; j++){
          for(int k = 0; k<size; k++){
              matrix[j][k]=in.nextInt();
              
          }
      }
      LatinSquare LS = new LatinSquare(matrix,size);
      System.out.println("Case #" + i + ": " + LS.computeTrace() + " " + LS.columnRepeats() + " " + LS.rowRepeats());
    }
  }
}
class LatinSquare {
    int[][] matrix;
    int size;
    public LatinSquare(int[][] matrix, int size){
        this.matrix = matrix;
        this.size = size;
    }
    public int rowRepeats(){
        int count = 0;
        for(int j = 0 ; j<size; j++){//for each row
            Set<Integer> a = new HashSet<Integer>();
            for(int k = 0; k<size; k++){//for each column in each row
                if(a.add(matrix[k][j])== false){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public int columnRepeats(){
        int count = 0;
        for(int j = 0 ; j<size; j++){//for each column
            Set<Integer> a = new HashSet<Integer>();
            for(int k = 0; k<size; k++){//for each row in each column
                if(a.add(matrix[j][k])== false){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    public int computeTrace(){
        int trace = 0;
        for(int j = 0;j<size;j++){
            trace +=matrix[j][j];
        }
        return trace;
    }

}
     