import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int answer = -1;
			for(int i=0;i<str[2].length();i++)
			{
				if(str[2].charAt(i) == 'E') x++;
				else if(str[2].charAt(i) == 'W') x--;
				else if(str[2].charAt(i) == 'N') y++;
				else if(str[2].charAt(i) == 'S') y--;
				if(Math.abs(x) + Math.abs(y) <= (i+1))
				{
					answer = i+1;
					break;
				}
			}
			if(answer == -1) System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
			else System.out.println("Case #" + t + ": " + answer);
		}
	}

}