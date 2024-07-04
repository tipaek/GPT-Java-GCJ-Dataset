import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i ++) {
			String s = br.readLine();
			String sp = "";
			for(int j = 0; j < s.length(); j++) {
				int num = Character.getNumericValue(s.charAt(j));
				sp+=paren(true, num)+(num+"")+(paren(false, num));
			}
			while(sp.contains(")(")) {
				sp = sp.replace(")(", "");
			}
			System.out.println("Case #"+(i+1)+": "+sp);
		}
	}
	
	public static String paren(boolean open, int n) {
		String out = "";
		if(open) {
			for(int i = 0; i < n; i++) {
				out+="(";
			}
		} else {
			for(int i = 0; i < n; i++) {
				out+=")";
			}
		}
		return out;
	}

}
