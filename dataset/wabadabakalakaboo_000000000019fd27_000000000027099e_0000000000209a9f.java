import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int queries = sc.nextInt();
        int caseNum = 0;
        while (queries --> 0) {
        	caseNum++;
        	String str = sc.next();
        	StringBuilder ans = new StringBuilder("");
        	if (Integer.parseInt(str.substring(0,1)) > 0) {
        		for (int i = 0; i < Integer.parseInt(str.substring(0,1)); i++) {
        			ans.append("(");
        		}
        	}
        	int pos = 0;
        	int posChange = 0;
        	for (int i = 0; i < str.length(); i++) {
        		ans.append(str.substring(pos,pos+1));
        		if (pos == str.length()-1) {
        			posChange = -Integer.parseInt(str.substring(str.length()-1, str.length()));
        		}
        		else {
        			posChange = Integer.parseInt(str.substring(pos+1,pos+2))
        				-Integer.parseInt(str.substring(pos,pos+1));
        		}
        		if (posChange > 0) {
        			for (int j = 0; j < posChange; j++) {
        				ans.append("(");
        			}
        		}
        		else if (posChange < 0) {
        			for (int j = 0; j < -posChange; j++) {
        				ans.append(")");
        			}
        		}
//        		ans.append(str.substring(pos,pos+1));
        		pos++;
        	}
        	pw.println("Case #" + caseNum + ": " + ans.toString());
        }
        
        pw.close();
    }
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}