import java.util.*;
import java.io.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader rd;
    PrintWriter wr;

    String nextToken() throws IOException {
        String token = null;
        token = rd.readLine();
        return token;
    }

	private String calculator(int nbr) throws IOException {
		String s = nextToken();
		char[] c = s.toCharArray();    	
    	StringBuilder sb = new StringBuilder();
    	int depth = 0;
    	for (int i = 0; i < c.length; i ++) {
    		int val = c[i] - '0';
    		int d = val - depth;
    		for (int j = 0; j < d; j ++) {
    			sb.append('(');
    		}
    		for (int j = d; j < 0; j ++) {
    			sb.append(')');
    		}
    		sb.append(c[i]);
    		depth = val;
    	}
    	for (int i = 0; i < depth; i ++) {
    		sb.append(')');
    	}

    	sb.insert(0, "Case #" + nbr + ": ");
		return sb.toString();
	}

	private void solve() throws IOException {
    	rd = new BufferedReader(new InputStreamReader(System.in));
    	wr = new PrintWriter(System.out);

		int tnbr = Integer.parseInt(nextToken());

		for (int i = 0; i < tnbr; i ++) {
			String sub = calculator(i + 1);
      		wr.println(sub);
		}
		
    	rd.close();
    	wr.close();
		return;
	}
}