import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tCount=1;tCount<=t;tCount++)
        {
            int x=scan.nextInt();
            int y=scan.nextInt();
            
            if(Math.abs(x%2)==Math.abs(y%2))
                System.out.println("Case #"+tCount+": IMPOSSIBLE");
            else
            {
                int []xMoves=new int[32];
                int []yMoves=new int[32];
                
                int xBin=x;
                int yBin=y;
                
                int power=1;
                for(int i=0;xBin!=0;i++)
                {
                    if(xBin%(power*2)==0)
                        xMoves[i]=0;
                    else if(xBin>0)
                    {
                        xMoves[i]=1;
                        xBin-=power;
                    }
                    else
                    {
                        xMoves[i]=-1;
                        xBin+=power;
                    }
                    power*=2;
                }
                power=1;
                for(int i=0;yBin!=0;i++)
                {
                    if(yBin%(power*2)==0)
                        yMoves[i]=0;
                    else if(yBin>0)
                    {
                        yMoves[i]=1;
                        yBin-=power;
                    }
                    else
                    {
                        yMoves[i]=-1;
                        yBin+=power;
                    }
                    power*=2;
                }
                
                int moves=-1;
                for(int i=0;i<32;i++)
                {
                    if(xMoves[i]==0 && yMoves[i]==0)
                    {
                        if(moves==-1)
                            moves=i;
                    }
                    else if(moves!=-1)
                        moves=-1;
                }
                
                boolean possible=true;
                
                for(int i=1;i<moves;i++)
                {
                    if(xMoves[i]==0 && yMoves[i]==0)
                    {
                        if(xMoves[i-1]!=0)
                        {
                            xMoves[i]=xMoves[i-1];
                            xMoves[i-1]*=-1;
                        }
                        else
                        {
                            yMoves[i]=yMoves[i-1];
                            yMoves[i-1]*=-1;
                        }
                    }
                    else if(xMoves[i]!=0 && yMoves[i]!=0)
                    {
                        if(xMoves[i-1]==xMoves[i] && xMoves[i+1]==0)
                        {
                            xMoves[i-1]*=-1;
                            xMoves[i+1]=xMoves[i];
                            xMoves[i]=0;
                            if(i==moves-1)
                                moves++;
                        }
                        else if(yMoves[i-1]==yMoves[i] && yMoves[i+1]==0)
                        {
                            yMoves[i-1]*=-1;
                            yMoves[i+1]=yMoves[i];
                            yMoves[i]=0;
                            if(i==moves-1)
                                moves++;
                        }
                        else if(xMoves[i-1]==-1*xMoves[i])
                        {
                            xMoves[i-1]*=-1;
                            xMoves[i]=0;
                        }
                        else if(yMoves[i-1]==-1*yMoves[i])
                        {
                            yMoves[i-1]*=-1;
                            yMoves[i]=0;
                        }
                        else
                        {
                            possible=false;
                            System.out.println("Case #"+tCount+": IMPOSSIBLE");
                            break;
                        }
                    }
                }
                
                if(possible)
                {
                    System.out.print("Case #"+tCount+": ");
                    for(int i=0;i<moves;i++)
                    {
                        if(xMoves[i]==1)
                            System.out.print("E");
                        else if(xMoves[i]==-1)
                            System.out.print("W");
                        else if(yMoves[i]==1)
                            System.out.print("N");
                        else if(yMoves[i]==-1)
                            System.out.print("S");
                    }
                    System.out.println();
                }
            }
        }
    }
}
