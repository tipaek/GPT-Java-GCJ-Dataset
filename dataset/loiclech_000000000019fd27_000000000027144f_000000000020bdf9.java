import java.util.Arrays; ;
public class Solution {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in) ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scanner.nextInt() ;
		int max = 24*60+1 ;
		for (int i=1 ; i<=t ;i++) {
			int n = scanner.nextInt();
			char[] choix = new char[n+1] ;
			short[][] activities = new short[n+2][max+1] ;
			for (int j=1 ; j<=n ; j++) {
				int s = scanner.nextInt();
				int e = scanner.nextInt();
				for (int k=s ; k<=e ;k++) {
					activities[j][k]=1 ;
				}
			}
			boolean impossible = false ;
			for (int j=0 ; j<=max ; j++) {
				int p=0 ;
				int k=1 ;
			    while(k<=n) {
					if (activities[k][j]!=0&& activities[p][j]!=k && activities[n+1][j]!=k) {
						if (activities[0][j]!=0 && activities[n+1][j]!=0) {
							impossible = true ;
						} else {
							if (activities[0][j]!=0) {
								p=n+1 ;
							}
							int m=j+1 ;
							while (m<=max && activities[k][m]!=0) {
								activities[p][m] = (short) k;  
								m++ ;
							}
							activities[p][m-1] = 0 ;
							if (choix[k]==0) {
								if (p==0) {
									choix[k]='C' ;
								} else {
									choix[k]='J' ;
								}
							}
						}
					}
					if (impossible) {
						break ;
					}
					k++ ;
				}
				if (impossible) {
					break ;
				}
			}
			System.out.print("Case #"+i+": ");
			if (impossible) {
				System.out.println("IMPOSSIBLE") ;
			} else {
				for (int j=1 ; j<=n ;j++) {
					System.out.print(choix[j]);
				}
				System.out.println();
			}
		}

	}

}
