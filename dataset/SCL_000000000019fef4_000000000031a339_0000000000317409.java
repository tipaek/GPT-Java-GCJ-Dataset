import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception{
		//BufferedReader input = new BufferedReader(new FileReader("../GCJ2018/io/input.txt"));
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		//pw = new PrintWriter(new FileWriter("../GCJ2018/io/output.txt"));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			String[] s = stdReader.readLine().split(" ");
			int px = Integer.parseInt(s[0]);
			int py = Integer.parseInt(s[1]);
			String str = s[2];
			int turn = -1;
			int x = 0;
			int y = 0;
			for(int j = 0 ; j < str.length() ; j++) {
				if(str.charAt(j) == 'W') {
					px--;
				}else if(str.charAt(j) == 'E') {
					px++;
				}else if(str.charAt(j) == 'S') {
					py--;
				}else if(str.charAt(j) == 'N') {
					py++;
				}
			}
			if(Math.abs(px - x) + Math.abs(py - y) <= str.length())turn = str.length();
			for(int j = str.length() - 1 ; j >= 0 ; j--) {
				if(str.charAt(j) == 'W') {
					px++;
				}else if(str.charAt(j) == 'E') {
					px--;
				}else if(str.charAt(j) == 'S') {
					py++;
				}else if(str.charAt(j) == 'N') {
					py--;
				}
				if(Math.abs(px - x) + Math.abs(py - y) <= j)turn = j;
			}
			if(turn != -1) {
				System.out.println("Case #"+(i+1)+": "+turn);
			}else {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
		stdReader.close();
	}
}
