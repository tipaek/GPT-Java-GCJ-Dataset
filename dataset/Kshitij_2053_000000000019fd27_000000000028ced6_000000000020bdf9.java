import java.util.*;
import java.io.*;

public class Solution
{
	public String schedule(Vector<Integer> vec, int num)
	{
		String ans = "";
		int tempJ = 1;
		int tempC = 1;
		int[] jamieArray = new int[1440];
		int[] camerArray = new int[1440];
		for(int i=0; i<1440; i++)
		{
			jamieArray[i]=0;
			camerArray[i]=0;
		}
		for(int i=0; i<num; i++)
		{
			tempJ=1;
			tempC=1;
			for(int j=vec.get(2*i); j<vec.get((2*i) + 1); j++)
			{
				if(jamieArray[j]!=0)
				{
					tempJ=0;
					break;
				}
			}
			for(int j=vec.get(2*i); j<vec.get((2*i) + 1); j++)
			{
				if(camerArray[j]!=0)
				{
					tempC=0;
					break;
				}
			}
			if(tempJ==1)
			{
				ans+="J";
				for(int j=vec.get(2*i); j<vec.get((2*i) + 1); j++)
					jamieArray[j]=1;
			}
			else if(tempC==1)
			{
				ans+="C";
				for(int j=vec.get(2*i); j<vec.get((2*i) + 1); j++)
					camerArray[j]=1;
			}
			else
			{
				ans="IMPOSSIBLE";
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		Solution obj = new Solution();
		Scanner myObj = new Scanner(System.in);
		int test_cases = myObj.nextInt();
		int act, temp;
		Vector<Integer> vec = new Vector<Integer>();
		Vector<String> final_ans = new Vector<String>();
		String ans = "";
		for(int i=1; i<=test_cases; i++)
		{
			act = myObj.nextInt();
			for(int j=1; j<=2*act; j++)
			{
				temp = myObj.nextInt();
				vec.add(temp);
			}
			ans=obj.schedule(vec, act);
			final_ans.add(ans);
			vec.clear();
			ans="";
		}
		for(int i=1; i<=test_cases; i++)
			System.out.println("Case #" + i + ": " + final_ans.get(i-1));
	}
}