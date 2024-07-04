import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int testCase = 1; testCase <= T; testCase++)
        {
            int N = in.nextInt();
            
            int[][] matrix = new int[N][N];
            
            int trace = 0;
            int rowRepeated = 0, colRepeated = 0;
            
            for (int row = 0; row < N; row++)
            {
                for (int col = 0; col < N; col++)
                {
                    int input = in.nextInt();
                    if (row == col) trace += input;
                    
                    matrix[row][col] = input;
                }
            }
            
            for (int row = 0; row < N; row++)
            {
                for (int col = 1; col < N; col++)
                {
                    boolean dupFound = false;
                    for (int check = 0; check < col; check++)
                    {
                        if (matrix[row][col] == matrix[row][check])
                        {
                            dupFound = true;
                            break;
                        }
                    }
                    if (dupFound)
                    {
                        rowRepeated++;
                        break;
                    }
                }
            }
            
            for (int col = 0; col < N; col++)
            {
                for (int row = 1; row < N; row++)
                {
                    boolean dupFound = false;
                    for (int check = 0; check < row; check++)
                    {
                        if (matrix[row][col] == matrix[check][col])
                        {
                            dupFound = true;
                            break;
                        }
                    }
                    if (dupFound)
                    {
                        colRepeated++;
                        break;
                    }
                }
            }
            
            //print output
            System.out.print("Case #" + testCase + ": ");
            System.out.print(trace + " " + rowRepeated + " " + colRepeated);
            System.out.println();
        }
    }
}