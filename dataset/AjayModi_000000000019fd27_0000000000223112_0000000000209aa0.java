import java.util.*;
class Solution
{
  public static void main(String[] args)
  {
      
      Scanner ob=new Scanner(System.in);
      int t=ob.nextInt();
      for(int it=1;it<=t;it++)
      {
          int n=ob.nextInt();
          int k=ob.nextInt();
          int arr[][]=new int[n][n];
          if(solve(arr,n,k))
          {
              System.out.println("Case #"+it+": POSSIBLE");
              print(arr,n);
          }
          else
          {
              System.out.println("Case #"+it+": IMPOSSIBLE");
          }
          /*if(k%n==0)
          {
             for(int i=0;i<n;i++)
             arr[i][i]=k/n;
             if(!solve(arr,n))
             {
                 int tt=0;
                 for(int hj=1;hj<=n;hj++)
                 {
                    tt+=hj; 
                 }
                if(tt==k)
                {
                    for(int i=0;i<n;i++)
                      arr[i][i]=i+1;
                    if(!solve(arr,n))
                    {
                        System.out.println("Case #"+it+": IMPOSSIBLE");
                    }
                    else
                    {
                        System.out.println("Case #"+it+": POSSIBLE");
                        print(arr,n);
                    }
                }
             }
             else
             {
                 System.out.println("Case #"+it+": POSSIBLE");
                 print(arr,n);
                 
             }
          }
          else
          {
             int tt=0;
                 for(int hj=1;hj<=n;hj++)
                 {
                    tt+=hj; 
                 }
                if(tt==k)
                {
                    for(int i=0;i<n;i++)
                      arr[i][i]=i+1;
                    if(!solve(arr,n))
                    {
                        System.out.println("Case #"+it+": IMPOSSIBLE");
                    }
                    else
                    {
                        System.out.println("Case #"+it+": POSSIBLE");
                        print(arr,n);
                    }
                }
          }*/
      }
  }
  public static void print(int arr[][],int n)
  {
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
              System.out.print(arr[i][j]+" ");
          }
          System.out.println();
      }
  }
  public static boolean solve(int[][] board, int n,int k)  
{ 
    int row = -1; 
    int col = -1; 
    int dig=0,digf=0;
    boolean isEmpty = true; 
    for(int i=0;i<n;i++)
    {
        if(board[i][i]==0)
        {
            digf=1;
            break;
        }
        else
        dig+=board[i][i];
    }
    if(digf==0&& dig!=k)
    return false;
    
    for (int i = 0; i < n; i++) 
    { 
        for (int j = 0; j < n; j++)  
        { 
            if (board[i][j] == 0)  
            { 
                row = i; 
                col = j; 
                  
                // we still have some remaining 
                // missing values in Sudoku 
                isEmpty = false;  
                break; 
            } 
        } 
        if (!isEmpty) 
        { 
            break; 
        } 
    } 
  
    // no empty space left 
    if (isEmpty)  
    { 
        return true; 
    } 
  
    // else for each-row backtrack 
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(board, row, col, num)) 
        { 
            board[row][col] = num; 
            if (solve(board, n, k))  
            { 
                // print(board, n); 
                return true; 
            }  
            else
            { 
                board[row][col] = 0; // replace it 
            } 
        } 
    } 
    return false; 
} 
  
  
  
  public static boolean isSafe(int[][] board,  
                             int row, int col,  
                             int num)  
{ 
    // row has the unique (row-clash) 
    for (int d = 0; d < board.length; d++)  
    { 
        // if the number we are trying to  
        // place is already present in  
        // that row, return false; 
        if (board[row][d] == num)  
        { 
            return false; 
        } 
    } 
      
    // column has the unique numbers (column-clash) 
    for (int r = 0; r < board.length; r++) 
    { 
        // if the number we are trying to 
        // place is already present in 
        // that column, return false; 
  
        if (board[r][col] == num) 
        { 
            return false; 
        } 
    } 
  
       // if there is no clash, it's safe 
    return true; 
} 
  
}