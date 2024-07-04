import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int test=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<test;i++)
		{ 
			String s=br.readLine();
			int len=s.length();
			int brac_open=0;
			StringBuilder str=new StringBuilder();
			
			for(int j=0;j<len;j++)
			{
				int count=Integer.parseInt(String.valueOf(s.charAt(j)));
				int loop=Math.abs(brac_open-count);
				
				if(brac_open>count)
				{
					while(loop>0)
					{
						str.append(")");
						brac_open--;
						loop--;
					}
					str.append(count);
					
				}
				
				else if(brac_open<count)
				{
					while(loop>0)
					{
						str.append("(");
						brac_open++;
						loop--;
					}
					str.append(count);
					
				}
				
				else
				{
					str.append(count);
				}
			}
			
			while(brac_open>0)
			{
				str.append(")");
				brac_open--;
			}
		  
		    System.out.println("Case #"+(int)(i+1)+": "+str);
			
		}
		
	}

}

