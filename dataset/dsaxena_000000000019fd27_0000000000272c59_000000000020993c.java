import java.util.*;
import java.io.*;
public class Solution {
  public static String latin(ArrayList<ArrayList<Integer>> mat)
	{
		int n=mat.size();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> union = new HashSet<Integer> ();
		HashSet<Integer> set=(new HashSet<Integer>());
		int trace=0;
		int num_row=0;
		for (int i=0;i<n;i++)
		{
			trace+=mat.get(i).get(i);
		}
		for (int i=0;i<n;i++)
		{
			map =  new HashMap<Integer,  Integer>();
			for (int j=0;j<n;j++)
			{
				if (map.get(mat.get(i).get(j))==null)
				{ 
					map.put(mat.get(i).get(j),1);
				}
				else {num_row+=1;break;}
			}
		}
		int num_col=0;
		HashSet<Integer> col_union = new HashSet<Integer> ();
		for (int j=0;j<n;j++)
		{
			map =  new HashMap<Integer,  Integer>();
			for (int i=0;i<n;i++)
			{
				if (map.get(mat.get(i).get(j))==null)
				{ 
					map.put(mat.get(i).get(j),1);
				}
				else {num_col+=1;break;}
			}
		}
		return (Integer.toString(trace)+" "+Integer.toString(num_row)+" "+Integer.toString(num_col));
	}
	public static void print(ArrayList<ArrayList<Integer>> mat)
	{
		for (int i=0;i<mat.size();i++)
		{
			for (int j=0;j<mat.size();j++)
			{
				System.out.println(mat.get(i).get(j));
			}
		}
	}

	public static void main(String args[]) 
	{
		String out="";
		Scanner s= new Scanner(System.in);
		int T = s.nextInt();
		int N;
		ArrayList<ArrayList<Integer>> arr;
		String[] lst;
		ArrayList<Integer> temp;
		String str;
		for (int t=0;t<T;t++)
		{
			N= s.nextInt();
			arr= new ArrayList<ArrayList<Integer>>();
			s.nextLine();
			for (int i = 0;i<N;i++)
			{
			
				str=s.nextLine();
				lst=str.split(" ");
				temp=new ArrayList<Integer> ();
				for (int j=0;j<N;j++)
				{
					temp.add(Integer.parseInt(lst[j]));
				}
				arr.add(temp);
			}
			if (t!=T-1) out+="Case #"+(t+1)+": "+latin(arr)+"\n";
			else out+="Case #"+(t+1)+": "+latin(arr);
		}
		System.out.println(out);
	}
}