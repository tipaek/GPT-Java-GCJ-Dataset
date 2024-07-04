

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		int t = Integer.parseInt(br.readLine());
		int t1 = t;
//		System.out.println(String.format("%0" + 3 + "d", 0).replace("0", "("));
		while (t -- > 0) {
//			
			String n = (br.readLine().trim());
			String ans = "";
			int prev = 0;
			for (int i = 0;i<n.length();i++) {
				int curr = Integer.parseInt(n.substring(i,i+1));
				if (curr>prev) {
					ans = ans + String.format("%0" + (curr-prev) + "d", 0).replace("0", "(") + "" + curr;
					
				}
				else if(curr == prev) {
					ans = ans +"" + curr;
				}
				else {
					ans = ans + String.format("%0" + (prev-curr) + "d", 0).replace("0", ")") + "" +curr;
				}
				prev = curr;
			}
			if (prev != 0) {
				ans = ans+(String.format("%0" + prev + "d", 0).replace("0", ")"));
			}
			
			System.out.println("Case #" + (t1-t) + ": " + ans);
		}
    }
}