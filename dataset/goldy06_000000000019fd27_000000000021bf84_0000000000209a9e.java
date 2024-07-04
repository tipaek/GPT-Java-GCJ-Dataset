import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		String w=scn.nextLine();
		while(t-->0) {
			solve();
			String s = scn.nextLine();
			if(s.equals("N"))return;
		}

	}
	
	/*
	 2
	 12
	 0 1 0 1 1 0 1 1 1 0 1 0 1 0
	 10
	 0 1 0 1 1 0 1 1 1 0 1 0
	 */
	
	public static void solve() {
		Scanner scn = new Scanner(System.in);
		int b=scn.nextInt();
		int[]a=new int[b];
		Arrays.fill(a, -1);
		int qn=1;
		LinkedList<Integer>q=new LinkedList<Integer>();
		for(int i=1;i<=a.length;i++)q.addLast(i);
		
		while(!q.isEmpty()) {
			int i=q.getFirst();
			System.out.println(i);
			int input=scn.nextInt();
			if(qn%10!=1) {
				q.removeFirst();
				a[i-1]=input;
			}
			qn++;
		}
		
		for(int v:a)System.out.print(v+" ");
	}

}
