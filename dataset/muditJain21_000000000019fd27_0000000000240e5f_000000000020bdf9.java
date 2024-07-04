import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jain
 */
public class Solution {
    
    static class Pair {
        int start;
        int end;
        
        @Override
        public String toString() {
            return "{"+start+","+end+"}";
        }
    }
    
    static class startSort implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.start - o2.start;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    int test = 1;
	    while(test <= t) {
	        int n = Integer.parseInt(br.readLine());
                List<Pair> list = new ArrayList<>();
	        
	        for(int i = 0; i < n; i++) {
	            String line = br.readLine();
	            String strs[] = line.trim().split("\\s+");
	            Pair pair = new Pair();
                    pair.start = Integer.parseInt(strs[0]);
                    pair.end = Integer.parseInt(strs[1]);
                    list.add(pair);
	        }
                
                Collections.sort(list, new startSort());
	        
//                System.out.println(list);
                String ans = "";
                boolean isPossible = true;
                int c=-1,j=-1;
                for(int i = 0; i < list.size(); i++) {
                    Pair pair = list.get(i);
                    if(c==-1) {
                        ans += "C";
                        c = pair.end;
                    }
                    else if(pair.start >= c) {
                        ans += "C";
                        c = pair.end;
                    }
                    else if(j == -1){
                        ans += "J";
                        j = pair.end;
                    }
                    else if(pair.start >= j) {
                        ans += "J";
                        j = pair.end;
                    }
                    else {
                        isPossible = false;
                        break;
                    }
                }
                
                if(!isPossible) {
                    ans = "IMPOSSIBLE";
                }
                
                
	        
	        System.out.println("Case #"+test+": "+ans);
	        
                test++;
	    }
	 }
}