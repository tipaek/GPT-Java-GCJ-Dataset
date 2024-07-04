import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int m=sc.nextInt();
            int a[][]=new int[m][m];
            for(int k=0;k<m;k++)
            {
                for(int j=0;j<m;j++)
                {
                    a[k][j]=sc.nextInt();
                }
            }
            int sum=diagonal_sum(a);
            int row=row_array(a);
            int column=column_array(a);
        System.out.print("Case #"+(i+1)+": "+sum+" "+row+" "+column);
        System.out.println();
        }
    
    }
    static int diagonal_sum(int[][] a)
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(i==j)
				{
					sum=sum+a[i][j];
				}
			}
		}
		return sum;
	}
	static int row_array(int a[][])
	{
		int row=0;
		for(int i=0;i<a.length;i++)
		{
			Set b=new LinkedHashSet();
			for(int j=0;j<a.length;j++)
			{
				b.add(a[i][j]);
			}
			if(b.size()==a.length)
				continue;
			else
				row+=1;
		}
		return row;
	}
	static int column_array(int a[][])
	{
		int column=0;
		for(int j=0;j<a.length;j++)
		{
			Set b=new LinkedHashSet();
			for(int i=0;i<a.length;i++)
			{
				b.add(a[i][j]);
			}
			if(b.size()==a.length)
				continue;
			else
				column+=1;
		}
		return column;
	}
}