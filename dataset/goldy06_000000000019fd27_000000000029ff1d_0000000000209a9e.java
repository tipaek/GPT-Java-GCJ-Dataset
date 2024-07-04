import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        String[]sa=str.split(" ");
		int t=Integer.parseInt(sa[0]);
        int b=Integer.parseInt(sa[1]);
		while(t-->0) {
			String rv = solve(b);
			System.out.println(rv);
			String s = scn.nextLine();
			if(s.equals("N"))return;
		}

	}
	
	public static String solve(int b) {
		Scanner scn = new Scanner(System.in);
		int[]a=new int[b];
		for(int i=1;i<=a.length;i++) {
			System.out.println(Integer.toString(i));
            String str = scn.nextLine();
			int input=Integer.parseInt(str);
			a[i-1]=input;
		}
		StringBuilder sb = new StringBuilder();
        for(int v:a)sb.append(Integer.toString(v));
        return sb.toString();
	}
	
//	public static String solve(int b) {
//        Scanner scn = new Scanner(System.in);
//		int[]a=new int[b];
//		int qn=1;
//		LinkedList<Integer>q=new LinkedList<Integer>();
//		for(int i=1;i<=a.length;i++)q.addLast(i);
//		
//		while(!q.isEmpty()) {
//			int i=q.getFirst();
//            System.out.println(Integer.toString(i));
//            String str = scn.nextLine();
//			int input=Integer.parseInt(str);
//			if(qn%10!=1) {
//				q.removeFirst();
//				a[i-1]=input;
//			}
//			qn++;
//		}
//		StringBuilder sb = new StringBuilder();
//        for(int v:a)sb.append(Integer.toString(v));
//        return sb.toString();
//	}
	
	/*
	 2
	 12
	 0 1 0 1 1 0 1 1 1 0 1 0 1 0
	 10
	 0 1 0 1 1 0 1 1 1 0 1 0
	 */

}
