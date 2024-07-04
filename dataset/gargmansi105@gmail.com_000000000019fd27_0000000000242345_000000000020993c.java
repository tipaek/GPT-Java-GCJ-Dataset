import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int q=1;q<=test;q++) {
			int n=sc.nextInt();
			int trace=0;
			int[][] ma=new int[n][n];
			for (int i = 0; i < ma.length; i++) {
				for (int j = 0; j < ma.length; j++) {
					ma[i][j]=sc.nextInt();
					if(i==j) {
						trace+=ma[i][j];
					}
				}
			}
			Set<Integer> set=new HashSet<Integer>();
			int ro=0,co=0;
			for (int i = 0; i < ma.length; i++) {
				boolean f=false;
				for (int j = 0; j < ma.length; j++) {
					if(set.contains(ma[i][j])) {
						f=true;
					}else {
						set.add(ma[i][j]);
					}
					
				}
				ro=f?ro+1:ro;
				set.clear();
			}
			
			for (int i = 0; i < ma.length; i++) {
				boolean f=false;
				for (int j = 0; j < ma.length; j++) {
					if(set.contains(ma[j][i])) {
						f=true;
					}else {
						set.add(ma[j][i]);
					}
					
				}
				co=f?co+1:co;
				set.clear();
			}
			
			System.out.println("Case #"+q+": "+trace+" "+ro+" "+co);
		}

	}

}
