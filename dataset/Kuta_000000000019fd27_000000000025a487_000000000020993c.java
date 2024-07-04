import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void solution( int[][] grid,int pos)
    {
        int trace_matrix=0;
        int repeat_in_row=0;
        int repeat_in_col=0;
        for(int i =0;i<grid.length;i++)
        {
            int row_count=0;
            HashSet<Integer> doubles=new HashSet<>();
            for(int j=0;j<grid[i].length;j++)
            {
                if(i==j)
                {
                    trace_matrix+=grid[i][j];
                }
                if(row_count==0)
                {
                    if(doubles.contains(grid[i][j]))
                    {
                        row_count++;
                    }
                    else
                    {
                        doubles.add(grid[i][j]);
                    }
                }
                if(i==0)
                {
                    HashSet<Integer> colDoubles=new HashSet<>();
                    HashSet<Integer> colCount=new HashSet<>();
                    dfs(colCount,grid,colDoubles,i,j);
                    if(colCount.size() > 0)
                    {
                        repeat_in_col++;
                    }
                }
                //System.out.print(grid[i][j]);
            }
            if(row_count >0)
            {
                ++repeat_in_row;
            }
        }
        System.out.println("Case #"+pos+":"+trace_matrix+" "+repeat_in_row +" "+repeat_in_col);
    }
    public static void dfs(HashSet<Integer> colCount,int [][] grid,HashSet<Integer> doubles,int i,int j)
    {
     if(i>=grid.length || colCount.size() > 0)
     {
         return;
     }
     if(doubles.contains(grid[i][j]))
     {
         if(!colCount.contains(j))
         {
             colCount.add(j);
         }
     }
     else
     {
         //System.out.println(grid[i][j]+" checked at "+i+","+j);
         doubles.add(grid[i][j]);
     }
     dfs(colCount,grid,doubles,i+1,j);
     return ;
    }
    public static void processSolution()
    {
            Scanner in=new Scanner(System.in);
            int cases=in.nextInt();
            for(int a=1;a<=cases; a++)
            {
                int size=in.nextInt();
                int [][] grid=new int[size][size];
                in.nextLine();
                for(int b=0;b<size;b++)
                {
                    String nextLane=in.nextLine().trim();
                        String[] cols=nextLane.split(" ");
                    for(int c=0;c<cols.length;c++)
                    {
                        grid[b][c]=Integer.parseInt(cols[c]);
                    }
                }
                solution(grid,a);
            }
            in.close();
    }
    public static void main (String [] args)
    {
        processSolution();
    }
}
