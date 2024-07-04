import java.util.*;
public class Solution {


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
                if (isSafe(board, row, col, num))
                {
                    board[row][col] = num;
                    if (solve(board, n, k))
                    {

                        return true;
                    }
                    else
                    {
                        board[row][col] = 0;
                    }
                }
            }
            return false;
        }



        public static boolean isSafe(int[][] board,int row, int col,int num)
        {

            for (int d = 0; d < board.length; d++)
            {

                if (board[row][d] == num)
                {
                    return false;
                }
            }


            for (int r = 0; r < board.length; r++)
            {


                if (board[r][col] == num)
                {
                    return false;
                }
            }


            return true;
        }

    }
