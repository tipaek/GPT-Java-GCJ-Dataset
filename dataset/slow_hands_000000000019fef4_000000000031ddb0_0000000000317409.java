

import java.util.*;
import java.io.*;


class pair1{
	int x ;int y;
	public pair1(int a,int b){
		this.x=a;
		this.y=b;
	}}
//5
//4 4 SSSS
//3 0 SNSS
//2 10 NSNNSN
//0 1 S
//2 7 SSSSSSSS
//
//  
//Case #1: 4
//Case #2: IMPOSSIBLE
//Case #3: IMPOSSIBLE
//Case #4: 1
//Case #5: 5
public class Solution { 
	public static int solve(int x,int y,String way) {
		int ans=0;
		int seq_len=way.length();
		if(x>seq_len) return -1;
		int cc=0;
		int mx=x;
		int my=y;
		while(cc<x) {
			if(way.charAt(cc)=='N') {
				my++;
			}else {
				my--;
			}
			cc++;
		}
		int mera=0;
		if(cc==seq_len && my==0) return x;
		
		int time=0;
		while(cc<seq_len) {
			if(way.charAt(cc)=='N') {
				my++;
			}else {
				my--;
			}
			time++;
			cc++;
			if(my==mera) return time+x;
			mera++;
		}
		
		return -1;
	}
	public static void main(String args[])throws IOException { 
		Scanner s=new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
		int x=Integer.parseInt(tem1[0]);
		int y=Integer.parseInt(tem1[1]);
		String way=tem1[2];
		
		int ans=solve(x,y,way);
		if(ans!=-1)
		System.out.println("Case #"+(c)+":"+" "+ans);
		else System.out.println("Case #"+(c)+":"+" "+"IMPOSSIBLE");
		c++;
		}

	} 
} 
