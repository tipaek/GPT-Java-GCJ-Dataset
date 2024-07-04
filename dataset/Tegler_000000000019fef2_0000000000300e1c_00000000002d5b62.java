import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(scan.readLine());

		for (int casen = 1; casen <= t; casen++) {

			String[] inp = scan.readLine().split(" ");

			int x = Integer.parseInt(inp[1]);
			int y = Integer.parseInt(inp[0]);

			int w = (int) (1 + Math.floor(Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2)));
			
			int xtemp = x;
			int ytemp = y;
			String out = "";

			for (int i = w-1; i >= 0; i--) {
				if (Math.abs(xtemp) >= Math.abs(ytemp)) {

					if (-Math.signum(xtemp) > 0) {
						out = "S" + out;
						xtemp += Math.pow(2, i)*(1);
					} else {
						out = "N" + out;
						xtemp += Math.pow(2, i) * (-1);
					}

				} else {
					if (-Math.signum(ytemp) > 0) {
						out = "W" + out;
						ytemp += Math.pow(2, i)*(1);
					} else {
						out = "E" + out;
						ytemp += Math.pow(2, i) * (-1);
					}

				}
			}

			if (xtemp == 0 && ytemp == 0) {
				System.out.println("Case #" + casen + ": " + out);
				continue;
			}
			xtemp = x;
			ytemp = y;
			out = "";

			for (int i = w; i >= 0; i--) {
				if (Math.abs(xtemp) >= Math.abs(ytemp)) {

					if (-Math.signum(xtemp) > 0) {
						out = "S" + out;
						xtemp += Math.pow(2, i)*(1);
					} else {
						out = "N" + out;
						xtemp += Math.pow(2, i) * (-1);
					}

				} else {
					if (-Math.signum(ytemp) > 0) {
						out = "W" + out;
						ytemp += Math.pow(2, i)*(1);
					} else {
						out = "E" + out;
						ytemp += Math.pow(2, i) * (-1);
					}

				}
			}

			if (xtemp == 0 && ytemp == 0) {
				System.out.println("Case #" + casen + ": " + out);
				continue;
			}

			System.out.println("Case #" + casen + ": " + "IMPOSSIBLE");
		}

	}

}
