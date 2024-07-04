import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 1; tt <= T; tt++)
        {   
            int R = in.nextInt();
            int C = in.nextInt();
            int ic = 0;
            int[][] floor = new int[R][C];
            for(int r = 0; r < R; r++)
            {
                for(int c = 0; c < C; c++)
                {
                    floor[r][c] = in.nextInt(); 
                    ic += floor[r][c];
                }
            }
            int eliminations = 1;
            int ir = 0;
            //System.out.println(ic);
            while(eliminations != 0)
            {
                int[][] floo = new int[R][C];                
                //System.out.println(ir);
                ic += ir;
                ir = 0;
                eliminations = 0;
                for(int r = 0; r < R; r++)
                {
                    for(int c = 0; c < C; c++)
                    {
                        if(floor[r][c] != 0)
                        {
                            //System.out.println(r + " " + c);
                            //System.out.println(avg(r, c, floor));
                            if(floor[r][c] < avg(r, c, floor))
                            {
                                eliminations++;
                                floo[r][c] = 0;
                            }
                            else
                            {
                                ir += floor[r][c];
                                floo[r][c] = floor[r][c];
                            }
                        }
                        else
                            floo[r][c] = 0;
                    }
                }
                floor = floo;
                
            }
            System.out.println("Case #" + tt + ": " + ic);
        }
    }
    public static double avg(int r, int c, int[][] fl)
    {
        int total = 0;
        int ct = 0;
        for(int x = 1; x < 1000; x++)
        {
            
            if(r-x < 0)
                break;
            //System.out.println(1);
            if(r-x >= 0 && fl[r-x][c] != 0)
            {
                total += fl[r-x][c];
                ct += 1;
                break;
            }
        }
        for(int x = 1; x < 1000; x++)
        {
            
            if(r+x >= fl[0].length)
                break;
            //System.out.println(2);
            if(r+x < fl[0].length && fl[r+x][c] != 0)
            {
                total += fl[r+x][c];
                ct += 1;
                break;
            }
        }
        for(int x = 1; x < 1000; x++)
        {
            if(c-x < 0)
                break;
            //System.out.println(3);
            if(c-x >= 0 && fl[r][c-x] != 0)
            {
                total += fl[r][c-x];
                ct += 1;
                break;
            }
        }
        for(int x = 1; x < 1000; x++)
        {
            if(c+x >= fl.length)
                break;
            //System.out.println(4);
            if(c+x < fl.length && fl[r][c+x] != 0)
            {
                total += fl[r][c+x];
                ct += 1;
                break;
            }
        }
        //System.out.println(ct + " " + total);
        if(ct > 0)
            return total/(ct*1.0);
        return 0;
        
    }
}
// class Dancer
// {
//     public ArrayList<Dancer> neighbors;
//     public int r;
//     public int c;
//     public Dancer(ro, co, sk)
//     {
//         s = sk;
//         r = ro;
//         c = co;
//     }
//     public void addNeighbor(Dancer d)
//     {
//         neighbors.add(d);
//     }
// }