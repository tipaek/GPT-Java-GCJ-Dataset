import java.util.*;
import java.io.*;


class timesection
{
   int st;
   int et;
}
  public class Solution 
 {
	public static void main(String[] args)throws Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ii = 1; ii <= t; ++ii) 
		{
			int n = in.nextInt();
			boolean ret;
			int st[]=new int[n];
			int end[]=new int[n];
			ArrayList<timesection> lis=new ArrayList<timesection>();
			ArrayList<timesection> lisj=new ArrayList<timesection>();
			timesection arr[]=new timesection[n];
			String s="";
            for (int j = 0; j < n; j++) 
            {
            	arr[j]=new timesection();
				 st[j]=in.nextInt();
				 end[j]=in.nextInt();
				 arr[j].st=st[j];
				 arr[j].et=end[j];
				 
				 if (j==0) 
		            {
					 lis.add(arr[j]);
		                s+="C";
		            }
				 else
		            {
		                ret = true;
		                for (int k=0;k<lis.size();k++)
		                {
		                    if (isoverlap(arr[j], lis.get(k)))
		                    {
		                        ret = false;
		                        break;
		                    }
		                }

		                if(ret) 
		                {
		                    lis.add(arr[j]);
		                     s+="C";
		                    continue;
		                }

		                ret = true;
		                for (int k=0;k<lisj.size();k++)
		                {
		                    if (isoverlap(arr[j], lisj.get(k)))
		                    {
		                        ret = false;
		                        break;
		                    }
		                }

		                if(ret) 
		                {
		                    lisj.add(arr[j]);
		                    s+="J";
		                }
		                else
		                {
		                    s = "IMPOSSIBLE";
		                    break;
		                }
		            }
            }
            System.out.println("Case #" + ii + ": "+s);
		}//test case
	}
	static boolean isoverlap(timesection t1, timesection t2)
	{
	    if (t1.st<=t2.st && t1.et>t2.st) return true;
	    if (t1.st<t2.et && t1.et>=t2.et) return true;
	    if (t1.st>=t2.st && t1.et<=t2.et) return true;
	    return false;
	}
 }