import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int k = 1; k<=t; k++)
        {
            int n = sc.nextInt();
            int grid[][] = new int[n][n];
            
            for(int i=0; i<n; i++)
            {            
            	for(int j = 0; j<n; j++)
            	{
            		grid[i][j] = sc.nextInt();
            	}
            }
            
            int numRows = 0;
            int numCols = 0;
            int trace = 0;
            
            for(int i=0; i<n; i++)
            {
            	trace += grid[i][i];
            }
            
            for(int i=0; i<n; i++)
            {
            	HashMap<Integer,Integer> hmap = new HashMap<>();
            	for(int j=0; j<n; j++)
            	{            		
            		if(hmap.get(grid[i][j])!=null)
            		{
            			numRows += 1;
            			break;
            		}
            		hmap.put(grid[i][j],1);
            	}
            }
            
            for(int i=0; i<n; i++)
            {
            	HashMap<Integer,Integer> hmap = new HashMap<>();
            	for(int j=0; j<n; j++)
            	{          		
            		if(hmap.get(grid[j][i])!=null)
            		{
            			numCols += 1;
            			break;
            		}
            		hmap.put(grid[j][i],1);
            	}
            }            
            System.out.println("Case #"+ k +": "+trace+" "+ numRows + " " + numCols);            
        }
    }
}