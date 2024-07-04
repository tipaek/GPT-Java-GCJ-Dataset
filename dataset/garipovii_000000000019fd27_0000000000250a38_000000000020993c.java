package package1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Solution {

	/**
	 * @param args
	 */
	public static int calc(int [][] a)
	{
		int j, count=0, n=a.length;
		ArrayList<Integer> b=new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			for (j=0;j<n;j++)
				b.add(a[i][j]);
			Collections.sort(b);
			for (j=0;j<n;j++)
				if(b.get(i)==b.get(i+1))
				{
					count++;
					break;
				}
		}
	    return count;
	}
	public static void transpose(int [][] a)
	{
		int n=a.length;
		for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) 
            {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
	}
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
			transpose(a);
			count_col=calc(a);	
			list_res[q-1]+=String.valueOf(count_col+" ");		
		}
		for (i=0;i<m;i++)
			if (i!=m-1) 
				System.out.println(list_res[i]); 
			else System.out.print(list_res[i]);
		input.close();
	}

}
