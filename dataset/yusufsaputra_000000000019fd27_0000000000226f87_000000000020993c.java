/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vestigium;
import java.util.Scanner;

/**
 *
 * @author Yusuf Saputra
 */
public class Vestigium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vestigium m = new Vestigium();
        m.view();
    }
    
    public void view()
    {
        int T=1;
        int N=4;
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        in.nextLine();
        for (int test = 0; test < T; test ++)
        {
            N = in.nextInt();
            in.nextLine();
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    M[i][j] = in.nextInt();
                    in.nextLine();
                }
                System.out.println("");
            }
            int diagonal = 0;
            int K = 0;
            for (int i = 0; i < N; i++)
            {
                K = K + M[diagonal][diagonal];
                diagonal++;
            }
            /** duplicate row **/
            int R = dupRows(M, N);
            int C = dupCols(M, N);
            System.out.println("#" + (test+1) + " " + K + " " + R + " " + C);
        }
    }
    
    /**
     *
     * @param M
     * @return
     */
    public int dupRows(int[][] M, int N)
    {
        int R = 0;
        for (int row = 0; row < N; row++)
        {
            boolean diff = false;
            for (int col = 0; col < N; col++)
            {
                int num = M[row][col];
                for (int otherCol = col + 1; otherCol < N; otherCol++)
                {
                    if (num == M[row][otherCol])
                    {
                        diff = true;
                    }
                }
            }
            if (diff == true)
            {
                R = R + 1;
            }
        }
        return R;
    }
    
    int dupCols(int[][] M, int N)
    {
        int C=0;
        for (int col = 0; col < N; col++)
        {
            boolean diff = false;
            for (int row = 0; row < N; row++)
            {
                int num = M[row][col];
                for (int otherRow = row + 1 ; otherRow < N; otherRow++)
                {
                    if (num == M[otherRow][col])
                    {
                        diff = true;
                    }
                }
            }
            if (diff == true)
            {
                C = C + 1;
            }
        }
        return C;
    }
    
}
