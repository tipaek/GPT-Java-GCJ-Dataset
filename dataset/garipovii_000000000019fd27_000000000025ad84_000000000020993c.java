package package1;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
public static void main(String[] args)
{	
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		int m=input.nextInt();
		int i,j,k,S,n,count_row,count_col;
		String []list_res=new String[m];
		for (int q=1;q<=m;q++)
		{	
			count_row=0;count_col=0;
			list_res[q-1]="Case #"+String.valueOf(q)+": ";
			n=input.nextInt();
			int [][]a=new int[n][n];
			S=0;
			for (i=0;i<n;i++)
				for(j=0;j<n;j++)
				{
					a[i][j]=input.nextInt();
					if(i==j)
						S+=a[i][j];
				}	
			list_res[q-1]+=String.valueOf(S+" ");	
			count_row=calc(a);
			list_res[q-1]+=String.valueOf(count_row+" ");	
			int [][]tr=new int[n][n];
			for(i=0;i<n;i++)  
				for(j=0;j<n;j++)   
				     tr[i][j]=a[j][i];  
			count_col=calc(tr);	
			list_res[q-1]+=String.valueOf(count_col+" ");		
		}
		for (i=0;i<m;i++)
			if (i!=m-1) 
				System.out.println(list_res[i]); 
			else System.out.print(list_res[i]);
		input.close();
}

	private static int calc(int[][] a)
	{
		// TODO Auto-generated method stub
		int j, count=0, n=a.length;
		
		for (int i=0;i<n;i++)
		{
			int [] b=new int [n];
			for (j=0;j<n;j++)
				b[j]=a[i][j];
			quickSort(b,0,n-1);
			for (j=0;j<n-1;j++)
				if(b[j]==b[j+1])
				{
					count++;
					break;
				}
		}
		return count;
	}

	private static void quickSort(int[] b, int begin, int end)
	{
		// TODO Auto-generated method stub
		 if (begin < end)
		    {
		        int partitionIndex = partition(b, begin, end);
		        quickSort(b, begin, partitionIndex-1);
		        quickSort(b, partitionIndex+1, end);
		    }
	}

	private static int partition(int[] b, int begin, int end)
	{
		// TODO Auto-generated method stub
		  int pivot = b[end];
		    int i = (begin-1);
		    for (int j = begin; j < end; j++) 
		    {
		        if (b[j] <= pivot) {
		            i++;
		 
		            int swapTemp = b[i];
		            b[i] =b[j];
		            b[j] = swapTemp;
		        }
		    }
		    int swapTemp = b[i+1];
		    b[i+1] = b[end];
		    b[end] = swapTemp;
		 
		    return i+1;
	}
	
}
