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
			short[][] activities = new short[n+1][2] ;
			short[][] taches = new short[2][max+1];
			for (int j=1 ; j<=n ; j++) {
				activities[j][0] =  scanner.nextShort(); 
				activities[j][1] =  scanner.nextShort(); 
			}
			boolean impossible = false ;
			for (int j=1 ; j<=n ; j++) {
				if (estLibre(taches[0],activities[j][0],activities[j][1])) {
					choix[j] = 'C' ;
					remplir(taches[0],activities[j][0],activities[j][1],j) ;
 				} else if (estLibre(taches[1],activities[j][0],activities[j][1])) {
					choix[j] = 'J' ;
					remplir(taches[1],activities[j][0],activities[j][1],j) ;
 				} else if (!changer(taches,choix,activities[j][0],activities[j][1],j)) {
 					impossible = true ;
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

	public static boolean estLibre(short[] personne, int s, int e) {
		int i=s+1 ;
		while (i<e && personne[i]==0) {
			i++ ;
		}
		return i==e ;
	}
	public static void remplir(short[] personne, int s, int e, int k) {
		if (personne[s]==0) {
			personne[s]=(short) k ;
		}
		for (int i=s+1 ; i<e ; i++) {
			personne[i]=(short) k ;
		}
		if (personne[e]==0) {
			personne[e]=(short) k ;
		}
	}
	
	public static boolean changer(short[][] taches, char[] choix, int s, int e, int ntache) {
		int s2 = s ;
		if (taches[0][s]!=0) {
			int i=s-1 ;
			while (i>=0 && taches[0][i]==taches[0][s]) {
				i-- ;
			}
			s2 = i+1 ;
		}
		int e2 = e ;
		if (taches[0][e]!=0) {
			int i=e+1 ;
			while (i<taches[0].length && taches[0][i]==taches[0][e]) {
				i++ ;
			}
			e2 = i-1 ;
			
		}
		for (int i=s2 ; i<=e2; i++) {
			if (taches[0][i]!=0 && taches[1][i]!=0) {
				if (i>0 && taches[0][i-1]==taches[0][i]&&taches[1][i-1]==taches[1][i]) {
					return false ;
				} else if (i<taches.length-1 && taches[0][i+1]==taches[0][i]&&taches[1][i+1]==taches[1][i]) {
					return false ;
				}
			}
		}
		for (int i=s2 ; i<=e2; i++) {
			if (taches[0][i]!=0 && taches[1][i]!=0) {
				if (taches[1][i]!=0) {
					taches[0][i]=taches[1][i] ;
					taches[1][i]=0 ;
					choix[taches[1][i]] = 'C' ;
				}
			}
		}
		for (int i=s ; i<=e ;i++) {
			taches[1][i]=(short) ntache;
		}
		return true ;
	}
}
