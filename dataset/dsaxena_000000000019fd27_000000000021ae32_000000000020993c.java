import java.util.*;
public class google{

	public static String latin(ArrayList<ArrayList<Integer>> mat)
	{
		int n=mat.size();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> union = new HashSet<Integer> ();
		HashSet<Integer> set=(new HashSet<Integer>());
		int trace=0;
		for (int i=0;i<n;i++)
		{
			map =  new HashMap<Integer,  HashSet<Integer>>();
			for (int j=0;j<n;j++)
			{
				if (map.get(mat.get(i).get(j))==null)
				{ 
					set=(new HashSet<Integer>());
					set.add(j);
					map.put(mat.get(i).get(j),set);
				}
				else map.get(mat.get(i).get(j)).add(j);
				if (i==j) trace+=mat.get(i).get(i);
			}
			for (int j=1;j<=n;j++)
			{
				if (map.get(j)!=null && map.get(j).size()>1)
					union.addAll(map.get(j));
			}
			
		}

		HashSet<Integer> col_union = new HashSet<Integer> ();
		for (int j=0;j<n;j++)
		{
			map =  new HashMap<Integer,  HashSet<Integer>>();
			for (int i=0;i<n;i++)
			{
				if (map.get(mat.get(i).get(j))==null)
				{ 
					set=(new HashSet<Integer>());
					set.add(j);
					map.put(mat.get(i).get(j),set);
				}
				else map.get(mat.get(i).get(j)).add(i);
			}
			for (int i=1;i<=n;i++)
			{
				if (map.get(i)!=null && map.get(i).size()>1)
					col_union.addAll(map.get(i));
			}
		}
		return (Integer.toString(trace)+" "+Integer.toString(union.size())+" "+Integer.toString(col_union.size()));
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
			if (t!=T-1) out+="Case#"+(t+1)+": "+latin(arr)+"\n";
			else out+="Case#"+(t+1)+": "+latin(arr);
		}
		System.out.println(out);
	}
}