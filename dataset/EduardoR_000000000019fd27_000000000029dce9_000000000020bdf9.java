import java.util.*;

public class Solution {
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
		int tests = input.nextInt();
		
		for (int a = 0; a < tests; a++) {
	    	String result = "";
		    int N = input.nextInt();
		    int b = 0;
		    
		    ArrayList<Integer> C = new ArrayList<>();
		    ArrayList<Integer> J = new ArrayList<>();
		    HashSet<Integer> cset = new HashSet<>();
		    HashSet<Integer> jset = new HashSet<>();
		    
		    while (b < N) {
		        int start = input.nextInt();
		        int finish = input.nextInt();
		        cset.addAll(C);
		        jset.addAll(J);
		        ArrayList<Integer> array = new ArrayList<>();
		        
		        for (int i = start; i < finish; i++) {
		            array.add(i);
		        }
		        
		        cset.retainAll(array);
		        jset.retainAll(array);
		        
		        if (cset.isEmpty()) {
		            for (int i = 0; i < array.size(); i++) {
		                C.add(array.get(i));
		            }
		            result = result + "C";
		        }
		        else {
		            if (jset.isEmpty()) {
		                for (int i = 0; i < array.size(); i++) {
		                    J.add(array.get(i));
		                }
		                result = result + "J";
		            }
		            else {
		                result = "IMPOSSIBLE";
		                break;
		            }
		        }
		        
		        array.clear();
		        b++;
		    }
		    
		    System.out.println("Case #" + (a + 1) + ": " + result);
		}
    }
}
