/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int v=1;v<=x;v++){
			sb.append("Case #"+v+": ");
			int n = sc.nextInt();
			Node[] nodes=new Node[n];
			char[] ans = new char[n];
			for(int i=0;i<n;i++){
				int s=sc.nextInt(),e=sc.nextInt();
				nodes[i]=new Node(s,e,i);
			}
			boolean pos=false;
			for(int i=0;i<(1<<n)-1;i++){
				int ind=0,y=i;
				ArrayList<Node> c = new ArrayList<>(), j =new ArrayList<>();
				while(y>0 || ind<n){
					if((y&1)==1){
						c.add(nodes[ind]);
					} else {
						j.add(nodes[ind]);
					}
					ind++;
					y/=2;
				}
				if(solve(c,j)){
     				// System.out.println(c+" "+j);
					for(Node node:c){
						ans[node.i]='C';
					}
					for(Node node:j){
						ans[node.i]='J';
					}
					pos=true;
					break;
				}
			}
			if(pos)for(char c:ans)sb.append(c);
			else sb.append("IMPOSSIBLE");
			sb.append('\n');
		}
		System.out.println(sb);
	}
	public static boolean solve(ArrayList<Node> c, ArrayList<Node> j){
		int[] a = new int[2000],b = new int[2000];
		for(Node node:c){
			for(int i=node.s;i<node.e;i++){
				a[i]++;
				if(a[i]>1)return false;
			}
		}
		for(Node node:j){
			for(int i=node.s;i<node.e;i++){
				b[i]++;
				if(b[i]>1)return false;
			}
		}
		return true;
	}
	static class Node{
		int s,e,i;
		Node(int s ,int e, int i){
			this.s=s;
			this.e=e;
			this.i=i;
		}
		@Override
		public String toString(){
			return s+" "+e;
		}
	}
}