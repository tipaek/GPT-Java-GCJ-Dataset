import java.io.*;
import java.util.*;
import java.math.*;

class Solution
{
	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;++t)
		{
			int my_x=0,my_y=0;
			String co[]=br.readLine().split(" ");
			int x=Integer.parseInt(co[0]);
			int y=Integer.parseInt(co[1]);
			char w[]=co[2].toCharArray();
			
			int ans=-1;
			
			for(int i=0;i<w.length;++i)
			{
				if(w[i]=='S') y--;
				else if(w[i]=='N') y++;
				else if(w[i]=='E') x++;
				else if(w[i]=='W') x--;
				
				int time_req=Math.abs(x-my_x)+Math.abs(y-my_y);
				
				if(time_req<=(i+1))
				{
					ans=i+1;
					break;
				}
			}
			
			if(ans==-1)
			{
				pw.println("Case #"+t+": IMPOSSIBLE");
			}
			else
			{
				pw.println("Case #"+t+": "+ans);
			}
		}
		
		pw.flush();
		pw.close();
	}
}