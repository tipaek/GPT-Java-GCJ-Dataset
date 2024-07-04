import java.io.*;
import java.util.*;


public class Solution {
    public static String isPossible(List<Integer> start, List<Integer> end) {
        
        HashMap<Integer,Integer> endStart = new HashMap<>();
        HashMap<Integer,List<Integer>> startIndex = new HashMap<>();
        
        for(int i=0; i<start.size(); i++) {
            endStart.put(end.get(i),start.get(i));
            if(!startIndex.containsKey(start.get(i))) {
            	startIndex.put(start.get(i),new ArrayList<Integer>());
            }
        	startIndex.get(start.get(i)).add(i);
        }
        
        Collections.sort(start);
        Collections.sort(end);
        char[] sb = new char[start.size()];
        
        int i=0;
        int j=0;
        int count = 0;
        int jUsed = 0;
        int cUsed = 0;
        int val;
        
        while(j<end.size()) {
            if(i<start.size() && start.get(i) < end.get(j)) {
                count++;
                if(jUsed == 0) {
                    jUsed = start.get(i);
                    //System.out.println("jUsed: " + startIndex.get(jUsed));
                    if(startIndex.get(jUsed).size() > 1) {
                    	val = startIndex.get(jUsed).get(startIndex.get(jUsed).size()-1);
                    	startIndex.get(jUsed).remove(startIndex.get(jUsed).size()-1);
                    } else {
                    	val = startIndex.get(jUsed).get(0);
                    }
                    sb[val] = 'C';
                } else {
                    cUsed = start.get(i);
                    //System.out.println("cUsed: " + startIndex.get(cUsed));
                    if(startIndex.get(cUsed).size() > 1) {
                    	val = startIndex.get(cUsed).get(startIndex.get(cUsed).size()-1);
                    	startIndex.get(cUsed).remove(startIndex.get(cUsed).size()-1);
                    } else {
                    	val = startIndex.get(cUsed).get(0);
                    }
                    sb[val] = 'J';                }
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