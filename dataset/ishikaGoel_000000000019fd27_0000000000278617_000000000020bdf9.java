import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Solution{
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		int num=0;
		while(t-->0)
		{
			num++;
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
				if(i==1)
				{
					if((((cs.get(0)<s)&&(s<ce.get(0)))||((cs.get(0)<e)&&(e<ce.get(0))))==false)
					{
						cs.add(s);
						ce.add(e);
						str=str+"C";
					}
					else
					{
						js.add(s);
						je.add(e);
						str=str+"J";
					}
				}
				if(i>1)
				{
					int c1=0;
					int c2=0;
					boolean var=false;
					boolean var2=false;
					for(int j=0;j<cs.size();j++)
					{
						if(((cs.get(0)<s)&&(s<ce.get(0)))||((cs.get(0)<e)&&(e<ce.get(0)))==true)
						{
							c1++;
						}
					}
					if(c1==0)
					{
						cs.add(s);
						ce.add(e);
						str=str+"C";
						var=true;
					}
					else
					{
						if(js.size()==0)
						{
							js.add(s);
							je.add(e);
							str=str+"J";
							continue;
						}
						for(int j=0;j<js.size();j++)
						{
							if(((js.get(j)<s)&&(s<je.get(j)))||((js.get(j)<=e)&&(e<je.get(j))==true))
							{
								c2++;
							}
						}
						if(c2==0)
						{
							js.add(s);
							je.add(e);
							str=str+"J";
							var2=true;
						}
					}
					if(var==false&&var2==false)
						count++;

				}
			}
			if(count>0)
			{
				System.out.println("Case #"+num+":"+" "+"IMPOSSIBLE");
			}
			else
			{
				System.out.println("Case #"+num+":"+" "+str);
			}
		}

	}
}

