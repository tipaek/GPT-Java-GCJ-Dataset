import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static Card[]x;
	static ArrayList<String>bi;
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		//st=new StringTokenizer(br.readLine());
		//long l=Long.parseLong(br.readLine());
		//int []a=new int[n];
		//long []b=new long[n];
		//int[][]mat=new int[n][n];
		//long[][]longmat=new long[n][n];
		//br.readLine();
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			bi=new ArrayList();
			x=new Card[r*s];
			fillInX(r,s);
			//System.out.println(Arrays.asList(x));
			doStuff(r,s);
			out.println("Case #"+(i+1)+": "+bi.size());
			for(String xh:bi) {
				out.println(xh);
			}
		}
		out.close();
	}
	private static int doStuff(int r, int s) {
		int swaps=0,trans=1;
		for(int i=x.length-1;i>=0;i--) {
			int hai=getFirstOccx(x[i].r);
			if(hai>=i||hai==-1) {
				continue;
			}
			//System.out.println(hai);
			swap(0,hai,hai+1,i-1);
			swaps++;
			
			i=x.length-trans++;
		}
		return swaps;
	}
	private static boolean sorted() {
		// TODO Auto-generated method stub
		return false;
	}
	private static void swap(int a,int b,int c,int d) {
		if(b<a||d<c)return;
		if(b-a==1&&d-c==1)return;
		bi.add((b-a+1)+" "+(d-c+1));
		Card[]temp=new Card[b-a+1];
	//	System.out.println(c-d+1);
		
		for(int i=a,j=0;i<=b;i++,j++) {
			temp[j]=x[i];
		}
		for(int i=a,j=c;i<=x.length&&j<=d;i++,j++) {
			x[i]=x[j];
		}
		for(int i=d-c+1,j=0;i<=d;i++,j++) {
			x[i]=temp[j];
		}
	}
	private static int getFirstOccx(int i) {
		for(int j=0;j<x.length;j++) {
			if(x[j].r==i)return j;
		}
		return -1;
	}
	private static void fillInX(int r, int s) {
		int c=0;
		for(int i=1;i<=s;i++) {
			for(int j=1;j<=r;j++) {
				x[c++]=new Card(j,i);
			}
		}
	}
	static class Card{
		int r,s;
		Card(int r,int s){
			this.r=r;
			this.s=s;
		}
		public int compareTo(Object o) {
			Card c=(Card)o;
			return this.r-c.r;
		}
		public String toString() {
			return r+","+s;
		}
	}
}
