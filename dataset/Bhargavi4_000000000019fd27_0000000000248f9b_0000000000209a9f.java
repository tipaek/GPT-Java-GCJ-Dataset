import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String tests = br.readLine();
		if(tests == null)return;

		int t = Integer.parseInt(tests);
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=t;i++) {
            sb.append("case #"+i+": ");
			String str = br.readLine();
			if(str == null)return;
			str = str.trim();
			int o = 0;
			
			int[] num = new int[str.length()];
			for (int k = 0; k < str. length(); k++){
			   num[k] = str.charAt(k) - '0';
			}
			
			String out = open(num[0]);
			o=num[0];
			sb.append(out).append(num[0]);
			for(int k=1;k < str.length();k++) {
				
				if(o > num[k]) {
					
					String s = close(o-num[k]);
					sb.append(s).append(num[k]);
					
					o = o - (o-num[k]);				
				}else if(o<num[k]) {
					String s = open(num[k]-o);
					sb.append(s).append(num[k]);
					o = o + (num[k]-o);	
				}else {
					sb.append(num[k]);
				}
			}
			
			sb.append(close(o));
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString().trim());
	}

	
	private static String close(int c) {
		String close="";
		int tempC = c;
		while(tempC-- > 0) {
			close = close + ")";
		}
		
		return close;
	}
	
	private static String open(int o) {
		String open="";
		int tempC = o;
		while(tempC-- > 0) {
			open = open + "(";
		}
		
		return open;
	}
}