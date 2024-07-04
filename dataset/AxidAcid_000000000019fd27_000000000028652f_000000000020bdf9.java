package Competion.Questions;

import java.util.Scanner;

public class CodeJamParenting {

	public static boolean checkOverlap(int a,int b,int c,int d) {
		if(d>=a&&d<=b&&c<=a)
			return true;
		else if(c>=a&&c<=b&&d>=b)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int r=1;r<=t;r++) {
		int n=sc.nextInt();
		int a[][]=new int[n][3];
		int f=0;
		for (int i = 0; i < a.length; i++) {
			f=0;
			a[i][2]=0;
			for (int j = 0; j < 2; j++) {
				a[i][j]=sc.nextInt();
				
			}
			
			if(i>0) {
				for(int k=i-1;k>=0;k--) {
					if(checkOverlap(a[i][0],a[i][1],a[k][0],a[k][1])) {
						f++;
						if(a[k][2]==0)
							a[i][2]=1;
						else
							a[i][2]=0;
					}
					else
						a[i][2]=a[k][2];
					
					if(f>2) {
						a[i][2]=-1;
						break;
					}
					
				}
			}
				
			
		}
		System.out.print("Case #"+r+": ");
			for(int i=0;i<n;i++) {
				if(a[i][2]==-1)
					System.out.println("IMPOSSIBLE");
				f=-1;
			}
			if(f!=-1)
			for(int i=0;i<n;i++) {
				if(a[i][2]==1)
					System.out.print("J");
				else
					System.out.print("C");
			}
		}
		
		
		
	}

}
