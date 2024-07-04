
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Solution {
	
	private static String validateTestCase(int ind, Scanner sc) throws Exception
	{
		int N;
		
		do
		{
			N=sc.nextInt();
		} while(N<2 || N>1000);
		
		char[] activityOrder=new char[N];
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
		
		Vector<HashMap<Integer, Integer>> st=sortArray(S, act);	
		char[] ao=new char[N];
		
		for(int i=0;i<st.size();i++)
		{
			HashMap<Integer, Integer> hm=st.get(i);
			int start=-1,end=-1, fixedEnd=-1, overlap=0;
			
			Set keys=hm.keySet();
			Iterator it=keys.iterator();
			
			while(it.hasNext())
			{
				start=(Integer)it.next();
				end=hm.get(start);
			}
			
			fixedEnd=end;
			
			for(int j=i+1;j<st.size();j++)
			{
				HashMap<Integer, Integer> hm2=st.get(j);
				int s1=-1,e1=-1;
				
				Set ki=hm2.keySet();
				Iterator it2=ki.iterator();
				
				while(it2.hasNext())
				{
					s1=(Integer)it2.next();
					e1=hm2.get(s1);
				}
				
				if(s1<fixedEnd)
				{
					overlap++;
					if(j==i+1)
					{
						start=s1;
						end=e1;
						continue;
					}
					else
					{
						if(isOverlapping(start,end,s1,e1))
						{
							return "Case #"+(ind+1)+": IMPOSSIBLE";
						}
						else
						{
							start=s1;
							end=e1;
						}
					}
				}
				else
				{
					break;
				}
			}
			
			if(overlap>0)
			{
				char main='C', ch='J';
				
				if('J'==ao[i])
				{
					main='J';
					ch='C';
				}
				
				ao[i]=main;
				
				for(int index=i+1;index<i+overlap+1;index++)
				{
					ao[index]=ch;
				}
			}	
		}
		
		for(int i=0;i<N;i++)
		{
			if('C'!=ao[i] && 'J'!=ao[i])
			{
				ao[i]='J';
			}
		}
		
		for(int i=0;i<st.size();i++)
		{
			char val=ao[i];
			
			HashMap<Integer, Integer> hm=st.get(i);
			int sta=-1,en=-1;
			
			Set ki=hm.keySet();
			Iterator it2=ki.iterator();
			
			while(it2.hasNext())
			{
				sta=(Integer)it2.next();
				en=hm.get(sta);
			}
			
			for(int j=0;j<act.size();j++)
			{
				HashMap<Integer, Integer> hm2=act.get(j);
				
				int star=-1,endd=-1;
				
				Set kii=hm2.keySet();
				Iterator itt=kii.iterator();
				
				while(itt.hasNext())
				{
					star=(Integer)itt.next();
					endd=hm2.get(star);
				}
				
				if(star==sta && en==endd)
				{
					activityOrder[j]=val;					
					hm2=new HashMap<Integer, Integer>();	
					hm2.put(-1, -1);
					act.put(j, hm2);
					break;
				}
			}
		}
		
		return "Case #"+(ind+1)+": "+new String(activityOrder);
	}
	
	private static boolean isOverlapping(int start, int end, int s1, int e1) throws Exception
	{
		if((s1<=start && e1>start) || (s1>=start && e1<=end) || (s1<end && e1>=end))
		{
			return true;
		}
		return false;
	}
	
	private static Vector sortArray(int[] A, HashMap<Integer, HashMap<Integer, Integer>> act) throws Exception
	{
		Vector<HashMap<Integer, Integer>> v=new Vector();
		
		int[] tempArr=A.clone();
		
		for(int i=0;i<tempArr.length;i++)
		{
			int least=tempArr[i], ind=i;
						
			for(int j=i;j<tempArr.length;j++)
			{
				if(least>tempArr[j])
				{
					least=tempArr[j];
					ind=j;
				}
			}
			
			int temp=tempArr[i];		
			tempArr[i]=least;
			tempArr[ind]=temp;
		}
		
		for(int i=0;i<tempArr.length;i++)
		{
			int val=tempArr[i];
			
			for(int j=0;j<A.length;j++)
			{
				if(val==A[j])
				{
					v.add(act.get(j));
					
					if(i<tempArr.length-1)
					{
						if(val==tempArr[i+1])
						{
							A[j]=-1;
						}
					}
					
					break;
				}
			}
		}
		
		return v;
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
