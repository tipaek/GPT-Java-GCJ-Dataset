import java.util.Scanner; 

public class Solution {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	int T=Integer.parseInt(s);
	for (int i = 1; i <= T; i++) {
		s = scanner.nextLine();
		String ns="";
		int old=0;
		for (int j = 0; j < s.length(); j++) {
		    int v=s.charAt(j)-'0';
		    for (int h = old; h < v; h++) ns+="(";
		    for (int h = old; h > v; h--) ns+=")";
		    ns+=v;
		    old=v;
		}
		for (int h = old; h > 0; h--) ns+=")";
		System.out.println("Case #"+i+": "+ ns);
	}
	scanner.close();		
}	
}