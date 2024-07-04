import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public  class Solution  {

	private Scanner scanner;
	private PrintWriter writer;
	
	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);		
	}
	

	private void solve() {
		int T = scanner.nextInt();
        for (int i=0;i<T;i++) {
        	
        	String S = scanner.next();

        	StringBuffer sb = new StringBuffer();
        	for (int j=0;j<S.length();j++) {
        		int digit = Character.getNumericValue(S.charAt(j));
        		
        		for (int k=0;k<digit;k++) {
        			sb.append("(");
        		}
        		sb.append(digit);
           		for (int k=0;k<digit;k++) {
        			sb.append(")");
        		}
        	}
        	
            writer.printf("Case #%d: %s%n",i+1, sb.toString());
        }
        writer.flush();
        writer.close();
	}
	
	
	public static void main(String[] args) {
    	
    	Solution solution = new Solution(System.in, System.out);
        solution.solve();
    }


}
