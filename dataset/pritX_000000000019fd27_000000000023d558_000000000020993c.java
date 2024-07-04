import java.util.HashSet;
import java.util.Scanner;

class Solution {

	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		int[] x=new int[t];
		int[] r=new int[t];
		int[] c=new int[t];
		for(int i=0;i<t;i++)
		{
			int m=sc.nextInt();
			sc.nextLine();
			int[][] matrix=new int[m][m];
			x[i]=0;
			c[i]=0;
			r[i]=0;
			for(int j=0;j<m;j++)
			{
				String str=sc.nextLine();
				String[] st=str.split(" ");
				for(int k=0;k<st.length;k++)
				{
					
					matrix[j][k]=Integer.parseInt(st[k]);
					if(j==k)
					{
						x[i]=x[i]+matrix[j][k];
					}
				}
			}
			
			for(int row=0;row<m;row++)
			{
				HashSet<Integer> dup = new HashSet<Integer>();
				for(int col=0;col<m;col++)
				{
					if(dup.add(matrix[row][col]))
					{	
		                continue;
					}   
		            else 
		            {
		               r[i]++;
		               break;
		            }
				}
			}
			
			for(int row=0;row<m;row++)
			{
				HashSet<Integer> dup = new HashSet<Integer>();
				for(int col=0;col<m;col++)
				{
					if(dup.add(matrix[col][row]))
					{	
		                continue;
					}   
		            else 
		            {
		               c[i]++;
		               break;
		            }
				}
			}
		}
		for(int i=0;i<t;i++)
		{
			int m=i+1;
			System.out.println("Case #"+ m +": "+ x[i] +" "+ r[i] +" "+ c[i]);
		}
		sc.close();
	}
}
