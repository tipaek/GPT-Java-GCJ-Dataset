import java.io.*;
import java.util.*;


public class Solution {
    public static String isPossible(List<Integer> start, List<Integer> end) {
        
        HashMap<Integer,Integer> endStart = new HashMap<>();
        HashMap<Integer,Integer> startIndex = new HashMap<>();
        
        for(int i=0; i<start.size(); i++) {
            endStart.put(end.get(i),start.get(i));
            startIndex.put(start.get(i),i);
        }
        
        Collections.sort(start);
        Collections.sort(end);
        char[] sb = new char[start.size()];

        int i=0;
        int j=0;
        int count = 0;
        int jUsed = 0;
        int cUsed = 0;
        
        while(j<end.size()) {
            if(i<start.size() && start.get(i) < end.get(j)) {
                count++;
                if(jUsed == 0) {
                    jUsed = start.get(i);
                    sb[startIndex.get(jUsed)] = 'C';
                } else {
                    cUsed = start.get(i);
                    sb[startIndex.get(cUsed)] = 'J';
                }
                i++;
                if(count > 2) {
                    return "IMPOSSIBLE";
                }
            } else {
                count--;
                if(jUsed > 0 && jUsed == endStart.get(end.get(j))) {
                    jUsed = 0;
                } else {
                    cUsed = 0;
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
    		ArrayList<Integer> start = new ArrayList<>();
    		ArrayList<Integer> end = new ArrayList<>();
    		
    		for(int j=0; j<n; j++) {
    			int i=0;
    			start.add(sc.nextInt());
    			end.add(sc.nextInt());
    		}
    		out.printf("Case #%d: %s\n", tc, isPossible(start, end));
    	}
    	out.close();
	}
}