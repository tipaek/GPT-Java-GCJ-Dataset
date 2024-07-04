import java.io.*;
public class Solution {
	public static void main(String [] args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(cin.readLine());
		String[] results = new String[N];
		for(int r = 0; r < results.length; r++) {
			int open = 0;
			String out = "";
			String seq = cin.readLine();
			for(int i = 0; i < seq.length(); i++) {
				int num = Integer.parseInt(seq.charAt(i) + "");
				while(open > num) {
					out+=')';
					open--;
				}
				while(open < num) {
					out+='(';
					open++;
				}
				out+= num;
			}
			while(open > 0) {
				out+=')';
				open--;
			}
			results[r] = out;
		}
		for(int i = 0; i < results.length; i++)
			System.out.println("Case #" + (i+1)+ ": " + results[i]);
	}
}
