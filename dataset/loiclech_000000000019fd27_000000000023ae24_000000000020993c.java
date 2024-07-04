import java.util.HashSet ;

public class Solution {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in) ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scanner.nextInt();
		for (int i=1 ; i<=t ; i++) {
			int n = scanner.nextInt();
			int[][] matrix = new int[n][n];
			
			for (int l=0 ; l<n ; l++) {
				for (int j=0 ; j<n ; j++) {
					matrix[l][j] = scanner.nextInt();
				}
			}
			int k = 0 ;
			int r = 0 ;
			int c = 0 ;
			for (int j=0 ; j<n ; j++) {
				HashSet<Integer> ligne = new HashSet<Integer>() ;
				HashSet<Integer> colonne = new HashSet<Integer>() ;
				k = k + matrix[j][j] ;
				for (int m=0 ; m<n ; m++) {
					ligne.add(matrix[j][m]) ;
					colonne.add(matrix[m][j]) ;
				}
				if (ligne.size()!=n) {
					r++ ;
				}
				if (colonne.size()!=n) {
					c++ ;
				}
			}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c) ;
		}
		
	}

}
