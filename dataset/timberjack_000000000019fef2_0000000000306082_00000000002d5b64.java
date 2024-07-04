package test;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int r=scanner.nextInt();
			int s=scanner.nextInt();
			int x=0;
			for(int j=r-1;j>0;j--) {
				for(int i=(s-1)*r;i>=(s-2)*(r-1)+r;i--) {
					x++;
				}
				}
			System.out.println("Case #"+(t+1)+": "+x);
			if(r>=2) {
				
				for(int j=r-1;j>0;j--) {
				for(int i=(s-1)*r;i>=(s-2)*(r-1)+r;i--) {
					System.out.println((i)+" "+j);
				}
				r--;
				}
			}
			
			
			else {
				
				
				
				
				
				
				
			}
			
			
		}
	}

}
