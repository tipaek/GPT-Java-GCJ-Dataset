import java.util.Arrays; ;
public class Solution {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in) ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scanner.nextInt() ;
		int max = 15 ;// 24*60+1 ;
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
		if (e==s+1) {
			if (personne[s]!=0&& personne[e]==personne[s]) {
				return false ;
			} else if (personne[s]!=0 && personne[e]!=0){
				return false ;
			} else {	
				return true ;
			}
		}
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
		int pa = 0 ;
		int sd = s ;
		if (taches[0][s]==0||(s<taches[0].length-1&&taches[0][s+1]==0)) {
			pa = 0 ;
			while (s>=0&&taches[1][s]!=0) {
				s-- ;
			}
			s++ ;
		} else if (taches[1][s]==0||(s<taches[1].length-1&&taches[1][s+1]==0)) {
			pa = 1 ;
			while (s>=0&&taches[0][s]!=0) {
				s-- ;
			}
			s++ ;
		} else {
			return false ;
		}
		int tcourante1 = 0 ;
		int tcourante2 = 0;
	    boolean end = false  ;
		while (s<=e || (s>e && s<taches[0].length && !end )) {
			if (s<taches[0].length-1&&taches[0][s]!=0&&taches[1][s]!=0&&taches[0][s+1]!=0&&taches[1][s+1]==0) {
				return false ;
			}
			if (taches[pa][s]==0) {
				if (taches[1-pa][s]!=0) {
					taches[pa][s]=taches[1-pa][s] ;
					taches[1-pa][s]=0 ;
					if (pa==0) {
						choix[taches[pa][s]] = 'C' ;
					} else {
						choix[taches[pa][s]] = 'J' ;
					}
				}  else {
					end = true ;
				}
			} else if (taches[1-pa][s]!=0){
				short temp = taches[pa][s] ;
				taches[pa][s]=taches[1-pa][s] ;
				taches[1-pa][s]=temp ;
				if (taches[pa][s]!=tcourante2 || taches[1-pa][s]!=tcourante1) {
					char tempc = choix[taches[pa][s]] ;
					choix[taches[pa][s]] = choix[taches[1-pa][s]] ;
					choix[taches[1-pa][s]] = tempc ;
					tcourante1 = taches[1-pa][s] ;
					tcourante2 = taches[pa][s] ;
					end = false ;
				}
			} else {
				end = true ;
			}
			s++ ;
		}
		for (int k=sd ; k<=e ; k++) {
			if (taches[1-pa][k]==0) {
				taches[1-pa][k]=(short) ntache ;
			} else {
				return false ;
			}
		}
		if (pa==0) {
			choix[ntache] = 'J' ;
		} else {
			choix[ntache] = 'C' ;
		}
		return true ;
	}
}
