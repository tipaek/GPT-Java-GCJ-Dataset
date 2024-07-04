import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tC; t++) {
			System.out.println("Case #" + t + ":");
			
			int n = Integer.parseInt(br.readLine());
			
			System.out.println("1 1");
			n--;
			int ind = 1;
			
			while(n > 0) {
				if(ind > n) {
					System.out.println((ind) + " " + (ind));
					n--;
				}
				else {
					System.out.println((ind+1) + " " + ind);
					n-=ind;
				}
				ind++;
				
				if(ind == 499)
					break;
			}
		}
	}
}
