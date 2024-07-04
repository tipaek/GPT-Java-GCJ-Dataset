

import java.util.Scanner;
import java.util.*;

public class Solution {

	public static void pn(Object o)
    {System.out.println(o);}
    public static void p(Object o)
    {System.out.print(o);}
    
    public static boolean isSafe(int[][] grid,  
            int row, int col,  
            int num)  
{ 

for (int d = 0; d < grid.length; d++)  
{ 

if (grid[row][d] == num)  
{ 
return false; 
} 
} 

 
for (int r = 0; r < grid.length; r++) 
{ 


if (grid[r][col] == num) 
{ 
return false; 
} 
} 





return true; 
} 

public static boolean solve(int[][] grid, int n)  
{ 
int row = -1; 
int col = -1; 
boolean isEmpty = true; 
for (int i = 0; i < n; i++) 
{ 
for (int j = 0; j < n; j++)  
{ 
if (grid[i][j] == 0)  
{ 
row = i; 
col = j; 
 

isEmpty = false;  
break; 
} 
} 
if (!isEmpty) 
{ 
break; 
} 
} 


if (isEmpty)  
{ 
return true; 
} 


for (int num = 1; num <= n; num++) 
{ 
if (isSafe(grid, row, col, num)) 
{ 
grid[row][col] = num; 
if (solve(grid, n))  
{ 
 
return true; 
}  
else
{ 
grid[row][col] = 0; 
} 
} 
} 
return false; 
} 
public static void print(int[][] grid, int N) 
{ 
    
    for (int r = 0; r < N; r++) 
    { 
        for (int d = 0; d < N; d++) 
        { 
            p(grid[r][d]); 
            p(" "); 
        } 
        p("\n"); 
          
        if ((r + 1) % (int) Math.sqrt(N) == 0)  
        { 
            p(""); 
        } 
    } 
}
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s =new Scanner(System.in);
		int t=s.nextInt();
		
		for(int test=1;test<=t;test++)
		{
			int N=s.nextInt();
			int grid[][]=new int[N][N];
			int k=s.nextInt();
			if(N==2&&k==3)
				pn("Case #"+test+": IMPOSSIBLE");
			else if(k%N==0)
			{
				pn("Case #"+test+": POSSIBLE");
				for(int i=0;i<N;i++)
				{
					grid[i][i]=(k/N);
				}
				if (solve(grid, N)) 
			    { 
			        print(grid, N);  
			    }  
			}
			else if((N*(N+1))/2==k)
			{
				pn("Case #"+test+": POSSIBLE");
				for(int i=0;i<N;i++)
				{
					grid[i][i]=i+1;
				}
				if (solve(grid, N)) 
			    { 
			        print(grid, N);  
			    }  
			}
			
			else
				pn("Case #"+test+": IMPOSSIBLE");
			
			
			 
		}
		    
	}

}
