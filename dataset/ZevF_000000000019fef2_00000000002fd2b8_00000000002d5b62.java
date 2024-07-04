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
                int []xMoves=new int[33];
                int []yMoves=new int[33];
                
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
                
                boolean possible=true;
                
                for(int i=1;i<33;i++)
                {
                    if(xMoves[i]==0 && yMoves[i]==0)
                    {
                        boolean done=true;
                        for(int j=i+1;j<33;j++)
                            if(xMoves[j]!=0 || yMoves[j]!=0)
                                done=false;
                        if(done)
                            break;
                        
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
                        if(xMoves[i-1]==xMoves[i])
                        {
                            xMoves[i-1]*=-1;
                            int j;
                            for(j=i+1;xMoves[j]!=0;j++)
                                xMoves[j]=0;
                            xMoves[j]=xMoves[i];
                            xMoves[i]=0;
                        }
                        else if(yMoves[i-1]==yMoves[i])
                        {
                            yMoves[i-1]*=-1;
                            int j;
                            for(j=i+1;yMoves[j]!=0;j++)
                                yMoves[j]=0;
                            yMoves[j]=yMoves[i];
                            yMoves[i]=0;
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
                    }
                }
                
                if(possible)
                {
                    System.out.print("Case #"+tCount+": ");
                    for(int i=0;i<33;i++)
                    {
                        if(xMoves[i]==1)
                            System.out.print("E");
                        else if(xMoves[i]==-1)
                            System.out.print("W");
                        else if(yMoves[i]==1)
                            System.out.print("N");
                        else if(yMoves[i]==-1)
                            System.out.print("S");
                        else
                            break;
                    }
                    System.out.println();
                }
            }
        }
    }
}
