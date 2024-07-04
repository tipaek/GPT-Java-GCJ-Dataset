import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			long X = in.nextLong();
			long Y = in.nextLong();


			String s = solve(X,Y,0,0,0);
			s = s==null ? "IMPOSSIBLE" : s;

			System.out.println(String.format("Case #%d: %s",t+1,s));
		}

		in.close();
	}

	public static String solve(long X, long Y, long Xi, long Yi, long step) {
		long powcurr = (int) Math.pow(2, step);
		long pownext = powcurr*2;

		// on target
		if (X==Xi && Y==Yi)
			return "";

		// one step to the target
		if (Math.abs(X-Xi) == 0 && Y-Yi == powcurr)
			return "N";
		if (Math.abs(X-Xi) == 0 && Y-Yi == -powcurr)
			return "S";
		if (Math.abs(Y-Yi) == 0 && X-Xi == powcurr)
			return "E";
		if (Math.abs(Y-Yi) == 0 && X-Xi == -powcurr)
			return "W";


		if (Math.abs(X-Xi)%pownext
				== Math.abs(Y-Yi)%pownext)
			return null;

		if (Math.abs(X-Xi)%pownext == 0) {
			String s = solve(X,Y,Xi,Yi-powcurr,step+1);
			if (s == null)
				return "N"+solve(X,Y,Xi,Yi+powcurr,step+1);
			return "S"+s;
		}
		
		String s = solve(X,Y,Xi-powcurr,Yi,step+1);
		if (s == null)
			return "E"+solve(X,Y,Xi+powcurr,Yi,step+1);
		return "W"+s;
	}

}
