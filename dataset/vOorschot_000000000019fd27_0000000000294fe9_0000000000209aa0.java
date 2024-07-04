/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] field = new int[N][N];
            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    field[r][c] = ((N + r - c) % N) + 1;
                }
            }
            int toSwap = 0;
            int trace = N;
            while (toSwap < N && trace != K)
            {
//                System.out.println(Arrays.deepToString(field));
                int swapper = N - 1;
                while (trace - field[toSwap][toSwap] + field[swapper][toSwap]
                        + field[toSwap][swapper] - field[swapper][swapper] > K)
                {
                    swapper--;
                }
                trace = trace - field[toSwap][toSwap] + field[swapper][toSwap] + field[toSwap][swapper] - field[swapper][swapper];
                int[] temp = field[toSwap];
                field[toSwap] = field[swapper];
                field[swapper] = temp;
//                System.out.println(Arrays.deepToString(field));
//                System.out.println(trace + " " + K);
                toSwap++;
            }
            if (trace == K)
            {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int r = 0; r < N; r++)
                {
                    for (int c = 0; c < N; c++)
                    {
                        System.out.print(field[r][c]);
                        if(c!=N-1){
                            System.out.print(" ");
                        }
                    }
                    System.out.println("");
                }
            } else
            {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}
