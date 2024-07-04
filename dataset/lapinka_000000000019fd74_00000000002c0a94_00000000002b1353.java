import java.util.*;

public class Solution {//Code Jam round 1A 2020, Pascal Walk 
	Scanner sc;
	public void findPath(int N, int[] pow2) {
		if (N==1) {
			System.out.println("1 1");
			return;
		}
		int b=0;
		int remN=N;
		while (N>pow2[b]) b++;
		boolean[] rows=new boolean[b];
		int currow=b-1;
		while (currow>0) {
			if (remN>=pow2[currow]+currow) {
				rows[currow]=true;
				remN=remN-pow2[currow];
			} else {
				remN--;
				rows[currow]=false;
			}
			currow--;
		}
		remN--;
		//System.out.println(remN);
		//for (int i=0; i<b; i++) System.out.print(rows[i]+" ");
		//System.out.println();
		boolean left=true;
		for (int i=0; i<b; i++) {
			if (rows[i]) {
				if (left) {
					for (int j=0; j<i+1; j++) System.out.println(i+1+" "+(j+1));
				} else {
					for (int j=i; j>=0; j--) System.out.println(i+1+" "+(j+1));
				}
				left=!left;
			} else {
				if (left) System.out.println(i+1+" 1");
				else System.out.println(i+1+" "+(i+1));
				}
			}
		for (int i=0; i<remN; i++) 
			if (left) System.out.println(b+1+i+" "+1);
			else System.out.println(b+1+i+" "+(b+1+i));
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		int[] pow2 = new int[30];
		pow2[0]=1;
		for (int i=1; i<30; i++) pow2[i]=2*pow2[i-1];
		for (int t=1; t<=T; t++) {
			int N=sol.sc.nextInt();
			sol.sc.nextLine();
			System.out.println("Case #"+t+":");
			sol.findPath(N, pow2);
		}
		
		 
	}
}
