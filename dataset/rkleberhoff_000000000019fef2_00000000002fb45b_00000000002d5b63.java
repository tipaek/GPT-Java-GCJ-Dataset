import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	enum Hit { CENTER, HIT, MISS };
	
	static final int DIM = 1000000000;
	
	static class FoundException extends RuntimeException {
		int x;
		int y;
		public FoundException(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int x=1; x<=t; x++) {
        	solve(in, a, b);
        }
        in.close();
    }

	private static void solve(Scanner in, int aMin, int bMax) {
		try {
			Point someHit = findInside(in);
			
			int xmin = searchXdown(in, someHit.y, someHit.x, -DIM);
			int xmax = searchXup(in, someHit.y, someHit.x, DIM);
			int xcenter = (xmin + xmax) / 2;
			
			int ymin = searchYdown(in, xcenter, someHit.y, -DIM);
			int ymax = searchYup(in, xcenter, someHit.y, DIM);
			int ycenter = (ymin + ymax) / 2;
			for (int x=xcenter-1; x<=xcenter+1; x++) {
				for (int y=ycenter-1; y<=ycenter+1; y++) {
					getHit(in, x, y);
				}
			}
		} catch (FoundException e) {
			
		}
	}
    
    private static Point findInside(Scanner in) {
    	final int factor = 100000000;
    	for (int y=-5; y<=5; y++) {
    		for (int x=-5; x<=5; x++) {
    			if (getHit(in, factor * x, factor * y) == Hit.HIT) {
    				return new Point(factor * x, factor * y);
    			}
    	    }
    	}
    	throw new RuntimeException("No inside found");
    }
    	
    // x0 has hit, xLast is last possible hit
    private static int searchXdown(Scanner in, int y, int x0, int xLast) {
    	int delta = x0 - xLast;
		if (delta > 1) {
    		int x1 = x0 - delta/2;
    		if (getHit(in, x1, y) == Hit.HIT) {
    			return searchXdown(in, y, x1, xLast);
    		} else {
    			return searchXdown(in, y, x0, x1+1);
    		}
    	} else if (delta == 0) {
    		return x0;
    	} else if (getHit(in, xLast, y) == Hit.HIT) {
    		return xLast;
    	} else {
    		return x0;
    	}
    }
    
    // x0 has hit, xLast is last possible hit
    private static int searchXup(Scanner in, int y, int x0, int xLast) {
    	int delta = xLast - x0;
		if (delta > 1) {
    		int x1 = x0 + delta/2;
    		if (getHit(in, x1, y) == Hit.HIT) {
    			return searchXup(in, y, x1, xLast);
    		} else {
    			return searchXup(in, y, x0, x1-1);
    		}
    	} else if (delta == 0) {
    		return x0;
    	} else if (getHit(in, xLast, y) == Hit.HIT) {
    		return xLast;
    	} else {
    		return x0;
    	}
    }
    
    // y0 has hit, yLast is last possible hit
    private static int searchYdown(Scanner in, int x, int y0, int yLast) {
    	int delta = y0 - yLast;
		if (delta > 1) {
    		int y1 = y0 - delta/2;
    		if (getHit(in, x, y1) == Hit.HIT) {
    			return searchYdown(in, x, y1, yLast);
    		} else {
    			return searchYdown(in, x, y0, y1+1);
    		}
    	} else if (delta == 0) {
    		return y0;
    	} else if (getHit(in, x, yLast) == Hit.HIT) {
    		return yLast;
    	} else {
    		return y0;
    	}
    }
    
    // y0 has hit, yLast is last possible hit
    private static int searchYup(Scanner in, int x, int y0, int yLast) {
    	int delta = yLast - y0;
		if (delta > 1) {
    		int y1 = y0 + delta/2;
    		if (getHit(in, x, y1) == Hit.HIT) {
    			return searchYup(in, x, y1, yLast);
    		} else {
    			return searchYup(in, x, y0, y1-1);
    		}
    	} else if (delta == 0) {
    		return y0;
    	} else if (getHit(in, x, yLast) == Hit.HIT) {
    		return yLast;
    	} else {
    		return y0;
    	}
    }
    
    private static Hit getHit(Scanner in, int x, int y) {
    	System.out.println(x + " " + y);
        System.out.flush();
        Hit result = Hit.valueOf(in.next());
        if (result == Hit.CENTER) {
        	throw new FoundException(x, y);
        }
        return result;
    }
}