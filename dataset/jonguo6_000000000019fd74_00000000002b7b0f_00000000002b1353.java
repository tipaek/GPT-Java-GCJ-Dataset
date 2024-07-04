import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			int n = Integer.parseInt(in.nextLine());
			System.out.println("Case #"+(test+1)+":");
			if(n <= 500) {
				for(int j=1;j<=n;j++) {
					System.out.println(j+" "+1);
				}
				continue;
			}
			int top = (int)(Math.log(n)/Math.log(2));
			top+=3;
			while(true) {
				if(n >= Math.pow(2, top)+top) {
					break;
				}
				top--;
			}
			//System.out.println(top);
			int remain = n - top - (int)Math.pow(2, top);
			//System.out.println(remain);
			int steps = 2*top+1;
			if(remain <= 500 - steps) {
				for(int i=1;i<=top+1;i++) {
					System.out.println(i+" "+1);
				}
				for(int j=2;j<=top+1;j++) {
					System.out.println((top+1)+" "+j);
				}
				for(int k=1;k<=remain;k++) {
					System.out.println((top+1+k)+" "+(top+1+k));
				}
				continue;
			}
			int[] rows = new int[100];
			int index = 0;
			while(remain > 500 - steps) {
				int log2 = (int) (Math.log(n)/Math.log(2));
				log2+=2;
				while(true) {
					if(remain >= Math.pow(2, log2)-1) {
						steps += log2;
						remain -= (Math.pow(2, log2)-1);
						rows[index] = log2;
						index++;
						break;
					}
					log2--;
				}
			}
			int[] sortrows = new int[index+1];
			for(int i=0;i<index;i++) {
				sortrows[i] = rows[index-1-i];
			}
			sortrows[index] = top;
			index++;
			int prevnum = 1;
			System.out.println(1+" "+1);
			boolean left = true;
			for(int i=0;i<index;i++) {
				int num = sortrows[i];
				for(int j=prevnum+1;j<=(num+1);j++) {
					if(left) {
						System.out.println(j+" "+1);
					} else {
						System.out.println(j+" "+j);
					}
				}
				if(left) {
					for(int j=2;j<=(num+1);j++) {
						System.out.println((num+1)+" "+j);
					}
				} else {
					for(int j=num;j>=1;j--) {
						System.out.println((num+1)+" "+j);
					}
				}
				left = !left;
				prevnum = num+1;
			}
			for(int k=1;k<=remain;k++) {
				if(left) System.out.println((top+1+k)+" "+1);
				else System.out.println((top+1+k)+" "+(top+1+k));
			}
		}
		in.close();
	}
}