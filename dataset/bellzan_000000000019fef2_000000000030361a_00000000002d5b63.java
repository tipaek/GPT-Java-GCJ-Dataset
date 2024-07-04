import java.util.*;
import java.io.*;

public class Solution {
    public static BufferedReader f;
    public static StringTokenizer st;
    //public static PrintWriter out;
    public static String readIn;
    public static void main (String[] args) throws IOException {
    	f = new BufferedReader(new InputStreamReader (System.in));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("blindfold.out")));
        st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String verdict;
        boolean done = false;
        int x; 
        int y;
        for (int i = 0; i < T; i++) {
        	done = false;
        	int j = 0;
        	while (!done && j < 121) {
        		x = (int) j/11;
        		y = j % 11;
        		//out.println((-5+x)+" "+(-5+y));
        		System.out.println((-5+x)+" "+(-5+y));
        		System.out.flush();
        		st = new StringTokenizer(f.readLine());
        		verdict = st.nextToken();
        		if (verdict.equals("CENTER")) {
        			done = true;
        		} /*else if (verdict.equals("HIT") || verdict.equals("MISS")) {
        			
        		} else {
        			out.println("Huh?");
        		}*/
        		j++;
        	}
        	//out.println("Done! "+done);
        	if (j != 100) {
        		//out.println("It worked!");
        	}
        }
        //out.close();
    }
}