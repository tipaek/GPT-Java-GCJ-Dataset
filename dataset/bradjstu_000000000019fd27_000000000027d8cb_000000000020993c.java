import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++)
        {
            runTestCase(i, in);
        }
    }

    private static void runTestCase(int testCaseNumber, Scanner in)
    {
        int testCaseSize = in.nextInt();

        int[][] matrix = createMatrix(testCaseSize, in);

        int trace = calculateTrace(matrix);

        int rowsWithRepeats = rowRepeats(matrix);

        int columnsWithRepeats = colRepeats(matrix);

        String testCaseString = trace + " " + rowsWithRepeats +  " " + columnsWithRepeats;
        outputTestCase(testCaseNumber, testCaseString);
    }

    private static int[][] createMatrix(int size, Scanner in)
    {
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                matrix[j][i] = in.nextInt();
            }
        }
        return matrix;
    }

    private static int colRepeats(int[][] matrix)
    {
        int count = 0;
        for(int j = 0; j < matrix.length; j++)
        {
            int[] temp = Arrays.copyOf(matrix[j], matrix.length);
            Arrays.sort(temp);
            if(checkRepeat(temp))
            {
                count++;
            }
        }
        return count;
    }

    private static int rowRepeats(int[][] matrix)
    {
        int count = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            int[] temp = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++)
            {
                temp[j] = matrix[j][i];
            }
            Arrays.sort(temp);
            if(checkRepeat(temp))
            {
                count++;
            }
        }
        return count;
    }

    private static boolean checkRepeat(int[] nums)
    {
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                return true;
            }
        }
        return false;
    }

    private static int calculateTrace(int[][] matrix)
    {
        int count = 0;
        for(int i = 0; i < matrix.length; i ++)
        {
            count += matrix[i][i];
        }
        return count;
    }

    private static void outputTestCase(int testCaseNumber, String outString)
    {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}