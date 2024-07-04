import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static String getNestedString(String S) {
		StringBuilder ans = new StringBuilder();
		S = S +"0";
		int prev = 0;
		for(int i = 0; i < S.length(); i++) {
			int curr = Integer.parseInt(S.charAt(i)+"");
			int num_bracks = Math.abs(curr - prev);
			String brack = curr > prev ?"(": ")";
			for(int j = 0; j < num_bracks; j++){
			ans.append(brack);
			}
			ans.append(""+curr);
			prev = curr;
		}
		ans.deleteCharAt(ans.length() - 1);
		return ans.toString();
	}
	
	public static void main( String args[]) {
		try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for(int i = 1; i <= T; i++){
				String S = br.readLine();
				String s = getNestedString(S);
				System.out.println("Case #" + i + ": "+ s);
			}
		br.close();
		} catch(Exception e) {
			
		}
	}

}
