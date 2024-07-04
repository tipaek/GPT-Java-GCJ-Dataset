import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		String[] tok=s.split(" ");
		int X=Integer.parseInt(tok[0]);
		int Y=Integer.parseInt(tok[1]);
		int d=Math.abs(Y)+Math.abs(X), j=0;
		for (j = 0; j < tok[2].length() && d>j; j++) {
			switch (tok[2].charAt(j)) {
			 	case 'N': Y++; break;
				case 'S': Y--; break; 
				case 'E': X++; break;
				case 'W': X--; break;
			}
			d=Math.abs(Y)+Math.abs(X);
		}
		if (d>j) s="IMPOSSIBLE";
		else s=""+j;
		System.out.println("Case #"+i+": "+ s);
	}
	scanner.close();		
}	
}