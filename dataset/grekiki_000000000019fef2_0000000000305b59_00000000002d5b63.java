import java.io.*;
import java.util.*;

public class Solution {
//    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static boolean solve(int tcase, long a, long b) throws Exception {
	boolean[][] disprove = new boolean[110][110];// o[x][y]->Sredisce je lahko na x,y
	int count = 110 * 110;
	int tries = 300;
	// iscemo v 10*10 mrezi okoli -10**9,-10**9. Gremo do 100 desno in do 100 dol
	long x0 = 707106781;
	long y0 = 707106781;

	for (long dx = -30; dx <= 30; dx += 1) {
	    for (long dy = dx; dy <= dx; dy +=1) {
		System.out.println((x0 + dx) + " " + (y0 + dy));
//		System.err.println(dx + " " + dy);
		System.out.flush();
		tries--;
		if (tries <= 0) {
		    System.err.println("Konec poskusov");
		    return false;
		}
		String response = in.readLine();
		if (response.equals("CENTER")) {
		    System.err.println("Zmagali smo, pa ne bi smeli");
		    return false;
		} else if (response.equals("HIT")) {
		    int t = prune(disprove, (x0 + dx), (y0 + dy), true, a);
		    count -= t;
		} else if (response.equals("MISS")) {
		    int t = prune(disprove, (x0 + dx), (y0 + dy), false, a);
		    count -= t;
		} else if (response.equals("WRONG")) {
		    System.err.println("Napaka");
		    return false;
		}
	    }
	}

	System.err.println(count + " " + tries);
	for (int dx = 0; dx < 110; dx++) {
	    for (int dy = 0; dy < 110; dy++) {
		if (!disprove[dx][dy]) {
		    System.out.println((-55 + dx) + " " + (-55 + dy));
		    System.out.flush();
		    tries--;
		    if (tries <= 0) {
			System.err.println("Konec poskusov");
			return false;
		    }
		    String response = in.readLine();
		    if (response.equals("CENTER")) {
			return true;
		    } else if (response.equals("HIT")) {
		    } else if (response.equals("MISS")) {
			System.err.println("WTF");
			return false;
		    } else if (response.equals("WRONG")) {
			System.err.println("Napaka");
			return false;
		    }
		}
	    }
	}
	for (int i = 0; i < 10; i++) {
	    System.err.println("Nismo nasli resitve");
	}
	return false;
    }

    private static int prune(boolean[][] disprove, long x, long y, boolean hit, long a) {
	int count = 0;
	for (int i = 0; i < 110; i++) {
	    for (int j = 0; j < 110; j++) {
		if (!disprove[i][j]) {
		    long px = -55 + i;
		    long py = -55 + j;
		    // kako dalec smo ciljali
		    long dist = (px - x) * (px - x) + (py - y) * (py - y);
		    long radius2 = a * a;// kako dalec je rob kroga
		    if (hit) {
			if (dist > radius2) {
			    count++;
			    disprove[i][j] = true;
			}
		    } else {
			if (dist <= radius2) {
			    count++;
			    disprove[i][j] = true;
			}
		    }
		}
	    }
	}
	return count;
    }

    public static void main(String[] args) throws Exception {
	StringTokenizer st = new StringTokenizer(in.readLine());
	int t = Integer.parseInt(st.nextToken());
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
	for (int tcase = 1; tcase <= t; tcase++) {
	    boolean ok=solve(tcase, a, b);
	    if(!ok) {
		return;
	    }
	}
    }

}
