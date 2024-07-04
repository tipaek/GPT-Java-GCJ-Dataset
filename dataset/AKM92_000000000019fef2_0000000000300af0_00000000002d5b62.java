/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package googlecodejam;
import java.util.*;
import java.lang.*;

/**
 *
 * @author hp
 */
public class Solution {
    
    public static int find(int x, int y)
    {
        int z = Math.abs(x) + Math.abs(y) - 1;
        int  n = 0;
        while(z > 0)
        {
            n++;
            z -= Math.pow(2, n);            
        }
        return n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int i = 0; i < T; i++)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            if((X+Y) % 2 == 0)
            {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
            else
            {
                int N = find(X,Y);
                StringBuilder sb = new StringBuilder();
                while(N > -1)
                {
                    int x1 = Math.abs(X);
                    int y1 = Math.abs(Y);
                    
                    if(x1 > y1)
                    {
                        if(X > 0)
                        {
                            X -= Math.pow(2, N);
                            sb.append("E");
                        }
                        else
                        {
                            X += Math.pow(2, N);
                            sb.append("W");
                        }
                    }
                    else
                    {
                        if(Y > 0)
                        {
                            Y -= Math.pow(2, N);
                            sb.append("N");
                        }
                        else
                        {
                            Y += Math.pow(2, N);
                            sb.append("S");
                        }
                    }
                    N--;
                }
                if(X == 0 && Y == 0)
                {
                    String ans = sb.reverse().toString();
                    System.out.println("Case #" + (i+1) + ": " + ans);
                }
                else
                {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                }
                
            }
        }
    }
    
}
