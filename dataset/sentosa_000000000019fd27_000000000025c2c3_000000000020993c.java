import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for ( int test=1; test<=t; test++) {
			int n = in.nextInt();
			int k=0;
			int a[][] = new int[n][n];
			for ( int i=0; i<n; i++) {
				for ( int j=0; j<n; j++) {
					a[i][j] = in.nextInt();
					if ( i == j) {
						k+= a[i][j];
					}
				}
			}
			int r = 0;
			Set<Integer> set = new HashSet<Integer>();
			
			int i=0;
			 
			while ( i<n) {
				for ( int j=0; j<n;j++) {
					if ( set.contains(a[i][j])) {
						r++;
						break;
					}
					else {
						set.add(a[i][j]);
					}
				}
				set = new HashSet<>();
				i++;
			}
			
			
			int c= 0;
			set = new HashSet<Integer>();
			
			int j=0;
			 
			while ( j<n) {
				for ( i=0; i<n;i++) {
					if ( set.contains(a[i][j])) {
						c++;
						break;
					}
					else {
						set.add(a[i][j]);
					}
				}
				set = new HashSet<>();
				j++;
			}
			
			System.out.println("Case #"+test+": "+k+" "+r+" "+c);
		}
		
		

	}

}
