import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Solution {

	int koffset=-1;
	int roffset=-1;
	public int [][] addRow(int rows, int arr[][]) {
		
		for(int r=1;r<=rows;r++) {
			for (int k = 1; k<=r;k++) {
				
				if(k==1 || k==r) {
					arr[r+roffset][k+koffset] = 1;
				}
				else
				{
					int val1 = 0;
					if(!(r+roffset-1<0||r+roffset-1>=501 || k+koffset-1<0|| k+koffset-1>=501))
						val1=arr[r+roffset-1][k+koffset-1];
					
					int val2 = 0;
					if(!(r+roffset-1<0||r+roffset-1>=501 || k+koffset<0|| k+koffset>=501))
						val2=arr[r+roffset-1][k+koffset];
					
							
					arr[r+roffset][k+koffset] =  val1+val2;
				}
					
			}
		}
		return arr;
	}
	
	public String process(int n) {
		int arr[][] = new int[502][502];
		
		arr = addRow(501,arr);
		int[] rowList = new int[500]; 
		int[] colList= new int[500]; 
		recur(arr,1,1,n,0,0, rowList,colList);
		
		StringBuffer sResult = new StringBuffer();
		for(int i = 0; i < rowList.length; i++) {
			if(rowList[i]!=0)
				sResult.append(rowList[i]+ " " + colList[i]+"\n");
	      }
		
		//System.out.println(sResult);
		return sResult.toString();
		
	}
	
	public boolean isPresent( int r, int k, int[] rowList, int[] colList, int index) {
		for (int i=0;i<index;i++) {
			if(rowList[i]==r && colList[i]==k)
				return true;
		}
		return false;
	}
	
	public boolean recur(int[][] arr, int r, int k, int N, int currSum, int index, int[] rowList, int[] colList) {
		
		if(r+roffset<0|| r+roffset>=501) return false;
		if(k+koffset<0|| k+koffset>=501) return false;
		
		
		if(arr[r+roffset][k+koffset]==0) return false;
		if(isPresent(  r,  k,  rowList,  colList,  index)) return false;
		
		currSum = currSum + arr[r+roffset][k+koffset];
		if(currSum>N) return false;
		
		rowList[index]=r;
		colList[index]=k;
		index=index+1;
		
		if(currSum==N)
			return true;
		
		
		boolean ret=false;
		ret = recur(arr, r-1,k-1,N,currSum, index, rowList,  colList);
		if(!ret)
			ret = recur(arr, r-1,k,N,currSum, index, rowList,  colList);
		
		if(!ret)
			ret = recur(arr, r,k-1,N,currSum, index, rowList,  colList);
		
		if(!ret)
			ret = recur(arr, r,k+1,N,currSum, index, rowList,  colList);
		
		if(!ret)
			ret = recur(arr, r+1,k,N,currSum, index, rowList,  colList);
		if(!ret)
			ret = recur(arr, r+1,k+1,N,currSum, index, rowList,  colList);
		
		return ret;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String n = in.nextLine();

			System.out.println("Case #" + i + ":\n" + sol.process(new Integer(n).intValue()));
		}
	}
}
