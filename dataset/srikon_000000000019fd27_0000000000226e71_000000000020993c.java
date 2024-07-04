import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = reader.nextInt();
        for (int testNum = 1; testNum <=testCount; testNum++)
        {
            int matrixSize = reader.nextInt();
            int trace = 0;
            int repeatRowCount = 0;
            int repeatColCount = 0;
            boolean rowHasDuplicates[] = new boolean[matrixSize+1];
            boolean colHasDuplicates[][] = new boolean[matrixSize+1][matrixSize+1];
            
            for (int row=0; row<=matrixSize; row++)
            {
                Arrays.fill(colHasDuplicates[row], false);
            }

            for (int row=1; row<=matrixSize; row++)
            {
                Arrays.fill(rowHasDuplicates, false);

                for (int col=1; col<=matrixSize; col++)
                {
                    int item = reader.nextInt();
                    if (row == col)
                        trace += item;

                    if (rowHasDuplicates[item])
                        rowHasDuplicates[0] = true;
                    
                    rowHasDuplicates[item] = true;

                    if (colHasDuplicates[item][col])
                    {
                        colHasDuplicates[0][col] = true;
                    }
                    colHasDuplicates[item][col] = true;
                }

                if (rowHasDuplicates[0])
                    repeatRowCount++;
            }

            for (int col=1; col<=matrixSize; col++)
            {
                if (colHasDuplicates[0][col])
                repeatColCount++;
            }

            System.out.println(String.format("Case #%d: %d %d %d", testNum, trace, repeatRowCount, repeatColCount));
        }
    }
}
