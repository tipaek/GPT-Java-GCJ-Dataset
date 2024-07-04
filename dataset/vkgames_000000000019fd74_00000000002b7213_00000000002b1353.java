import java.util.*; import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c = 0;
		while(t>0) {
			c++;
			System.out.println("Case #" + c+": ");
			int n = sc.nextInt();
			solve(n);
//			print(4);
//			System.out.println(count);
			t--;
		}
	}
	static int count;
	static void solve(int n) {
		if(n==0) {
			return;
		}
		else if(n==1) {
			System.out.println(1 + " " + 1);
//			count++;
		}
		else if(n==2) {
			System.out.println(1 + " " + 1);
			System.out.println(2 + " " + 2);
//			count+=2;
		}
		else if(n==3) {
			System.out.println(1 + " " + 1);
			System.out.println(2 + " " + 2);
			System.out.println(2 + " " + 1);
//			count+=3;
		}
			
		else {
			for(int a=2;a<=30;a++) {
				if((int) (Math.pow(2,a)+2*a-1)>n) {
					print(a-1);
					solve(n-((int) Math.pow(2,a-1)+2*(a-1)-1));
					break;
				}
			}
		}
	}
	static void print(int pathNum) {
		for(int i=1;i<=pathNum;i++) {
			System.out.println(i + " " + i);
		}
		System.out.println((pathNum+1) + " " + (pathNum+1));
		for(int i=1;i<=pathNum;i++) {
			System.out.println((pathNum+1) + " " + (pathNum+1-i));
		}
		for(int i=pathNum;i>1;i--) {
			System.out.println(i + " " + 1);
		}
	}
}
