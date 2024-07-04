import java.util.Scanner;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt( in .nextLine());

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            int arraySize = Integer.parseInt( in .nextLine());
            int[][] squareArray = new int[arraySize][arraySize];
            for (int row = 0; row < arraySize; row++) {
                String[] rowValues = in .nextLine().split(" ");

                for (int column = 0; column < arraySize; column++) {

                    squareArray[row][column] = Integer.parseInt(rowValues[column]);

                }
            }
            int k = 0;
            int rowCount = 0;
            int columnCount = 0;
            boolean breakForcount = false;
            for (int row = 0; row < arraySize; row++) {
                HashMap < Integer, Integer > hm = new HashMap < Integer, Integer > ();
                for (int column = 0; column < arraySize; column++) {
                    if (row == column){
                        k = k + squareArray[row][column];
  
                    }
                    
                    if(!breakForcount)
                    if(hm.get(squareArray[row][column]) != null){
                        rowCount +=1;
                        breakForcount = true;
                    }
                    else
                     hm.put(squareArray[row][column],1);
                      
                
                }
            }

               for (int column = 0; column < arraySize; column++) {
                HashMap < Integer, Integer > hm = new HashMap < Integer, Integer > ();
                for (int row = 0; row < arraySize; row++) {
                    
                    
                    if(hm.get(squareArray[row][column]) != null){
                        columnCount +=1;
                        break;
                    }
                    else
                     hm.put(squareArray[row][column],1);
                      
                
                }
            }
            

            System.out.println("Case #" + (noOfCases + 1) + ": " + k + " " +rowCount+ " " + columnCount +" ");

            }

        }
    }