import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long cases = kb.nextLong();
        int sizeOfSquare;
        for(long i = 1; i <= cases; i++)
        {
            sizeOfSquare = kb.nextInt();
            int rows = 0;
            int columns = 0;
            int matrix[][] = initMatrix(sizeOfSquare);


            for(int j = 0; j < matrix.length; j++) {
                // create a column array
                int[] column = new int[matrix[j].length];
                for (int k = 0; k < matrix.length; k++) {
                    column[k] = matrix[k][j]; // could throw an exception if the input file isn't square 3x3, 2x2, 4x4, etc
                }
                // check for duplicates in each column
                columns = duplicates(column);
            }
            rows = countIdenticalRows(matrix);

            System.out.println("Case #" + i + ':' + getTrace(matrix) +' ' + rows + ' ' + columns);
            kb.nextLine();



        }
    }
    public static void parseData(int matrix[][], Scanner kb)
    {
        for(int r = 0; r < matrix.length; r++)
        {
            String splitLine[] = kb.nextLine().split(" ");
            matrix[r] = new int[splitLine.length];
            for(int c = 0; c < matrix[r].length; c++)
            {
                matrix[r][c] = Integer.parseInt(splitLine[c]);
            }
        }
    }


    public static int getTrace(int matrix[][])
    {
        int trace = 0;
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[r].length; c++)
            {
                if(c == r)
                {
                    trace += matrix[r][c];
                }
            }

        }
        return trace;
    }


    public static int duplicates(int[] array)
    {
        int tally = 0;
        for (int i = 0; i<array.length; i++)
        {
            for(int j = 0; j<array.length; j++)
            {
                if (i != j && array[i] == array[j])
                {
                    tally++;
                }
            }
        }
        return tally;
    }

    public static int countIdenticalRows(int mat[][])
    {

        int count = 0;

        for (int i = 0; i < mat.length; i++) {

            // HashSet for current row
            HashSet<Integer> hs = new HashSet<>();

            // Traverse the row
            for (int j = 0; j < mat[i].length; j++) {

                // Add all the values of the row in HashSet
                hs.add(mat[i][j]);
            }

            // Check if size of HashSet = 1
            if (hs.size() < mat.length) {
                count++;
            }
        }

        return count;
    }

    public static int[][] initMatrix(int sizeOfSquare)
    {
        int matrix[][];
        Scanner filein = null;

            filein = new Scanner(System.in);
            int numRows = sizeOfSquare;
            matrix = new int[numRows][];
            parseData(matrix, filein);

            return matrix;


    }
    
}
