
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(sc.readLine());
		int k=1;
		while(t-->0)
		{
			StringBuffer ans=new StringBuffer();
			ArrayList<Integer> c=new ArrayList<Integer>();
			ArrayList<Integer> j=new ArrayList<Integer>();
			int n=Integer.parseInt(sc.readLine());
			boolean impossible=false;
			for(int i=0;i<n;i++)
			{
				String[] str=sc.readLine().split(" ");
				int start=Integer.parseInt(str[0]);
				int end=Integer.parseInt(str[1]);
				if(c.size()==0 && j.size()==0)
				{
					c.add(start);
					c.add(end);
					ans.append('C');
					continue;
				}	
				int h;
				for(h=0;h<c.size();h+=2)
				{
					if((start>=c.get(h) && start<c.get(h+1)) || (end>c.get(h) && end<=c.get(h+1)))
					{
						break;
					}
				}
				if(h==c.size())
				{
					c.add(start);
					c.add(end);
					ans.append('C');
				}
				else {
					for(h=0;h<j.size();h+=2)
					{
						if((start>=j.get(h) && start<j.get(h+1)) || (end>j.get(h) && end<=j.get(h+1)))
						{
							break;
						}
					}
					if(h==j.size())
					{
						j.add(start);
						j.add(end);
						ans.append('J');
					}
					else {
						impossible=true;
						break;
					}
				}
			}
			if(impossible==false)
				System.out.println("Case #"+k+": "+ans);
			else
				System.out.println("Case #"+k+": "+"IMPOSSIBLE");
			k++;
		}
	}

}
