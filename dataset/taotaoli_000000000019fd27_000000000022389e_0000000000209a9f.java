import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		Scanner file = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = file.nextInt();
		file.nextLine();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": " + method(file.nextLine()));
		}
	}
	
	public static String method(String k) {
		ArrayList<Character> pp = new ArrayList<Character>();
		String urmom = "";
		urmom += k;
		for (int i = 0; i < urmom.length(); i++) {
			pp.add(urmom.charAt(i));
		}
		for (int i = pp.size() - 1; i >= 0; i--) {
			for (int j = 0; j < pp.get(i) - 48; j++) {
				pp.add(i + 1, ')');
			}
		}
		for (int i = pp.size() - 1; i >= 0; i--) {
			for (int j = 0; j < pp.get(i) - 48; j++) {
				pp.add(i, '(');
				i++;
			}
		}
		
		
		String ppp = "";
		for (int i = 0; i < pp.size(); i++) {
			ppp += pp.get(i);
		}
		return ppp;
	}
}
