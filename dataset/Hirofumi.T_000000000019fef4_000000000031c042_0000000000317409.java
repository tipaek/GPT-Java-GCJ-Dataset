import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numX = input.nextInt();
            int numY = input.nextInt();
            String tour = input.next();
            String answer = solver(numX, numY, tour);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static String solver(int numX, int numY, String tour) {
    	if (numX == 0 && numY == 0) {
    		return "0";
    	}
    	for (int i = 1; i <= tour.length(); i++) {
    		String s = String.valueOf(tour.charAt(i-1));
    		switch (s) {
    			case "N":
    				numY = numY + 1;
    				break;
    			case "S":
    				numY = numY - 1;
    				break;
    			case "W":
    				numX = numX - 1;
    				break;
    			case "E":
    				numX = numX + 1;
    				break;
    			default:
    				break;
    		}
    		int x = numX;
    		int y = numY;
    		if (x <= 0) {
    			x = x * (-1);
    		}
    		if (y <= 0) {
    			y = y * (-1);
    		}
    		int res = i - (x + y);
    		if (res < 0) {
    	    	continue;
    		} else {
    			return String.valueOf(i);
    		}
    	}

    	return "IMPOSSIBLE";
    }
}
