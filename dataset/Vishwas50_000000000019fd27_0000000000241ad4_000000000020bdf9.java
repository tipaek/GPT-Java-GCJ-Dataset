import java.util.Scanner;
class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(scan.nextLine());
            int[] start = new int[n];
            int[] end = new int[n];
            for(int j=0; j<n; j++) {
                String[] temp = scan.nextLine().split(" ");
                start[j] = Integer.parseInt(temp[0]); 
                end[j] = Integer.parseInt(temp[1]); 
            }
            String ans = solve(n, start, end);
            System.out.println("Case #" + (i+1) + ": " + ans);
        }
    }
    
    private static String solve(int n, int[] start, int[] end) {
		String ans = "C";
        for(int i=1; i<n; i++) {
        	boolean cFlag = true, jFlag = true;
        	for(int j=0; j<i; j++) {
        		if((start[i] > start[j] && start[i] < end[j]) || (end[i] > start[j] && end[i] < end[j])){
        			if(ans.charAt(j) == 'C') cFlag = false;
        			else jFlag = false;
        		}
        	}
        	if(cFlag) ans += "C";
        	else if(jFlag) ans += "J";
        	else return "IMPOSSIBLE";
        } 
        return ans;
    }
      
}