import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		int num=0;
		while(t-->0)
		{
			num++;
			boolean flag=false;
			boolean flag2=false;
			int count=0;
			String str="";
			int  n=obj.nextInt();
			ArrayList<Integer> cs=new ArrayList<>();
			ArrayList<Integer> ce=new ArrayList<>();
			ArrayList<Integer> js=new ArrayList<>();
			ArrayList<Integer> je=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int s=obj.nextInt();
				int e=obj.nextInt();
				if(i==0)
				{
					cs.add(s);
					ce.add(e);
					str+="C";
					continue;
				}
				int size=cs.size();
				flag=false;
				flag2=false;
				for(int j=0;j<size;j++)
				{
					if((((s<cs.get(j))&&(e<=cs.get(j)))||((s>=ce.get(j))&&(e>ce.get(j)))==false))
					{

						flag=true;
						break;
					}
				}
				if(flag==false)
				{
					cs.add(s);
					ce.add(e);
					str=str+"C";
				}
				else
				{
					int size2=js.size();
					for(int k=0;k<size2;k++)
					{
						if((((s<js.get(k))&&(e<=js.get(k)))||((s>=je.get(k))&&(e>je.get(k))))==false)
						{
							flag2=true;
							break;
						}
					}
					if(flag2==false)
					{
						js.add(s);
						je.add(e);
						str=str+"J";
					}

				}
			}
			if(flag2==true)
				System.out.println("Case #"+num+":"+" "+"IMPOSSIBLE");
			else
				System.out.println("Case #"+num+":"+" "+str);

		}
	}
}

