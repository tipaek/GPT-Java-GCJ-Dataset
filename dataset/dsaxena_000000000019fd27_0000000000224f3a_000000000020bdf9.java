import java.util.*;
import java.io.*;
public class Solution {
	static class Interval{
		int start;
		int end;
		Interval(int s,int e)
		{
			this.start=s;
			this.end=e;
		}

		public int overlap(Interval I)
		{
			if (this.end<=I.start ) return 0;
			else if (this.start>=I.end ) return 0;
			else return 1;
		}
	}
	public static int get(ArrayList<Interval> inp,Interval I)
	{
		int flag=1;
		if (inp.size()==0) return 1;
		for (int i=0;i<inp.size();i++)
		{
			if (I.overlap(inp.get(i))==1)
			{
				return 0;
			}
		}
		return 1;
	}
	public static String parent(ArrayList<Interval> inp)
	{
		ArrayList<Interval> jam= new ArrayList<Interval>();	
		ArrayList<Interval> cam= new ArrayList<Interval>();
		String out="";
		int flag=0;
		Interval I;
		for (int i=0;i<inp.size();i++)
		{
			I=inp.get(i);
			if (get(jam,I)==1) {jam.add(I);out+="J";}
			else if (get(cam,I)==1) {cam.add(I);out+="C";}
			else 
				{flag=1;break;}
		}
		if (flag==1) return "IMPOSSIBLE";
		return out;
	}

	public static void main(String args[]) 
	{
		String out="";
		Scanner s= new Scanner(System.in);
		int T = s.nextInt();
		int N;
		ArrayList<Interval> inp;
		String[] lst;
		Interval temp;
		String str;
		String p;
		for (int t=0;t<T;t++)
		{
			N= s.nextInt();
			inp=new ArrayList<Interval>();
			s.nextLine();
			for (int i = 0;i<N;i++)
			{
				str=s.nextLine();
				lst=str.split(" ");
				temp= (new Interval(Integer.parseInt(lst[0]),Integer.parseInt(lst[1])));
				inp.add(temp);
			}
			p=parent(inp);
			if (t!=T-1) out+="Case #"+(t+1)+": "+p+"\n";
			else out+="Case #"+(t+1)+": "+p;
		}
		System.out.println(out);
	}
}