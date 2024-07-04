import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        String[]sa=str.split(" ");
		int t=Integer.parseInt(sa[0]);
        int b=Integer.parseInt(sa[1]);
		while(t-->0) {
			solve(b);
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
	
	public static void solve(int b) {
        Scanner scn = new Scanner(System.in);
		int[]a=new int[b];
		Arrays.fill(a, -1);
		int qn=1;
		LinkedList<Integer>q=new LinkedList<Integer>();
		for(int i=1;i<=a.length;i++)q.addLast(i);
		
		while(!q.isEmpty()) {
			int i=q.getFirst();
            System.out.print(Integer.toString(i));
            String str = scn.nextLine();
			int input=Integer.parseInt(str);
			if(qn%10!=1) {
				q.removeFirst();
				a[i-1]=input;
			}
			qn++;
		}
		StringBuilder sb = new StringBuilder();
        for(int v:a)sb.append(Integer.toString(v));
        System.out.print(sb.toString());
	}

}
