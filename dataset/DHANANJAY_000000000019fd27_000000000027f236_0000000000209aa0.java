import java.util.*;
class Solution 
{ 
      
    static final int MAX = 100; 
    static int[][] mat = new int[MAX][MAX]; 
    static void fillRemaining(int i, int j, int n) 
    {
        int x = 3; 
        for (int k = i + 1; k < n; k++)
        {
            if(k==j)
            {
                mat[k][j]=k/n+2;
            }
            else
            mat[k][j] = x++; 
        }
        for (int k = 0; k < i; k++) 
        {
            
          if(k==j)
            {
                mat[k][j]=k/n+2;
            }
            else
            mat[k][j] = x++;
        }
    } 
    static void constructMatrix(int n) 
    { 
        int right = n - 1, left = 0; 
        for (int i = 0; i < n; i++) 
        { 
            if (i % 2 == 0) 
            { 
                mat[i][right] = 1; 
      
                // After filling 1, fill remaining  
                // entries of column "right" 
                fillRemaining(i, right, n); 
      
                // Move right one column back 
                right--; 
            } 
              
            // Fill next column from left
            else
            { 
                mat[i][left] = 1; 
      
                // After filling 1, fill remaining  
                // entries of column "left" 
                fillRemaining(i, left, n); 
      
                // Move left one column forward 
                left++; 
            } 
        } 
    } 
      
    // Driver Code 
    public static void main(String args[]) 
    { 
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        for(int x=1;x<=t;x++)
        {
          int n =kb.nextInt();
          int k=kb.nextInt();
          int r=k/n;
          if(k%n!=0)
          {
              System.out.println("Case #"+x+": IMPOSSIBLE");
              continue;
          }
        // Passing n to constructMatrix function 
         else
         {
           constructMatrix(n); 
         }
         System.out.println("Case #"+x+": POSSIBLE");
        // Printing the desired unique matrix 
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0 ; j < n; j++) 
            System.out.print(mat[i][j]+" "); 
            System.out.println(); 
        }
      }
    } 
} 