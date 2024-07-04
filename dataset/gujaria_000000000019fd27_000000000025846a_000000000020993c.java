import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		int test_case=in.nextInt();
		int i=0;
		do {
			int len=in.nextInt();
			int[][] test = new int[len][len]; 
		       // Scanner tin = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		        for(int row = 0; row< len; row++){ 
		              for(int col = 0 ;col< len; col++){  
		                  test[row][col] = in.nextInt(); 
		               } 
		          } 
			i++;
		
		
		System.out.println("Case #"+i+": "+trace(test)+" "+rep_rows(test)+" "+rep_col(test));
		test_case--;
		}while(test_case>0);
		
	
		
		
		
	}
	
	public static int trace(int[][] arr)
	{
		int len=arr[0].length;
		int res=0;
		
		for(int i=0,j=0;i<len && j<len;i++,j++)
		{
			res=res+arr[i][j];
		}
		return res;
	}
	
	public static int rep_rows(int[][] arr)
	{
		int len=arr[0].length;
		int res=0;
		for(int i=0;i<len;i++)
		{
			int temp[]=Arrays.copyOf(arr[i], arr.length);
			
			Arrays.sort(temp);
			for(int j=0;j<len-1;j++)
			{
				if(temp[j]==temp[j+1])
				{
					res=res+1;
					break;
				}
			}
		}
		return res;
	}
	
	public static int[] getColumn(int[][] array, int index){
		
	    int[] column = new int[array[0].length];
	    for(int i=0; i<column.length; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}
	
	public static int rep_col(int[][] arr)
	{
		int len=arr[0].length;
		int res=0;
		for(int i=0;i<len;i++)
		{
			int temp[]= getColumn(arr,i);
			Arrays.sort(temp);
			for(int j=0;j<len-1;j++)
			{
				if(temp[j]==temp[j+1])
				{
					res=res+1;
					break;
				}
			}
		}
		return res;
	}

	
}
