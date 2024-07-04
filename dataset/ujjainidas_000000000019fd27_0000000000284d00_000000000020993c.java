import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;

        int testCases = Integer.parseInt(s.nextLine());
        for(int i = 1; i<=testCases; i++)
        {
            int diagonal = 0;
            int n = Integer.parseInt(s.nextLine());
            int[][] matrix = new int[n][];
            parse(matrix, s);
            diagonal = 0;
            for(int j = 0; j<matrix.length; j++)
            {
                diagonal += matrix[j][j];
            }
            int[] array = isLatin(matrix);
            System.out.println("Case #" + i + ": " + diagonal + " " + array[0] + " " + array[1]);

        }
    }

    public static boolean duplicates(int[] array)
    {
        for(int i = 0; i<array.length; i++)
        {
            for(int j = 0; j<array.length; j++)
            {
                if(i != j && array[i] == array[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] isLatin(int[][] matrix)
    {
        int[] array = {0, 0};
        for(int i = 0; i<matrix.length; i++)
        {
            if(duplicates(matrix[i]))
            {
                array[0]++;
            }

            int[] column = new int[matrix.length];
            for(int j = 0; j<matrix.length; j++)
            {
                column[j] = matrix[j][i];
            }
            if(duplicates(column))
            {
                array[1]++;
            }
        }
        return array;
    }

    public static void parse(int[][] matrix, Scanner in)
    {
        for(int r = 0; r<matrix.length; r++)
        {
            String[] split = in.nextLine().split(" ");
            matrix[r] = new int[split.length];
            for(int c = 0; c<matrix[r].length; c++)
            {
                matrix[r][c] = Integer.parseInt(split[c]);
            }
        }


    }


}
