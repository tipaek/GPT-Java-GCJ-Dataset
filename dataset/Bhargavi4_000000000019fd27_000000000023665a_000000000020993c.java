import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TraceMatrix {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
	    String tests = br.readLine();
	    if(tests == null)return;
	    
	    int t = Integer.parseInt(tests);
	    StringBuilder sb = new StringBuilder();
	    for(int i = 1;i<=t;i++) {
	    	
	    	int n = Integer.parseInt(br.readLine());
	    	int[][] arr = new int[n][n];
	    	for(int k = 0;k<n;k++) {
	    		String str = br.readLine();
	    		arr[k] = Stream.of(str.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();	    				
	    	}
	    	
	    	int trace = calculateTrace(arr,n);
	    	
	    	int rows = calculateDupsInRows(arr,n);
	    	
	    	
	    	int columns = calculateDupsInColumns(arr,n);
	    	
	    	sb.append("case #").append(i).append(":").append(" "+trace).append(" "+rows).append(" "+columns);
	    	sb.append("\n");
	    	
	    }
	    
	    System.out.println(sb.toString().trim());
	}
	
	private static int calculateTrace(int[][] arr,int n) {
		int trace = 0;
    	
    	for(int k=0;k<n;k++) {
    		trace = trace + arr[k][k];
    	}
    	return trace;
	}
	
	private static int calculateDupsInRows(int[][] arr,int n) {
		int rows = 0;
    	for(int r = 0;r<n;r++) {
    		Set<Integer> set = new HashSet();
    		
    		for(int c=0;c<n;c++) {
    			if(!set.contains(Integer.valueOf(arr[r][c]))) {
    				set.add(Integer.valueOf(arr[r][c]));
    			}else {
    				rows = rows+1;
    				break;
    			}
    			
    		}
    	}
    	return rows;
	}
	
	private static int calculateDupsInColumns(int[][] arr ,int n) {
		int columns = 0;
    	for(int r = 0;r<n;r++) {
    		Set<Integer> set = new HashSet();
    		
    		for(int c=0;c<n;c++) {
    			if(!set.contains(Integer.valueOf(arr[r][c]))) {
    				set.add(Integer.valueOf(arr[c][r]));
    			}else {
    				columns = columns+1;
    				break;
    			}
    			
    		}
    	}
    	return columns;
	}

}
