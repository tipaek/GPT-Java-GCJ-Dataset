import java.util.*;

public class Prob1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        String[] output = new String[testCases];
        for(int i=0; i<testCases; i++)
        {
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];
            for(int j=0; j<size; j++)
            {
                for(int k=0; k<size; k++)
                {
                    matrix[j][k] = scan.nextInt();
                }
            }

            int diagSum = 0;
            for(int j=0; j<size; j++)
                diagSum += matrix[j][j];
            ArrayList<Integer> repeatCol = new ArrayList<Integer>();
            ArrayList<Integer> repeatRow = new ArrayList<Integer>();

            for(int j=0; j<size; j++)
            {
                for(int k=1; k<=size; k++)
                {
                    repeatCol = appearancesCol(k, j, matrix, size, repeatCol);
                    repeatRow = appearancesRow(k, j, matrix, size, repeatRow);
                }
            }
            ArrayList<Integer> numRepCol = new ArrayList<Integer>();
            ArrayList<Integer> numRepRow = new ArrayList<Integer>();
            for(int j=1; j<=size; j++)
            {
                if(repeatCol.contains(j))
                    numRepCol.add(j);
                if(repeatRow.contains(j))
                    numRepRow.add(j);
            }
            String str = "";


            str = "Case #" + (i+1) + ": " + diagSum + " " + numRepRow.size() + " " + numRepCol.size();
            output[i] = str;
        }
        for(int i=0; i<output.length; i++)
        {
            System.out.println(output[i]);
        }
    }
    public static ArrayList appearancesCol(int target, int col, int[][] matrix, int size, ArrayList repeat)
    {
        int counter = 0;
        for(int i=0; i<size; i++)
        {
            if(matrix[i][col] == target)
                counter++;
        }
        if(counter > 1)
            repeat.add(col+1);
        return repeat;
    }

    public static ArrayList appearancesRow(int target, int row, int[][] matrix, int size, ArrayList repeat)
    {
        int counter = 0;
        for(int i=0; i<size; i++)
        {
            if(matrix[row][i] == target)
                counter++;
        }
        if(counter > 1)
            repeat.add(row+1);
        return repeat;
    }

}

