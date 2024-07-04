
/**
 * Round 1C 2020 - Code Jam 2020
 * 01 Overexcited Fan
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Solution {
	public static int caseNum;
	public static int px, py;
	public static String mStr;
	public static int[] cache;
	public static int limit;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./src/cj2020/round01/c01/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		caseNum = Integer.parseInt(br.readLine().trim());
		
		StringTokenizer st;
		

		for (int cn = 1; cn <= caseNum; ++cn) {
			cache = new int[1001];
			st = new StringTokenizer(br.readLine());
			px = Integer.parseInt(st.nextToken());
			py = Integer.parseInt(st.nextToken());
			mStr = st.nextToken();
			limit = mStr.length();
			
//			System.out.println("limit : " + limit);
			
			int answer = move(px, py, px + px, py - py, 0);
			
			if(answer < 1001) {				
				System.out.println("Case #" + cn + ": " + answer);
			} else {
				System.out.println("Case #" + cn + ": IMPOSSIBLE");
				
			}
		
		}
	}
	
	
	public static int move(int px, int py, int mx, int my, int cnt) {
		if(py == my && px == mx) return 0;

		if(cnt == limit) return 99999;
		
		if(cache[cnt] > 0) return cache[cnt];
		
		int ret = 99999;
		
		String direction = mStr.substring(cnt, cnt + 1);
		
		if(direction.equals("S")) --py;
		if(direction.equals("N")) ++py;
		if(direction.equals("E")) ++px;
		if(direction.equals("W")) --px;
		
//		System.out.println("direction : " + direction + " | py : " + py + " | px : " + px + " | my : " + my + " | mx : " + mx + " | cnt : " + cnt);
		
		if(py > my) ret = 1 + move(px, py, mx, my + 1, cnt + 1);
		else if(py < my){
			ret = Math.min(ret,  1 + move(px, py, mx, my - 1, cnt + 1));
		} else {
			ret = Math.min(ret,  1 + move(px, py, mx, my, cnt + 1));
		}
		
//		System.out.println("ret 1 : " + ret);
		
		if(px > mx) ret = Math.min(ret, 1 + move(px, py, mx + 1, my, cnt + 1));
		else if(px < mx){
			ret = Math.min(ret,  1 + move(px, py, mx - 1, my, cnt + 1));
		} else {
			ret = Math.min(ret,  1 + move(px, py, mx, my, cnt + 1));
		}
		
//		System.out.println("ret 2 : " + ret);

		return ret;
		
	}
}
