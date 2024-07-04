import java.io.*;
import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testC = sc.nextInt();
        
        for(int tc = 1; tc <= testC; tc++)
        {
            int N = sc.nextInt();
            int[] A = new int[N];
            int trace = 0, rowR = 0, colR = 0;
            
            for(int row = 0; row < N; row++)
            {
                for(int col = 0; col < N; col++)
                {
                    A[row][col] = sc.nextInt();
                    if(row == col)
                        trace = trace + A[row][col];
                }
            }
            
            for(int row = 0; row < N; row++)
            {
                for(int col = 1; col < N; col++)
                {
                    for(int i = 1; i <= col; i++)
                    {
                        if(A[row][col] == A[row][col-i])
                            rowR++;
                        if(A[col][row] == A[col-i][row])
                            colR++;
                    }
                }
                
            }
            
            System.out.println("Case #" + tc + ": " + trace + " " + rowR + " " + colR);
        }
    }
}