import java.util.*;
import java.io.*;

class Interval{
	int start,end;
	public Interval(int s,int e)
	{
		start = s;
		end = e;
	}
}
class SortByStartingTime implements Comparator<Interval>{
	public int compare(Interval a,Interval b) {
		return a.start - b.start;
	}
}
public class Solution{
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	int i=1;
	
	while(i<=t)
	{
		
		int n = Integer.parseInt(br.readLine());
		Interval arr[] = new Interval[n];
		Map<String,Integer> hm = new HashMap<String,Integer>();
		StringTokenizer st ;
		
		for(int j=0;j<n;j++)
		{
			
			st = new StringTokenizer(br.readLine());
		
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[j] = new Interval(s,e);
			hm.put(s+" "+e,j);
			
		}
		
		Arrays.sort(arr,new SortByStartingTime());
		
		String s="C";
		boolean cam = true,jam=false,imp = false ;
		int in1 = 0,in2=0;
		int index[] = new int[n];
		index[0] = hm.get(arr[0].start+" "+arr[0].end);
		for(int j=1;j<n;j++)
		{
			if(cam && !jam)
			{
				if(arr[in1].end <= arr[j].start)
				{
					s = s+'C';
					index[j] = hm.get(arr[j].start+" "+arr[j].end);
				}
				else {
					in2 = j; 
					s = s+'J';
					index[j] = hm.get(arr[j].start+" "+arr[j].end);
					jam = true;
				}
			}else if(cam && jam)
			{
			
				if(arr[in1].end<arr[in2].end)
				{
					if(arr[in1].end<=arr[j].start)
					{
						s = s + s.charAt(in1); 
						in1 = j;
						index[j] = hm.get(arr[j].start+" "+arr[j].end);
					}else{
						imp = true;
						break;
					}
				}else 
				{
					if(arr[in2].end<=arr[j].start)
					{
						s = s + s.charAt(in2); 
						in2 = j;
						index[j] = hm.get(arr[j].start+" "+arr[j].end);
					}else{
						imp = true;
						break;
					}

				}
			}
		}
		
		if(imp)
		{
			System.out.println("Case #"+i+": "+"IMPOSSIBLE");
		}else {
			char ch[] = new char[n];
			for(int j=0;j<n;j++)
			{
				ch[index[j]] = s.charAt(j);
			}
			String res="";
			for(int j=0;j<n;j++)
			{
				res = res+ch[j];
			}
			System.out.println("Case #"+i+": "+res);
		}
		
		
		i++;
		
	}
    }
}