import java.util.Scanner;
class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int i=0; i<t; i++){
            String s = scan.nextLine();
            String ans = solve(s);
            System.out.println("Case #" + (i+1) + ": " + ans);
        }
    }
    
    private static String solve(String s) {
		String ans = "";
		int openBrackets = 0;
        for(int i=0; i<s.length()-1; i++) {
            int curr = Character.getNumericValue(s.charAt(i));
            int next = Character.getNumericValue(s.charAt(i+1));
            int open = curr-openBrackets;
        	for(int j=0; j<open; j++) {
				ans += "(";
			}
			ans += Character.toString(s.charAt(i));
			int close = 0;
			if(next < curr) {
				close = curr-next;
				for(int j=0; j<close; j++) {
					ans += ")";
				}
			}
			else {
				close = 0;
			}
            openBrackets += (open-close);
        }
        char lastChar = s.charAt(s.length()-1); 
        int toOpen = Character.getNumericValue(lastChar)-openBrackets;
        for(int i=0; i<toOpen; i++) {
        	ans += "(";
        }
        ans += Character.toString(lastChar);
        int end = Character.getNumericValue(lastChar);
		for(int i=0; i<end; i++) {
			ans += ")";
		}
		return ans;
	}
     
}