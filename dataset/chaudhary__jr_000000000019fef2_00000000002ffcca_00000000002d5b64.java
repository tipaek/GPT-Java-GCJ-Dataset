import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Solution {
        
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int p = 1; p <= t; ++p) {
        	int rank = in.nextInt();
        	int suit = in.nextInt();
        	int j=(rank*suit)-(rank+1);
            System.out.println("Case #" + p  + ": " +((rank-1)*(suit-1)));
        	for(int i=rank;i>1;i--) {
        		for(int s=1;s<suit;s++,j--) {
        			System.out.println(i +" "+ j);
        		}
        	}
        }
      }
}
