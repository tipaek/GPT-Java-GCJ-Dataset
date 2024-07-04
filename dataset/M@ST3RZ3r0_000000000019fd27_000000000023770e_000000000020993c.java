import java.util.*;
import java.io.*;
class Solution
{
	public static boolean repeated(int set[])
	{
		for (int i=0;i<set.length;i++)
		{
			if (set[i]>1)
			  return true;
		}
		return false;
	}
	public static int rowrepeated(int M[][])
	{
		int rowrepeated=0;
		for (int i=0;i<M.length;i++)
		{
			int set[]=new int[M.length];
			for (int j=0;j<M[0].length;j++)
                 set[(M[i][j])-1]++;
			if (repeated(set)==true)
			     rowrepeated++;
		}
		return rowrepeated;
	}
	public static int colrepeated(int M[][])
	{
		int colrepeated=0;
		for (int i=0;i<M.length;i++)
		{
			int set[]=new int[M.length];
			for (int j=0;j<M[0].length;j++)
                 set[(M[j][i])-1]++;
			if (repeated(set)==true)
			     colrepeated++;
		}
		return colrepeated;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=input.nextInt();
		if ((T<1) && (T>100))
		    return ;
        for (int i=0;i<T;i++)
        {
			int N=input.nextInt();
			if ((N<2) && (N>100))
		      return ;
			int M[][]=new int[N][N];
			int sum=0;
			for (int j=0;j<M.length;j++)
			{
				for (int k=0;k<M[0].length;k++)
				{
				   M[j][k]=input.nextInt();
				   if((M[j][k]<1)||(M[j][k]>M.length))
					   return ;
				   if (j==k)
				       sum+=M[j][k];
			    }
			}
			System.out.println("Case #"+(i+1)+": "+sum+" "+rowrepeated(M)+" "+colrepeated(M));	
        }
        return ;
	}
}