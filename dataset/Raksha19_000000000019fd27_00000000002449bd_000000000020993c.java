import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++)
				 arr[j][k]=sc.nextInt();
			}
			int result[]= getResult(arr);
			System.out.println("Case #"+(i+1)+": "+result[0]+" "+result[1]+" "+result[2]);
		}
		
	}
	
	private static int[] getResult(int arr[][]){
		int n=arr.length;
		int result[]=new int[3];
		for(int i=0;i<n;i++){
			result[0]+=arr[i][i];
		}
		int count=0;
		for(int i=0;i<n;i++){
			HashSet<Integer> hs=new HashSet<>();
			for(int j=0;j<n;j++){
				if(!hs.add(arr[i][j])){
					count++;
					break;
				}
			}
		}
		result[1]=count;
		count=0;
		for(int i=0;i<n;i++){
			HashSet<Integer> hs=new HashSet<>();
			for(int j=0;j<n;j++){
				if(!hs.add(arr[j][i])){
					count++;
					break;
				}
			}
		}
		result[2]=count;
		return result;
	}
}