import java.io.*;
import java.util.*;

class Solution {
	static int psx;//Peppurr start x
	static int psy;//Peppurr start y
	static int pex;//Peppurr end x
	static int pey;//Peppurr end y
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        boolean possible = true;
        String pPath;
        int totalTime;
        int holds;
        int cX;
        int cY;
        boolean done;
        boolean Ngood = false;
        boolean Wgood = false;
        boolean Sgood = false;
        boolean Egood = false;
        int answer = 5;
        for (int i = 0; i < T; i++) {
        	possible = true;
        	st = new StringTokenizer(f.readLine());
        	psx = Integer.parseInt(st.nextToken());
        	psy = Integer.parseInt(st.nextToken());
        	pPath = st.nextToken();
        	totalTime = pPath.length();
        	
        	//Find Peppurr endpoint:
        	pex = psx;
        	pey = psy;
        	for (int j = 0; j < totalTime; j++) {
        		if (pPath.charAt(j) == 'N') {
        			pey++;
        		} else if (pPath.charAt(j) == 'S') {
        			pey--;
        		} else if (pPath.charAt(j) == 'W') {
        			pex--;
        		} else if (pPath.charAt(j) == 'E') {
        			pex++;
        		}
        	}
        	if (pex > 0) {
        		Wgood = false;
        		Egood = true;
        	} else {
        		Wgood = true;
        		Egood = false;
        	}
        	if (pey > 0) {
        		Sgood = false;
        		Ngood = true;
        	} else {
        		Sgood = true;
        		Ngood = false;
        	}
        	
        	//System.out.println("We end up here: "+pex+", "+pey);
        	
        	if (Math.abs(pey)+Math.abs(pex) <= totalTime) {
        		//We can do it!
        		holds = totalTime - (Math.abs(pey)+Math.abs(pex));
        		//System.out.println("holds: "+holds);
        		cX = pex;
        		cY = pey;
        		done = false;
        		int j = totalTime-1;
        		char currentChar;
        		answer = j+1;
        		while (!done && j > -1) {
        			currentChar = pPath.charAt(j);
        			if ((currentChar == 'N' &&  cY > 0) || (currentChar == 'E' && cX > 0) || (currentChar == 'W' && cX < 0) || (currentChar == 'S' && cY < 0)) {
        				//This is easy!
        				if (currentChar == 'N') {
                			cY--;
                		} else if (currentChar == 'S') {
                			cY++;
                		} else if (currentChar == 'W') {
                			cX++;
                		} else if (currentChar == 'E') {
                			cX--;
                		}
        				answer--;
        				//System.out.println("We can walk together! ("+currentChar+")");
        			} else if (holds > 1) {
        				holds-=2;
        				if (currentChar == 'N') {
                			cY--;
                		} else if (currentChar == 'S') {
                			cY++;
                		} else if (currentChar == 'W') {
                			cX++;
                		} else if (currentChar == 'E') {
                			cX--;
                		}
        				answer--;
        				//System.out.println("I guess I'll go out of my way ("+currentChar+")");
        			} else {
        				done = true;
        				//System.out.println("Sorry, not happening");
        			}
        			j--;
        		}
        	} else {
        		//Nope, not happening
        		possible = false;
        	}
        	
        	if (!possible) {
        		System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        	} else {
        		System.out.println("Case #"+(i+1)+": "+answer);
        	}
        }
    }
}