
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Solution
{

    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++)
        {
            int trace = 0;
            int row = 0;
            int col = 0;
            int N = sc.nextInt();
            boolean[][] seenColum = new boolean[N][N];

            for (int r = 0; r < N; r++)
            {
                boolean[] seenRow = new boolean[N];
                for (int c = 0; c < N; c++)
                {
                    int cell = sc.nextInt();
                    seenRow[cell - 1] = true;
                    seenColum[c][cell - 1] = true;
                    if (r == c)
                    {
                        trace += cell;
                    }
                }
                for (int c = 0; c < N; c++)
                {
                    if(!seenRow[c]){
                        row++;
                        break;
                    }
                }
            }
            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    if(!seenColum[r][c]){
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
        }
    }

    public static void main(String[] args)
    {
        new Solution().run();
    }
}
