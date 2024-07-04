import java.util.Scanner;
import java.util.ArrayList;

public class Solution
{
    int t,n,number,i,j,trace,r,c;

    public static void main(String args[])
    {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    void takeInputAndSolve()
    {
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        for (int a=0;a<t;a++)
        {
            trace = 0;
            r = 0;
            c = 0;
            n = s.nextInt();
            
            int[][] matrix = new int[n][n];
            for (i=0;i<n;i++)
            {
                for (j=0;j<n;j++)
                {
                    number = s.nextInt();
                    matrix[i][j] = number;
                    if (i==j){
                        trace = trace + matrix[i][j];
                    }
                }
            }
            
            for (i=0;i<n;i++)
            {
                ArrayList<Integer> rowElements = new ArrayList<Integer>();
                innerloop:
                for (j=0;j<n;j++)
                {
                    if (rowElements.isEmpty())
                    {
                        rowElements.add(matrix[i][j]);
                    }
                    else if (rowElements.contains(matrix[i][j]))
                    {
                        r++;
                        break innerloop;
                    }
                    else
                    {
                        rowElements.add(matrix[i][j]);
                    }
                }
            }
            
            for (j=0;j<n;j++)
            {
                ArrayList<Integer> colElements = new ArrayList<Integer>();
                innerloop:
                for (i=0;i<n;i++)
                {
                    if (colElements.isEmpty())
                    {
                        colElements.add(matrix[i][j]);
                    }
                    else if (colElements.contains(matrix[i][j]))
                    {
                        c++;
                        break innerloop;
                    }
                    else
                    {
                        colElements.add(matrix[i][j]);
                    }
                    
                }
            }
            
            System.out.println("Case #"+(a+1)+": "+trace+" "+r+" "+c);
        }
        
    }

}
