import java.util.*;
public class Vestigium {

	public static void main(String[] args) 
	{
		int T,N;
		
		System.out.println("Enter number of test cases");
		Scanner s=new Scanner(System.in);
		T=s.nextInt();
		
		while(T>0)
		{
			
			System.out.println("Enter N");
			N=s.nextInt();
			int[][] matrix=new int[N][N];
			for (int i = 0; i < N; i++)
	          {
	              for (int j = 0; j < N; j++)
	              {
	                  matrix[i][j] = s.nextInt();
	              }
	          }
			int trace=trace(matrix);
			int cols=cols(matrix);
			int rows=rows(matrix);
			System.out.println(trace+" "+cols+" "+rows);
			T--;

		}
	}
	public static int trace(int[][] a)
	{
		int sum=0;
		for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
            	if(i == j)
              	 {
                 	     sum = sum + a[i][j];
                 }
              }
          }
		
		return sum;
	}
	public static int cols(int[][] a)
	{
		
		int x;
		int fc=0;
		//for each value in the column check if there are duplicates
		for (int i = 0; i < a.length; i++)//goes column to column
        {
			int count=0;
			for (int j=0;j<a.length;j++)//for every value in particular column
			{
				
				x=a[j][i];
				for(int k=0;k<a.length;k++)//checking with every other value in the column
				{
					if(a[k][i]==a[j][i]& k!=j)
					{
						count++;
						
					}
				}
			}
			if(count>0)
			{
				fc++;
			}
        }
		return fc;
	}
	public static int rows(int[][] a)
	{
		
		int x;
		int fc=0;
		//for each value in the row check if there are duplicates
		for (int i = 0; i < a.length; i++)//goes row to row
        {
			int count=0;
			for (int j=0;j<a.length;j++)//for every value in particular row
			{
				x=a[i][j];
				for(int k=0;k<a.length;k++)//checking with every other value in the row
				{
					if(a[i][k]==a[i][j]& k!=j)
					{
						count++;
					}
				}
			}
			if(count>0)
			{
				fc++;
			}
        }
		return fc;
		
		
		
		
		}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

