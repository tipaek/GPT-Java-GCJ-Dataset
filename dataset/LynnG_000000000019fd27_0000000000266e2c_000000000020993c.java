
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    int trace = 0;
    int repRow = 0;
    int repCol = 0;
    int size = 0;
   
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        //reset values
        trace = 0;
        repRow = 0;
        repCol = 0;
        
        size = in.nextInt();
        int[][] square = new int[size][size];
        for(int row = 0; row < size; row++){
          for(int col = 0; col < size; col++){
              square[row][col] = in.nextInt();
              //System.out.print(square[row][col]+ " ");
              if(row == col){
                trace += square[row][col]; 
              }
          }
          //System.out.println();
      }
      //check for repeats in each row
        for(int row = 0; row < size; row++){
          for(int col = 0; col < size; col++){
              for(int j = col+1; j < size; j ++){
                  if(square[row][col] == square[row][j]){ //found duplicates
                    repRow += 1; 
                    j = size;
                    col = size;
                } 
              }
          }
      }
      
    for(int col = 0; col < size; col++){
          for(int row = 0; row < size; row++){
              for(int j = row+1; j < size; j ++){
                  if(square[row][col] == square[j][col]){ //found duplicates
                    repCol += 1; 
                    j = size;
                    row = size;
                } 
              }
          }
      }
      
      System.out.println("Case #" + i +": " + trace + " " + repRow + " " + repCol);
    }
  } 
}
