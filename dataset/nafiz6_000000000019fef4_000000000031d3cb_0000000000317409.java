import java.util.*;
import java.io.*;

class Pair {
	public int i,j;
    public	StringBuilder sb;
	public Pair(int i, int j) {
		this.i = i;
		this.j=j;
		sb = new StringBuilder();
	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int z = 1; z <= t; ++z) {
			int x = in.nextInt();
			int y = in.nextInt();
			String m = in.nextLine();
			System.out.print("Case #" + z + ": ");
			boolean found =false;
			
			for (int i=1;i<m.length();i++){

				if (Math.abs(x)+Math.abs(y) <= i-1){
				
					System.out.println(i-1);
					found=true;
					break;
				}
				if (m.charAt(i)=='S')y-=1;
				if (m.charAt(i)=='N')y+=1;
				if (m.charAt(i)=='E')x+=1;
				if (m.charAt(i)=='W')x-=1;
			}	
			if (found)continue;
			if (Math.abs(x)+Math.abs(y)<=m.length()-1){
				System.out.println(m.length()-1);
				continue;
			}
			System.out.println("IMPOSSIBLE");







		}
	}
}
