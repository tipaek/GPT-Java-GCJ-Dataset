package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Google_Code_Jam_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			
			int open_cnt = 0;
			
			char[] array = br.readLine().toCharArray();
			
			for(int i = 0; i < array.length; i++) {
				int temp = array[i] - '0';
				
				if(temp > open_cnt) {
					while(temp > open_cnt) {
						sb.append("(");
						open_cnt++;
					}
					sb.append(temp);
				}
				else {
					while(temp < open_cnt) {
						sb.append(")");
						open_cnt--;
					}
					sb.append(temp);
				}
			}
			while(open_cnt > 0) {
				sb.append(")");
				open_cnt--;
			}
			
			System.out.println("Case #" + tc + ": " + sb.toString());
		}
	}
}
