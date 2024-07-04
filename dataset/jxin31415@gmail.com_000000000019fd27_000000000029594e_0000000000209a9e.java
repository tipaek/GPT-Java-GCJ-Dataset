import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Solution {
	static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);

    public static void main (String [] args) throws IOException {
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int T = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    
	    while(T --> 0) {
	    	String s = solve(B);
	    	out.println(s);
	    	char verdict = f.readLine().charAt(0);
	    	if(verdict == 'Y')
	    		continue;
	    	else
	    		System.exit(1);
	    }
	    
	    out.close();
	    f.close();
	}
	
	public static String solve(int B) throws IOException {
		boolean[] storage = new boolean[B+1];
		int sameIndex = -1;
		int diffIndex = -1;
		
		for(int i = 1; i <= 5; i++) {
			out.println(i);
			storage[i] = read();
		}
		
		for(int i = B; i >= B-4; i--) {
			out.println(i);
			storage[i] = read();
		}
		
		for(int i = 1; i <= 5; i++) {
			if(storage[i] == storage[B-i+1]) {
				sameIndex = i;
			} else {
				diffIndex = i;
			}
		}
		
		
		int i = 6;
		while(i <= B/2) {
			boolean r = false;
			boolean c = false;
			if(sameIndex == -1) {
				out.println(1);
				f.readLine();
				out.println(diffIndex);
				boolean same = read() == storage[diffIndex];
				
				if(!same)
					c = true;
			} else if (diffIndex == -1) {
				out.println(1);
				f.readLine();
				out.println(sameIndex);
				boolean same = read() == storage[sameIndex];
				
				if(!same)
					c = true;
			} else {
				out.println(sameIndex);
				boolean same1 = read() == storage[sameIndex];
				out.println(diffIndex);
				boolean same2 = read() == storage[diffIndex];
				
				if(same1 && !same2) {
					r = true;
				} else if (same2 && !same1) {
					r = true; c = true;
				} else if (!same1 && !same2) {
					c = true;
				}
			}
			
			for(int j = i; j < i + 4 && j <= B/2; j++) {
				out.println(j);
				storage[j] = read();
			}
			
			for(int j = B-i+1; j > (B-i+1) - 4 && j > B/2; j--) {
				out.println(j);
				storage[j] = read();
			}
			
			for(int j = i; j<i+4; j++) {
				if(sameIndex == -1 && storage[j] == storage[B-j+1]) {
					sameIndex = j;
				} else if(diffIndex == -1 && storage[j] != storage[B-j+1]) {
					diffIndex = j;
				}
			}
			
			if(r) {
				for(int j = 1; j < i && j <= B/2; j++) {
					boolean temp = storage[B-j+1];
					storage[B-j+1] = storage[j];
					storage[j] = temp;
				}
			}
			if(c) {
				for(int j = 1; j < i && j <= B/2; j++) {
					storage[j] = !storage[j];
					storage[B-j+1] = !storage[B-j+1];
				}
			}
			i += 4;
		}
		
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb2 = new StringBuilder("");
		for(int j = 1; j <= storage.length/2; j++) {
			sb.append((storage[j]) ? 1 : 0);
			sb2.insert(0, (storage[B-j+1]) ? 1 : 0);
		}
		
		return sb.toString() + sb2.toString();
    }
	
	public static boolean read() throws IOException {
		return Integer.parseInt(f.readLine()) == 1;
		/*String s = f.readLine();
		if(s.charAt(0) == 'N')
			System.exit(0);
		return Integer.parseInt(s) == 1;*/
	}
}