import java.util.*;
public class Solution {
	public static String add(String thing) {
		String y = thing;
		if (y.equals("")) {
			y = "J";
		}
		else if (y.charAt(y.length()-1) == 'J')
			y += "C";
		else if (y.charAt(y.length()-1) == 'C')
			y += "J";
		
		return y;
	}
    public static void solve(Scanner sc, int t) {
    	int n = Integer.parseInt(sc.nextLine());
    	int s, e;
    	StringTokenizer st;
    	String[] arr = new String[1440];
    	String y = "";
    	
    	for(int x = 0; x<arr.length; x++)
    		arr[x] = "";
    	for(int x = 0; x<n;x++) {
    		st = new StringTokenizer(sc.nextLine());
    		s = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	String hold = "";
        	if (arr[s].contains("J") && arr[s].contains("C")) {
    			y = "IMPOSSIBLE";
    			break;
    		}
    		else if (arr[s].contains("J") == false && arr[e-1].contains("J") == false) {
    			y += "J";
    			hold = "J";
    		}
    		else if (arr[s].contains("C") == false && arr[e-1].contains("C") == false) {
    			y += "C";
    			hold = "C";
    		}
        	while(s<e) {
        		arr[s] += hold;
        		s++;
        	}
    	}
        System.out.println("Case #" + t + ": " + y);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int x = 1; x <= t; x++){
            solve(sc, x);
        }
    }
}