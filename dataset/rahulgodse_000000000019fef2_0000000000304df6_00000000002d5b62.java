import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	
	private static int x = 0;
	private static int y = 0;
	
	private static String direction = null;
	private static int steps = 99;

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				String[] temp = bf.readLine().split(" ");
				
				x = Integer.parseInt(temp[0]);
				y = Integer.parseInt(temp[1]);
				
				steps = 99;
				direction = "";
				
				boolean[] X = convertToBoolean(Math.abs(x));
				boolean[] invX = x!=0 ? inverse(X) : new boolean[32];
				
				boolean[] Y = convertToBoolean(Math.abs(y));
				boolean[] invY = y!=0 ? inverse(Y) : new boolean[32];
				
				boolean possible = false;
				
				possible = match(X, Y, true, true);
				possible = y != 0 ? possible || match(X, invY, true, false) : possible;
				possible = x != 0 ? possible || match(invX, Y, false, true) : possible;
				possible = x!=0 && y!=0 ? possible || match(invX, invY, false, false) : possible;
							
				System.out.println("Case #" + (i+1) + ": " + (possible ? direction : "IMPOSSIBLE"));
			}
			
			
		} catch (Exception e) {
			
		}
		
	}

	private static boolean match(boolean[] a, boolean[] b, boolean fwdA, boolean fwdB) {
		
		String dir = "";
		int s = 0;
		boolean result = true;
		
		boolean start = false;
		boolean firstA = false;
		boolean firstB = false;
		for (int i=0; i<32; i++) {
			if (!start  && (a[i] || b[i])) {
				start = true;
			}
			if (start) {
				if ((a[i] && b[i]) || (!a[i] && !b[i])) {
					result = false;
					break;
				} else if (a[i]) {
					boolean negative = (x<0);
					if (!fwdA) negative = !negative;
					if (!firstA && !fwdA) negative = !negative;
					dir = (negative ? "W" : "E") + dir;
					firstA = true;
					s++;
				} else if (b[i]) {
					boolean negative = (y<0);
					if (!fwdB) negative = !negative;
					if (!firstB && !fwdB) negative = !negative;
					dir = (negative ? "S" : "N") + dir;
					firstB = true;
					s++;
				}
			}
			
		}
		
		if (result) {
			if (s < steps) {
				steps = s;
				direction = dir;
			}
		}
		
		return result;
	}

	private static boolean[] inverse(boolean[] a) {
		boolean[] result = new boolean[32];
		boolean found = false;
		
		for (int i=0; i<32; i++) {
			if (found) {
				result[i] = !a[i];
			} else if (a[i]) {
				result[i] = false;
				result[i-1] = true;
				found = true;
			}
		}
		
		for (int i=31; i>=0; i--) {
			if (result[i]) {
				result[i] = false;
			} else {
				result[i] = true;
				break;
			}
		}
		
		return result;
	}

	private static boolean[] convertToBoolean(int a) {
		boolean[] result = new boolean[32];
		
		int temp = a;
		int pow = 31;
		
		while (temp > 0) {
			
			if (temp >= Math.pow(2, pow)) {
				result[31 - pow] = true;
				temp = temp - (int) Math.pow(2, pow);
			}
  			pow--;
		}
		
		return result;
	}
	
}
