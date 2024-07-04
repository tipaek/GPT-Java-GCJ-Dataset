import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i < t; i++)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            int repeatRow = 0;
            int diagSum = 0;
            int repeatCol = 0;
            int differentNumRow = 0;
            int differentNumCol = 0;
            for(int j = 0; j < n; j++)
            {
                Set<Integer> rowSet = new HashSet<>();
                for(int k = 0 ; k < n; k++)
                {
                    mat[j][k] = sc.nextInt();
                    if(rowSet.contains(mat[j][k]))
                    {
                      
                    }
                    else
                    {
                        rowSet.add(mat[j][k]);
                        differentNumRow++;
                    }
                        
                    if(j==k)
                        diagSum += mat[j][k];
                }
                if(differentNumRow != n)
                    repeatRow++;
                
                differentNumRow = 0;
            }
           
            for(int j = 0 ; j < n; j++)
            {
                Set<Integer> colSet = new HashSet<>();
                for(int k = 0; k < n; k++)
                {
                    if(colSet.contains(mat[k][j]))
                    {
                        
                    }
                    else
                    {
                        colSet.add(mat[k][j]);
                        differentNumCol++;
                    }
                }
                if(differentNumCol != n)
                    repeatCol++;
                differentNumCol = 0;
            }
            
            System.out.println("Case #"+i+": "+ diagSum + " " + repeatRow +" " +repeatCol);
            
        }
    }
}