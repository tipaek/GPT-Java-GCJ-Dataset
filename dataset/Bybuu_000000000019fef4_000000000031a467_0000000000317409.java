import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
 		for (int r = 0; r<recursive; r++) {
 			int X = scanner.nextInt();
 			int Y = scanner.nextInt();
 			String s = scanner.nextLine();
 			int n = s.length();
 			int lap = 0;
 			boolean flag = false;
 			for(int i=0; i<n; i++) {
 				char c = s.charAt(i);
 				if( c == 'N') {
 					Y++;
 				}
 				if( c == 'S') {
 					Y--;
 				}
 				if( c == 'E') {
 					X++;
 				}
 				if( c == 'W') {
 					X--;
 				}
 				if(i >= (Math.abs(X) + Math.abs(Y))) {
 					flag = true;
 					lap = i;
 					break;
 				}
 			}
 			if (flag == true) {
 				System.out.println("Case #" +(r+1)+": "+ lap);
 			} else {
 				System.out.println("Case #" +(r+1)+": IMPOSSIBLE");
 			}
 			
 			
 		}
	}
}