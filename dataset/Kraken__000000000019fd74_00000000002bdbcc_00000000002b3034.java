import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		int N=Integer.parseInt(s);
		boolean fg=false;
		String px="", sf="", md="";
		for (int j = 0; j < N; j++) {
			s = scanner.nextLine();
			if (fg) continue;
			int k=0;
			while (s.charAt(k)!='*'){
				if (k>=px.length()) px+=s.charAt(k);
				else if (px.charAt(k)!=s.charAt(k)) {fg=true; break;}
				k++;
			}
			int h=s.length()-1, h2=sf.length()-1;
			while (s.charAt(h)!='*'){
				if (h2<0) sf=s.charAt(h)+sf;
				else if (sf.charAt(h2)!=s.charAt(h)) {fg=true; break;}
				h--; h2--;
			}
			for (int l = k+1; l < h; l++) {
				if (s.charAt(l)!='*') md+=s.charAt(l);
			}
			//System.out.println(px+" - "+sf+" --- "+md);
		}
		if (fg) s="*";
		else s=px+md+sf;
		System.out.println("Case #"+i+": "+ s);
	}
	scanner.close();		
}	
}