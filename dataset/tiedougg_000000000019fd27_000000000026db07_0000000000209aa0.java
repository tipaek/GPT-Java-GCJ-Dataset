import java.util.*;
import java.io.*;
public class Solution {
    private static int[][] dirs = {{1,0},{0,1},{-1,0},{0, -1}};
    private static String Board = "";
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(n,k,i);
        }
    }
    
    private static void solve(int n, int k, int i)
    {
        int[][] board = new int[n][n];
        Set<Integer>[] lflag = new HashSet[n];
        Set<Integer>[] cflag = new HashSet[n];
        for(int j = 0; j<n; j++)
        {
            lflag[j] = new HashSet<>();
            cflag[j] = new HashSet<>();
        }
        if(dfs(n, board, lflag, cflag, 0, 0, 0, k))
        {
            System.out.println("Case #" + i + ": POSSIBLE");    
            System.out.println(Board);    
        }
        else
        {
            System.out.println("Case #" + i + ": IMPOSSIBLE");    
        }
        
    }
    
    private static boolean dfs(int n, int[][] board, Set<Integer>[] lflag, Set<Integer>[] cflag, int r, int c, int cnt, int k)
    {
        //if(cnt == n*n && check(board, n, k)) 
        //{
        //    Board = printBoard(board, n);
        //    return true;
        //}
        for(int i = 1; i<=n; i++)
        {
            if(!lflag[r].contains(i)&&!cflag[c].contains(i))
            {
                board[r][c] = i;
                lflag[r].add(i);
                cflag[c].add(i);
                if(cnt+1 == n*n && check(board, n, k)) 
                {
                    Board = printBoard(board, n);
                    return true;
                }
                for(int kk = 0; kk<4; kk++)
                {
                    int newR = r+dirs[kk][0];     
                    int newC = c+dirs[kk][1];
                    if(newR>=0&&newR<n&&newC>=0&&newC<n&&board[newR][newC]==0)
                    {
                        if(dfs(n, board, lflag, cflag, newR, newC, cnt+1, k))
                        {
                            return true;
                        }
                    }
                }
          
                board[r][c] = 0;
                lflag[r].remove(i);
                cflag[c].remove(i);
            }
        }
        return false;
    }
    private static String printBoard(int[][] board, int n)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                sb.append(board[i][j]);    
                if(j!=n-1)
                    sb.append(" ");    
            }
            if(i!=n-1) sb.append("\n");
        }
        return sb.toString();
    }
    private static boolean check(int[][] board, int n, int k)
    {
        int tmp = 0;
        for(int i = 0; i<n; i++)
            tmp += board[i][i];
        return tmp == k;
    }
    
}
