import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            long numX = input.nextLong();
            long numY = input.nextLong();
            String answer = solver(numX, numY);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static String solver(long numX, long numY) {
    	String answer = "";
    	if (numX % 2 == 0 && numY % 2 == 0) {
    		return "IMPOSSIBLE";
    	}
    	if (numX % 2 != 0 && numY % 2 != 0) {
    		return "IMPOSSIBLE";
    	}

    	int xJou = 0;
    	int yJou = 0;

    	boolean isXMinus = false;
    	boolean isYMinus = false;

    	if (numX < 0) {
    		isXMinus = true;
    		numX = numX * (-1);
    	}
    	if (numY < 0) {
    		isYMinus = true;
    		numY = numY * (-1);
    	}

    	while (true) {
    		double x = Math.pow(2, xJou);
    		if (numX <= x) {
    			break;
    		}
    		xJou++;
    	}
    	while (true) {
    		double y = Math.pow(2, yJou);
    		if (numY <= y) {
    			break;
    		}
    		yJou++;
    	}

		String xPos = isXMinus?"W":"E";
		String xNeg = isXMinus?"E":"W";
		String yPos = isYMinus?"S":"N";
		String yNeg = isYMinus?"N":"S";

		String xBin = Long.toBinaryString(numX);
		long numX_ = (long)(Math.pow(2, xJou) - numX);
		String xBin_ = Long.toBinaryString(numX_);
		String yBin = Long.toBinaryString(numY);
		long numY_ = (long)(Math.pow(2, yJou) - numY);
		String yBin_ = Long.toBinaryString(numY_);

		while (true) {
			if (xBin.length() < Long.toBinaryString(numX>numY?numX:numY).length()) {
				xBin = "0" + xBin;
			} else {
				break;
			}
		}

		String num00 = Long.toBinaryString(numX ^ numY);
		while (true) {
			if (num00.length() < Long.toBinaryString(numX>numY?numX:numY).length()) {
				num00 = "0" + num00;
			} else {
				break;
			}
		}
		String num0_ = Long.toBinaryString(numX ^ numY_);
		while (true) {
			if (num0_.length() < Long.toBinaryString(numX>numY_?numX:numY_).length()) {
				num0_ = "0" + num0_;
			} else {
				break;
			}
		}
		String num_0 = Long.toBinaryString(numX_ ^ numY);
		while (true) {
			if (num_0.length() < Long.toBinaryString(numX_>numY?numX_:numY).length()) {
				num_0 = "0" + num_0;
			} else {
				break;
			}
		}
		String num__ = Long.toBinaryString(numX_ ^ numY_);
		while (true) {
			if (num__.length() < Long.toBinaryString(numX_>numY_?numX_:numY_).length()) {
				num__ = "0" + num__;
			} else {
				break;
			}
		}

		if (!num00.contains("0")) {
			String ans = xBin.replace("1", xPos);
			ans = ans.replace("0", yPos);
			StringBuffer sb = new StringBuffer(ans);
			String dst = sb.reverse().toString();
			return dst;
		} else if (!num0_.contains("0")) {
			String ans = xBin.replace("1", xPos);
			ans = ans.replace("0", yNeg);
			StringBuffer sb = new StringBuffer(ans);
			String dst = sb.reverse().toString();
			dst = dst + yPos;
			return dst;
		} else if (!num_0.contains("0")) {
			String ans = xBin.replace("1", xNeg);
			ans = ans.replace("0", yPos);
			StringBuffer sb = new StringBuffer(ans);
			String dst = sb.reverse().toString();
			dst = dst + xPos;
			return dst;
		} else if (!num__.contains("0")) {
			return "IMPOSSIBLE";
		}

    	return "IMPOSSIBLE";
    }
}
