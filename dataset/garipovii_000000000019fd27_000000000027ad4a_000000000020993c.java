package package1;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static long calc(long[][] a)
	{
		// TODO Auto-generated method stub
		int i,j, count=0, n=a.length;
		
		for ( i=0;i<n;i++)
		{
			long [] b=new long [n];
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

	public static void quickSort(long[] b, int begin, int end)
	{
		// TODO Auto-generated method stub
		 if (begin < end)
		    {
		        int partitionIndex = partition(b, begin, end);
		        quickSort(b, begin, partitionIndex-1);
		        quickSort(b, partitionIndex+1, end);
		    }
	}

	public static int partition(long[] b, int begin, int end)
	{
		// TODO Auto-generated method stub
		  long pivot = b[end];
		    int i = (begin-1);
		    for (int j = begin; j < end; j++) 
		    {
		        if (b[j] <= pivot) {
		            i++;
		 
		            long swapTemp = b[i];
		            b[i] =b[j];
		            b[j] = swapTemp;
		        }
		    }
		    long swapTemp = b[i+1];
		    b[i+1] = b[end];
		    b[end] = swapTemp; 
		    return i+1;
	}
public static void main(String[] args)
{	
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); 
		int m=input.nextInt();
		int i,j,k,n;
		long [] S = new long[m];
		long [] count_row =new long[m];
		long [] count_col =new long[m];
		for (int q=0;q<m;q++)
		{	
			count_row[q]=0;count_col[q]=0;	
			n=input.nextInt();
			long [][]a=new long[n][n];
			S[q]=0;
			for (i=0;i<n;i++)
				for(j=0;j<n;j++)
				{
					a[i][j]=input.nextLong();
					if(i==j)
						S[q]+=a[i][j];
				}	
			count_row[q]=calc(a);
			long [][]tr=new long[n][n];
			for(i=0;i<n;i++)  
				for(j=0;j<n;j++)   
				     tr[i][j]=a[j][i];  
			count_col[q]=calc(tr);			
		}
		input.close();
		for (i=0;i<m;i++) 
				System.out.println("Case #"+String.valueOf(i+1)+": "+S[i]+" "+count_row[i]+" "+count_col[i]); 	
}
}
