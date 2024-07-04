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
			int arr[][]=new int[n][2];
			for(int j=0;j<n;j++){
				arr[j][0]=sc.nextInt();
				arr[j][1]=sc.nextInt();
			}
			int J[]=new int[1440];
			int C[]=new int[1440];
			String result="";
			for(int j=0;j<n;j++){
				if(isValid(J,arr[j][0],arr[j][1])){
					result+='J';
					populate(J,arr[j][0],arr[j][1]);
				}
				else if(isValid(C,arr[j][0],arr[j][1])){
					result+='C';
					populate(C,arr[j][0],arr[j][1]);
				}
				else{
					result="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(i+1)+": "+result);
		}
			
	}
	private static boolean isValid(int arr[],int start,int end){
		for(int i=start;i<end;i++){
			if(arr[i]==1)
			return false;
		}
		return true;
	}
	private static void populate(int arr[],int start,int end){
			for(int i=start;i<end;i++){
			arr[i]=1;
		}
	}
}