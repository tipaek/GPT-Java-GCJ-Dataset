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
		StringBuilder sb=new StringBuilder();
		int v=sc.nextInt();
		for(int b=1;b<=v;b++){
			sb.append("Case #"+b+": ");
			long x=sc.nextLong(),y=sc.nextLong();
			long max=test(Math.abs(x)+Math.abs(y));
			if(max!=-1){
				int size=0;
				long temp=max;
				while(temp!=0){
					size++;
					temp/=2;
				}
				long[] a=new long[size];
				temp=max;
				for(int i=size-1;i>=0;i--,temp/=2){
					a[i]=temp;
				}
				long neg=((max*2-1)-(Math.abs(x)+Math.abs(y)))/2;
				String pow=Long.toBinaryString(neg);
				// System.out.println(max+" "+neg+" "+pow);
				for(int i=pow.length()-1,ind=0;i>=0&&ind<a.length;i--,ind++){
					if(pow.charAt(i)=='1'){
						a[ind]*=-1;
					}
				}
				// System.out.println(Arrays.toString(a));
				boolean[] blgx=bag(a,x,y);
				for(int i=0;i<a.length;i++){
					if(blgx[i]){
						if(a[i]>0){
							sb.append('E');
						} else {
							sb.append('W');
						}
					} else {
						if(a[i]>0){
							sb.append('N');
						} else {
							sb.append('S');
						}
					}
				}
				
			} else {
				sb.append("IMPOSSIBLE");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static long test(long n){
		long p=1,sum=1;
		while(sum<n){
			p*=2;
			sum+=p;
		}
		if((n-sum)%2==0){
			return p;
		} else return -1;
	}
	static boolean[] bag(long[] a, long x,long y){
		HashMap<Long,Boolean> map=new HashMap<>();
		ArrayList<Node> list=new ArrayList<>();
		list.add(new Node(a[0],"0",0));
		map.put(a[0],true);
		int top = 0;
		int sumx=-1;
		while(top<list.size() && list.get(top).sum!=x){
			// System.out.println(list);
			Node node = list.get(top);
			if(node.ind+1<a.length){
				if(map.get(node.sum+a[node.ind+1])==null){
					long sum=node.sum+a[node.ind+1];
					String str=String.valueOf(node.str)+","+(node.ind+1);
					map.put(sum,true);
					list.add(new Node(sum,str,node.ind+1));
					if(sum==x){
						sumx=1;
						break;
					} if(sum==y){
						sumx=0;
						break;
					}
				}
				list.add(new Node(node.sum,node.str,node.ind+1));
				
			}
			top++;
		}
		Node node=list.get(list.size()-1);
		String[] str = node.str.split(",");
		boolean[] b=new boolean[a.length];
		if(sumx==0)Arrays.fill(b,true);
		for(int i=0;i<str.length;i++){
			int ind=Integer.parseInt(str[i]);
			if(sumx==1){
				b[ind]=true;
			} else {
				b[ind]=false;
			}
		}
		return b;
	}
	static class Node{
		long sum;
		String str;
		int ind;
		public Node(long sum, String str, int ind){
			this.sum=sum;
			this.str=str;
			this.ind=ind;
		}
		@Override
		public String toString(){
			return sum+" "+str+" "+ind;
		}
	}
	
}