
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	int T;
	int[] X;
	int[] Y;
	String[] path;
	
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			T = Integer.parseInt(br.readLine());
			
			X = new int[T+1];
			Y = new int[T+1];
			path = new String[T+1];
			
			for (int i=1; i<=T; i++) {
				String[] split = br.readLine().split("\\s");
				X[i] = Integer.parseInt(split[0]);
				Y[i] = Integer.parseInt(split[1]);
				path[i] = split[2];
			}
			
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void solve(int index) {
		int x = X[index];
		int y = Y[index];
		String pa = path[index];
		
		char[] pathArr = pa.toCharArray();
		
		int possibleCountToWalk = 0;
		for (int i=0; i<pathArr.length; i++) {
			char direction = pathArr[i];
			switch (direction) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
				default:
			}
			possibleCountToWalk++;
			
			int howFar = Math.abs(x) + Math.abs(y);
			
			if (possibleCountToWalk >= howFar) {
				System.out.println("Case #"+index+": "+possibleCountToWalk);
				return;
			}
		}
		System.out.println("Case #"+index+": IMPOSSIBLE");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution m = new Solution();
		m.input();
		for (int i=1; i<=m.T;i++) {
			m.solve(i);
		}
	}

}
