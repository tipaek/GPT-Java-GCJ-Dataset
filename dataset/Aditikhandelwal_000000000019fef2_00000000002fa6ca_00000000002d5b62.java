import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t= scn.nextInt();
        String s="";
        int tc=t;
        while(t!=0)
        {
        	long x = scn.nextInt(), y = scn.nextInt();
        	if(x==0)
        	{
        		if(y==1)
        		{
        			s="N";
        		}
        		else if(y==-1)
        		{
        			s="S";
        		}
        		else if(y==3)
        		{
        			s="NN";
        		}
        		else if(y==-3)
        		{
        			s="SS";
        		}
        		else
        		{
        			s="IMPOSSIBLE";
        		}
        	}
        	else if(y==0)
        	{
        		if(x==1)
        		{
        			s="E";
        		}
        		else if(x==-1)
        		{
        			s="W";
        		}
        		else if(x==3)
        		{
        			s="EE";
        		}
        		else if(x==-3)
        		{
        			s="WW";
        		}
        		else
        		{
        			s="IMPOSSIBLE";
        		}
        	}
        	else if(x==1 && y==2)
        	{
        		s="EN";
        	}
        	else if(x==1 && y==-2)
        	{
        		s="ES";
        	}
        	else if(x==-1 && y==2)
        	{
        		s="WN";
        	}
        	else if(x==-1 && y==-2)
        	{
        		s="WS";
        	}
        	else if(x==2 && y==1)
        	{
        		s="NE";
        	}
        	else if(x==2 && y==-1)
        	{
        		s="SE";
        	}
        	else if(x==-2 && y==1)
        	{
        		s="NW";
        	}
        	else if(x==-2 && y==-1)
        	{
        		s="SW";
        	}
        	else if(x==2 && y==3)
        	{
        		s="SEN";
        	}
        	else if(x==-2 && y==3)
        	{
        		s="SWN";
        	}
        	else if(x==2 && y==-3)
        	{
        		s="NES";
        	}
        	else if(x==-2 && y==-3)
        	{
        		s="NWS";
        	}
        	else if(x==3 && y==2)
        	{
        		s="WNE";
        	}
        	else if(x==3 && y==-2)
        	{
        		s="WSE";
        	}
        	else if(x==-3 && y==2)
        	{
        		s="ENW";
        	}
        	else if(x==-3 && y==-2)
        	{
        		s="ESW";
        	}
        	else {
        		s="IMPOSSIBLE";
        	}
        	System.out.println("Case #"+(tc-t+1)+": "+ s );
        	t--;
        }
	}

}