import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][n];
            boolean[][] availableLine = new boolean[n+1][n+1];
            boolean[][] availableCol = new boolean[n+1][n+1];
            if(solve(matrix,0,0,availableCol,availableLine,k,n))
            {
                System.out.println("Case #"+testCase+": POSSIBLE");
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(matrix[i][j]);
                        if(j<n-1)System.out.print(" ");
                    }
                    System.out.println();

                }
            }
            else System.out.println("Case #"+testCase+": IMPOSSIBLE");
        
            
        }
      }
      
      public static boolean solve(int[][] matrix, int i, int j,boolean[][] occupiedCol,boolean[][] occupiedLine,int k,int n)
      {
    	  for(int num = 1;num<=n;num++)
    	  {
    		  if(!occupiedCol[j][num] && !occupiedLine[i][num])
    		  {
    			  matrix[i][j] = num;
    			  occupiedCol[j][num] = occupiedLine[i][num] = true;
    			  if(i == n-1 && j == n-1)
    			  {
    				  int sum=0;
    				  for(int e=0;e<n;e++)sum += matrix[e][e];
    				  if(sum==k)return true;
    			  }
    			  else
    			  {
    				  int nextI=i,nextJ=j+1;
    				  if(j==n-1)
    				  {
    					  nextI = i+1;
    					  nextJ=0;
    				  }
    				  if(solve(matrix,nextI,nextJ,occupiedCol,occupiedLine,k,n))return true;
    			  }
    			  occupiedCol[j][num] = occupiedLine[i][num] = false;
    		  }
    	  }
    	  return false;
      }
}