import java.util.*;


class Solution{
    public static void code(int[][] a)
    {
        int n=a.length;
        int trace=0;
        //trace done
        for(int i=0;i<n;i++)
        {
            trace+=a[i][i];
        }
       
        int numdupRow=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> rowSet=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                rowSet.add(a[i][j]);
            }
            if(rowSet.size()<n)
            {
                numdupRow++;
            }
        }
        int numdupCol=0;
        for(int col=0;col<n;col++)
        {
            Set<Integer> colSet=new HashSet<>();
            for(int row=0;row<n;row++)
            {
                colSet.add(a[row][col]);
            }
            if(colSet.size()<n)
            {
                numdupCol++;
            }
        }
        System.out.println(trace + " " + numdupRow + " " + numdupCol);
        
        
    }
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=s.nextInt();
            int[][] latin=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    latin[j][k]=s.nextInt();
                }
            }
            code(latin);
        }
    }
    
}

