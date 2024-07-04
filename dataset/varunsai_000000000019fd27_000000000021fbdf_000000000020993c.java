import java.util.*;
import java.io.*;
class Solution {

	private static Scanner ob;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ob = new Scanner(System.in);
			int test=ob.nextInt();
			
			for(int t = 1;t<=test;t++) {
				int n = ob.nextInt();
				int a[][] = new int[n][n];
				int k=0;
				Set<Integer> set = new HashSet<>();
				Set<Integer> set2 = new HashSet<>();
				for(int i=0;i<a.length;i++) {
					for(int j = 0;j<a[i].length;j++) {
						a[i][j]=ob.nextInt();
						if(i==j) {
							k+=a[i][j];
						}
						
					}
				}
				int r=0;
				int c=0;
				int cnt=0;
				for(int i=0;i<a.length;i++) {
					for(int j=0;j<a[i].length;j++) {
						set.add(a[i][j]);
						set2.add(a[j][i]);
						cnt++;
						if(cnt%n==0) {
							if(set.size()!=n) {
								r++;
							}
							if(set2.size()!=n) {
								c++;	
							}
							set.clear();
							set2.clear();
						}
					}
				}
				System.out.println("Case #"+t+": "+k+" "+r+" "+c);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
