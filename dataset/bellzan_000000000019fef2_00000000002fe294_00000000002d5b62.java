import java.io.*;
import java.util.*;

class Solution {
	static long x;
	static long y;
	public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        boolean possible;
        boolean done;
        String solution;
        int pow;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	x = (long) Integer.parseInt(st.nextToken());
        	y = (long) Integer.parseInt(st.nextToken());
        	done = false;
        	possible = true;
        	solution = new String("");
        	pow = 1;
        	
        	while (!done && pow < 4) {
        		if (x % (Math.pow(2, pow)) == 0) {//X gets 0 and 0
        			//System.out.println("Hi!");
        			if (y % Math.pow(2, pow) == 0) {
        				//System.out.println("Oh,no!");
        				//We have a problem
        				possible = false;
        				done = true;
        			} else {//Y gets 0 and 1
        				//Now pick which gets 0 and which gets 1
        				if (x == 0 && Math.abs(y)-Math.pow(2, pow-1) == 0) {
        					if (y > 0) {
        						y -= Math.pow(2, pow-1);
        						solution += 'N';
        					} else {
        						y += Math.pow(2, pow-1);
        						solution += 'S';
        					}
        				} else if (x % Math.pow(2, pow+1) == 0) {
        					//System.out.println("Next time too");
        					//We want the next time for y to be not divisible
        					if ((y+Math.pow(2, pow-1)) % Math.pow(2, pow+1) != 0) {
        						y += Math.pow(2, pow-1);
        						solution += 'S';
        					} else {
        						y -= Math.pow(2, pow-1);
        						solution += 'N';
        					}
        				} else {
        					//We want the next time for y to be divisible
        					if ((y+Math.pow(2, pow-1)) % Math.pow(2, pow+1) == 0) {
        						//System.out.println("hello");
        						y += Math.pow(2, pow-1);
        						solution += 'S';
        					} else {
        						y -= Math.pow(2, pow-1);
        						solution += 'N';
        					}
        				}
        			}
        		} else {//X gets 0 and 1
        			if (y % Math.pow(2, pow) != 0) {
        				//We have a problem
        				possible = false;
        				done = true;
        			} else {//Y gets 0 and 0
        				//Now pick which gets 0 and which gets 1
        				if (y == 0 && Math.abs(x)-Math.pow(2, pow-1) == 0) {
        					if (x > 0) {
        						x -= Math.pow(2, pow-1);
        						solution += 'E';
        					} else {
        						x += Math.pow(2, pow-1);
        						solution += 'W';
        					}
        				} else if (y % Math.pow(2, pow+1) == 0) {
        					//We want the next time for x to be not divisible
        					if ((x+Math.pow(2, pow-1)) % Math.pow(2, pow+1) != 0) {
        						x += Math.pow(2, pow-1);
        						solution += 'W';
        					} else {
        						x -= Math.pow(2, pow-1);
        						solution += 'E';
        					}
        				} else {
        					//We want the next time for x to be divisible
        					if ((x+Math.pow(2, pow-1)) % Math.pow(2, pow+1) == 0) {
        						x += Math.pow(2, pow-1);
        						solution += 'W';
        					} else {
        						x -= Math.pow(2, pow-1);
        						solution += 'E';
        					}
        				}
        			}
        		}
        		if (x == 0 && y == 0) {
        			done = true;
        		}
        		//System.out.println("X: "+x+" Y: "+y);
        		pow++;
        	}
        	
        	System.out.print("Case #"+(i+1)+": ");
        	if (!possible) {
        		System.out.println("IMPOSSIBLE");
        	} else {
        		System.out.println(solution);
        	}
        }
        f.close();
    }
}