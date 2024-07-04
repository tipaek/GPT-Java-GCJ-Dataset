import java.io.*;

public class Solution {
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			String s = stdReader.readLine();
			StringBuilder sb = new StringBuilder();
			int now = 0;
			for(int j = 0 ; j < s.length(); j++) {
				int num = s.charAt(j) - 48;
				if(num > now) {
					for(int k = 0 ; k < num - now ; k++) {
						sb.append("(");
					}
				}
				if(num < now) {
					for(int k = 0 ; k < now - num ; k++) {
						sb.append(")");
					}
				}
				sb.append(num);
				now = num;
			}
			for(int j = now ; j > 0 ; j--) {
				sb.append(")");
			}
			System.out.println("Case #"+(i+1)+": "+sb.toString());
		}
		stdReader.close();
	}
}
