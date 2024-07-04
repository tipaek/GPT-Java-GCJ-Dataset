public class Solution {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in) ;
	public static void main(String[] args) {
		
		int t = scanner.nextInt() ;
		for (int i=1 ; i<=t ;i++) {
			String s = scanner.next();
			System.out.print("Case #"+i+": ") ;
			int po = 0 ;
			for (int j=0 ; j<s.length() ;j++) {
				int d = ((int) s.charAt(j))-48 ;
				int diff = po-d ;
				for (int k=0; k<diff ; k++) {
					System.out.print(')') ;
					po-- ;
				}
				while (po<d) { 
					System.out.print('(') ;
					po++ ;
				}
				System.out.print(d);
			}
			while (po>0) { 
				System.out.print(')') ;
				po-- ;
			}
			System.out.println();
		}
	
	}

}
