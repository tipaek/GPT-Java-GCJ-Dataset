
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static String validateTestCase(int ind, Scanner sc) throws Exception
	{
		int N;
		
		do
		{
			N=sc.nextInt();
		} while(N<2 || N>1000);
		
		char[] activityOrder=new char[N];
		HashMap<Integer, ArrayList<Integer>> loop=new HashMap<Integer, ArrayList<Integer>>(); 
		int[] S=new int[N], E=new int[N];

		HashMap<Integer, HashMap<Integer, Integer>> act=new HashMap<Integer, HashMap<Integer, Integer>>();
		
		for(int i=0;i<N;i++)
		{
			do
			{
				S[i]=sc.nextInt();
			} while(S[i]<0 || S[i]>24*60);
			
			do
			{
				E[i]=sc.nextInt();
			} while(E[i]<=S[i] || E[i]>24*60);
			
			HashMap<Integer, Integer> times=new HashMap<Integer, Integer>();
			times.put(S[i], E[i]);
			act.put(i, times);
		}
		
		for(int i=0;i<N;i++)
		{
		
			int start=S[i], end=E[i], overlap=0;		
						
			for(int j=0;j<N;j++)
			{
				if(j==i)
				{
					continue;
				}
				
				HashMap<Integer, Integer> time=act.get(j);
				int s1=-1,e1=-1;	
				Set keys=time.keySet();
				
				Iterator it=keys.iterator();
				
				while(it.hasNext())
				{
					s1=(Integer)it.next();
					e1=time.get(s1);
				}
				
				if((s1<=start && e1>start) || (s1>=start && e1<=end) || (s1<end && e1>=end))
				{
					if(overlap>0)
					{
						overlap++;
						break;
					}
						
					overlap++;
					if('C'==activityOrder[i] || 'J'==activityOrder[i] || 'C'==activityOrder[j] || 'J'==activityOrder[j])
					{
						if('C'==activityOrder[i])
						{
							activityOrder[j]='J';
						}
						else if('J'==activityOrder[i])
						{
							activityOrder[j]='C';
						}
						else if('C'==activityOrder[j])
						{
							activityOrder[i]='J';
						}
						else
						{
							activityOrder[i]='C';
						}
					}
					else
					{
						activityOrder[i]='C';
						activityOrder[j]='J';
						ArrayList<Integer> t=new ArrayList<Integer>();
						
						if(loop.containsKey(j))
						{
							t=loop.get(j);
							t.add(i);
						}
					}
				}
			}
			
			if(overlap==2)
			{
				activityOrder[0]='X';
				break;
			}		
		}
		
		
		String finalStr="";
		
		if(activityOrder[0]=='X')
		{
			finalStr="Case #"+(ind+1)+": IMPOSSIBLE";
			return finalStr;
		}
		
		for(int i=0;i<N;i++)
		{
			if('C'!=activityOrder[i] && 'J'!=activityOrder[i])
			{
				activityOrder[i]='C';
			}
		}
		
		finalStr="Case #"+(ind+1)+": "+new String(activityOrder);
		return finalStr;
	}

	public static void main(String[] args) {
	    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T;
		
		do
		{
			T=sc.nextInt();
		} while(T<1 || T>100);
			
		String[] result=new String[T];
		try
		{
			for(int i=0;i<T;i++)
			{
				result[i]=validateTestCase(i,sc);
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println(result[i]);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}
}
