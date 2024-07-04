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
			int J[]=new int[1440];
			Arrays.fill(J,0);
			int C[]=new int[1440];
			Arrays.fill(C,0);
			String result="";
			int start,end;
			for(int j=0;j<n;j++){
				start=sc.nextInt();
				end=sc.nextInt();
				if(isValid(J,start,end)){
					result+='J';
					populate(J,start,end);
				}
				else if(isValid(C,start,end)){
					result+='C';
					populate(C,start,end);
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