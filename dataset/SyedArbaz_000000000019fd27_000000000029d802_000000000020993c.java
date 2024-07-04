
import java.lang.Math;
import java.util.Scanner;

class Main 
    {
    public static int getRepeatedColumns(int[][] colMap, int size) 
    {
        int repeatedColumns = 0;
        for (int i = 0; i < size; ++i) 
        {
            boolean repeatedCol = false;
            for (int j = 0; j < size; ++j)
            {
                if (colMap[j][i] == 0)
                {
                    repeatedCol = true;
                }
            }
            if (repeatedCol) 
            {
                repeatedColumns += 1;
            }
        }
        return repeatedColumns;
    }

    public static int getRepeatedRows(int[][] rowMap, int size) {
        int repeatedRows = 0;
        for (int i = 0; i < size; ++i) 
        {
            boolean repeatedRow = false;
            for (int j = 0; j < size; ++j) 
            {
                if (rowMap[i][j] == 0) 
                {
                    repeatedRow = true;
                }
            }
            if (repeatedRow) 
            {
                repeatedRows += 1;
            }
        }
        return repeatedRows;
    }

    public static int createMapsAndgetDiagonalSum(int[][] rowMap, int[][] colMap, int size, Scanner in) {
        int diagonalSum = 0;
        for (int i = 0; i < size; ++i)
        {
            for (int j = 0; j < size; ++j) 
            {
                int value = in.nextInt();
                rowMap[i][value - 1] = 1;
                colMap[value - 1][j] = 1;
                if (i == j) 
                {
                    diagonalSum += value;
                }
            }
        }
        return diagonalSum;
    }

    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) 
        {
            int size = in.nextInt();
            int rowMap[][] = new int[size][size];
            int colMap[][] = new int[size][size];
            int diagonalSum = createMapsAndgetDiagonalSum(rowMap, colMap, size, in);
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + getRepeatedRows(rowMap, size) + " "
                    + getRepeatedColumns(colMap, size));
        }
        in.close();
    }
}