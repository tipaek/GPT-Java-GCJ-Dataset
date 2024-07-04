import java.util.*;

class MyVestigium
{
	int row;
	int col;
	
	int n;
	int[][] a;
	
	Scanner scan = new Scanner(System.in);
	
	MyVestigium(int size)
	{
		n = size;
		a = new int[n][n];
		row = 0;
		col = 0;
	}
	
	void read()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j] = scan.nextInt();
			}
		}
	}
	
	int trace()
	{
		//System.out.println("Computing Sum in Trace");
		int sum=0;
		int temp = n;
		int i=0; int j=0;
		while(temp>0)
		{
			sum = sum + a[i][j];
			i++;
			j++;
			--temp;
		}
		//System.out.println("SUM = "+sum);
		return sum;
	}
	
	void Latin()
	{
		int rowc=0;
		int colc=0;
		int []b = new int[n];
		int []c = new int[n];
		for(int i=0;i<n;i++)
		{		
			for(int r=0;r<n;r++)
			{
				b[r]=a[i][r];
				c[r]=a[r][i];
				System.out.println("B[]= "+b[r]);
				System.out.println("C[]= "+c[r]);
			}
			for(int k=0;k<n;k++)
			{	
				int x=b[k];
				int flag=0;
				for(int y=k+1;y<n;y++)
				{
					if(x==b[y])
					{
						rowc++;
						//System.out.println("X = "+x+" Y = "+b[y]);
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
				//System.out.println("Rows = "+rowc);
			}
			for(int k=0;k<n;k++)
			{
				int z=c[k];
				int flag1=0;
				for(int u=k+1;u<n;u++)
				{
					if(z==c[u])
					{
						colc++;
						//System.out.println("Z = "+z+" U = "+c[u]);
						flag1=1;
						break;
					}
				}
				if(flag1==1)
					break;
				//System.out.println("Cols = "+colc);	
			}
			row = rowc;
			col = colc;
			//System.out.println("Total Rows = "+row);
			//System.out.println("Total Cols = "+col);
		}
	}
}


public class vestigium 
{
	public static void main(String[] args) 
	{
		int t,n,c=0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter the Number of Test Cases");
		t = scan.nextInt();
		while(t>0)
		{
			//System.out.println("Enter the Size of Matrix");
			n = scan.nextInt();
			MyVestigium V = new MyVestigium(n);
			//System.out.println("Enter the Array Elements");
			V.read();
			//System.out.println("Calling Trace Funtion");
			int traceresult = V.trace();
			//System.out.println("Trace Result = "+traceresult);
			//System.out.println("Calling Latin Function");
			V.Latin();
			//System.out.println("ROW = "+V.row+" Col= "+V.col);
			c++;
			System.out.println("Case #"+c+": "+traceresult+" "+V.row+" "+V.col);
			t--;
		}
	}

}
