
import java.util.*;
import java.io.*;


class pair{
	int a ;int b;
	public pair(int a,int b){
		this.a=a;
		this.b=b;
	}}
 class Solution { 
	
	public static int[] solve(int n,int[][] arr) {
		
		int []ans=new int[3];
		for( int i=0;i<n;i++) {
			ans[0]+=arr[i][i];
		}
		int rep=0;
		for (int j = 0; j < arr[0].length; j++) {
			TreeSet<Integer> jj=new TreeSet<>();
			for(int i=0;i<arr.length;i++) {
				if(jj.size()==0 || !jj.contains(arr[i][j])) jj.add(arr[i][j]);
				else if(jj.contains(arr[i][j])){
					rep++;break;
				}
			}
			
		}
		ans[2]=rep;
		rep=0;
		for (int j = 0; j < arr[0].length; j++) {
			TreeSet<Integer> jj=new TreeSet<>();
			for(int i=0;i<arr.length;i++) {
				if(jj.size()==0 || !jj.contains(arr[j][i])) jj.add(arr[j][i]);
				else if(jj.contains(arr[j][i])){
					rep++;break;
				}
			}
			
		}
		ans[1]=rep;
				
		return ans;
	}
	public static void main(String args[])throws IOException { 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
		int n=Integer.parseInt(tem1[0]);
		
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++) {
			String[] keys=reader.readLine().split(" ");
			arr[i]=Arrays.asList(keys).stream().mapToInt(Integer::parseInt).toArray();
		}
		
		int[] ans=solve(n,arr);
		System.out.println("Case #"+(c)+":"+" "+ans[0]+" "+ans[1]+" "+ans[2]);
		c++;
		}

	} 
} 
