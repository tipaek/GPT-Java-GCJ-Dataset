
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Solution 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=test;t++)
		{
			int n=Integer.parseInt(br.readLine().trim());
			
			ArrayList<ArrayList<Integer>> latin=new ArrayList<ArrayList<Integer>>();
			
			int trace=0,row=0,temp=0;
			
			for(int i=0;i<n;i++)
			{
				temp=0;
				
				String s[]=br.readLine().split(" ");
				
				ArrayList<Integer> al=new ArrayList<Integer>();
				
				for(int j=0;j<n;j++)
				{
					int y=Integer.parseInt(s[j]);
					if(al.contains(y))
					{
						temp++;
						al.add(y);
					}
					else
					{
						al.add(y);
					}
					
					if(i==j)
					{
						trace+=y;
					}
				}
				latin.add(al);
				row=Math.max(temp,row);
				al=null;
				s=null;
			}
			
			temp=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(latin.get(i).get(j)+" ");
				}
				System.out.println(" ");
			}
			
			int col=0;
			
			for(int i=0;i<n;i++)
			{
				temp=0;
				ArrayList<Integer> al=new ArrayList<Integer>();
				for(int j=0;j<n;j++)
				{
					if(al.contains(latin.get(j).get(i)))
					{
						temp++;
					}
					else
					{
						al.add(latin.get(j).get(i));
					}
				}
				col=Math.max(temp, col);
				al=null;
			}
			
			if(col>0)
			{
				col++;
			}
			if(row>0)
			{
				row++;
			}

			System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
		}
		
		br.close();
	}

}
