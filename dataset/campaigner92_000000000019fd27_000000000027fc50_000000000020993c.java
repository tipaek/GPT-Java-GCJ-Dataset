import java.util.Scanner;
import java.util.HashSet;


public class Solution {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      int testcases = scan.nextInt();
      int[][] result = new int[testcases][3];
      
      
      //go to each test case 
      for(int t=0; t<testcases; t++){
        int matrix_size = scan.nextInt();
        int[][] mat = new int[matrix_size][matrix_size];
                
        for(int i=0;i<matrix_size;i++){
        
          boolean dup_found = false;
          boolean part_done = false;
          HashSet<Integer> rowSet = new HashSet<Integer>();
          for(int j=0;j<matrix_size; j++){
            mat[i][j] = scan.nextInt();
            
              if(!dup_found){
                dup_found = rowSet.contains(mat[i][j]);
                rowSet.add(new Integer(mat[i][j]));
              }
              if(dup_found && !part_done){
                result[t][1] += 1;
                part_done = true;
              }
            
            if(i == j){
              result[t][0] += mat[i][j];
            }
          }
        }
        
        for(int col=0; col< matrix_size; col++){
          
          boolean dup_found = false;
          boolean part_done = false;
          HashSet<Integer> colSet = new HashSet<Integer>();
          
          for(int row=0;row<matrix_size; row++){
            if(!dup_found){
              dup_found = colSet.contains(mat[row][col]);
              colSet.add(new Integer(mat[row][col]));
            }
            if(dup_found && !part_done){
              result[t][2] += 1;
              part_done = true;
            }
          }
        }
      }
      
      for (int t=0;t<testcases;t++){
        System.out.println("Case #"+(t+1)+": " + result[t][0]+ " "+result[t][1]+ " "+result[t][2]);
      }
      scan.close();
    }
}