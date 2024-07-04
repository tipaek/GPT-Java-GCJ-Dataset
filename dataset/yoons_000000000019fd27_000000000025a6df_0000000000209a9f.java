/**
 * Nesting Depth
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int caseNum;
	public static String str;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./src/cj2020/qualification02/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		caseNum = Integer.parseInt(br.readLine().trim());

		for (int cn = 1; cn <= caseNum; ++cn) {
			str = br.readLine();
			
			int leng = str.length();
			
			String answer = "";
			
			String nowStr = str.substring(0, 1);
			int now = Integer.parseInt(nowStr);
			
			for(int p = 0; p < now; ++p) {
				answer += "(";
			}
			
			answer += nowStr;
			
			String nextStr = "";
			int next = 0;
			if(leng == 1) {
				for(int p = 0; p < now; ++p) {
					answer += ")";
				}
			} else {
				for(int i = 1; i < leng; ++i) {
					nextStr = str.substring(i, i+1);
					next = Integer.parseInt(nextStr);
//					System.out.println("now : " + now + " | next : " + next);
					if(now > next) {
						for(int p = 0; p < now - next; ++p) {
							answer += ")";
						}
						answer += nextStr;
					}else if(now < next){
						for(int p = 0; p < next - now; ++p) {
							answer += "(";
						}
						answer += nextStr;
					} else {
						answer += nextStr;
					}
					nowStr = nextStr;
					now = next;
				}
				nextStr = str.substring(leng - 1, leng);
				next = Integer.parseInt(nextStr);
				
				for(int p = 0; p < next; ++p) {
					answer += ")";
				}
			}
			
			
			System.out.println("Case #" + cn + ": " + answer);
		}
	}
	
	

}
