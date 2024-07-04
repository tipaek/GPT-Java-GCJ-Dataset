import java.io.*;
import java.util.*;
public class Solution {
/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
 */
	public static void main(String[]args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());   //b0 is before contest
		StringBuilder sb = new StringBuilder("J");
		for(int t = 1; t <= test; t++) {
			int n = Integer.parseInt(br.readLine().trim());
			shift [] tasks = new shift [n];
			char [] finalorder = new char [n];
			
			//System.out.println(sb);
			for (int i=0; i<n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());   //two strings in one line
				tasks[i] = new shift(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
			}
			
			Arrays.sort(tasks);	
			//for (int l=0; l<tasks.length; l++)
				//System.out.println(tasks[l]);
			finalorder[tasks[0].order]='J';
			Jam j = new Jam (tasks[0].start, tasks[0].end);
			Cam c = new Cam (-1, -1);
			boolean impos =false;
			for (int i=1; i<n; i++)
			{
				if (c.takeshift(tasks[i].start, tasks[i].end)==false && j.takeshift(tasks[i].start, tasks[i].end)==false)
				{
					impos = true;
					break;
				}
				else if (c.takeshift(tasks[i].start, tasks[i].end)==true && j.takeshift(tasks[i].start, tasks[i].end)==true)
				{
					int cdiff = tasks[i].start-c.curend;
					int jdiff = tasks[i].start-j.curend;
					if (cdiff<=jdiff)
					{
					c.curstart = tasks[i].start;
					c.curend = tasks[i].end;
					finalorder[tasks[i].order]='C';
					sb.append("C");
					}
					else
					{
					j.curstart = tasks[i].start;
					j.curend = tasks[i].end;
					finalorder[tasks[i].order]='J';
					sb.append("J");
					}
				}
				else if (c.takeshift(tasks[i].start, tasks[i].end)==true)
				{
					c.curstart = tasks[i].start;
					c.curend = tasks[i].end;
					sb.append("C");
					finalorder[tasks[i].order]='C';
				}
				else if (j.takeshift(tasks[i].start, tasks[i].end)==true)
				{
					j.curstart = tasks[i].start;
					j.curend = tasks[i].end;
					sb.append("J");
					finalorder[tasks[i].order]='J';
				}
			}
			if (impos==true)
			{
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				impos = false;
				sb.delete(0, sb.length());
				sb.append("J");
				j = new Jam (tasks[0].start, tasks[0].end);
				c = new Cam (-1, -1);
			}
			else
			{
			String ans = "";
			for (int i=0; i<finalorder.length; i++)
			{
				ans+=finalorder[i];
			}
			System.out.println("Case #" + t + ": " + ans);
			sb.delete(0, sb.length());
			sb.append("J");
			j = new Jam (tasks[0].start, tasks[0].end);
			c = new Cam (-1, -1);
			}
		}
	}
}
class Cam
{
	public int curstart;
	public int curend;
	public Cam(int s, int e)
	{
		curstart = s;
		curend = e;
	}
	public String toString()
	{
		return curstart+" "+curend;
	}
	public boolean takeshift(int s, int e)
	{
		if (s<curend)
			return false;
		return true;
	}
}
class Jam
{
	public int curstart;
	public int curend;
	public Jam(int s, int e)
	{
		curstart = s;
		curend = e;
	}
	public String toString()
	{
		return curstart+" "+curend;
	}
	public boolean takeshift(int s, int e)
	{
		if (s<curend)
			return false;
		return true;
	}
}
class shift implements Comparable
{
	public int start;
	public int end;
	public int order;
	public shift(int s, int e, int i)
	{
		start = s;
		end = e;
		order = i;
	}
	public String toString()
	{
		return start+" "+end;
	}
	public int compareTo(Object other) {
		shift o = (shift)other;
		if (this.start<o.start)
			return -1;
		if (this.start==o.start)
			return 0;
		return 1;
	}
}
