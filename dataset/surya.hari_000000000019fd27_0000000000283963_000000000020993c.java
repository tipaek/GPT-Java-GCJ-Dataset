

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		for(int t=1;t<=x;t++) {
			int n=s.nextInt();
			int[][] m=new int[n][n];
			int dupR=0;
			int dupC=0;
					
			for(int i=0;i<n;i++) {
				List<Integer> rowList=new ArrayList<Integer>();
				int flag=0;
				for(int j=0;j<n;j++) {
					m[i][j]=s.nextInt();
					if(rowList.contains(m[i][j])&&flag==0) {
						dupR++;
						flag=1;
					}
					else
					rowList.add(m[i][j]);
					
				}
			}
			int trace=0;
			for(int i=0;i<n;i++) {
				List<Integer> colList=new ArrayList<Integer>();
				int flag=0;
				for(int j=0;j<n;j++) {
					if(i==j)
						trace+=m[i][j];
					if(colList.contains(m[j][i])&&flag==0) {
						dupC++;
						flag=1;
					}
					else
						colList.add(m[j][i]);
					
				}
			}
			System.out.println("Case #"+t+": "+trace+" "+dupR+" "+dupC);
		}
	}
}
