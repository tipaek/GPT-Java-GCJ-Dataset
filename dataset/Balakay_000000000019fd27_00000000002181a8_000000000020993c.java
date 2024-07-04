import java.util.*;

public class Solution
{
    public static void main (String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        int cases = scan.nextInt();
        for (int k = 1; k<=cases; k++)
        {
            int n = scan.nextInt();
            int [][] matrix = new int [n][n];
            for (int i = 0; i<n; i++)
            {
                for (int j = 0; j<n; j++)
                    matrix[i][j] = scan.nextInt();
            }
            System.out.println("Case #" + k+ ": " +
            sumDiagonal(matrix, n) + " " + 
            rows(matrix,n) + " " + columns(matrix,n));
        }
    }
    
    public static int sumDiagonal (int [][] matrix, 
    int n)
    {
        int sum = 0;
        int i = 0, j = 0;
        while (i < n && j < n)
        {
            sum += matrix[i][j];
            i++;
            j++;
        }
        return sum;
    }
    
    public static int columns (int [][] matrix, 
    int n)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j<n; j++)
            {
                if (set.add(matrix[j][i]) == false)
                {
                    count++;
                    break;
                }
            }
            set.clear();
        }
        return count;
    }
    
    public static int rows (int [][] matrix, 
    int n)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i<n; i++)
        {
            for (int j = 0; j<n; j++)
            {
                if (set.add(matrix[i][j]) == false)
                {
                    count++;
                    break;
                }
            }
            set.clear();
        }
        return count;
    }
}