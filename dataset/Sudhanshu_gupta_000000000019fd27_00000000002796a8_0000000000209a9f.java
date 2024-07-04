import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
	static int op = 0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		int kk = 1;
		while(tc -- > 0) {
			
			char crr[] = br.readLine().trim().toCharArray();
			String res = "";
			op = 0;
			for(char c : crr) {
				int x = Integer.parseInt( c + "");
				res = add(x, res);
			}
			while(op != 0) {
				res += ")";
				op--;
			}
			
			System.out.println(String.format("Case #%d: %s", kk, res));
			kk++;
			
		}
	}
	
	static String add(int x, String res) {
		
		if(op > x) {
			while(op != x) {
				res += ")";
				op--;
			}
		}
		if(op < x) {
			while(op != x) {
				res += "(";
				op++;
			}
		}
		res += x;
		return res;
	}

}
