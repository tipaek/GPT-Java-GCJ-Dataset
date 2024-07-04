import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		int kk = 1;
		while(tc -- > 0) {
			
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[1441];
			int stt[] = new int[n];
			int st[][] = new int[n][2];
			char crr[] = new char[n];
			
			String res = "";
			int cb = 0, jb = 0;
			
			for(int i = 0; i < n; i ++) {
				
				String str[] = br.readLine().split(" ");
				st[i][0] = Integer.parseInt(str[0]);
				st[i][1] = Integer.parseInt(str[1]);
				
				stt[i] = st[i][0];
				
				arr[st[i][0]] += 1;
				arr[st[i][1]] -= 1;
			}
			
			for(int i = 1; i < 1441; i++) {
				arr[i] += arr[i-1];
				if(arr[i] > 2) {
					res = "IMPOSSIBLE";
					break;
				}
			}
			if(!res.equals("IMPOSSIBLE")) {
				res = "C";
				crr[0] = 'C';
				for(int i = 1; i < n; i++) {
					char f = 'C';
					for(int j = 0; j < i; j++) {
						if( Math.min(st[i][1], st[j][1]) - Math.max(st[i][0], st[j][0]) > 0) {
							
							f = crr[j] == 'C' ? 'J' : 'C';
							break;
						}
					}
					crr[i] = f;
					res += f;
				}
				
			}
			
			System.out.println(String.format("Case #%d: %s", kk, res));
			kk++;
			
		}
	}

}
