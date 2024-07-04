import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 0; tt < T; tt++)
        {
            int N = in.nextInt();
            
            int[][] mat = new int[N][N];
            for(int x = 0; x < N; x++)
            {
                for(int y = 0; y < N; y++)
                {
                    mat[x][y] = in.nextInt();
                }
            }
            int trace = 0;
            for(int x = 0; x < N; x++)
            {
                trace += mat[x][x];
            }
            int hor = 0;
            for(int x = 0; x < N; x++)
            {
                Set<Integer> s = new HashSet<Integer>();
                for(int y = 0; y < N; y++)
                    s.add(mat[x][y]);
                if(s.size() != N)
                    hor++;
            }
            int ver = 0;
            for(int x = 0; x < N; x++)
            {
                Set<Integer> s = new HashSet<Integer>();
                for(int y = 0; y < N; y++)
                    s.add(mat[y][x]);
                if(s.size() != N)
                    ver++;
            }
            System.out.println("Case #"+tt+": " + trace + " " + hor + " " + ver);
        }
    }
}