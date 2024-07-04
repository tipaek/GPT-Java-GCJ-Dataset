/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vichugof
 */
import java.io.*;
import java.util.*;

public class Solution {

    private String endLine;
        
    public static void main(String[] args) throws FileNotFoundException
    { 
        Solution objSolution = new Solution();
        objSolution.execute();
    }
    
    public void execute()
    {
        try
        {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String line = "";
            int numCases = 0;
            int sumTrace = 0;
            String output = "";
            int idxCasosReal = 0;
            int numRepeatedRows = 0;
            int numRepeatedColumn = 0;

            int [] partsRow = null;
            
            line = in.nextLine();

            numCases = Integer.parseInt(line);

            for(int idxCasos = 0; idxCasos<numCases; idxCasos++) {
                int sizeSquare = Integer.parseInt(in.nextLine());
                int [][] square = new int[sizeSquare][sizeSquare];
                int [][] squareInvertColumn = new int[sizeSquare][sizeSquare];

                for(int idxSquare = 0; idxSquare<sizeSquare; idxSquare++)
                {
                    line = in.nextLine();
                    partsRow = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

                    if (partsRow.length < sizeSquare) {
                        square[idxSquare] = this.completeRowSquare(square[idxSquare], sizeSquare);
                    } else {
                        square[idxSquare] = partsRow;
                    }

                    sumTrace += square[idxSquare][idxSquare];

                    for (int idxSquareInv = 0; idxSquareInv<partsRow.length; idxSquareInv++) {
                        squareInvertColumn[idxSquareInv][idxSquare] = partsRow[idxSquareInv];
                    }

                    if (this.hasRepeatedValues(partsRow)) {
                        numRepeatedRows++;
                    }
                }
                
                for(int idxSquareInv = 0; idxSquareInv<sizeSquare; idxSquareInv++) {
                    if (this.hasRepeatedValues(squareInvertColumn[idxSquareInv])) {
                        numRepeatedColumn++;
                    }
                }

                idxCasosReal++;
                output = sumTrace + " "  + numRepeatedRows + " " + numRepeatedColumn;
                square = null;
                squareInvertColumn = null;
                sumTrace = 0;
                numRepeatedRows = 0;
                numRepeatedColumn = 0;
                System.out.println("Case #"+(int)(idxCasosReal)+": "+output+this.endLine);
            }
        }
        catch(Exception e)
        {
               e.printStackTrace();
        }
    }   

    public int [] completeRowSquare(int [] squareLine, int sizeSquare) {
        if (sizeSquare > squareLine.length) {
            int [] newSquareLine = new int[sizeSquare];
            int idxInitComplete = sizeSquare - squareLine.length;
            for (int idx = 0; idx < squareLine.length; idx++) {
                newSquareLine[idx] = squareLine[idx];
            }
            for (int idx = idxInitComplete; idx < sizeSquare; idx++) {
                newSquareLine[idx] = 0;
            }

            // squareLine = newSquareLine;

            // System.out.println(squareLine.length);
            return newSquareLine;
        }
        return squareLine;
    }

    public boolean hasRepeatedValues(int [] squareLine) {
        // int [] sortedArray = Arrays.sort(squareLine);
        Arrays.sort(squareLine);

        for (int idx = 0; idx < squareLine.length-1; idx++) {
            if (squareLine[idx] == squareLine[idx+1] && squareLine[idx] != 0) {
                return true;
            }
        }

        return false;
    }

    public Solution()
    {
        this.endLine = "\r";
       
    }

    public void printSquare(int[][] square)
    {
        int rows = square.length;
        int columns = square[0].length;
        for (int idxRow = 0; idxRow<rows; idxRow++) { 
            for (int idxCol = 0; idxCol<columns; idxCol++) {
                System.out.print(square[idxRow][idxCol]+" ");
            }
            System.out.println(" ");
        }
    }
}
