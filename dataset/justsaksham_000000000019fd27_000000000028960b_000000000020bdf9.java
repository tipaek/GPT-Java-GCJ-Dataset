//package dsalearning;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int tt=0;
		while(tt<t) {
			int n=s.nextInt();
			int a[][]=new int[24*60+1][2];
			for(int i=0;i<n;i++) {
				int y=s.nextInt();
				a[y][0]++;
				a[y][1]=s.nextInt();
			}
			String k="";
			char[] o=new char[2];
			o[0]='C';
			o[1]='J';
			int second =0;
			int third=0,f=0;
			int cc=0;
			for(int i=0;i<24*60+1;i++) {
				if(a[i][0]!=0 && second <=i) {
					int l=i;
					second=a[i][1];
					if(cc%2==0)
					k=k+o[0];
					else k=k+o[1];
				}
				else if(a[i][0]!=0 && third <=i) {
					int l=i;
					third=a[i][1];
				if(cc%2==0)
					k=k+o[1];
				else k=k+o[0];

					//k=k+"J";
				}
				else if(a[i][0]!=0) {
				System.out.println("Case #"+(tt+1)+": "+"IMPOSSIBLE");
				f=1;
				break;
			}
			//System.out.println(k);
			cc++;
			}
			if(f==0)
			System.out.println("Case #"+(tt+1)+": "+k);
			tt++;
		}
	}
	}
