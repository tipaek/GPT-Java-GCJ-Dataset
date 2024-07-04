import java.util.Scanner;
class Vestigium 
{
	public static int trace(int M[][])
	{
		int sum=0;
		for (int i=0;i<M.length;i++)
           sum+=M[i][i];
		return sum;
	}
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
		int set[]=new int[M.length];
		for (int i=0;i<M.length;i++)
		{
			for (int j=0;j<M[0].length;j++)
                 set[(M[i][j])-1]++;
			if (repeated(set)==true)
			     rowrepeated++;
			for (int k=0;k<set.length;k++)
			     set[k]=0;
		}
		return rowrepeated;
	}
	public static int colrepeated(int M[][])
	{
		int colrepeated=0;
		int set[]=new int[M.length];
		for (int i=0;i<M.length;i++)
		{
			for (int j=0;j<M[0].length;j++)
                 set[(M[j][i])-1]++;
			if (repeated(set)==true)
			     colrepeated++;
			for (int k=0;k<set.length;k++)
			     set[k]=0;
		}
		return colrepeated;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int T=input.nextInt();
		if ((T<1) && (T>100))
		    return ;
        for (int i=0;i<T;i++)
        {
			int N=input.nextInt();
			if ((N<2) && (N>100))
		      return ;
			int M[][]=new int[N][N];
			for (int j=0;j<M.length;j++)
			{
				for (int k=0;k<M[0].length;k++)
				{
				   M[j][k]=input.nextInt();
				   if((M[j][k]<1)||(M[j][k]>M.length))
					   return ;
			    }
			}
			int k=trace(M);
			int r=rowrepeated(M);
			int c=colrepeated(M);
			System.out.println("Case #"+(i+1)+":"+k+" "+r+" "+c);
        }
	}
}