import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int tt = 1; tt <= T; tt++)
		{
		    String ans = "";
		    int X = in.nextInt(); //East
		    int Y = in.nextInt(); //North
		    String S = in.next();
		    String[] Z = S.split("");
		    int sz = S.length();
		    
		  //  int XX = X;
		  //  int YY = Y;
		  //  for(int i = 0; i < sz; i++)
		  //  {
		  //      if(Z[i].equals("N"))
		  //          YY += 1;
		  //      if(Z[i].equals("S"))
		  //          YY -= 1;
		  //      if(Z[i].equals("E"))
		  //          XX += 1;
		  //      if(Z[i].equals("W"))
		  //          XX -= 1;
		  //  }
		  //  if(XX + YY < sz)
		  //  {
		  //      System.out.println("Case #" + tt + ": IMPOSSIBLE");
		  //      continue;
		  //  }
		    int ct = 0;
		    int dist = X + Y;
		    while(ct < sz && dist != 0)
		    {
		        String move = Z[ct];
		        if(move.equals("N"))
		        {
		            Y += 1;
		            ct += 1;
		            if(Math.abs(X) + Math.abs(Y) == 0)
		            {
		                dist = 0;
		                break;
		            }
		            if(Math.abs(X) >= Math.abs(Y))
		            {
		                if( X < 0)
		                    X += 1;
		                else
		                    X -= 1;
		            }
		            else
                    {
                        if( Y < 0 )
                            Y += 1;
                        else
                            Y -= 1;
                    }
		        
		        }
		        if(move.equals("S"))
		        {
		            Y -= 1;
		            ct += 1;
		            if(Math.abs(X) + Math.abs(Y) == 0)
		            {
		              dist = 0;
		                break;
		            }
		            if(Math.abs(X) >= Math.abs(Y))
		            {
		                if( X < 0)
		                    X += 1;
		                else
		                    X -= 1;
		            }
		            else
                    {
                        if( Y < 0 )
                            Y += 1;
                        else
                            Y -= 1;
                    }
		        
		        }
		        if(move.equals("E"))
		        {
		            X += 1;
		            ct += 1;
		            if(Math.abs(X) + Math.abs(Y) == 0)
		            {
		                dist = 0;
		                break;
		            }
		            if(Math.abs(X) >= Math.abs(Y))
		            {
		                if( X < 0)
		                    X += 1;
		                else
		                    X -= 1;
		            }
		            else
                    {
                        if( Y < 0 )
                            Y += 1;
                        else
                            Y -= 1;
                    }
		        }
		           
		        if(move.equals("W"))
		        {
		            X -= 1;
		            ct += 1;
		            if(Math.abs(X) + Math.abs(Y) == 0)
		            {
		                dist = 0;
		                break;
		            }
		            if(Math.abs(X) >= Math.abs(Y))
		            {
		                if( X < 0)
		                    X += 1;
		                else
		                    X -= 1;
		            }
		            else
                    {
                        if( Y < 0 )
                            Y += 1;
                        else
                            Y -= 1;
                    }
		        }
		        dist =  Math.abs(X) + Math.abs(Y);
		        //System.out.println(dist + " " +  X + " " + Y);
		    }
		    if(dist == 0)
		        System.out.println("Case #" + tt + ": " + ct);
		    else
		        System.out.println("Case #" + tt + ": IMPOSSIBLE");
		}
	}
}
