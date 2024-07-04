import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int test=0;
		while(test++<T)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			String M=st.nextToken();
			boolean flag=false;
			int distanceFromMypoint = 0;
			int i;
			for(i=0;i<M.length();i++)
			{
				if(M.charAt(i)=='N')
					Y++;
				else if(M.charAt(i)=='S')
					Y--;
				else if(M.charAt(i)=='E')
					X++;
				else
					X--;
				
				distanceFromMypoint=Math.abs(X)+Math.abs(Y);
				if(i+1>=distanceFromMypoint)
				{
					flag=true;
					break;
				}
			}
			
			System.out.print("Case #"+test+": ");
			System.out.println((flag)?i+1:"IMPOSSIBLE");
		}
	}

}
