import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			String[] spl = br.readLine().trim().split("\\s+");
			int X = Integer.parseInt(spl[0]);
			int Y = Integer.parseInt(spl[1]);
			char[] chr =  spl[2].toCharArray();
			int[] arr = new int[chr.length+1];
			arr[0] = X + Y;
			int counter = 1;
			for(char ch : chr) {
				if(ch == 'S') {
					Y -= 1;
				} else if(ch == 'N') {
					Y += 1;
				} else if(ch == 'E') {
					X += 1;
				} else {
					X -= 1;
				}
				arr[counter++] = Math.abs(X) + Math.abs(Y);
			}
			int ret = -1;
			boolean flag = false;
			for(int i = 0; i < arr.length; i++) {
				if(i >= arr[i]) {
					flag = true;
					ret = i;
					break;
				}
			}
			if(flag) {
				System.out.println("Case #" + t + ": " + ret);
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
	}
}
