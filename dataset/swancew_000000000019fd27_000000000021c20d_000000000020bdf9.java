import java.io.*;
import java.util.*;


public class Solution {
	public static class ValueIndex implements Comparable {
		public int value;
		public int index;
		
		public ValueIndex(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(Object other) {
			return Integer.compare(this.value, ((ValueIndex) other).value);
		}
	}
	

    public static String isPossible(List<ValueIndex> start, List<ValueIndex> end) {
               
        Collections.sort(start);
        Collections.sort(end);
        char[] sb = new char[start.size()];
        
        int i=0;
        int j=0;
        int count = 0;
        int jUsed = -1;
        int cUsed = -1;
        
        while(j<end.size()) {
            if(i<start.size() && start.get(i).value < end.get(j).value) {
                count++;
                if(count > 2) {
                    return "IMPOSSIBLE";
                }
                if(jUsed == -1) {
                    jUsed = start.get(i).index;
                    sb[jUsed] = 'J';
                } else {
                    cUsed = start.get(i).index;
                    sb[cUsed] = 'C';                }
                i++;
            } else {
                count--;
                if(jUsed == end.get(j).index) {
                    jUsed = -1;
                } else {
                    cUsed = -1;
                }
                j++;
            }
        }
        
        return String.valueOf(sb);
    }

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	PrintWriter out = new PrintWriter(System.out);
    	int tcs = sc.nextInt();
    	for (int tc = 1; tc <= tcs; tc++) {
    		int n = sc.nextInt();
    		ArrayList<ValueIndex> start = new ArrayList<>();
    		ArrayList<ValueIndex> end = new ArrayList<>();
    		
    		for(int j=0; j<n; j++) {
    			start.add(new Solution.ValueIndex(sc.nextInt(),j));
    			end.add(new ValueIndex(sc.nextInt(),j));
    		}
    		out.printf("Case #%d: %s\n", tc, isPossible(start, end));
    	}
    	out.close();
	}


}