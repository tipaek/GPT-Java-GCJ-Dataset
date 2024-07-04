package main;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			int N=sc.nextInt();
			int[][] mat=new int[N][N];
			int rc=0;
			int trace=0;
			for(int i=0;i<N;i++) {
				boolean[] row=new boolean[N];
				
				boolean r_done=false;
				for(int j=0;j<N;j++) {
					mat[i][j]=sc.nextInt();
					if(!r_done) {
						if(!row[mat[i][j]-1]) {
							row[mat[i][j]-1]=true;
						}
						else {
							rc++;
							r_done=true;
						}
					}
					if(i==j) {
						trace+=mat[i][j];
					}
				}
			}
			int cc=0;
			for(int i=0;i<N;i++) {
				boolean[] col=new boolean[N];
				
				boolean c_done=false;
				for(int j=0;j<N;j++) {
					if(!c_done) {
						if(!col[mat[j][i]-1]) {
							col[mat[j][i]-1]=true;
						}
						else {
							cc++;
							c_done=true;
						}
					}
				}
			}
			System.out.println("Case #"+t+": "+trace+" "+rc+" "+cc);
			
		}
	}

}
