import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
public class Solution { 
    public static void main(String[] args) throws IOException { 
        BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int x = 1; x <= T; ++x) {
            String test = reader.readLine();
            System.out.println("Case #"+x+": "+solve(test));
        }
    }
    private static String solve(String test) {
	    // Init part
	    int[] values = new int[test.length()];
	    String[] substrings = new String[test.length()];
	    for (int i=0; i<values.length; ++i) {
	        substrings[i] = test.substring(i,i+1);
	        values[i] = Integer.parseInt(substrings[i]);
	    }
	    
	    // Iteration part
	    while (substrings.length > 1) {
	        int max = getMaxValue(values);
	        int i = findFirst(values, max);
	        int cnt = countSame(values, i);
	        int[] next_values = new int[values.length-(cnt-1)];
	        String[] next_substrings = new String[substrings.length-(cnt-1)];
	        for (int j=0; j<i; ++j) {
	            next_values[j] = values[j];
	            next_substrings[j] = substrings[j];
	        }
	        StringBuilder b = new StringBuilder();
	        if (values[i] > 0) {
	            next_values[i] = values[i]-1;
	            b.append("(");
	        } else {
	            next_values[i] = values[i];
	        }
	        for (int j=0; j<cnt; ++j) {
	            b.append(substrings[i+j]);
	        }
	        if (values[i] > 0) {
	            b.append(")");
	        }
	        next_substrings[i] = b.toString();
	        for (int j=i+cnt; j<values.length; ++j) {
	            next_values[j-cnt+1] = values[j];
	            next_substrings[j-cnt+1] = substrings[j];
	        }
	        values = next_values;
	        substrings = next_substrings;
	    }
	    
	    // Clenup part
	    while (values[0] > 0) {
	        values[0] -= 1;
	        substrings[0] = "(" + substrings[0] + ")";
	    }
	    return substrings[0];
	}
	private static int getMaxValue(int[] values) {
	    int max = values[0];
	    for (int v : values) {
	        if (v > max){
	            max = v;
	        }
	    }
	    return max;
	}
	private static int findFirst(int[] values, int max) {
	    for (int i=0; i<values.length; ++i) {
	        if (values[i] == max) return i;
	    }
	    return -1;
	}
	private static int countSame(int[] values, int i) {
	    int cnt = 1;
	    for (int j=i+1; j<values.length; ++j) {
	        if (values[j] == values[i]) {
	            cnt += 1;
	        } else {
	            return cnt;
	        }
	    }
	    return cnt;
	}
} 