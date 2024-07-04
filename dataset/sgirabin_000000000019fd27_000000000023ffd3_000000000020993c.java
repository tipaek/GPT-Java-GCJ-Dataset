import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private Scanner scanner;
	private PrintWriter writer;

	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);
	}
	
	public void solve() {
		int T = scanner.nextInt();
        for (int i=0;i<T;i++) {
            
            int N = scanner.nextInt();

            int r=0;
            int c=0;
            int trace=0;
            
            Map<Integer, HashSet<Integer>> column  = new HashMap<Integer, HashSet<Integer>>();
            
            for (int j=0;j<N;j++) {

            	Set<Integer> row = new HashSet<Integer>();
            	for (int k=0;k<N;k++) {
                    int element = scanner.nextInt();
                    if (j==k) {
                        trace=trace+element;
                    }
                    row.add(element);
                    
            		HashSet<Integer> col = column.getOrDefault(k, new HashSet<>());
            		col.add(element);
            		column.put(k, col);
                }
                
                if (row.size() < N) {
                	r=r+1;
                }
            }
            
            for (int j=0;j<N;j++) {
            	HashSet<Integer> col = column.get(j);
            	if (col.size()<N) {
            		c=c+1;
            	}
            }
            
            writer.printf("Case #%d: %d %d %d%n",i+1, trace, r, c);
        }
        writer.flush();
        writer.close();
	}


	public static void main(String[] args) {
        Solution solution = new Solution(System.in, System.out);
        solution.solve();
    }
}
