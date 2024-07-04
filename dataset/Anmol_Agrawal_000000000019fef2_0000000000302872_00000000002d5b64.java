import java.util.*;
class Solution {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int r = sc.nextInt();
	        int s = sc.nextInt();
	        System.out.println("Case #" + tt + ": " + (r- 1) * (s - 1));
	        int a = r;
	        int b = 1;
	        for(int i = 1; i < r; i++){
	            for(int j = 1; j < s; j++){
	                System.out.println(a + " " + ((r * s) - a - b));
	                b++;
	            }
	            a--;
	            b++;
	        }
	    }
	}
}
