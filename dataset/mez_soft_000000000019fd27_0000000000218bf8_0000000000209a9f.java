import java.util.*;


public class Solution {
	private static int t;
	private static int n;
	private static String solve(String s) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int x = 0 , y = 0;
		int n;
		String t = "";
		for (int i = 0; i < s.length(); i++) {
			l.add(Integer.parseInt(s.substring(i, i+1)));
		}
		for (int i = 0; i < l.size(); i++) {
			n = l.get(i);
			if(x < n) do {t+="(";x++;}while(x < n);
			else if(x > n) do {t+=")";x--;}while(x > n);
			t+=Integer.toString(n);
		}
		if(x > 0) do {t+=")";x--;}while(x > 0);
		return t;
	}

	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for(int i = 1;i <= t;i++) {
        	String s = input.nextLine();
            System.out.println(String.format("Case #"+i+": "+ solve(s)));
        }
		
	}
}
 