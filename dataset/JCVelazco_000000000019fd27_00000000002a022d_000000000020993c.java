import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int repeteadRow = 0, repeatedCol = 0, traceSum = 0;
    for (int i = 1; i <= t; ++i) {
        repeteadRow = 0;
        repeatedCol = 0; 
        traceSum = 0;
        int size = sc.nextInt();
        


        int matrix[][] = new int[size][size];
      
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                matrix[row][col] = sc.nextInt();

                if(row == col){
                    traceSum += matrix[row][col];
                }
            }
        }


        for(int row = 0; row < size; row++){
            Set<Integer> my_set = new HashSet<Integer>();
            for(int col = 0; col < size; col++){
                my_set.add(matrix[row][col]);
            }

            if(my_set.size() != size){
                repeteadRow++;
            }
        }

        for(int col = 0; col < size; col++){
            Set<Integer> my_set = new HashSet<Integer>();
            for(int row = 0; row < size; row++){
                my_set.add(matrix[row][col]);
            }

            if(my_set.size() != size){
                repeatedCol++;
            }
        }

        System.out.print("Case #"+i+": "+traceSum+" "+repeteadRow+" "+repeatedCol+"\n");

    }
  }
}