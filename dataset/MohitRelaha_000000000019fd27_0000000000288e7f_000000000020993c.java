import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        for(int i = 0; i<t; i++)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            int trace = 0, rows = 0, cols = 0;
            for(int j = 0; j<n; j++)
            {
                for(int k = 0; k<n; k++)
                {
                    matrix[j][k] = sc.nextInt();
                    if(j == k)
                    trace += matrix[j][k];
                }
            }
            for(int j = 0; j<n; j++)
            {
                Set<Integer> set = new HashSet();
                for(int k = 0; k<n; k++)
                {
                    set.add(matrix[j][k]);
                }
                if(set.size() != n)
                rows++;
            }
            
            for(int j = 0; j<n; j++)
            {
                Set<Integer> set = new HashSet();
                for(int k = 0; k<n; k++)
                {
                    set.add(matrix[k][j]);
                }
                if(set.size() != n)
                cols++;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+cols);
            
            
        }
    }
}