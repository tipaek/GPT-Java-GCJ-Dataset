/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejamr1c;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Amith
 */
public class Solution {
    
    public static boolean checkImp(int x, int y, int x1, int y1, int len)
    {
        if((Math.abs(x-x1) + Math.abs(y-y1)+1) % 2 <= len)
                return true;
        return false;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i< T; i++)
        {
            String dr1 = sc.nextLine();
            String[] str = dr1.split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);
            String dr = str[2];
            int X1 = 0, Y1 = 0;
            
            int len = dr.length();
            
            if(X==X1 && Y==Y1)
            {
                System.out.println("Case #" + (i+1) + ": 0");
                break;
            }
            
            if(checkImp(X,Y,X1,Y1,len))
            {
                int count = 0;
                
                for(int j = 0; j < len; j++)
                {
                    count++;
                    if(dr.charAt(j) == 'N')
                    {
                        Y += 1;
                    }
                    else if(dr.charAt(j) == 'S')
                    {
                        Y -= 1;
                    }
                    else if(dr.charAt(j) == 'E')
                    {
                        X += 1;
                    }
                    else if(dr.charAt(j) == 'W')
                    {
                        X -= 1;
                    }
                    if(X==X1 && Y==Y1)
                    {
                        break;
                    }
                    
                    if(dr.charAt(j) == 'N')
                    {
                        if(X > X1)
                        {
                            X1 += 1;
                        }
                        else if(X < X1)
                        {
                            X1 -= 1;
                        }
                        else if(Y > Y1)
                        {
                            Y1 += 1;
                        }
                        else
                        {
                            Y1 -= 1;
                        }
                    }
                    else if(dr.charAt(j) == 'S')
                    {
                        if(X > X1)
                        {
                            X1 += 1;
                        }
                        else if(X < X1)
                        {
                            X1 -= 1;
                        }
                        else if(Y > Y1)
                        {
                            Y1 += 1;
                        }
                        else
                        {
                            Y1 -= 1;
                        }
                    }
                    else if(dr.charAt(j) == 'E')
                    {
                        if(Y > Y1)
                        {
                            Y1 += 1;
                        }
                        else if(Y < Y1)
                        {
                            Y1 -= 1;
                        }
                        else if(X > X1)
                        {
                            X1 += 1;
                        }
                        else
                        {
                            X1 -= 1;
                        }
                    }
                    else if(dr.charAt(j) == 'W')
                    {
                        
                    }
                    
                    if(X==X1 && Y==Y1)
                    {
                        break;
                    }
                    
                    if(!checkImp(X,Y,X1,Y1,len-j-1))
                        break;
                }
                
                if(X==X1 && Y==Y1)
                {
                    System.out.println("Case #" + (i+1) + ": " + count);
                }
                else
                {
                    System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                }
            }
            else
            {
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
        }
    }
    
}
