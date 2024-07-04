

import java.util.*;
import java.io.*;


class pair{
	int a ;int b;
	public pair(int a,int b){
		this.a=a;
		this.b=b;
	}}
public class Solution { 
	public static String solve(int x1,int y1) {
		String ans="";
		int x=Math.abs(x1);
		int y=Math.abs(y1);
		if(x==0 && y==1) {
			ans="N";
		}
		if(x==0 && y==0) {
			ans="";
		}
		if(x==0 && y==2) {
			ans="IMPOSSIBLE";
		}
		if(x==0 && y==3) {
			ans="NN";
		}
		if(x==0 && y==4) {
			ans="IMPOSSIBLE";
		}
		//////
		if(x==1 && y==4) {
			ans="WEN";
		}
		if(x==1 && y==1) {
			ans="IMPOSSIBLE";
		}
		if(x==1 && y==2) {
			ans="NN";
		}
		if(x==1 && y==3) {
			ans="IMPOSSIBLE";
		}
		if(x==1 && y==0) {
			ans="E";
		}
		/////////
		if(x==2 && y==4) {
			ans="IMPOSSIBLE";
		}
		if(x==2 && y==1) {
			ans="NE";
		}
		if(x==2 && y==2) {
			ans="IMPOSSIBLE";
		}
		if(x==2 && y==3) {
			ans="SEN";
		}
		if(x==2 && y==0) {
			ans="IMPOSSIBLE";
		}
		/////
		if(x==3 && y==4) {
			ans="EEN";
		}
		if(x==3 && y==1) {
			ans="IMPOSSIBLE";
		}
		if(x==3 && y==2) {
			ans="WNE";
		}
		if(x==3 && y==3) {
			ans="IMPOSSIBLE";
		}
		if(x==3 && y==0) {
			ans="EE";
		}
		/////
		if(x==4 && y==4) {
			ans="IMPOSSIBLE";
		}
		if(x==4 && y==1) {
			ans="SNE";
		}
		if(x==4 && y==2) {
			ans="IMPOSSIBLE";
		}
		if(x==4 && y==3) {
			ans="NNE";
		}
		if(x==4 && y==0) {
			ans="IMPOSSIBLE";
		}
		///////
		if(x1<0 && y1>=0) {
			char[] temp=ans.toCharArray();
			if(ans.compareTo("IMPOSSIBLE")==0) return ans;
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]=='W') temp[i]='E';
				else if(temp[i]=='E') temp[i]='W';
			}
			return String.valueOf(temp);
		}
		if(x1<0 && y1<0) {
			char[] temp=ans.toCharArray();
			if(ans.compareTo("IMPOSSIBLE")==0) return ans;
			for (int i = 0; i < temp.length; i++) {
				if(temp[i]=='W') temp[i]='E';
				else if(temp[i]=='E') temp[i]='W';
				else if(temp[i]=='S') temp[i]='N';
				else if(temp[i]=='N') temp[i]='S';
			}
			return String.valueOf(temp);
		}
		if(x1>=0 && y1<0) {
			char[] temp=ans.toCharArray();
			if(ans.compareTo("IMPOSSIBLE")==0) return ans;
			for (int i = 0; i < temp.length; i++) {
				 if(temp[i]=='S') temp[i]='N';
				else if(temp[i]=='N') temp[i]='S';
			}
			return String.valueOf(temp);
		}
		return ans;
	}
	public static void main(String args[])throws IOException { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String[] tem1=reader.readLine().split(" ");	
			int x=Integer.parseInt(tem1[0]);
			int y=Integer.parseInt(tem1[1]);


			String ans=solve(x,y);
			System.out.println("Case #"+(c)+":"+" "+ans);
			c++;
		}

	} 
} 
