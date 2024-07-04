import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		for(int td=1;td<=t;td++)
		{
			
			String data[]=br.readLine().split(" ");
			int x=Integer.valueOf(data[0]);
			int y=Integer.valueOf(data[1]);
			int xForTimeI[]=new int[data.length-1];
			int yForTimeI[]=new int[data.length-1];
			xForTimeI[0]=x;
			yForTimeI[0]=y;
			boolean isDone=false;
			int answer=-1;
			String data2[]=data[2].split("");
			for(int i=0;i<data2.length;i++)
			{
				
				if(data2[i].equals("S"))
					y--;
				else if(data2[i].equals("N"))
					y++;
				
				else if(data2[i].equals("E"))
					x++;
				
				else if(data2[i].equals("W"))
					x--;
					
				
				int sum=Math.abs(x)+Math.abs(y);
				
				if(sum<=i+1)
				{
					isDone=true;
					answer=i+1;
					break;
				}
				
			}
			
			if(isDone)
			{
				System.out.println("Case #"+td+": "+answer);
			}
			else
			{
				System.out.println("Case #"+td+": IMPOSSIBLE");
			}
			
			
			
		}
	}

}
