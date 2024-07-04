import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++)
		{
			String input=br.readLine();
			ArrayList<Character> res=new ArrayList<>();
			int bcount=0;
			int N=input.length();
			for(int i=0;i<N;i++)
			{
				int curr=Integer.parseInt(Character.toString(input.charAt(i)));
				if(curr>bcount) {
					int diff=curr-bcount;
					for(int j=0;j<diff;j++)
					{
						res.add('(');
						bcount++;
					}
					res.add(input.charAt(i));
				}
				else if(bcount>curr)
				{
					int diff=bcount-curr;
					for(int j=0;j<diff;j++)
					{
						res.add(')');
						bcount--;
					}
					res.add(input.charAt(i));
				}
				else
					res.add(input.charAt(i));
			}
			
			while(bcount-->0)
				res.add(')');
			
			System.out.print("Case #"+test+": ");
			for (Character character : res) {
				System.out.print(character);
			}
			System.out.println();
		}
	}

}
