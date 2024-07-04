
import java.io.BufferedReader;
import java.io.InputStreamReader;

 class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(sc.readLine());
		int k=1;
		while(t-->0)
		{
			int count=0;
			String ip=(sc.readLine());
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<ip.length();i++)
			{
				char temp=ip.charAt(i);
				if(temp=='0')
				{
					if(count!=0)
					{
						//System.out.println(count);
						sb.append('(');
						while(count!=0)
						{
							sb.append('1');
							count--;
						}
						sb.append(')');
					}
					sb.append('0');
				}
				else {
					count++;
				}
			}
			if(count!=0)
			{
				sb.append('(');
				while(count-->0)
				{
					sb.append('1');
				}
				sb.append(')');
			}
			System.out.println("Case #"+k+": "+sb);
			k++;
		}
	}

}
