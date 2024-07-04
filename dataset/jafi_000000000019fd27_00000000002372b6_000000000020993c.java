

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int n=1; n<=T; n++)
		{
			int N = scan.nextInt();
			int a[][] = new int[N][N];
			int sum =0;
			int row=0;
			int col=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					a[i][j]= scan.nextInt();
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) {
						sum= sum+a[i][j];
					}
				}
			}
			System.out.print("Case #"+n+": ");
			System.out.print(sum+" ");
			for(int i=0; i<N; i++) {
				int dup=0;
				List<Integer> li = new ArrayList<Integer>();
				for(int j=0;j<N;j++) {
					if(li.contains(a[i][j])){
						dup++;}
					else {
					li.add(a[i][j]); }
				
					}
				if(dup>0) {
					row++;
					dup=0;
				}
			}
			System.out.print(row+" ");
			for(int j=0; j<N; j++) {
				int dup=0;
				List<Integer> li = new ArrayList<Integer>();
				for(int i=0;i<N;i++) {
					if(li.contains(a[i][j])) {
						dup++;
					}
					else {
						li.add(a[i][j]);
					}
				}
				if(dup>0) {
					col++;
					dup=0;
				}
			}
			System.out.println(col+" ");
		}
		
		

	}

}
