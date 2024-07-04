import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	
	
	public static void main( String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++){
			int N = in.nextInt();
			int K = in.nextInt();
			String s =  K % N == 0? "POSSIBLE":"IMPOSSIBLE";
			System.out.println("Case #" + i + ": "+ s);
		}
		in.close();
	}
}
