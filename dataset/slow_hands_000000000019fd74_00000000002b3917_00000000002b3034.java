import java.util.*;
import java.io.*;


class pair{
	int a ;int b;
	public pair(int a,int b){
		this.a=a;
		this.b=b;
	}}
public class Solution { 
	public static String solve(int n,String[] arr) {
		String ans="";
		String max="";
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].substring(1).length()>max.length())
				max=arr[i].substring(1);
		}
		for (int i = 0; i < arr.length; i++) {
			if(!max.contains(arr[i].substring(1))) {
				return "*";
			}
				
		}
				
		return max;
	}
	public static void main(String args[])throws IOException { 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
		int n=Integer.parseInt(tem1[0]);
		

		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=reader.readLine();
			
		}
		
		String ans=solve(n,arr);
		System.out.println("Case #"+(c)+":"+" "+ans);
		c++;
		}

	} 
} 
