import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n = in.nextInt();
            int mat[][] = new int[n][n];

            //Input
            int trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int num = in.nextInt();
                    mat[i][j] = num;

                    if(i==j)
                        trace+=num;
                }
            }

            int rowCount=0;
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> row = new ArrayList<Integer>();
                for(int j=0;j<n;j++)
                {
                    int num = mat[i][j];
                    if(row.contains(num))
                    {
                        rowCount++;
                        break;
                    }
                    else
                        row.add(num);
                }
            }
            
            int colCount=0;
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> row = new ArrayList<Integer>();
                for(int j=0;j<n;j++)
                {
                    int num = mat[j][i];
                    if(row.contains(num))
                    {
                        colCount++;
                        break;
                    }
                    else
                        row.add(num);
                }
            }
            
            
            System.out.println("Case #"+q+": "+trace+" "+rowCount+" "+colCount);
        }
    }
    
}