import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		String[] array = new String[T];
		for(int a=0;a<T;a++)
		{
			String str = "C";
		int n = sc.nextInt();
		int[] start = new int[n];
		int[] original = new int[n];
		int[] end = new int[n];
		int cam = 0;
		int jam =0;
					TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
			hm.put(start[i],i);

		}
		int[] endd = new int[n];
		int i=0;
		
		original = start.clone();
//Collections.sort(hm);
		for(Map.Entry entry : hm.entrySet())
		{
			/////System.out.println(entry.getKey());
			start[i]=Integer.parseInt(entry.getKey().toString());
			endd[i]=end[hm.get(start[i])];
			i++;
		}
		
		
		
		
		Solution obj = new Solution();
		String pri = obj.Schedule(start,endd,n,str);
		
		int[] index = new int[n];
		String rearr ="";
		i=0;
		if(!pri.equals("IMPOSSIBLE"))
		{
		for(Map.Entry entry : hm.entrySet())
		{
			//System.out.println(entry.getKey());
			index[i]=Integer.parseInt(entry.getValue().toString());
			rearr = rearr+pri.charAt(index[i]);
			i++;
		}
		pri=rearr;}
		
		
		array[a]= "Case #"+(a+1)+": "+pri;
		}
		for(String c:array)
		{
			System.out.println(c);
		}
	
	}
	
	
	String Schedule(int[] start, int[] end, int n, String str)
	{
	 int cam=end[0];int jam=0;
		for(int i=1;i<n;i++ )
		{
			//if(str.charAt(str.length()-1)=='C'){
			if(start[i]-cam>=0)
			{
				cam = end[i];
				str=str+'C';
			}
			else if(start[i]-jam>=0)
			{
				jam = end[i];
				str=str+'J';
			}}
			/*else
			{
				if(start[i]-jam>=0)
			{
				jam = end[i];
				str=str+'J';
			}
			else if(start[i]-cam>=0)
			{
				cam = end[i];
				str=str+'C';
			}
			}*/
		
			
			
			
			if(str.length()!=n)
			{
				return "IMPOSSIBLE";
			}
			return str;
	}
	}
	

