
import java.util.Scanner;
public class Solution {
	
	public static void main (String args[]) {
	Scanner inp = new Scanner(System.in);
	int T = inp.nextInt();
	for(int t = 0 ;t < T; t++) {
		String S = inp.next();
		String fin = "";
		int track = 0 ;
		int current = 0;
		for(int s= 0; s<S.length(); s++) {
			current = Integer.parseInt(S.charAt(s)+"") - track;
			if(current>0) {
				for(int i = 0; i <current; i++) {
					track++;
					fin = fin + "(";
					
				}
			}else if(current <0) {
				for(int i = 0; i < (-1*current); i++) {
					track--;
					fin = fin + ")";
			}
		}
			fin = fin + S.charAt(s);
	}
		if(track>0) {
			for(int i = 0 ; i <track ; i++) {
				fin = fin + ")";
			}
		}else if(track<0) {
			for(int i = 0 ; i < (-1*track) ; i++) {
				fin = fin + "(";
			}
		}
		System.out.println("Case #" + (t+1) + ": " + fin );
		
	}

}
}
