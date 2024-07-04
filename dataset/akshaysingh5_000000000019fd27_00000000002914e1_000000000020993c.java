import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution
{
    private static Scanner sc;
    static int jaat =1;
    
    public static void main(String args[])
    {
        sc = new Scanner(System.in);
        int pep=  sc.nextInt();
        sc.nextLine();
        
        while(pep-- >0)
        {
            solve();
        }
    }
    
    private static void solve()
    {
        int size=  sc.nextInt();
        int[][] mat = new int[size][size];
        
        int sumeet=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                mat[i][j]= sc.nextInt();
                if(i==j)
                {
                    sumeet=sumeet+mat[i][j];
                }
            }
        }
        int ramu = getRow(mat);
        int kalu= getCol(mat);
        System.out.println("Case #"+(jaat++)+": "+sumeet+" "+ramu+" "+kalu);
    }
    
    private static int getRow(int[][] matrix)
    {
        int mehnat=0;
        for(int i=0;i<matrix.length;i++)
        {
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<matrix[i].length;j++)
            {
                if(set.contains(matrix[i][j]))
                {
                    mehnat++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return mehnat;
    }
    private static int getCol(int[][] matrix)
    {
        int mehnat=0;
        for(int i=0;i<matrix.length;i++)
        {
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<matrix[i].length;j++)
            {
                if(set.contains(matrix[j][i]))
                {
                    mehnat++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }
        return mehnat;
    }
}