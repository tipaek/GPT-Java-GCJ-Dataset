import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

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
			boolean in[] = new boolean[n];
			HashMap<String, Integer> hm = new HashMap();
			HashMap<String, String> an = new HashMap();
			HashMap<Integer, Integer> hn = new HashMap();
			
			String res = "";
			int cb = 0, jb = 0;
			
			for(int i = 0; i < n; i ++) {
				
				String str[] = br.readLine().split(" ");
				st[i][0] = Integer.parseInt(str[0]);
				st[i][1] = Integer.parseInt(str[1]);
				
				stt[i] = st[i][0];
				
				hm.put(st[i][0]+"_"+ st[i][1], i);
				hn.put(st[i][0], st[i][1]);
				
				arr[st[i][0]] += 1;
				arr[st[i][1]] -= 1;
			}
			
			Arrays.sort(stt);
			
			for(int i = 0; i < n; i++) {
				in[i] = true;
				
				int end = hn.get(stt[i]);
				
				an.put(stt[i] + "_" + end, "C");
				
				while(i < n && stt[i] < end)
					i++;
				i--;
			}
			
			for(int i = 0; i < n; i++) {
				if(!in[i]) {
					int end = hn.get(stt[i]);
					an.put(stt[i] + "_" + end, "J");
					
					while(i < n && stt[i] < end)
						i++;
					i--;
				}
			}
			for(int i = 0; i < n; i++) {
				if(an.get(st[i][0]+"_"+st[i][1]) != null) {
					res += an.get(st[i][0]+"_"+st[i][1]);
				}else {
					res = "IMPOSSIBLE";
				}
			}
			
			System.out.println(String.format("Case #%d: %s", kk, res));
			kk++;
			
		}
	}

}
