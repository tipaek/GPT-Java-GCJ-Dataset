
import java.util.*;
import java.io.*;


class pair{
	int a ;char b;
	public pair(int a,char b){
		this.a=a;
		this.b=b;
	}}
public class Solution { 
public static String solve(int[][] arr) {
	String ans="";
		int n=arr.length;
		pair[] jj=new pair[2*n];
		int index=0;
		for (int i = 0; i < n; i++) {
			jj[index++]=new pair(arr[i][0],'s');
			jj[index++]=new pair(arr[i][1],'e');
		}
		Arrays.sort(jj,(a,b)->(a.a-b.a));
		int over=0;
		int am=0;
		
		for (int i = 0; i < jj.length; i++) {
			if(jj[i].b=='s') {
				over++;
			}
			else {
				over--;
			}
			
			am=Math.max(am,over);
		}
		if(am>2) return "IMPOSSIBLE"; 
		boolean flag=false;
		int last=0;
		Arrays.sort(arr,(a,b)->a[0]-b[0]);
		for (int i = 0; i < arr.length; i++) {
			if(last<=arr[i][0]) {
				flag=false;
				last=0;
			}
			if(flag==false) {
				ans+="C";flag=true;
				last=arr[i][1];
			}
			else ans+="J";
			
			
			
		}
		
		return ans;
	}

//
//	Case #1: CJC
//	Case #2: IMPOSSIBLE
//	Case #3: JCCJJ
//	Case #4: CC
	public static void main(String args[])throws IOException { 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
			int n=Integer.parseInt(tem1[0]);
		int[][] arr=new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			String[] er=reader.readLine().split(" ");	
			int a=Integer.parseInt(er[0]);
			int b=Integer.parseInt(er[1]);
			arr[i][0]=a;
			arr[i][1]=b;
		}
		String ans=solve(arr);
		System.out.println("Case #"+(c)+":"+" "+ans);
		c++;
		}

	} 
} 
