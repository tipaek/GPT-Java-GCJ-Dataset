import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        
        int T = input.nextInt();
        input.nextLine();
        int n;
        int[][] list; 
        int trace;
        int r;
        int c;
        for(int x = 0; x < T; x++)
        {
            n = input.nextInt();
            list = new int[n][n];
            trace = 0;
            r = 0;
            c = 0;
            for(int i = 0; i < n; i++)
            {
                input.nextLine();
                for(int y = 0; y < n; y++)
                {
                    list[i][y] = input.nextInt();
                    if(i == y)
                    {
                        trace += list[i][y];
                    }
                }
            }
            for(int i = 0; i < n; i++)
            {
                Outer:
                for(int y = 0; y < n; y++)
                {
                    for(int k = y + 1; k < n; k++)
                    {
                        if(list[i][y] == list[i][k])
                        {
                            r++;
                            break Outer;
                        }
                    }
                }
            }
            for(int i = 0; i < n; i++)
            {
                Outer:
                for(int y = 0; y < n; y++)
                {
                    for(int k = y + 1; k < n; k++)
                    {
                        if(list[y][i] == list[k][i])
                        {
                            c++;
                            break Outer;
                        }
                    }
                }
            }
            System.out.println("Case #" + T + ": " + trace + " " + r + " " + c);
        }
        
        
        input.close();
        output.flush();
        output.close();
    }
}