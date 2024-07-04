import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		
		for(int td=1;td<=t;td++)
		{
			String data[]=br.readLine().split(" ");
			int x=Integer.valueOf(data[0]);
			int y=Integer.valueOf(data[1]);
			
			if(x%2==0)
			{
				if(y%2==0)
				{
					System.out.println("Case #"+td+": IMPOSSIBLE");
					break;
				}
			}
			else if(y%2!=0)
			{
				System.out.println("Case #"+td+": IMPOSSIBLE");
				break;
			}
			
			int sum=Math.abs(x)+Math.abs(y);
			int num=log2(sum);
			ArrayList<String> answer=new ArrayList<String>();
			int power=(int)Math.pow(2, num);
			int count=0;
			while(power>0)
			{
				if(Math.abs(x)>Math.abs(y))
				{
					if(x<0) {
						x=x+power;
						count++;
						answer.add("W");
					}
					else if(x>0) {
						x=x-power;
						count++;
						answer.add("E");
					}
				}
				else
				{
					if(y<0) {
						y=y+power;
						count++;
						answer.add("S");
					}
					else if(y>0)
					{
						y=y-power;
						count++;
						answer.add("N");
						}
					
					
				}
				
				
				
				power=power/2;
			}
			
			
			if(count==num+1&&x==0&&y==0)
			{
				System.out.print("Case #"+td+": ");
			for(int i=answer.size()-1;i>=0;i--)
			{
				System.out.print(answer.get(i));
			}
				System.out.println();
			}
			
			else
			{
				System.out.println("Case #"+td+": IMPOSSIBLE");
			}
			
			
				
			
			
		}
	}
	
	public static int log2(int x)
	{
	    return (int) (Math.log(x) / Math.log(2));
	}

}
