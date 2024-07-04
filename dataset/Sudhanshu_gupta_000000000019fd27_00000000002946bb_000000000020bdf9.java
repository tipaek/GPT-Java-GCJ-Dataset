import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
			int sst[][] = new int[n][2];
			boolean in[] = new boolean[n];
			boolean dd[] = new boolean[n];
			HashMap<String, String> an = new HashMap();	
			HashMap<String, Integer> hm = new HashMap();			
			String res = "";
			
			for(int i = 0; i < n; i ++) {
				
				String str[] = br.readLine().split(" ");
				st[i][0] = Integer.parseInt(str[0]);
				st[i][1] = Integer.parseInt(str[1]);
				
				sst[i][0] = Integer.parseInt(str[0]);
				sst[i][1] = Integer.parseInt(str[1]);
				
				if(hm.get(st[i][0] + "_" + st[i][1]) != null) {
					dd[i] = true;
				}else {
					hm.put(st[i][0] + "_" + st[i][1], i);
				}
				
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
				Arrays.sort(st, new Comparator<int[]>() { 
	            
		         @Override              
		         public int compare(final int[] entry1, final int[] entry2) {
					if (entry1[0] > entry2[0]) 
					    return 1; 
					else
					    return -1; 
		        }
		        });
				
				for(int i = 0; i < n; i++) {
					
					in[i] = true;
					int end = st[i][1];
					an.put(st[i][0] + "_" + end, "C");
					
					while(i < n && st[i][0] < end)
						i++;
					i--;
				}
				for(int i = 0; i < n; i++) {
					if(an.get(sst[i][0] + "_" + sst[i][1]) != null && !dd[i]) {
						res += "C";
					}else {
						res += "J";
					}
				}
			}
			
			System.out.println(String.format("Case #%d: %s", kk, res));
			kk++;
			
		}
	}

}
